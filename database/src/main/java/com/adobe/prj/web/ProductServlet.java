package com.adobe.prj.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adobe.prj.dao.DaoException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.impl.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); // MIME
		PrintWriter out = response.getWriter(); // open character stream to brower/client
		// ServletOutputStream out = response.getOutputStream();
		out.print("<html>");
		out.print("<body>");
		out.print("<table>");
		out.print("<tr><th>Name</th><th>Price</th></tr>");
		ProductDao productDao = new ProductDaoJdbcImpl();
		try {
			List<Product> products = productDao.getProducts();
			for(Product p : products) {
				 out.println("<tr>");
				 	out.print("<td>" + p.getName() + "</td>");
				 	out.print("<td>" + p.getPrice() + "</td>");
				 out.print("</tr>");
			}
		} catch (DaoException e) {
			e.printStackTrace(); // development mode
		}
		
		out.print("</table>");
		out.print("<a href=\"index.html\">Back</a>");
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		product.setName(request.getParameter("name"));
		product.setPrice(Double.parseDouble(request.getParameter("price")));
		product.setQuantity(Integer.parseInt(request.getParameter("qty")));
		
		ProductDao productDao = new ProductDaoJdbcImpl();
		try {
			 productDao.addProduct(product);
			 response.sendRedirect("index.html");
		} catch (DaoException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}

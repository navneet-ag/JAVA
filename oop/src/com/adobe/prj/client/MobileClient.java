package com.adobe.prj.client;

import com.adobe.prj.dao.MobileDao;
import com.adobe.prj.dao.MobileDaoFactory;
import com.adobe.prj.entity.Mobile;

public class MobileClient {

	public static void main(String[] args) {
//		MobileDao mobileDao = new MobileDaoMySqlImpl();
		// cmd + shift + o ==> organize imports
		MobileDao mobileDao = MobileDaoFactory.getMobileDao();
		Mobile m = new Mobile();
		mobileDao.addMobile(m);
	}

}

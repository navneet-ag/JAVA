package com.adobe.prj.dao;

public class MobileDaoFactory {
	// factory method
	public static MobileDao getMobileDao() {
//		return new MobileDaoMySqlImpl();
		return new MobileDaoFileImpl();
	}
}

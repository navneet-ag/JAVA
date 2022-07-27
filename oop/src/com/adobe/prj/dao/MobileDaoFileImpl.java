package com.adobe.prj.dao;

import com.adobe.prj.entity.Mobile;

public class MobileDaoFileImpl implements MobileDao {
	@Override
	public void addMobile(Mobile m) {
		System.out.println("stored in file system...");
	}
}

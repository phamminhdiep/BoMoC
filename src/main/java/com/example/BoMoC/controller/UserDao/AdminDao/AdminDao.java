package com.example.BoMoC.controller.UserDao.AdminDao;

import com.example.BoMoC.Model.Admin.Admin;

public interface AdminDao {

	public void add(Object aAdmin);

	public Admin get(Object aAdminId);
}
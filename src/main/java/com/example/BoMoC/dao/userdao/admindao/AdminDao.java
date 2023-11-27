package com.example.BoMoC.dao.userdao.admindao;

import com.example.BoMoC.model.admin.Admin;

public interface AdminDao {

	public void add(Object aAdmin);

	public Admin get(Object aAdminId);
}
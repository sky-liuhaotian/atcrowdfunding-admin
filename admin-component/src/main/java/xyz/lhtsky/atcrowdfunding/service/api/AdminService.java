package xyz.lhtsky.atcrowdfunding.service.api;


import xyz.lhtsky.atcrowdfunding.entity.Admin;

import java.util.List;

public interface AdminService {

	List<Admin> getAll();

	void updateAdmin();

}

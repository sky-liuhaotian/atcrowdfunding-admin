package xyz.lhtsky.atcrowdfunding.service.api;


import com.github.pagehelper.PageInfo;
import xyz.lhtsky.atcrowdfunding.entity.Admin;

import java.util.List;

public interface AdminService {

	List<Admin> getAll();

	void updateAdmin();
	
	Admin login(String loginAcct, String userPswd);

	PageInfo<Admin> queryForKeywordSearch(Integer pageNum, Integer pageSize, String keyword);

	void batchRemove(List<Integer> adminIdList);

	void saveAdmin(Admin admin);

	Admin getAdminById(Integer adminId);

	void updateAdmin(Admin admin);
}

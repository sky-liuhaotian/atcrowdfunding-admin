package xyz.lhtsky.atcrowdfunding.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lhtsky.atcrowdfunding.CrowdFundingUtils;
import xyz.lhtsky.atcrowdfunding.mapper.AdminMapper;
import xyz.lhtsky.atcrowdfunding.entity.Admin;
import xyz.lhtsky.atcrowdfunding.entity.AdminExample;
import xyz.lhtsky.atcrowdfunding.service.api.AdminService;

import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

	
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public List<Admin> getAll() {
		return adminMapper.selectByExample(new AdminExample());
	}

	@Override
	public void updateAdmin() {
		adminMapper.updateByPrimaryKey(new Admin(1, "harry333", "123123", "哈利333", "harry@qq.com", null));
		System.out.println(10 / 0);
		adminMapper.updateByPrimaryKey(new Admin(2, "poter333", "123123", "波特333", "poter@qq.com", null));
	}

	@Override
	public Admin login(String loginAcct, String userPswd) {
		//根据loginAcct查询数据库
		AdminExample adminExample = new AdminExample();
		adminExample.createCriteria().andLoginacctEqualTo(loginAcct);

		//执行查询
		List<Admin> list = adminMapper.selectByExample(adminExample);

		if (!CrowdFundingUtils.collectionEffective(list)) {
			//如果查询结果集合无效，则直接返回null
			return null;
		}

		// 获取唯一集合元素
		Admin admin = list.get(0);

		// 确认admin不为null
		if(admin == null) {

			return null;
		}

		// 比较密码
		String userPswdDataBase = admin.getUserpswd();

		String userPswdBroswer = CrowdFundingUtils.md5(userPswd);

		if(Objects.equals(userPswdBroswer, userPswdDataBase)){
			// 如果两个密码相等那么说明登录能够成功，返回Admin对象
			return admin;
		}
		return null;
	}

	@Override
	public PageInfo<Admin> queryForKeywordSearch(Integer pageNum, Integer pageSize, String keyword) {
		//1.调用PageHelper的工具方法，开启分页功能
		PageHelper.startPage(pageNum, pageSize);
		//2.执行分页查询
		List<Admin> list = adminMapper.selectAdminListByKeyword(keyword);
		System.out.println(list.toString());
		//3.将list封装到PageInfo对象中
		return new PageInfo<>(list);
	}

}

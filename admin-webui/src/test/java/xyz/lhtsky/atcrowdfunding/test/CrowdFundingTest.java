package xyz.lhtsky.atcrowdfunding.test;

import org.codehaus.jackson.JsonToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.lhtsky.atcrowdfunding.entity.Admin;
import xyz.lhtsky.atcrowdfunding.mapper.AdminMapper;
import xyz.lhtsky.atcrowdfunding.service.api.AdminService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CrowdFundingTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private AdminService adminService;

	@Autowired
	private AdminMapper adminMapper;

//	@Test
//	public void batchSaveAdmin() {
//		for(int i = 0; i < 500; i++) {
//			adminMapper.insert(new Admin(null, "loginAcct"+i, "1111111", "userName"+i, "email"+i+"@qq.com", null));
//		}
//	}

	@Test
	public void testTx() {
		adminService.updateAdmin();
	}

	@Test
	public void testMybatis() {
		List<Admin> adminList = adminService.getAll();
		for (Admin admin : adminList) {
			System.out.println(admin);
		}
	}

	@Test
	public void testConnection() throws SQLException {
		Connection connection = dataSource.getConnection();

		System.out.println(connection);
	}

//	@Test
//	public  void testQuery() throws SQLException{
//		List<Admin> list = adminMapper.selectAdminListByKeyword("");
//		Iterator iterator = list.iterator();
//		while(iterator.hasNext()){
//			Admin admin = (Admin) iterator.next();
//			System.out.println(admin.toString());
//
//
//		}
//	}

}

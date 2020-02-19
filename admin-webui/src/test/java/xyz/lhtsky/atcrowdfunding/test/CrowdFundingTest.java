package xyz.lhtsky.atcrowdfunding.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.lhtsky.atcrowdfunding.entity.Admin;
import xyz.lhtsky.atcrowdfunding.service.api.AdminService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CrowdFundingTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private AdminService adminService;

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

}

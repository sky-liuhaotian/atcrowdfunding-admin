package xyz.lhtsky.atcrowdfunding.handler;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.lhtsky.atcrowdfunding.CrowdFundingConstant;
import xyz.lhtsky.atcrowdfunding.entity.Admin;
import xyz.lhtsky.atcrowdfunding.service.api.AdminService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminHandler {
	
	@Autowired
	private AdminService adminService;

	@RequestMapping("/admin/query/for/search")
	public String queryForSearch(

			// 如果页面上没有提供对应的请求参数，那么可以使用defaultValue指定默认值
			@RequestParam(value="pageNum", defaultValue="1") Integer pageNum,
			@RequestParam(value="pageSize", defaultValue="5") Integer pageSize,
			@RequestParam(value="keyword", defaultValue="") String keyword,
			Model model) {

		PageInfo<Admin> pageInfo = adminService.queryForKeywordSearch(pageNum, pageSize, keyword);

		model.addAttribute(CrowdFundingConstant.ATTR_NAME_PAGE_INFO, pageInfo);

		return "admin-page";
	}

	@RequestMapping("/admin/logout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:/index.html";
	}


@RequestMapping("/admin/do/login")
	public String doLogin(
			@RequestParam("loginAcct") String loginAcct,
			@RequestParam("userPswd") String userPswd,
			Model model,HttpSession session){

	// 调用adminService的login方法执行登录业务逻辑，返回查询到的Admin对象
	Admin admin = adminService.login(loginAcct, userPswd);

	// 判断admin是否为null
	if(admin == null) {

		model.addAttribute(CrowdFundingConstant.ATTR_NAME_MESSAGE, CrowdFundingConstant.MESSAGE_LOGIN_FAILED);

		return "admin-login";
	}

	session.setAttribute(CrowdFundingConstant.ATTR_NAME_LOGIN_ADMIN, admin);

	return "redirect:/admin/to/main/page.html";
}

@RequestMapping("/admin/get/all")
	public String getAll(Model model){

	List<Admin> list = adminService.getAll();

	return "admin-target";
}


}

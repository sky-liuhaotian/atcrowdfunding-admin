package xyz.lhtsky.atcrowdfunding.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.lhtsky.atcrowdfunding.entity.Admin;
import xyz.lhtsky.atcrowdfunding.service.api.AdminService;

import java.util.List;

@Controller
public class AdminHandler {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/admin/get/all")
	public String getAll(Model model) {
		
		List<Admin> list = adminService.getAll();
		
		model.addAttribute("list", list);
		
		return "admin-target";
	}

}

package xyz.lhtsky.atcrowdfunding.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.lhtsky.atcrowdfunding.entity.Auth;
import xyz.lhtsky.atcrowdfunding.entity.ResultEntity;
import xyz.lhtsky.atcrowdfunding.entity.Role;
import xyz.lhtsky.atcrowdfunding.service.api.AuthService;
import xyz.lhtsky.atcrowdfunding.service.api.RoleService;

import java.util.List;
import java.util.Map;

/**
 * @Author sky
 * @Date 2020/3/1 12:38
 * @Version 1.0
 */


@Controller
public class AssignHandler {
    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthService authService;

    @ResponseBody
    @RequestMapping("/assign/do/assign")
    public ResultEntity<String> doRoleAssignAuth(
            @RequestBody Map<String, List<Integer>> assignDataMap) {

        authService.updateRelationShipBetweenRoleAndAuth(assignDataMap);

        return ResultEntity.successWithoutData();
    }

    @ResponseBody
    @RequestMapping("/assign/get/assigned/auth/id/list")
    public ResultEntity<List<Integer>> getAssignedAuthIdList(@RequestParam("roleId") Integer roleId) {

        List<Integer> authIdList = authService.getAssignedAuthIdList(roleId);

        return ResultEntity.successWithData(authIdList);
    }

    @ResponseBody
    @RequestMapping("/assign/get/all/auth")
    public ResultEntity<List<Auth>> getAllAuth() {

        List<Auth> authList = authService.getAllAuth();

        return ResultEntity.successWithData(authList);
    }

    @RequestMapping("/assign/role")
    public String doAssignRole(
            // roleIdList不一定每一次都能够提供，没有提供我们也接受
            @RequestParam(value="roleIdList", required=false) List<Integer> roleIdList,
            @RequestParam("adminId") Integer adminId,
            @RequestParam("pageNum") String pageNum) {

        roleService.updateRelationship(adminId, roleIdList);

        return "redirect:/admin/query/for/search.html?pageNum="+pageNum;
    }

    @RequestMapping("/assign/to/assign/role/page")
    public String toAssignRolePage(@RequestParam("adminId") Integer adminId, Model model) {

        // 1.查询已分配角色
        List<Role> assignedRoleList = roleService.getAssignedRoleList(adminId);

        // 2.查询未分配角色
        List<Role> unAssignedRoleList = roleService.getUnAssignedRoleList(adminId);

        // 3.存入模型
        model.addAttribute("assignedRoleList", assignedRoleList);
        model.addAttribute("unAssignedRoleList", unAssignedRoleList);

        return "assign-role";
    }
}

package xyz.lhtsky.atcrowdfunding.handler;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.lhtsky.atcrowdfunding.entity.ResultEntity;
import xyz.lhtsky.atcrowdfunding.entity.Role;
import xyz.lhtsky.atcrowdfunding.service.api.RoleService;

import java.util.List;

@RestController
public class RoleHandler {

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/role/search/by/keyword")
    public ResultEntity<PageInfo<Role>> search(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
            @RequestParam(value="keyword", defaultValue="") String keyword
    ){
        //1.查询得到PageInfo对象
        PageInfo<Role> pageInfo = roleService.queryForKeywordWithPage(pageNum,pageSize,keyword);

        // 2.封装结果对象返回
        return ResultEntity.successWithData(pageInfo);
    }

    @ResponseBody
    @RequestMapping("/role/save/role")
    public ResultEntity<String> saveRole(@RequestParam("roleName") String roleName) {

        roleService.saveRole(roleName);

        return ResultEntity.successWithoutData();
    }

    @RequestMapping("/role/batch/remove")
    public ResultEntity<String> batchRemove(@RequestBody List<Integer> roleIdList) {

        roleService.batchRemove(roleIdList);

        return ResultEntity.successWithoutData();
    }

    @RequestMapping("/role/get/list/by/id/list")
    public ResultEntity<List<Role>> getRoleListByIdList(@RequestBody List<Integer> roleIdList) {

        List<Role> roleList = roleService.getRoleListByIdList(roleIdList);

        return ResultEntity.successWithData(roleList);
    }

    // @ResponseBody
    @RequestMapping("/role/update/role")
    public ResultEntity<String> updateRole(Role role) {

        roleService.updateRole(role);

        return ResultEntity.successWithoutData();
    }
}

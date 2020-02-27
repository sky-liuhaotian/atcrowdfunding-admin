package xyz.lhtsky.atcrowdfunding.service.api;

import com.github.pagehelper.PageInfo;
import xyz.lhtsky.atcrowdfunding.entity.Role;

import java.util.List;

public interface RoleService {
    PageInfo<Role> queryForKeywordWithPage(Integer pageNum, Integer pageSize, String keyword);

    List<Role> getRoleListByIdList(List<Integer> roleIdList);

    void batchRemove(List<Integer> roleIdList);

    void saveRole(String roleName);

    void updateRole(Role role);
}

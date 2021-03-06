package xyz.lhtsky.atcrowdfunding.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lhtsky.atcrowdfunding.entity.Role;
import xyz.lhtsky.atcrowdfunding.entity.RoleExample;
import xyz.lhtsky.atcrowdfunding.mapper.RoleMapper;
import xyz.lhtsky.atcrowdfunding.service.api.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public PageInfo<Role> queryForKeywordWithPage(Integer pageNum, Integer pageSize, String keyword) {
        //1.开启分页功能
        PageHelper.startPage(pageNum,pageSize);

        //2.执行查询
      List<Role> list = roleMapper.selectForKeywordSearch(keyword);

      //3.封装为PageInfo对象
        return new PageInfo<>(list);
    }

    @Override
    public List<Role> getRoleListByIdList(List<Integer> roleIdList) {
        // 创建实体类Role对应的Example对象
        RoleExample roleExample = new RoleExample();

        // 在Example对象中封装查询条件
        roleExample.createCriteria().andIdIn(roleIdList);

        // 执行查询
        return roleMapper.selectByExample(roleExample);
    }

    @Override
    public void batchRemove(List<Integer> roleIdList) {
        RoleExample roleExample = new RoleExample();

        roleExample.createCriteria().andIdIn(roleIdList);

        roleMapper.deleteByExample(roleExample);
    }

    @Override
    public void saveRole(String roleName) {
        roleMapper.insert(new Role(null, roleName));
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public List<Role> getAssignedRoleList(Integer adminId) {
        List<Role> roleList = roleMapper.selectUnAssignedRoleList(adminId);

        return roleList;
    }

    @Override
    public List<Role> getUnAssignedRoleList(Integer adminId) {
        return null;
    }

    @Override
    public void updateRelationship(Integer adminId, List<Integer> roleIdList) {

    }
}

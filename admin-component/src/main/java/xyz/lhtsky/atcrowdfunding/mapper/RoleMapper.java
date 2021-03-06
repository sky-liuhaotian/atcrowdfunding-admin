package xyz.lhtsky.atcrowdfunding.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.lhtsky.atcrowdfunding.entity.Role;
import xyz.lhtsky.atcrowdfunding.entity.RoleExample;

import java.util.List;

public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectForKeywordSearch(String keyword);

    List<Role> selectAssignedRoleList(Integer adminId);

    List<Role> selectUnAssignedRoleList(Integer adminId);

    void deleteOldAdminRelationship(Integer adminId);

    void insertNewAdminRelationship(@Param("adminId") Integer adminId, @Param("roleIdList") List<Integer> roleIdList);
}
package xyz.lhtsky.atcrowdfunding.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.lhtsky.atcrowdfunding.entity.Admin;
import xyz.lhtsky.atcrowdfunding.entity.AdminExample;

import java.util.List;

public interface AdminMapper {
    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> selectAdminListByKeyword(String keyword);
}
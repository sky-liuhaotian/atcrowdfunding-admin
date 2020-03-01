package xyz.lhtsky.atcrowdfunding.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lhtsky.atcrowdfunding.CrowdFundingUtils;
import xyz.lhtsky.atcrowdfunding.entity.Auth;
import xyz.lhtsky.atcrowdfunding.entity.AuthExample;
import xyz.lhtsky.atcrowdfunding.mapper.AuthMapper;
import xyz.lhtsky.atcrowdfunding.service.api.AuthService;

import java.util.List;
import java.util.Map;

/**
 * @Author sky
 * @Date 2020/3/1 15:30
 * @Version 1.0
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthMapper authMapper;

    @Override
    public List<Auth> getAllAuth() {
        return authMapper.selectByExample(new AuthExample());
    }

    @Override
    public List<Integer> getAssignedAuthIdList(Integer roleId) {
        return authMapper.selectAssignedAuthIdList(roleId);
    }

    @Override
    public void updateRelationShipBetweenRoleAndAuth(Map<String, List<Integer>> assignDataMap) {

        // 1.获取两部分List数据
        List<Integer> roleIdList = assignDataMap.get("roleIdList");
        List<Integer> authIdList = assignDataMap.get("authIdList");

        // 2.取出roleId
        Integer roleId = roleIdList.get(0);

        // 3.删除旧数据
        authMapper.deleteOldRelationship(roleId);

        // 4.保存新数据
        if(CrowdFundingUtils.collectionEffective(authIdList)) {
            authMapper.insertNewRelationship(roleId, authIdList);
        }
    }
}

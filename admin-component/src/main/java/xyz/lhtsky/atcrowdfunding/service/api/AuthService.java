package xyz.lhtsky.atcrowdfunding.service.api;


import xyz.lhtsky.atcrowdfunding.entity.Auth;

import java.util.List;
import java.util.Map;

public interface AuthService {

	List<Auth> getAllAuth();
	
	List<Integer> getAssignedAuthIdList(Integer roleId);

	void updateRelationShipBetweenRoleAndAuth(Map<String, List<Integer>> assignDataMap);

}

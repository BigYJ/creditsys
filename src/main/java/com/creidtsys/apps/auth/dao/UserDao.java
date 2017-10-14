package com.creidtsys.apps.auth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.creidtsys.apps.auth.entity.Permission;
import com.creidtsys.apps.auth.entity.User;

public interface UserDao {

	List<User> selectAll();

	User selectPrimaryById(Integer userId);

	User findUserByLoginName(String username);

	// ��ȡ�û�������Ȩ��
	List<Permission> findUserPermissionByName(String username);

	int insert(User user);

	int delete(Integer userId);

	int update(User user);

	int selectCount();

	List<User> limit(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

	// ���Ȩ��
	int insertRole(@Param("roleId") Integer roleId, @Param("userId") Integer userId);
	
	int updateRole(@Param("roleId") Integer roleId, @Param("userId") Integer userId);
	
	int countUserRoleById(Integer userId);
}
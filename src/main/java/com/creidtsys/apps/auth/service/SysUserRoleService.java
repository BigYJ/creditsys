package com.creidtsys.apps.auth.service;

import java.util.List;

import com.creidtsys.apps.auth.entity.SysDept;
import com.creidtsys.apps.auth.entity.SysUserRole;

/**
 * 
* @ClassName: SysUserRoleService
* @Description: TODO �û���ɫ��ϵservice
* @author liuyj
* @date 2017��8��26�� ����11:02:09
*
 */
public interface SysUserRoleService {
	/**
	 * 
	* @Title: getRoleByUser 
	* @Description: TODO �����û���ѯ��������ɫ 
	* @param userId
	* @return    
	* @return List<SysDept>    ��������
	 */
	List<SysUserRole> getRoleByUser(String userId);
	/**
	 * 
	* @Title: saveUserRole 
	* @Description: TODO ά���û����ɫ֮��Ĺ�ϵ 
	* @param sysUserRole    
	* @return void    ��������
	 */
	
	void saveUserRole(SysUserRole sysUserRole);

}

package com.creidtsys.apps.auth.dao;

import java.util.List;

import com.creidtsys.apps.auth.entity.SysUserRole;

/**
 * 
* @ClassName: SysUserRoleDao
* @Description: TODO �û���ɫ��ϵdao
* @author liuyj
* @date 2017��8��26�� ����11:01:08
*
 */
public interface SysUserRoleDao {
	/**
	 * 
	* @Title: getRoleByUser 
	* @Description: TODO �������û���ѯְλ
	* @return    
	* @return List<SysUserRole>    ��������
	 */
	List<SysUserRole> getRoleByUser(String userId);
	/**
	 * 
	* @Title: delReByUser 
	* @Description: TODO �����û�ɾ�������ɫ֮��Ĺ�ϵ
	* @param urUserid    
	* @return void    ��������
	 */
	void delReByUser(String urUserid);
	/**
	 * 
	* @Title: addRe 
	* @Description: TODO �����û����ɫ֮��Ĺ�ϵ
	* @param newSysUserRole    
	* @return void    ��������
	 */
	void addRe(SysUserRole newSysUserRole);

}

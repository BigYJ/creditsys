package com.creidtsys.apps.auth.dao;

import java.util.List;

import com.creidtsys.apps.auth.entity.SysUser;

/**
 * 
* @ClassName: SysUserDao
* @Description: TODO Ȩ���û�dao��
* @author liuyj
* @date 2017��8��26�� ����10:23:57
*
 */
public interface SysUserDao {
	/**
	 * 
	* @Title: getAllUser 
	* @Description: TODO ��ѯȫ���û�������������ɫ��
	* @return    
	* @return List<SysUser>    ��������
	 */
	List<SysUser> getAllUser(SysUser sysUser);
	/**
	 * 
	* @Title: addUser 
	* @Description: TODO ����û�
	* @param sysUser    
	* @return void    ��������
	 */
	void addUser(SysUser sysUser);
	/**
	 * 
	* @Title: delUser 
	* @Description: TODO ɾ���û���Ϣ
	* @param userId    
	* @return void    ��������
	 */
	void delUser(String userId);
	/**
	 * 
	* @Title: editUser 
	* @Description: TODO �޸��û���Ϣ
	* @param sysUser    
	* @return void    ��������
	 */
	void editUser(SysUser sysUser);
	/**
	 * 
	* @Title: getUserByLoginName 
	* @Description: TODO  ���ݵ�¼����ȡ�û���Ϣ
	* @param userName
	* @return    
	* @return SysUser    ��������
	 */
	SysUser getUserByLoginName(String userName);

}

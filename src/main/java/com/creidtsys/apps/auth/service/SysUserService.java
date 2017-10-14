package com.creidtsys.apps.auth.service;

import java.util.List;

import com.creidtsys.apps.auth.entity.SysRes;
import com.creidtsys.apps.auth.entity.SysUser;


/**
 * 
* @ClassName: SysUserService
* @Description: TODO Ȩ���û�service��
* @author liuyj
* @date 2017��8��26�� ����10:24:43
*
 */
public interface SysUserService {
	/**
	 * 
	* @Title: getAllUser 
	* @Description: TODO �����û������ݲ��ű�ʶ��������Ϊ�գ�
	* @param sysUser
	* @return    
	* @return List<SysUser>    ��������
	 */
	List<SysUser> getAllUser(SysUser sysUser);
	/**
	 * 
	* @Title: saveUser 
	* @Description: TODO ����û�
	* @param sysUser    
	* @return void    ��������
	 */
	void saveUser(SysUser sysUser);
	/**
	 * 
	* @Title: delUsers 
	* @Description: TODO ����ɾ���û�
	* @param ids    
	* @return void    ��������
	 */
	void delUsers(String ids);
	/**
	 * 
	* @Title: updateDept 
	* @Description: TODO �޸��û���Ϣ
	* @param sysUser    
	* @return void    ��������
	 */
	void updateDept(SysUser sysUser);
	/**
	 * 
	* @Title: getUserByLoginName 
	* @Description: TODO ���ݵ�¼����ȡ�û���Ϣ
	* @param username
	* @return    
	* @return SysUser    ��������
	 */
	SysUser getUserByLoginName(String userName);
}


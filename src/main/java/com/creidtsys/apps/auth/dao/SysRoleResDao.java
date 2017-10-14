package com.creidtsys.apps.auth.dao;

import java.util.List;

import com.creidtsys.apps.auth.entity.SysRoleRes;

/**
 * 
* @ClassName: SysRoleResDao
* @Description: TODO Ȩ�޽�ɫ��Դdao
* @author liuyj
* @date 2017��8��26�� ����10:49:26
*
 */
public interface SysRoleResDao {
	/**
	 * 
	* @Title: addRoleRes 
	* @Description: TODO ���Ȩ�޽�ɫ֮��Ĺ�ϵ
	* @param sysRoleRes    
	* @return void    ��������
	 */
	void addRoleRes(SysRoleRes sysRoleRes);
	/**
	 * 
	* @Title: getResByRole 
	* @Description: TODO ���ݽ�ɫ��ȡȨ��
	* @param roleId
	* @return    
	* @return List<SysRoleRes>    ��������
	 */
	List<SysRoleRes> getResByRole(String roleId);
	/**
	 * 
	* @Title: delResByRole 
	* @Description: TODO ���ݽ�ɫɾ����ϵ
	* @param roleId    
	* @return void    ��������
	 */
	void delResByRole(String roleId);
	/**
	 * 
	* @Title: addRes 
	* @Description: TODO ��ӽ�ɫ����Դ֮��Ĺ�ϵ 
	* @param userRes    
	* @return void    ��������
	 */
	void addRes(SysRoleRes userRes);

}

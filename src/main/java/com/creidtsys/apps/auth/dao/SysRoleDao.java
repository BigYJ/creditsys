package com.creidtsys.apps.auth.dao;

import java.util.List;
import java.util.Map;

import com.creidtsys.apps.auth.entity.SysRole;

/**
 * 
* @ClassName: SysRoleDao
* @Description: TODO Ȩ�޽�ɫdao 
* @author liuyj
* @date 2017��8��26�� ����10:37:05
*
 */

public interface SysRoleDao {
	/**
	 * 
	* @Title: getAllRole 
	* @Description: TODO ��ѯ���н�ɫ 
	* @param roleParentId �ϼ���ɫ��ʶ
	* @return    
	* @return List<SysRole>    ��������
	 */
	List<SysRole> getAllRole(String roleParentId);
	/**
	 * 
	* @Title: delRoles 
	* @Description: TODO ��������ɾ����ɫ��Ϣ 
	* @param roleId    
	* @return void    ��������
	 */
	void delRoles(String roleId);
	/**
	 * 
	* @Title: addRole 
	* @Description: TODO ��ӽ�ɫ��Ϣ
	* @param sysRole    
	* @return void    ��������
	 */
	void addRole(SysRole sysRole);
	/**
	 * 
	* @Title: editRole 
	* @Description: TODO �޸Ľ�ɫ��Ϣ
	* @param sysRole    
	* @return void    ��������
	 */
	void editRole(SysRole sysRole);
	/**
	 * 
	* @Title: getTreeDate 
	* @Description: TODO ����id����pid ��ѯ��ɫ
	* @param para
	* @return    
	* @return List<SysRole>    ��������
	 */
	List<SysRole> getTreeDate(Map<String, Object> para);
	/**
	 * 
	* @Title: getById 
	* @Description: TODO ����roleId��ȡ��ɫ��Ϣ
	* @param roleId
	* @return    
	* @return SysRole    ��������
	 */
	SysRole getById(String roleId);

}

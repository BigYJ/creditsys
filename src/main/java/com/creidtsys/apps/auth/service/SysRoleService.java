package com.creidtsys.apps.auth.service;

import java.util.List;

import com.creidtsys.apps.auth.entity.SysRole;
import com.creidtsys.utils.TreeModel;

/**
 * 
* @ClassName: SysRoleService
* @Description: TODO  Ȩ���û�service��
* @author liuyj
* @date 2017��8��26�� ����10:35:56
*
 */
public interface SysRoleService {
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
	* @Title: initRoleTree 
	* @Description: TODO ��ʼ����ɫ�� 
	* @return    
	* @return List<SysRole>    ��������
	 */
	List<SysRole> initRoleTree();
	/**
	 * 
	* @Title: delRoles 
	* @Description: TODO ɾ����ɫ��Ϣ
	* @param ids    
	* @return void    ��������
	 */
	void delRoles(String ids);
	/**
	 * 
	* @Title: saveRole 
	* @Description: TODO ��ӽ�ɫ
	* @param sysRole    
	* @return void    ��������
	 */
	void saveRole(SysRole sysRole);
	/**
	 * 
	* @Title: updateRole 
	* @Description: TODO  �޸Ľ�ɫ��Ϣ
	* @param sysRole    
	* @return void    ��������
	 */
	void updateRole(SysRole sysRole);
	/**
	 * 
	* @Title: selectTree 
	* @Description: TODO ���role��
	* @param id
	* @return    
	* @return TreeModel    ��������
	 */
	TreeModel selectTree(String id);
	/**
	 * 
	* @Title:  getById 
	* @Description: TODO ����roleId��ȡ��ɫ��Ϣ 
	* @param roleId
	* @return    
	* @return SysRole    ��������
	 */
	SysRole getById(String roleId);
}

package com.creidtsys.apps.auth.service;

import java.util.List;
import java.util.Map;

import com.creidtsys.apps.auth.entity.SysRoleRes;

/**
 * 
* @ClassName: SysRoleResService
* @Description: TODO Ȩ�޽�ɫ��Դservice
* @author liuyj
* @date 2017��8��26�� ����10:50:30
*
 */
public interface SysRoleResService {
	/**
	 * 
	* @Title: resRoleTree 
	* @Description: TODO ���ݽ�ɫid���Ȩ��
	* @param roleId
	* @return    
	* @return List<SysUserRes>    ��������
	 */
	List<SysRoleRes> resRoleTree(String roleId);
	/**
	 * 
	* @Title: saveRela 
	* @Description: TODO �޸ı����ɫ��Դ��ϵ
	* @param map    
	* @return void    ��������
	 */
	void saveRela(Map<String, String> map);

}

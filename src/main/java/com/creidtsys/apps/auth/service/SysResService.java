package com.creidtsys.apps.auth.service;

import java.util.List;

import com.creidtsys.apps.auth.entity.SysRes;
import com.creidtsys.apps.auth.entity.SysRole;
import com.creidtsys.utils.TreeModel;

/**
 * 
* @ClassName: SysResService
* @Description: TODO Ȩ����Դservice 
* @author liuyj
* @date 2017��8��26�� ����10:45:27
*
 */
public interface SysResService {
	/**
	 * 
	* @Title: getAllRes 
	* @Description: TODO ��ѯ���е�Ȩ����Դ
	* @return    
	* @return List<SysRes>    ��������
	 */
	List<SysRes> getAllRes();
	/**
	 * 
	* @Title: initResTree 
	* @Description: TODO  ��ʼ����ԴȨ����
	* @return    
	* @return List<SysRes>    ��������
	 */
	List<SysRes> initResTree();
	/**
	 * 
	* @Title: saveRole 
	* @Description: TODO ���Ȩ����Դ��Ϣ
	* @param sysRes    
	* @return void    ��������
	 */
	void saveRole(SysRes sysRes);
	/**
	 * 
	* @Title: selectTree 
	* @Description: TODO ��ȡ��Դ��
	* @param id
	* @return    
	* @return TreeModel    ��������
	 */
	TreeModel selectTree(String id);
	/**
	 * 
	* @Title: updateRes 
	* @Description: TODO(������һ�仰�����������������) 
	* @param sysRes    
	* @return void    ��������
	 */
	void updateRes(SysRes sysRes);
	/**
	 * 
	* @Title: delRes 
	* @Description: TODO ɾ����Դ
	* @param ids    
	* @return void    ��������
	 */
	void delRes(String ids);

}

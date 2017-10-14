package com.creidtsys.apps.auth.service;

import java.util.List;
import java.util.Map;

import com.creidtsys.apps.auth.entity.SysRes;
import com.creidtsys.apps.auth.entity.SysUserRes;

/**
 * 
* @ClassName: SysUserResService
* @Description: TODO �û�Ȩ�޹�ϵservice��
* @author liuyj
* @date 2017��8��26�� ����10:55:57
*
 */
public interface SysUserResService {
	/**
	 * 
	* @Title: getResByUser 
	* @Description: TODO ��ѯ�û�����Ȩ��
	* @param userId
	* @return    
	* @return List<SysRes>    ��������
	 */
	List<SysUserRes> getResByUser(String userId);
	/**
	 * 
	* @Title: getUserRes 
	* @Description: TODO ����û���������Ȩ
	* @param userId
	* @return    
	* @return List<SysUserRes>    ��������
	 */
	List<SysUserRes> getUserRes(String userId);
	/**
	 * 
	* @Title: getRoleRes 
	* @Description: TODO ����û�������ɫ��Ȩ��
	* @param userId
	* @return    
	* @return List<SysUserRes>    ��������
	 */
	
	List<SysUserRes> getRoleRes(String userId);
	/**
	 * 
	* @Title: resUserTree 
	* @Description: TODO huoide ��ú���checkbox��Ȩ���� 
	* @param userId
	* @return    
	* @return List<SysUserRes>    ��������
	 */
	List<SysUserRes> resUserTree(String userId);
	/**
	 * 
	* @Title: saveUserRes 
	* @Description: TODO �Զ��û���Ȩ��֮��Ĺ�ϵ����ά��
	* @param map
	* @return    
	* @return void    ��������
	 */
	void saveUserRes(Map<String, String> map);
	/**
	 * 
	* @Title: getPermissionByNo 
	* @Description: TODO �����û���Ż����Ȩ��
	* @param userNo
	* @return    
	* @return List<SysRes>    ��������
	 */
	List<SysUserRes> getPermissionByNo(String userNo);
	/**
	 * 
	* @Title: getAuthMenu 
	* @Description: TODO ��ȡ�˵�Ȩ��
	* @param userId
	* @return    
	* @return List<Map<String,String>>    ��������
	 */
	List<Map<String, String>> getAuthMenu(String userNo);
	/**
	 * 
	* @Title: findRoots 
	* @Description: TODO ƴ�ӳ��ַ����ַ���
	* @param list
	* @return    
	* @return List    ��������
	 */
	List findRoots(List<Map<String, String>> list);

}
package com.creidtsys.apps.auth.dao;

import java.util.List;
import java.util.Map;

import com.creidtsys.apps.auth.entity.SysRes;
import com.creidtsys.apps.auth.entity.SysUserRes;

/**
 * 
* @ClassName: SysUserResDao
* @Description: TODO �û�Ȩ�޹�ϵdao
* @author liuyj
* @date 2017��8��26�� ����10:55:14
*
 */
public interface SysUserResDao {
	/**
	 * 
	* @Title: getResByUser 
	* @Description: TODO �����û���ѯ������Ȩ��
	* @param userId
	* @return    
	* @return List<SysUserRes>    ��������
	 */
	List<SysUserRes> getResByUser(String userId);
	/**
	 * 
	* @Title: getUserRes 
	* @Description: TODO  ����û�������Ȩ���Ȩ��
	* @param userId
	* @return    
	* @return List<SysUserRes>    ��������
	 */
	List<SysUserRes> getUserRes(String userId);
	/**
	 * 
	* @Title: getRoleRes 
	* @Description: TODO ����û�������ɫ��Ȩ��
	* @return    
	* @return List<SysUserRes>    ��������
	 */
	List<SysUserRes> getRoleRes(String userId);
	/**
	 * 
	* @Title: getChecked 
	* @Description: TODO ��ú���checkbox��Ȩ����
	* @param userId
	* @return    
	* @return List<SysUserRes>    ��������
	 */
	List<SysUserRes> getChecked(String userId);
	/**
	 * 
	* @Title: delResByUser 
	* @Description: TODO ɾ���û�Ȩ��֮��Ĺ�ϵ
	* @param userId    
	* @return void    ��������
	 */
	
	void delResByUser(String userId);
	/**
	 * 
	* @Title: addRes 
	* @Description: TODO ����û���Ȩ��֮��Ĺ�ϵ
	* @param userRes    
	* @return void    ��������
	 */
	
	void addRes(SysUserRes userRes);
	/**
	 * 
	* @Title: getResByNo 
	* @Description: TODO �����û���Ż����Ȩ��
	* @param userNo
	* @return    
	* @return List<SysUserRes>    ��������
	 */
	List<SysUserRes> getResByNo(String userNo);
	/**
	 * 
	* @Title: getAuthMenu 
	* @Description: TODO ����û��Ѿ���Ȩ�Ĳ˵�
	* @param userNo
	* @return    
	* @return List<Map<String,String>>    ��������
	 */
	List<Map<String, String>> getAuthMenu(String userNo);
	
	/**
	 * 
	* @Title: get 
	* @Description: TODO ��Ч����
	* @param userNo
	* @return    
	* @return List<Map<String,String>>    ��������
	 */
	List<Map<String, String>> get(String userNo);
	/**
	 * 
	* @Title: getLeafId 
	* @Description: TODO �����û���ȡȨ��Ҷ�ӽڵ�
	* @param userNo
	* @return    
	* @return List<SysRes>    ��������
	 */
	List<SysUserRes> getLeafId(String userNo);
	/**
	 * 
	* @Title: getResPid 
	* @Description: TODO �ݹ���ݻ���ȡ���ڵ�
	* @param resId
	* @return    
	* @return List<SysRes>    ��������
	 */
	List<SysRes> getResPid(String resId);

}

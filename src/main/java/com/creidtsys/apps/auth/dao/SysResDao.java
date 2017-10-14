package com.creidtsys.apps.auth.dao;

import java.util.List;
import java.util.Map;

import com.creidtsys.apps.auth.entity.SysRes;
import com.creidtsys.apps.auth.entity.SysRole;

/**
 * 
* @ClassName: SysResDao
* @Description: TODO Ȩ����Դdao��
* @author liuyj
* @date 2017��8��26�� ����10:44:07
*
 */
public interface SysResDao {
	/**
	 * 
	* @Title: getRes 
	* @Description: TODO ��ѯ����Ȩ����Դ
	* @return    
	* @return List<SysRes>    ��������
	 */
	List<SysRes> getRes();
	/**
	 * 
	* @Title: addRes 
	* @Description: TODO ���Ȩ����Դ��Ϣ
	* @param sysRes    
	* @return void    ��������
	 */
	void addRes(SysRes sysRes);
	/**
	 * 
	* @Title: getTreeDate 
	* @Description: TODO ����id����pid�����Դ
	* @param para
	* @return    
	* @return List<SysRes>    ��������
	 */
	
	List<SysRes> getTreeDate(Map<String, Object> para);
	/**
	 * 
	* @Title: editRes 
	* @Description: TODO ����Ȩ����Ϣ 
	* @param sysRes    
	* @return void    ��������
	 */
	void editRes(SysRes sysRes);
	/**
	 * 
	* @Title: delRes 
	* @Description: TODO ɾ���估������Դ
	* @param resId    
	* @return void    ��������
	 */
	void delRes(String resId);

}

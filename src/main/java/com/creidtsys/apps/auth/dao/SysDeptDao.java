package com.creidtsys.apps.auth.dao;

import java.util.List;
import java.util.Map;

import com.creidtsys.apps.auth.entity.SysDept;
import com.creidtsys.apps.auth.entity.Tree;

/**
 * 
* @ClassName: SysDeptDao
* @Description: TODO Ȩ����֯dao��
* @author liuyj
* @date 2017��8��26�� ����10:38:19
*
 */
public interface SysDeptDao {
	/**
	 * 
	* @Title: getSysDept 
	* @Description: TODO ��ѯ������Ϣ
	* @param deptParentId  �ϼ�������Ϣ
	* @return    
	* @return List<SysDept>    ��������
	 */
	List<SysDept> getSysDept(String deptParentId);
	/**
	 * 
	* @Title: addDept 
	* @Description: TODO �����֯���� 
	* @param sysDept    
	* @return void    ��������
	 */
	void addDept(SysDept sysDept);
	/**
	 * 
	* @Title: delDept 
	* @Description: TODO ��������ɾ����֯������Ϣ
	* @param deptId    
	* @return void    ��������
	 */
	void delDept(String deptId);
	/**
	 * 
	* @Title: editDept 
	* @Description: TODO �޸���֯������Ϣ
	* @param sysDept    
	* @return void    ��������
	 */
	void editDept(SysDept sysDept);
	/**
	 * 
	* @Title: getTreeDate 
	* @Description: TODO ����id����pid��ȡ����
	* @param para
	* @return    
	* @return List<Tree>    ��������
	 */
	List<SysDept> getTreeDate(Map<String, Object> para);
	/**
	 * 
	* @Title: getById 
	* @Description: TODO ����������ò�����Ϣ
	* @param deptId
	* @return    
	* @return SysDept    ��������
	 */
	SysDept getById(String deptId);
}

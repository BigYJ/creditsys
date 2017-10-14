package com.creidtsys.apps.auth.service;

import java.util.List;

import com.creidtsys.apps.auth.entity.SysDept;
import com.creidtsys.utils.TreeModel;

/**
 * 
* @ClassName: SysDeptService
* @Description: TODO Ȩ����֯servicre��
* @author liuyj
* @date 2017��8��26�� ����10:39:01
*
 */
public interface SysDeptService {
	/**
	 * 
	* @Title: getAllDept 
	* @Description: TODO  ��ѯ���в�����Ϣ 
	* @param deptParentId  �ϼ�������Ϣ
	* @return    
	* @return List<SysDept>    ��������
	 */
	List<SysDept> getAllDept(String deptParentId);
	/**
	 * 
	* @Title: initDeptTree 
	* @Description: TODO(������һ�仰�����������������) 
	* @return    
	* @return List<SysDept>    ��������
	 */
	List<SysDept> initDeptTree();
	/**
	 * 
	* @Title: saveDept 
	* @Description: TODO    �����֯����
	* @param sysDept    
	* @return void    ��������
	 */
	void saveDept(SysDept sysDept);
	/**
	 * 
	* @Title: delDept 
	* @Description: TODO ɾ����֯����
	* @param ids    ����������֯������ʶ
	* @return void    ��������
	 */
	void delDept(String ids);
	/**
	 * 
	* @Title: updateDept 
	* @Description: TODO �޸�����
	* @param sysDept    
	* @return void    ��������
	 */
	void updateDept(SysDept sysDept);
	/**
	 * 
	* @Title: selectTree 
	* @Description: TODO ��������ݸ�ʽ
	* @param id
	* @return    
	* @return TreeModel    ��������
	 */
	TreeModel selectTree(String id);
	/**
	 * 
	* @Title: getById 
	* @Description: TODO  ����������ѯ������Ϣ
	* @param deptId
	* @return    
	* @return SysDept    ��������
	 */
	SysDept getById(String deptId);

}

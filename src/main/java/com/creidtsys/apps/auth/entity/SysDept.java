package com.creidtsys.apps.auth.entity;

import com.creidtsys.utils.Pager;

/**
 * 
* @ClassName: SysDept
* @Description: TODO Ȩ����֯����ʵ��
* @author liuyj
* @date 2017��8��26�� ����8:59:40
*
 */
public class SysDept extends Pager {
	private String deptId ;    		//��֯������ʶ
	private String deptName ;   	//��֯��������
	private String deptDesc ;		//��֯��������
	private String deptParentId ; 	//�ϼ���֯������ʶ
	private String deptLevel ; 		//��֯�����ȼ�
	private String deptOrder ;		//��֯�������
	private String deptIsValid ;	//��֯������Ч��ʶ
	private String deptLeader ;     //��֯����������
	
	public String getDeptLeader() {
		return deptLeader;
	}
	public void setDeptLeader(String deptLeader) {
		this.deptLeader = deptLeader;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDesc() {
		return deptDesc;
	}
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}
	public String getDeptParentId() {
		return deptParentId;
	}
	public void setDeptParentId(String deptParentId) {
		this.deptParentId = deptParentId;
	}
	public String getDeptLevel() {
		return deptLevel;
	}
	public void setDeptLevel(String deptLevel) {
		this.deptLevel = deptLevel;
	}
	public String getDeptOrder() {
		return deptOrder;
	}
	public void setDeptOrder(String deptOrder) {
		this.deptOrder = deptOrder;
	}
	public String getDeptIsValid() {
		return deptIsValid;
	}
	public void setDeptIsValid(String deptIsValid) {
		this.deptIsValid = deptIsValid;
	}
	

}

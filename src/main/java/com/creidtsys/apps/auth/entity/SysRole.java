package com.creidtsys.apps.auth.entity;

import java.io.Serializable;

import com.creidtsys.utils.Pager;
/**
 * 
* @ClassName: SysRole
* @Description: TODO Ȩ�޽�ɫʵ��
* @author liuyj
* @date 2017��8��26�� ����8:53:08
*
 */
@SuppressWarnings("serial")
public class SysRole   extends Pager  implements Serializable{
	private String roleId ;       //��ɫ��ʶ
	private String roleName ;     //��ɫ����
	private String roleIsValid ;  //��ɫ��Ч��
	private String roleParentId ; //�ϼ���ɫ��ʶ
	private String remake ;       //��ע
	private String resIds ;       //��֮������Ȩ�޵ļ���
	
	public SysRole() {
		super();
	}
	
	public String getResIds() {
		return resIds;
	}

	public void setResIds(String resIds) {
		this.resIds = resIds;
	}

	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleIsValid() {
		return roleIsValid;
	}
	public void setRoleIsValid(String roleIsValid) {
		this.roleIsValid = roleIsValid;
	}
	public String getRoleParentId() {
		return roleParentId;
	}
	public void setRoleParentId(String roleParentId) {
		this.roleParentId = roleParentId;
	}
	public String getRemake() {
		return remake;
	}
	public void setRemake(String remake) {
		this.remake = remake;
	}
}

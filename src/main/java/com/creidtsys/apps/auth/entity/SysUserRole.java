package com.creidtsys.apps.auth.entity;

import java.io.Serializable;
/**
 * 
* @ClassName: SysUserRole
* @Description: TODO Ȩ���û���ɫ����ʵ��
* @author liuyj
* @date 2017��8��26�� ����9:23:20
*
 */
@SuppressWarnings("serial")
public class SysUserRole   extends SysRole implements Serializable{
	private String urUserId ;  //�û���ʶ
	private String urRoleId ;  //��ɫ��ʶ
	private String roleIds ;   //��ɫ��ʶ��
	
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	public String getUrUserId() {
		return urUserId;
	}
	public void setUrUserId(String urUserId) {
		this.urUserId = urUserId;
	}
	public String getUrRoleId() {
		return urRoleId;
	}
	public void setUrRoleId(String urRoleId) {
		this.urRoleId = urRoleId;
	}
}

package com.creidtsys.apps.auth.entity;


/**
 * 
* @ClassName: SysUserRes
* @Description: TODO �û�����Դ��ϵʵ��
* @author liuyj
* @date 2017��8��26�� ����9:59:52
*
 */
public class SysUserRes  extends SysRoleRes  {
	private String urUserId ; 	//�û���ʶ
	private String urResId ;  	//��Դ��ʶ
	public SysUserRes() {
		super();
	}
	public String getUrUserId() {
		return urUserId;
	}
	public void setUrUserId(String urUserId) {
		this.urUserId = urUserId;
	}
	public String getUrResId() {
		return urResId;
	}
	public void setUrResId(String urResId) {
		this.urResId = urResId;
	}
}

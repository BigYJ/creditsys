package com.creidtsys.apps.auth.entity;

import java.io.Serializable;

import com.creidtsys.utils.Pager;
/**
 * 
* @ClassName: SysRoleRes
* @Description: TODO   ��ɫurl��Դ������
* @author liuyj
* @date 2017��8��26�� ����9:30:59
*
 */
@SuppressWarnings("serial")
public class SysRoleRes  extends SysRes   implements Serializable{
	private String isChecked   ; //ѡ�б�ʶ
	private  String rrRoleId ;  //��ɫid
	private  String rrResId ;   //urlȨ��id
	public String getIsChecked() {
		return isChecked;
	}
	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}
	public String getRrRoleId() {
		return rrRoleId;
	}
	public void setRrRoleId(String rrRoleId) {
		this.rrRoleId = rrRoleId;
	}
	public String getRrResId() {
		return rrResId;
	}
	public void setRrResId(String rrResId) {
		this.rrResId = rrResId;
	}

	
 	 
}

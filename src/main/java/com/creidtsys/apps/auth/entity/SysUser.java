package com.creidtsys.apps.auth.entity;

import java.io.Serializable;

import com.creidtsys.utils.Pager;
/**
 * 
* @ClassName: SysUser
* @Description: TODO Ȩ���û�ʵ�� 
* @author liuyj
* @date 2017��8��26�� ����8:44:23
*
 */
@SuppressWarnings("serial")
public class SysUser  extends Pager  implements Serializable{
	private String userId ;        //�û���ʶ
	private String userDeptId ;    //�û����ű�ʶ
	private String userNo ;        //�û���ţ�ѧ�š����ţ� 
 	private String userPwd ;       //�û�����
	private String userName ;      //�û���
	private String userSex ;       //�û��Ա�
	private String cardId ;        //���֤��
	private String userAddr ;      //�û���ַ
	private String userContact ;   //�û���ϵ��ʽ
	private String enterDate ;     //��У��������
	private String leaveDate ;     //��У����
	private String userProfess ;   //ְ��
	private String userStatus ;    //�û�״̬ 
	private String userEmail ;     //�û�����
	private String lastLogin ;     //�ϴε�¼ʱ��
	private String schoolYear ;    //ѧ����
	private String remark ;        //��ע
	private String urUserId ;      //��ϲ�û�id
	
	public SysUser() {
		super();
	}
	
	public String getUrUserId() {
		return urUserId;
	}

	public void setUrUserId(String urUserId) {
		this.urUserId = urUserId;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserDeptId() {
		return userDeptId;
	}
	public void setUserDeptId(String userDeptId) {
		this.userDeptId = userDeptId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(String enterDate) {
		this.enterDate = enterDate;
	}
	public String getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getUserProfess() {
		return userProfess;
	}
	public void setUserProfess(String userProfess) {
		this.userProfess = userProfess;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getSchoolYear() {
		return schoolYear;
	}
	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
}

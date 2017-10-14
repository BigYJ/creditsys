package com.creidtsys.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import com.creidtsys.security.realm.ShiroDbRealm;
/**
 * 
* @ClassName: ShiroUtils
* @Description: TODO ��ǰ�û���Ϣ������
* @author liuyj
* @date 2017��9��7�� ����6:58:38
*
 */
public class ShiroUtils {
	/**
	 * 
	* @Title: getCurrentUser 
	* @Description: TODO ��ȡ��ǰ�û���¼��
	* @return    
	* @return String    ��������
	 */
	
	public static  String getLoginName(){
		String userNo = (String) SecurityUtils.getSubject().getPrincipals().iterator().next() ;
		return userNo ;
	}
	/**
	 * 
	* @Title: clearAuth 
	* @Description: TODO ���������ԴȨ��  
	* @return void    ��������
	 */
	public static void clearAuth(){
		RealmSecurityManager rsm = (RealmSecurityManager)SecurityUtils.getSecurityManager();
		ShiroDbRealm realm = (ShiroDbRealm)rsm.getRealms().iterator().next();
		realm.clearAuthz();
	}
}

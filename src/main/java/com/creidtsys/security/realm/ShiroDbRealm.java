package com.creidtsys.security.realm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.creidtsys.apps.auth.entity.SysUser;
import com.creidtsys.apps.auth.entity.SysUserRes;
import com.creidtsys.apps.auth.service.SysUserResService;
import com.creidtsys.apps.auth.service.SysUserService;
/**
 * 
* @ClassName: ShiroDbRealm
* @Description: TODO �Զ���shiro  AuthorizingRealm
* @author liuyj
* @date 2017��9��8�� ����10:43:33
*
 */
public class ShiroDbRealm extends AuthorizingRealm {
  
 
	@Autowired
	private SysUserService sysUserService ;
	@Autowired
	private SysUserResService sysUserResService ;
	public ShiroDbRealm() {
		super();
	}

	/**
	 * ��֤��½
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		SysUser sysUser = sysUserService.getUserByLoginName(token.getUsername()) ;
		//���ݵ�¼����ȡ�û���Ϣ
		if (sysUser != null) {
			return new SimpleAuthenticationInfo(sysUser.getUserNo(), sysUser.getUserPwd(), getName());
		} else {
			throw new AuthenticationException();
		}
	}

	/**
	 * ��½�ɹ�֮�󣬽��н�ɫ��Ȩ����֤
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		String userNo = (String) getAvailablePrincipal(principals);
		// �оٴ��û����е�Ȩ��
		//List<Permission> permissions = userService.findUserPermissionByName(username);
		List<SysUserRes> listRes = sysUserResService.getPermissionByNo(userNo) ;
		Set<String> strs=new HashSet<String>();
		Iterator<SysUserRes> it = listRes.iterator();
		while (it.hasNext()) {
			SysUserRes re=it.next();
			strs.add(re.getResUrl());
		}
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addStringPermissions(strs);
		return authorizationInfo;
	}

	/**
	 * ��������û���Ȩ��Ϣ����.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * ��������û���Ȩ��Ϣ����.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}
	/**
	 * 
	* @Title: clearAuthz 
	* @Description: TODO ����������Ȩ��Ϣ  
	* @return void    ��������
	 */
	public void clearAuthz(){
		this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
	}
}

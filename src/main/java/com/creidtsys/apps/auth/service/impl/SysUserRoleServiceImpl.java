package com.creidtsys.apps.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creidtsys.apps.auth.dao.SysUserRoleDao;
import com.creidtsys.apps.auth.entity.SysDept;
import com.creidtsys.apps.auth.entity.SysUserRole;
import com.creidtsys.apps.auth.entity.UserRole;
import com.creidtsys.apps.auth.service.SysUserRoleService;

/**
 * 
* @ClassName: SysUserRoleServiceImpl
* @Description: TODO �û���ɫ�ҹ�ϵserviceʵ����
* @author liuyj
* @date 2017��8��26�� ����11:02:54
*
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService{
	@Autowired
	private SysUserRoleDao userRoleDao ;

	@Override
	public List<SysUserRole> getRoleByUser(String userId) {
		// TODO Auto-generated method stub
		List<SysUserRole> list = userRoleDao.getRoleByUser(userId) ;
		return list;
	}

	@Override
	public void saveUserRole(SysUserRole sysUserRole) {
		// TODO Auto-generated method stub
		String urUserid = sysUserRole.getUrUserId() ;
		String urUserIds = sysUserRole.getRoleIds() ;
		//ɾ����ɫ�û�֮��Ľ�ɫ��ϵ
		userRoleDao.delReByUser(urUserid) ;
		if(!"".equals(urUserIds)&&urUserIds!=null){
			//����ά���û���ɫ֮����ϵ
			for(String urRoleId : urUserIds.split(",")){
				SysUserRole newSysUserRole = new SysUserRole() ;
				newSysUserRole.setUrRoleId(urRoleId);
				newSysUserRole.setUrUserId(urUserid);
				userRoleDao.addRe(newSysUserRole) ;
			}
		}
		
	}
}	

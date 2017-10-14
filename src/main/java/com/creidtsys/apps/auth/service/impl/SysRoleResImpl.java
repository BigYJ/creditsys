package com.creidtsys.apps.auth.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creidtsys.apps.auth.dao.SysRoleResDao;
import com.creidtsys.apps.auth.entity.SysRoleRes;
import com.creidtsys.apps.auth.service.SysRoleResService;
import com.creidtsys.utils.ShiroUtils;
/**
 * 
* @ClassName: SysRoleResImpl
* @Description: TODO Ȩ�޽�ɫ��Դserviceʵ����
* @author liuyj
* @date 2017��8��26�� ����10:52:07
*
 */
@Service("sysRoleResService")
public class SysRoleResImpl implements SysRoleResService{
	@Autowired
	private SysRoleResDao sysRoleResDao ;

	@Override
	public List<SysRoleRes> resRoleTree(String roleId) {
		// TODO Auto-generated method stub
		List<SysRoleRes> list = sysRoleResDao.getResByRole(roleId) ;
		return list;
	}
	@Override
	public void saveRela(Map<String, String> map) {
		// TODO Auto-generated method stub
		String roleId = map.get("roleId") ;
		String resIds = map.get("resIds") ;
		//ɾ��֮ǰ�Ĺ�ϵά��
		sysRoleResDao.delResByRole(roleId) ;
		//���µĹ�ϵ����ά��		
		if(resIds!=null&&!"".equals(resIds)){
			for(String resId : resIds.split(",")){
				SysRoleRes userRes = new SysRoleRes() ;
				userRes.setRrResId(resId);
				userRes.setRrRoleId(roleId);
				sysRoleResDao.addRes(userRes) ;
			}	
		}
		// ��̬����Ȩ�� ���¸�ֵȨ��
		ShiroUtils.clearAuth();
	}
}

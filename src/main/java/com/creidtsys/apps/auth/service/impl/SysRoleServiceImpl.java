package com.creidtsys.apps.auth.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.creidtsys.apps.auth.dao.SysRoleDao;
import com.creidtsys.apps.auth.dao.SysRoleResDao;
import com.creidtsys.apps.auth.entity.SysDept;
import com.creidtsys.apps.auth.entity.SysRole;
import com.creidtsys.apps.auth.entity.SysRoleRes;
import com.creidtsys.apps.auth.service.SysRoleService;
import com.creidtsys.utils.TreeModel;
import com.creidtsys.utils.TreeUtils;
/**
 * 
* @ClassName: SysRoleServiceImpl
* @Description: TODO Ȩ�޽�ɫservice��ʵ����
* @author liuyj
* @date 2017��8��26�� ����10:36:37
*
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService{
	@Autowired
	private SysRoleDao sysRoleDao ;
	@Autowired
	private SysRoleResDao sysRoleResDao ;
	 
	
	@Override
	public List<SysRole> getAllRole(String roleParentId) {
		// TODO Auto-generated method stub
		List<SysRole> list = sysRoleDao.getAllRole(roleParentId) ;
		return list;
	}

	@Override
	public List<SysRole> initRoleTree() {
		// TODO Auto-generated method stub
		List<SysRole> list = sysRoleDao.getAllRole("") ;
		return list;
	}

	@Override
	public void delRoles(String ids) {
		// TODO Auto-generated method stub
		for(String roleId:ids.split(",")){
			sysRoleDao.delRoles(roleId) ;
		}
		
	}

	@Override
	public void saveRole(SysRole sysRole) {
		// TODO Auto-generated method stub
		sysRoleDao.addRole(sysRole) ;
		String resids = sysRole.getResIds() ;
		String roleId = sysRole.getRoleId() ;
		//ѭ������
		for(String rrid : resids.split(",")){
			SysRoleRes  sysRoleRes = new SysRoleRes() ;
			sysRoleRes.setRrResId(rrid);
			sysRoleRes.setRrRoleId(roleId);
			sysRoleResDao.addRoleRes(sysRoleRes);
		}		
	}

	@Override
	public void updateRole(SysRole sysRole) {
		// TODO Auto-generated method stub
		sysRoleDao.editRole(sysRole) ;
	}

	@Override
	public TreeModel selectTree(String id) {
		// TODO Auto-generated method stub
		TreeModel tm = new TreeModel();  
        //�ڴ�ֻ�������Ż�λ��id��name����,����չ  
        String[] s = new String[] { "getRoleId", "getRoleName" };  
        List<SysRole> li = this.selectChildren(id);  
        this.tree(tm, li, s);  
        return tm;  
	}
	private void tree(TreeModel tm, List<SysRole> li, String[] s ) {  
        if (!CollectionUtils.isEmpty(li)) {  
            for (int i = 0, l = li.size(); i < l; i++) {  
                TreeModel ntm = new TreeModel();  
                SysRole tree = li.get(i);  
                TreeUtils.copyModel(ntm, tree, s);// ����ֵ��TreeModel  
                tm.getChildren().add(ntm);// ��ӵ����ӽڵ��б�  
				List<SysRole> list = this.selectChildren(tree.getRoleId());
				tree(ntm, list, s);// �ݹ飬ʵ�����޲㼶  
            }  
        }  
    }  
 private List<SysRole> selectChildren(String id) {  
        Map<String, Object> para = new HashMap<String, Object>();  
        para.put("roleParentId", id);  
        return sysRoleDao.getTreeDate(para);  
    }

@Override
public SysRole getById(String roleId) {
	// TODO Auto-generated method stub
	SysRole role = sysRoleDao.getById(roleId) ;
	return role;
}  
}

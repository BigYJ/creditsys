package com.creidtsys.apps.auth.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.creidtsys.apps.auth.dao.SysResDao;
import com.creidtsys.apps.auth.entity.SysRes;
import com.creidtsys.apps.auth.service.SysResService;
import com.creidtsys.utils.TreeModel;
import com.creidtsys.utils.TreeUtils;
/**
 * 
* @ClassName: SysResServiceImpl
* @Description: TODO Ȩ����Դserviceʵ����
* @author liuyj
* @date 2017��8��26�� ����10:46:41
*
 */
@Service("sysResService")
public class SysResServiceImpl implements SysResService {
	@Autowired
	private SysResDao sysResDao ;

	@Override
	@Cacheable(value = "myCache",key="test") 
	public List<SysRes> getAllRes() {
		// TODO Auto-generated method stub
		List<SysRes> list = sysResDao.getRes();
		return list;
	}

	@Override
	public List<SysRes> initResTree() {
		// TODO Auto-generated method stub
		List<SysRes> list = sysResDao.getRes();
		return list;
		
	}

	@Override
	public void saveRole(SysRes sysRes) {
		// TODO Auto-generated method stub
		sysResDao.addRes(sysRes) ;
	}

	@Override
	public TreeModel selectTree(String id) {
		// TODO Auto-generated method stub
		TreeModel tm = new TreeModel();  
        //�ڴ�ֻ�������Ż�λ��id��name����,����չ  
        String[] s = new String[] { "getResId", "getResName" };  
        List<SysRes> li = this.selectChildren(id);  
        this.tree(tm, li, s);  
        return tm;  
	}
	private void tree(TreeModel tm, List<SysRes> li, String[] s ) {  
        if (!CollectionUtils.isEmpty(li)) {  
            for (int i = 0, l = li.size(); i < l; i++) {  
                TreeModel ntm = new TreeModel();  
                SysRes tree = li.get(i);  
                TreeUtils.copyModel(ntm, tree, s);// ����ֵ��TreeModel  
                tm.getChildren().add(ntm);// ��ӵ����ӽڵ��б�  
				List<SysRes> list = this.selectChildren(tree.getResId());
				tree(ntm, list, s);// �ݹ飬ʵ�����޲㼶  
            }  
        }  
    }  
 private List<SysRes> selectChildren(String id) {  
        Map<String, Object> para = new HashMap<String, Object>();  
        para.put("resParentId", id);  
        return sysResDao.getTreeDate(para);  
    }

@Override
@CacheEvict(value="myCache",beforeInvocation=true)
public void updateRes(SysRes sysRes) {
	// TODO Auto-generated method stub
	sysResDao.editRes(sysRes) ;
}

@Override
public void delRes(String ids) {
	// TODO Auto-generated method stub
	String resId = ids ;
	sysResDao.delRes(resId) ;
}  
}

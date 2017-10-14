package com.creidtsys.apps.auth.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.creidtsys.apps.auth.service.TreeService;
import com.creidtsys.utils.TreeModel;

@Controller
@RequestMapping("/tree")
public class TreeController {
	private final String  TOTREE = "page/auth/tree/tree" ;
	@Autowired
	private TreeService treeService ;
    // ��ʾ��Ŀ¼��pid  
    public static final String ROOT = "00000000000000000000000000000000";  
    @RequestMapping("/toTree")
    public String toTree(){
    	return TOTREE ;
    }
    /** 
     * ��λ������(������)json 
     */  
    @RequestMapping("/deptTree")  
    @ResponseBody  
    // ���ص���JSON��ʽ  
    public List<TreeModel> deptTree(HttpServletRequest request) {  
        // Ĭ�ϴӸ��ڵ㿪ʼ  
        String id = ROOT;  
        TreeModel tm = treeService.selectTree(id);  
        return tm.getChildren();  
    }  
}

package com.creidtsys.apps.auth.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.creidtsys.security.realm.ShiroDbRealm;
/**
 * 
* @ClassName: PageContoller
* @Description: TODO ҳ����תcontroller
* @author liuyj
* @date 2017��9��25�� ����1:51:29
*
 */
@Controller
@RequestMapping("/page")
public class PageContoller {  
	private final String NOPERS = "page/error/noperms" ;
	private static Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);
	@RequestMapping("/wsyyt")
	public String toWsyyt(){
		return "/wsyyt/index" ;
	}
	/**
	 * ��ʼ��½����
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView tologin(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.debug("����IP[" + request.getRemoteHost() + "]�ķ���");
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("login");
		return modelView;
	}
	/**
	 * 
	* @Title: toIndex 
	* @Description: TODO ��ת������Ӫҵ����ҳ
	* @return    
	* @return String    ��������
	 */
	@RequestMapping("/index")
	public ModelAndView toIndex() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("redirect:index");
		return modelView;
	}

	//�˳�ϵͳ
	@RequestMapping(value = "/exitUser")
	@ResponseBody
	public ModelAndView logout() {
		ModelAndView modelView = new ModelAndView();
		Subject currentUser = SecurityUtils.getSubject();
		String result = "logout";
		currentUser.logout();
		modelView.setViewName("redirect:login");
		return modelView;
	}
	/*
	 * json��ʽ
		{
		    result:"success",
		    news:["8��20�ų��춫���","�����ִ�ᡷͶƱ���ֹ����","�����õ������Ʒ�һ�����","���ڲʺ�Ӫҵ������������ַ����"]
		}
	*/
	/**
	 * 
	* @Title: initNotice 
	* @Description: TODO  ��ʼ������ 
	* @return    
	* @return JSONObject    ��������
	 */
	@RequestMapping(value="initNotice",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody  
	public Map<String,Object> initNotice(){                 //�Ƿ�ʹ��jsonObjectû��Ӱ��
        Map<String, Object> map = new HashMap<String, Object>();  
        List<String> list = new ArrayList<String>() ;
        list.add("8��20�ų��춫���");
        list.add("�����ִ�ᡷͶƱ���ֹ����");
        list.add("�����õ������Ʒ�һ�����");
        list.add("���ڲʺ�Ӫҵ������������ַ����");
        map.put("result", "success") ;
        map.put("news", list) ;
        return map ;
	}
	/**
	 * 
	* @Title: noPers 
	* @Description: TODO  ��Ȩ����ת���� 
	* @return    
	* @return String    ��������
	 */
	@RequestMapping("/noPers")
	public String noPers(){
		return NOPERS ;
	}
}
	
//�����п��ܻ������������������
//ֻҪ����Я�ֹ�ͬ���
//����ֻ�������ǰ��ĸ���
/*   
  
 	 try{	
		 living();
	 }catch(Exception e){
		 faceTogether();
	 }finally{
		 you.love++;
	 }   
	 	    --by l&&x
	 	    --Oct.10.2017 


*/                     

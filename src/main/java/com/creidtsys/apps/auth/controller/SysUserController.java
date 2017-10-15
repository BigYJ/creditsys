package com.creidtsys.apps.auth.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.creidtsys.apps.auth.entity.SysUser;
import com.creidtsys.apps.auth.service.SysUserService;
import com.creidtsys.security.realm.ShiroDbRealm;
import com.creidtsys.utils.CipherUtil;
import com.creidtsys.utils.JsonMessage;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
/**
 * 
* @ClassName: SysUserController
* @Description: TODO Ȩ���û�Controller��
* @author liuyj
* @date 2017��8��26�� ����10:22:50
*
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {
	@Autowired
	private SysUserService userService ;
	private static ObjectMapper mapper = new ObjectMapper() ;
	private final String  LIST = "page/auth/user/list" ;
	private final String TOADD  = "page/auth/user/addUser" ;
	private final String TOEDIT = "page/auth/user/editUser" ;
	private final String TOLISTUSER = "page/auth/user/listUser" ;
	private static Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);
	/**
	 * 
	* @Title: toIndex 
	* @Description: TODO ������
	* @param request
	* @param response
	* @param model
	* @return    
	* @return ModelAndView    ��������
	 */
	@RequestMapping("/index")
	public ModelAndView toIndex(HttpServletRequest request, HttpServletResponse response, Model model) {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("index");
		return modelView;
	}
	/**
	 * ��֤�û���������
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, Model model) {
		ModelAndView modelView = new ModelAndView();
		String result = "login";
		// ȡ���û���
		String username = request.getParameter("username");
		// ȡ�� ���룬����MD5����
		String password = CipherUtil.generatePassword(request.getParameter("password"));
		// String password = request.getParameter("password");
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject currentUser = SecurityUtils.getSubject();
		try {
			currentUser.login(token);// ��֤��ɫ��Ȩ��
		} catch (AuthenticationException e) {
			e.printStackTrace();
			String msg = "��¼�������. Password for account " + token.getPrincipal() + " was incorrect.";
			model.addAttribute("message", msg);
			System.out.println(msg);
			modelView.setViewName("login");
		}
		if (currentUser.isAuthenticated()) {// ʹ��shiro����֤
			token.setRememberMe(true);
			modelView.setViewName("redirect:index");
		} else {
			modelView.setViewName("login");
		}
		return modelView;
	}
	
	/**
	 * 
	* @Title: toListUser 
	* @Description: TODO ��ת���û�Ȩ�޲鼰�û���Ȩ���濴����
	* @return    
	* @return String    ��������
	 */
	@RequestMapping("/toListUser")
	private String toListUser(){
		return TOLISTUSER ;
	}
	
	
	/**
	 * 
	* @Title: list 
	* @Description: TODO ��ת��user������ 
	* @return    
	* @return String    ��������
	 */
	@RequestMapping("/list")
	private String list(){
		return LIST ;
	}
	/**
	 * 
	* @Title: toAdd 
	* @Description: TODO ��ת������û����� 
	* @return    
	* @return String    ��������
	 */
	@RequestMapping("/toAdd")
	private String toAdd(){
		return TOADD ;
	}
	/**
	 * 
	* @Title: toEdit 
	* @Description: TODO ��ת���޸��û����� 
	* @return    
	* @return String    ��������
	 */
	@RequestMapping("/toEdit") 
	private String toEdit(){
		return TOEDIT ;
	}
	
	@RequestMapping(value="/allUser" ,method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public  Map<String,Object>  allUser (String data) throws JsonParseException, JsonMappingException, IOException{
		    SysUser sysUser= mapper.readValue(data, new TypeReference<SysUser>() { });  
	        int page = Integer.parseInt(sysUser.getPageNumber()) ;  
	        int rows =Integer.parseInt(sysUser.getPageSize()) ;   
	        Map<String, Object> map = new HashMap<String, Object>();  
	        List<SysUser> listAll = userService.getAllUser(sysUser) ;  
	        map.put("total", listAll.size());//total�� ����ܼ�¼���������    
	        PageHelper.startPage(page,rows);  
	        List<SysUser> listPage = userService.getAllUser(sysUser) ;  
	        map.put("rows", listPage);//rows�� ���ÿҳ��¼ list             
	       return  map ;
	}
	/**
	 * 
	* @Title: addDept 
	* @Description: TODO ����û���Ϣ
	* @param data
	* @return
	* @throws JsonParseException
	* @throws JsonMappingException
	* @throws IOException    
	* @return JsonMessage    ��������
	 */
	@RequestMapping(value="/add" ,method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonMessage addDept(String data) throws JsonParseException, JsonMappingException, IOException{
		SysUser sysUser = mapper.readValue(data, new TypeReference<SysUser>() { });
		//md5����
		String pwd =  CipherUtil.generatePassword(sysUser.getUserPwd());
		sysUser.setUserPwd(pwd);
		sysUser.setUserId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		userService.saveUser(sysUser);
		return new JsonMessage().success();
	}
	
	/**
	 * 
	* @Title: delUsers 
	* @Description: TODO ����ɾ���û� 
	* @param ids		 �û���ʶƴ�Ӷ��ɵ��ַ���
	* @return    
	* @return JsonMessage    ��������
	 */
	@RequestMapping(value="/delUsers" ,method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonMessage delUsers(String ids){
		userService.delUsers(ids) ;
		return new JsonMessage().success() ;
	}
	/**
	 * 
	* @Title: edit 
	* @Description: TODO	�޸��û���Ϣ
	* @param data
	* @return
	* @throws JsonParseException
	* @throws JsonMappingException
	* @throws IOException    
	* @return JsonMessage    ��������
	 */
	@RequestMapping(value="/edit" ,method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonMessage edit(String data) throws JsonParseException, JsonMappingException, IOException{
	    SysUser sysUser= mapper.readValue(data, new TypeReference<SysUser>() { });  
	    //md5����
  		String pwd =  CipherUtil.generatePassword(sysUser.getUserPwd());
  		sysUser.setUserPwd(pwd);
	    userService.updateDept(sysUser) ;
		return new JsonMessage().success() ;
	}
}
package com.creidtsys.apps.auth.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.creidtsys.apps.auth.entity.SysUserRole;
import com.creidtsys.apps.auth.service.SysUserRoleService;
import com.creidtsys.utils.JsonMessage;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
* @ClassName: SysUserRoleController
* @Description: TODO �û���ɫcontroller
* @author liuyj
* @date 2017��9��4�� ����6:40:17
*
 */
@RequestMapping("/sysUserRole")
@Controller
public class SysUserRoleController {
	private final String ALLOTROLE = "page/auth/user/allotRole" ;
	private static ObjectMapper mapper = new ObjectMapper() ;
	@Autowired
	private SysUserRoleService userRoleService ;
	/**
	 * 
	* @Title: allotRole 
	* @Description: TODO ��ת�������ɫ����
	* @return    
	* @return String    ��������
	 */
	
	@RequestMapping("/allotUser")
	private String allotRole(){
		return ALLOTROLE ;
	}
	/**
	 * 
	* @Title: getRoleByUser 
	* @Description: TODO �����û���ѯ��ɫ
	* @param userId
	* @return
	* @throws JsonParseException
	* @throws JsonMappingException
	* @throws IOException    
	* @return JSONObject    ��������
	 */
	@RequestMapping(value="/getRoleByUser" ,method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public  Map<String,Object>  getRoleByUser (String userId) throws JsonParseException, JsonMappingException, IOException{
	        Map<String, Object> map = new HashMap<String, Object>();  
	        List<SysUserRole> listPage =  userRoleService.getRoleByUser(userId) ;  
	        map.put("rows", listPage);//rows�� ���ÿҳ��¼ list             
	        return  map ;
	}
	/**
	 * 
	* @Title: saveUserRole 
	* @Description: TODO Ϊ�û���ֵ��ɫ
	* @param data
	* @return
	* @throws JsonParseException
	* @throws JsonMappingException
	* @throws IOException    
	* @return JsonMessage    ��������
	 */
	@RequestMapping(value="/saveUserRole" ,method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public  JsonMessage  saveUserRole (String data) throws JsonParseException, JsonMappingException, IOException{
			SysUserRole sysUserRole = mapper.readValue(data, new TypeReference<SysUserRole>() { });
			userRoleService.saveUserRole(sysUserRole) ;  
			return  new JsonMessage().success() ;
	}
}

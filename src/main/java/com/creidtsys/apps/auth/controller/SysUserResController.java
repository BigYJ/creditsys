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

import com.creidtsys.apps.auth.entity.SysUserRes;
import com.creidtsys.apps.auth.service.SysUserResService;
import com.creidtsys.utils.JsonMessage;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
* @ClassName: SysUserResController
* @Description: TODO �û���ԴȨ�޹�ϵcontroller
* @author liuyj
* @date 2017��8��26�� ����10:58:01
*
 */
@Controller
@RequestMapping("sysUserRes")
public class SysUserResController {
	@Autowired
	private SysUserResService sysUserResService ;
	private static ObjectMapper mapper = new ObjectMapper() ;

	/**
	 * 
	* @Title: getResByUser 
	* @Description: TODO ��ѯ���û�����Ȩ��
	* @param userId
	* @return    
	* @return JSONObject    ��������
	 */
	@RequestMapping(value="/getResByUser",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public Map<String,Object> getResByUser(String userNo){
		//17.10.20 i��Ϊ����userNo�������ؽڵ�֮�ϵ����нڵ�
	//	List<SysUserRes> list = sysUserResService.getResByUser(userId);
	//	List<SysUserRes> list = sysUserResService.getAllByNo("admin") ;
		List<Map<String, String>> list =sysUserResService.getAuthMenu(userNo) ;
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rows", list);
		return map;
	}
	/**
	 * 
	* @Title: getUserRes 
	* @Description: TODO ����û����������Ȩ��
	* @param userId
	* @return    
	* @return JSONObject    ��������
	 */
	@RequestMapping(value="/getUserRes",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public Map<String,Object> getUserRes(String userId){
		List<SysUserRes> list = sysUserResService.getUserRes(userId);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rows", list);
		return map;
	}
	/**
	 * 
	* @Title: getRoleRes 
	* @Description: TODO ����û�����ȫ��ɫ��Ȩ��
	* @param userId
	* @return    
	* @return JSONObject    ��������
	 */
	@RequestMapping(value="/getRoleRes",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public Map<String,Object> getRoleRes(String userId){
		List<SysUserRes> list = sysUserResService.getRoleRes(userId);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rows", list);
		return map;
	}
	/**
	 * 
	* @Title: resUserTree 
	* @Description: TODO ��ú���checkbox ��Ȩ����
	* @param userId
	* @return    
	* @return JsonMessage    ��������
	 */
	@RequestMapping(value="/resUserTree",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public JsonMessage resUserTree(String userId){
		List<SysUserRes> list = sysUserResService.resUserTree(userId);
		return new JsonMessage().success(list);
	}
	/**
	 * 
	* @Title: saveUserRes 
	* @Description: TODO �����û���Ȩ��֮��Ĺ�ϵ
	* @param userId
	* @return    
	* @return JsonMessage    ��������
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value="/saveUserRes",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public JsonMessage saveUserRes(String data) throws JsonParseException, JsonMappingException, IOException{
	    Map<String,String> map= mapper.readValue(data, new TypeReference<Map<String,String>>() { });  
		sysUserResService.saveUserRes(map);
		return new JsonMessage().success();
	}
	/**
	 * 
	* @Title: getAuthMenu 
	* @Description: TODO ��ȡ�˵�Ȩ��
	* @param userId
	* @return
	* @throws Exception    
	* @return JsonMessage    ��������
	 */
	@RequestMapping(value="/getAuthMenu",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public JsonMessage getAuthMenu(String userNo) throws Exception{
		List<Map<String, String>> list =sysUserResService.getAuthMenu(userNo) ;
		List finalList = sysUserResService.findRoots(list) ;
		return new JsonMessage().success(finalList);
	}
}

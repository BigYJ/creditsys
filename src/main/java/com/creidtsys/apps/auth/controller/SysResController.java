package com.creidtsys.apps.auth.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.creidtsys.apps.auth.entity.SysRes;
import com.creidtsys.apps.auth.entity.SysRole;
import com.creidtsys.apps.auth.service.SysResService;
import com.creidtsys.utils.JsonMessage;
import com.creidtsys.utils.TreeModel;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
* @ClassName: SysResController
* @Description: TODO Ȩ����Դcontroller
* @author liuyj
* @date 2017��8��26�� ����10:47:44
*
 */
@Controller
@RequestMapping("/sysRes")
public class SysResController {
	@Autowired
	private SysResService sysResService ;
	private static ObjectMapper mapper = new ObjectMapper() ;
	private final String  LIST = "page/auth/res/list" ;
	private final String TOADD  = "page/auth/res/addRe" ;
	private final String TOEDIT = "page/auth/res/editRe" ;
	private final String TOALLOTRES = "page/auth/res/allotRes" ;
	private final String ROOT = "0" ;
	/**
	 * 
	* @Title: toAllOTRES 
	* @Description: TODO ��ת����Ȩ����
	* @return    
	* @return String    ��������
	 */
	@RequestMapping("/toAllotRes")
	public String toAllOTRES(){
		return TOALLOTRES ;
	}
	/**
	 * 
	* @Title: list 
	* @Description: TODO ��ת�������� 
	* @return    
	* @return String    ��������
	 */
	@RequestMapping("/list")
	public String list(){
		return LIST ;
	}
	/**
	 * 
	* @Title: toAdd 
	* @Description: TODO ��ת����ӽ��� 
	* @return    
	* @return String    ��������
	 */
	@RequestMapping("/toAdd")
	public String toAdd(){
		return TOADD ;
	}
	/**
	 * 
	* @Title: TOEDIT 
	* @Description: TODO ��ת���༭����
	* @return    
	* @return String    ��������
	 */
	@RequestMapping("/toEdit")
	public String TOEDIT(){
		return TOEDIT ;
	}
	/**
	 * 
	* @Title: getTreeData 
	* @Description: TODO ��ѯ����Ȩ����Դ
	* @return    
	* @return JsonMessage    ��������
	 */
	@RequestMapping(value="/getTreeData",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public JSONObject getTreeData(){
		List<SysRes> list = sysResService.getAllRes();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rows", list);
		return JSONObject.fromObject(map);
	}
	
	@RequestMapping(value="/initTree",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public JsonMessage initTree(){
		List<SysRes> list = sysResService.getAllRes();
		return new JsonMessage().success(list) ;
	}
	/**
	 * 
	* @Title: initResTree 
	* @Description: TODO ��ʼ��Ȩ��combobox
	* @return    
	* @return JsonMessage    ��������
	 */
	@RequestMapping(value="/initResTree",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public List<TreeModel> initResTree(){
	  String id = ROOT;  
      TreeModel tm = sysResService.selectTree(id);  
      return tm.getChildren(); 
	}
	/**
	 *  
	 *  
	* @Title: addRole 
	* @Description: TODO �����ԴȨ����Ϣ
	* @param data
	* @return
	* @throws JsonParseException
	* @throws JsonMappingException
	* @throws IOException    
	* @return JsonMessage    ��������
	 */
	@RequestMapping(value="/add" ,method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonMessage addRole(String data) throws JsonParseException, JsonMappingException, IOException{
		SysRes sysRes = mapper.readValue(data, new TypeReference<SysRes>() { });
		sysRes.setResId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		sysResService.saveRole(sysRes);
		return new JsonMessage().success();
	}
	/**
	 * 
	* @Title: edit 
	* @Description: TODO �޸���Դ��Ϣ
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
		SysRes sysRes = mapper.readValue(data, new TypeReference<SysRes>() { });
		sysResService.updateRes(sysRes) ;
		return new JsonMessage().success() ;
	}
	/**
	 * 
	* @Title: delDept 
	* @Description: TODO ɾ����ǰ����Դ�Լ����µ�ȫ����Դ
	* @param ids
	* @return    
	* @return JsonMessage    ��������
	 */
	@RequestMapping(value="/delRes" ,method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonMessage delDept(String ids){
		sysResService.delRes(ids) ;
		return new JsonMessage().success() ;
	}
}

package com.creidtsys.apps.auth.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.creidtsys.apps.auth.entity.SysRole;
import com.creidtsys.apps.auth.service.SysRoleService;
import com.creidtsys.apps.auth.service.SysUserService;
import com.creidtsys.utils.JsonMessage;
import com.creidtsys.utils.TreeModel;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
/**
 * 
* @ClassName: SysRoleController
* @Description: TODO Ȩ�޽�controller��
* @author liuyj
* @date 2017��8��26�� ����10:35:26
*
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService ;
	@Autowired
	private SysUserService sysUserService ;
	private static ObjectMapper mapper = new ObjectMapper() ;
	private final String LIST = "page/auth/role/list"; 
	private final String TOADD = "page/auth/role/newRole" ;
	private final String TOEDIT ="page/auth/role/editRole" ;
	private final String TOAUTH ="page/auth/role/allotResToRole" ;
	public static final String ROOT = "0";  

	/**
	 * 
	* @Title: list 
	* @Description: TODO ��ת����ɫ������ 
	* @return    
	* @return String    ��������
	 */
	@RequiresPermissions(value={"role:serch","user:create"}, logical= Logical.AND)
	@RequestMapping("/list")
	public String list(){
		return LIST ;
	}
	@RequestMapping("/toAuth")
	public String toAuth(){
		return TOAUTH ;
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
	@RequestMapping(value="/allRole" ,method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public  Map<String, Object>  allRole (String data) throws JsonParseException, JsonMappingException, IOException{
		
		SysRole sysRole= mapper.readValue(data, new TypeReference<SysRole>() { });  
		int page = Integer.parseInt(sysRole.getPageNumber()) ;  
		int rows =Integer.parseInt(sysRole.getPageSize()) ;   
		String roleParentId = sysRole.getRoleParentId() ;
		Map<String, Object> map = new HashMap<String, Object>();  
		List<SysRole> listAll = sysRoleService.getAllRole(roleParentId) ;  
		map.put("total", listAll.size());//total�� ����ܼ�¼���������    
		PageHelper.startPage(page,rows);  
		List<SysRole> listPage = sysRoleService.getAllRole(roleParentId) ;  
		map.put("rows", listPage);//rows�� ���ÿҳ��¼ list             
        return  map ;
	}
	/**
	 * 
	* @Title: initRoleTree 
	* @Description: TODO ��ʼ����ɫ��
	* @return    
	* @return JsonMessage    ��������
	 */
	@RequestMapping(value="/initRoleTree",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public List<TreeModel> initRoleTree(){
		
		 // Ĭ�ϴӸ��ڵ㿪ʼ  
        String id = ROOT;  
        TreeModel tm = sysRoleService.selectTree(id);  
        return tm.getChildren();  
	}
	/**
	 * 
	* @Title: delDept 
	* @Description: TODO ɾ����ɫ��Ϣ 
	* @param ids
	* @return    
	* @return JsonMessage    ��������
	 */
	@RequestMapping(value="/delRoles" ,method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonMessage delDept(String ids){
		sysRoleService.delRoles(ids) ;
		return new JsonMessage().success() ;
	}
	/**
	 * 
	* @Title: addRole 
	* @Description: TODO ��ӽ�ɫ��Ϣ
	* @param data  ��ɫ��Ϣjson��
	* @return
	* @throws JsonParseException
	* @throws JsonMappingException
	* @throws IOException    
	* @return JsonMessage    ��������
	 */
	
	@RequestMapping(value="/add" ,method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonMessage addRole(String data) throws JsonParseException, JsonMappingException, IOException{
		SysRole sysRole = mapper.readValue(data, new TypeReference<SysRole>() { });
		sysRole.setRoleId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		sysRoleService.saveRole(sysRole);
		return new JsonMessage().success();
	}
	/**
	 * 
	* @Title: edit 
	* @Description: TODO �޸Ľ�ɫ��Ϣ
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
		SysRole sysRole = mapper.readValue(data, new TypeReference<SysRole>() { });
		sysRoleService.updateRole(sysRole) ;
		return new JsonMessage().success() ;
	}
	/**
	 * 
	* @Title: getById 
	* @Description: TODO ��ѯ��ɫ��
	* @param roleId
	* @return
	* @throws JsonParseException
	* @throws JsonMappingException
	* @throws IOException    
	* @return JsonMessage    ��������
	 */
	@RequestMapping(value="/getById" ,method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonMessage getById(String roleId) throws JsonParseException, JsonMappingException, IOException{
		SysRole sysRole = sysRoleService.getById(roleId) ;
		return new JsonMessage().success(sysRole) ;
	}
}

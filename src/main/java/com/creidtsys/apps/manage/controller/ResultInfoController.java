package com.creidtsys.apps.manage.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.creidtsys.apps.manage.entity.Paper;
import com.creidtsys.apps.manage.entity.PaperRelation;
import com.creidtsys.apps.manage.entity.ResultDetial;
import com.creidtsys.apps.manage.entity.ResultInfo;
import com.creidtsys.apps.manage.service.PaperRelationService;
import com.creidtsys.apps.manage.service.PaperService;
import com.creidtsys.apps.manage.service.ReadExcelService;
import com.creidtsys.apps.manage.service.ResultDetialService;
import com.creidtsys.apps.manage.service.ResultInfoService;
import com.creidtsys.utils.JsonMessage;
import com.creidtsys.utils.UtilTools;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value="/resultInfo")
public class ResultInfoController {
	@Resource
	private ResultInfoService resultInfoService ;
	@Autowired
	private ReadExcelService readExcelService ;
	@Resource
	private ResultDetialService detialService  ;
	@Resource
	private PaperService paperService ;
	@Resource
	private ResultDetialService resultDetialService ;
	@Resource
	private PaperRelationService paperRelationService ;
	private final String  LIST ="jsp/manage/resultInfo/list" ;
	private final String TONEWJSP = "jsp/manage/resultInfo/add" ;
	private final String TOEDITJSP ="jsp/manage/resultInfo/edit" ;	
	private final String TOADDINFO = "jsp/manage/resultInfo/addInfo";
	private final String TOADDMANY ="jsp/manage/resultInfo/addMany" ;
	private static ObjectMapper mapper = new ObjectMapper();	
	@RequestMapping("/toAddMany")
	public String toAddMany(){
		return TOADDMANY ;
	}
	@RequestMapping("/addInfo")
	public String toAddInfo(){
		return TOADDINFO ;
	}
	@RequestMapping("/toList")
	public String list(){
		return LIST ;                                 
	}
    @RequestMapping("/toNew")
    public String toNew(){
    	return TONEWJSP ;
    }
    @RequestMapping("/toEdit")
    public String toEdit(){
    	return TOEDITJSP ;
    }
    @RequestMapping(value="/list",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public Map<String,Object> queryAll(String riPaperId){
		List<ResultInfo> list = resultInfoService.findAll(riPaperId);
		Map<String,Object> map =new HashMap<String, Object>() ;
		map.put("total", list.size()) ;
		map.put("rows", list) ;
		return map ;
	}
    @RequestMapping(value="/add",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public JsonMessage addResultInfo(String data) throws Exception{
		 ResultInfo  resultInfo= mapper.readValue(data, new TypeReference<ResultInfo>() { 
		 });
		 resultInfo.setResultId(UtilTools.getNum19().toUpperCase());
		 resultInfoService.add(resultInfo);
		return new JsonMessage().success() ;
	}
	@RequestMapping(value="/edit",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public JsonMessage editResultInfo(String data) throws Exception{
		ResultInfo  resultInfo= mapper.readValue(data, new TypeReference<ResultInfo>() { 
		 });
		resultInfoService.editresultInfo(resultInfo);
		return new JsonMessage().success() ;
	}
	@RequestMapping(value="/delete",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public JsonMessage deleteResult(String data) throws Exception{
		ResultInfo  resultInfo= mapper.readValue(data, new TypeReference<ResultInfo>() { 
	 });
		//ɾ��resultinfo
		resultInfoService.deleteResult(resultInfo.getResultId());
		ResultDetial resultDetial = new ResultDetial();
		resultDetial.setRdInfoId(resultInfo.getResultId());
		resultDetial.setUserLoginName(resultInfo.getUserNo());
		//ɾ��resultDetial
		detialService.delete(resultDetial);
		return new JsonMessage().success() ;
	}
	//������ӳɼ�
	@RequestMapping(value="/addResults",method = RequestMethod.POST) 
	@ResponseBody 
	public JsonMessage analazyMapExtent(@RequestParam("file")  MultipartFile file,HttpServletRequest request) throws Exception {
		String path=request.getSession().getServletContext().getRealPath("");
	    String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));     
	    String fileName = UUID.randomUUID().toString()+ suffix; 
	    File f=new File(path,fileName);
	    file.transferTo(f);	  
 		//1.��ȡexcel�ļ��ĵ�һ���������,��ÿγ̴������û�id
	  //2.���ݿγ̴������û�id����Ծ�id���������û�����
 		List<ResultInfo>resultIdList= new ArrayList<ResultInfo>();
        //��������EXCEL
        //����excel����ȡ�ͻ���Ϣ���ϡ�
         List<ResultInfo> resultList = readExcelService.getExcelInfo(f);
         for(ResultInfo resultInfo:resultList){
         	if(!resultInfoService.isExist(resultInfo)){
         		//�ж��Ƿ����\
         		//3.�γ���Ӧ���ݲ��뵽�ɼ�����
         		Paper paper = paperService.getById(resultInfo.getRiPaperId());
         		resultInfo.setResultId(UtilTools.getNum19().toUpperCase());
         		resultInfo.setResultTotal(paper.getUserTotal());
         		resultInfoService.add(resultInfo);
             	resultIdList.add(resultInfo) ;
         	}
         }
         
 		 List<ResultDetial> resuDetiList = new ArrayList<ResultDetial>() ;
         for(ResultInfo resustInfo:resultIdList){
        	 //�ж��Ƿ񾭴���
        	 List<ResultDetial> ifContain = resultDetialService.ifContain(resustInfo.getResultId());
        	 if(ifContain.size()<=0){
        		//������
        		//����paperid�����Ŀ��ϸ��Ϣ  
        		List<PaperRelation> listPaperRela = paperRelationService.selectByOtherId(resustInfo.getRiPaperId());
        		//ѭ����ʼ���ɼ���ϸ��Ϣ
        		for(PaperRelation paperRe : listPaperRela){
        			//4.����paper�гɶ�Ӧ��ϸ�ɼ��ĵ�����Ŀ�����ݽṹ�������ݣ�
        			ResultDetial resultDetial = new ResultDetial() ;
    				resultDetial.setRdId(UtilTools.getNum19());
    				resultDetial.setRdInfoId(resustInfo.getResultId());
    				resultDetial.setPrId(paperRe.getPrId());
    				resultDetial.setPrPid(paperRe.getPrPid());
    				resultDetial.setPrName(paperRe.getPrName());
    				resultDetial.setType(paperRe.getType());
    				resultDetial.setOtherId(paperRe.getOtherId());
    				resultDetial.setUserLoginName(resustInfo.getUserNo());
    				resultDetial.setRdIndex(paperRe.getPrIndex());
    				resultDetial.setDetialCore(paperRe.getPrScore());
    				resultDetialService.add(resultDetial) ;
    				resuDetiList.add(resultDetial) ;
    			}
        	 }
         }
        //5.��ȡexcel�ļ���һһ�޸ĵ�����Ŀ�ĳɼ�

  		//6.�����ܳɼ�ÿ�����ܳɼ������뵽�ɼ���
  		
         for(ResultInfo resultInfo : resultList){
 			readExcelService.addResultDetial(f,resultInfo);
 	    //	detialService.edit(list);;
 		}
        List<ResultInfo> listLast = resultInfoService.findAll("");
		return new JsonMessage().success(listLast);
	}
	
}

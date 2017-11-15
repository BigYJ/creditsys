package com.creidtsys.apps.manage.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.creidtsys.apps.manage.entity.PaperRelation;
import com.creidtsys.apps.manage.service.PaperRelationService;
import com.creidtsys.utils.ResumeWord;


/**
 * 
* @ClassName: BillController
* @Description: TODO ����word�ĵ�controller
* @author liuyj
* @date 2017��11��13�� ����9:41:37
*
 */
@Controller
@RequestMapping("/bill")
public class BillController {
	@Resource
	private PaperRelationService paperRelationService ;
	//����word�ĵ�
	  @RequestMapping("/downResumeDoc")
	  @ResponseBody
	    public String downResumeDoc(HttpServletRequest request,HttpServletResponse response,String paperId) throws Exception{
	        request.setCharacterEncoding("utf-8");
	        Map<String,Object> map = new HashMap<String,Object>();
	        //��ñ���
	        List<PaperRelation> listTitle = paperRelationService.getTitleList(paperId) ;
	        //��ô��⼯��
	        List<Map<String,Object>> bigList = paperRelationService.getBigList(paperId) ;
	        //���С�⼯��
	        List<PaperRelation> smallList = paperRelationService.getSmallList(paperId) ;
	        String title = listTitle.get(0).getPrName()+"�Ծ�Ҫ��" ;
	        map.put("title", title) ;
	        map.put("bigList",bigList) ;
	        map.put("smallList",smallList) ;
	        //��ʾ���ڵ��ù���������Word�ĵ�֮ǰӦ����������ֶ��Ƿ�����
	        //����Freemarker��ģ�������ڴ���ʱ���ܻ���Ϊ�Ҳ���ֵ������������ʱ�����������
	        File file = null;
	        InputStream fin = null;
	        ServletOutputStream out = null;
	        try{
	            //���ù�����WordGenerator��createDoc��������Word�ĵ�
	            file = ResumeWord.createDoc(map, "paperDetial");
	            fin = new FileInputStream(file);
	            response.setCharacterEncoding("utf-8");
	            response.setContentType("application/msword");
	            response.addHeader("Content-Disposition", "attachment;filename=paperDetial.doc");
	            out = response.getOutputStream();
	            byte[] buffer = new byte[1024];//������
	            int bytesToRead = -1;
	            // ͨ��ѭ���������Word�ļ�������������������  
	            while((bytesToRead = fin.read(buffer)) != -1) {  
	                out.write(buffer, 0, bytesToRead);  
	            }
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
	        finally{
	            if(fin != null) fin.close();  
	            if(out != null) out.close();  
	            if(file != null) file.delete(); // ɾ����ʱ�ļ�  
	        }
	        return null;
	    }
}

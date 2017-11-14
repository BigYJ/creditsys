package com.creidtsys.apps.manage.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.creidtsys.apps.auth.service.SysUserService;
import com.creidtsys.apps.manage.entity.ResultDetial;
import com.creidtsys.apps.manage.entity.ResultInfo;
import com.creidtsys.utils.UtilTools;


@Service
public class ReadExcelService {
	@Resource
	private PaperService paperService ;
	@Resource
	private SysUserService sysUserService ;
	@Resource
	private ResultInfoService resultInfoService ;
	@Resource
	private ResultDetialService resultDetialService ;
    private int totalRows = 0;  
    //������
    private int totalCells = 0; 
    //������Ϣ������
    private String errorMsg;
    //���췽��
    public ReadExcelService(){}
    //��ȡ������
    public int getTotalRows()  { return totalRows;} 
    //��ȡ������
    public int getTotalCells() {  return totalCells;} 
    //��ȡ������Ϣ-��ʱδ�õ���ʱ����
    public String getErrorInfo() { return errorMsg; }
    
  /**
   * ��EXCEL�ļ�����ȡ�ͻ���Ϣ����
   * @param fielName
   * @return
   */
  public List<ResultInfo> getExcelInfo(File  file){     
       List<ResultInfo> resultInfoList=new ArrayList<ResultInfo>();
       FileInputStream is = null;
       Workbook wb = null;
       
       try{
          is = new FileInputStream(file);
          if(UtilTools.isExcel2003(file.getName())){
       	   wb = new HSSFWorkbook(is);
          }else{
       	   wb = new XSSFWorkbook(is);
          }
          resultInfoList=readExcelValue(wb);
          is.close();
      }catch(Exception e){
          e.printStackTrace();
      } finally{
          if(is !=null)
          {
              try{
                  is.close();
              }catch(IOException e){
                  is = null;    
                  e.printStackTrace();  
              }
          }
      }
      return resultInfoList;
  }
 
  /**
   * ��ȡExcel����ͻ�����Ϣ
   * @param wb
   * @return
   */
  private List<ResultInfo> readExcelValue(Workbook wb){ 
       Sheet sheet=wb.getSheetAt(0);
       this.totalRows=sheet.getPhysicalNumberOfRows();
       if(totalRows>=1 && sheet.getRow(0) != null){//�ж���������һ�����ҵ�һ�б����б��⣨������bug���ļ���һ��ûֵ�����ˣ�
            this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
       }else{
           return null;
       }
       List<ResultInfo> resultInfoList=new ArrayList<ResultInfo>();//����һ�����󼯺�
       List<String> nameList = new ArrayList<String>();
       for(int r=1;r<totalRows;r++){
    	   ResultInfo  resultInfo = new ResultInfo();
           Row row = sheet.getRow(r);
           String loName = null;
           if (row == null) continue;  
           for(int c = 0; c <this.totalCells; c++){ 
               Cell cell = row.getCell(c);
               if (null != cell){
                   if(c==0){
                	   String paperId = paperService.getIdByCode(getValue(cell));
                	   resultInfo.setRiPaperId(paperId);
                   }else if(c==3){
                	   String userId = sysUserService.getUserByLoginName(getValue(cell)).getUserId() ;
                	   resultInfo.setRiUserId(userId);
                	   loName =getValue(cell) ;
                	   resultInfo.setUserNo(getValue(cell));
                   }
               }
           }
           if(!nameList.contains(loName)){
    		   nameList.add(loName);
    		   resultInfoList.add(resultInfo);
    	   }
       }
       return resultInfoList;
  }
  
  /**
   * �õ�Excel���е�ֵ
   * 
   * @param cell
   *            Excel�е�ÿһ������
   * @return Excel��ÿһ�������е�ֵ
   */
  private String getValue(Cell cell) {
	  if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
          // ���ز������͵�ֵ
          return String.valueOf(cell.getBooleanCellValue());
      } else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
    	  DecimalFormat df = new DecimalFormat("#");
          // ������ֵ���͵�ֵ
          return String.valueOf(df.format(cell.getNumericCellValue()));
      } else {
          // �����ַ������͵�ֵ
          return String.valueOf(cell.getStringCellValue());
      }
  }
  
  
public void addResultDetial(File file, ResultInfo resultInfo) throws Exception {
	// TODO Auto-generated method stub
    FileInputStream is = null;
    Workbook wb = null;
       //�����½����ļ�ʵ����������
       is = new FileInputStream(file);
       if(UtilTools.isExcel2003(file.getName())){
    	   wb = new HSSFWorkbook(is);
       }else{
    	   wb = new XSSFWorkbook(is);
       }
       readExcelValues(wb,resultInfo);
       is.close();
}


private void readExcelValues(Workbook wb,ResultInfo resultInfo) {
	String resultId =resultInfo.getResultId() ;
	String name = resultInfo.getUserNo() ;
	double totalResult =0;
    List<ResultDetial> list = new ArrayList<ResultDetial>();
    Sheet sheet=wb.getSheetAt(0);
    this.totalRows=sheet.getPhysicalNumberOfRows();
    if(totalRows>=1 && sheet.getRow(0) != null){//�ж���������һ�����ҵ�һ�б����б��⣨������bug���ļ���һ��ûֵ�����ˣ�
         this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
    }
    for(int r=1;r<totalRows;r++){
    	String userName = "";
        Row row = sheet.getRow(r);
        if (row == null) continue;  
        ResultDetial resultDetial = new ResultDetial() ;
        resultDetial.setRdInfoId(resultId);
        //ѭ��Excel����
        for(int c = 0; c <this.totalCells; c++){ 
            Cell cell = row.getCell(c);
            if (null != cell){
               if(c==3){
                	userName=cell.getStringCellValue();
                	resultDetial.setUserLoginName(cell.getStringCellValue());
                }else if(c==6){
              	  	String result =subZeroAndDot(Double.toString(cell.getNumericCellValue()));
	              	  if(name.equals(userName)){
	              		totalResult+=cell.getNumericCellValue();
	              	  }
	              	  resultDetial.setRdResult(result);
		         }else if(c==8){
		        	   resultDetial.setRdIndex(subZeroAndDot(Double.toString(cell.getNumericCellValue())));
			     }
            }
        }
        if(name.equals(userName)){
        	resultDetialService.editResult(resultDetial);
        	// list.add(resultDetial);
      	  }
    }
    resultInfo.setRiResult((Double.toString(totalResult)));
    resultInfoService.editRe(resultInfo);

    
}
public static String subZeroAndDot(String s){  
    if(s.indexOf(".") > 0){  
        s = s.replaceAll("0+?$", "");//ȥ�������0  
        s = s.replaceAll("[.]$", "");//�����һλ��.��ȥ��  
    }  
    return s;  
}  
}

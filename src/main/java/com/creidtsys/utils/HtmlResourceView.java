package com.creidtsys.utils;

import java.io.File;
import java.util.Locale;

import org.springframework.web.servlet.view.InternalResourceView;

/**
 * ���ö����ͼ����������дcheckResource����
 * @author Administrator
 *
 */
public class HtmlResourceView extends InternalResourceView{
	 @Override  
     public boolean checkResource(Locale locale) {  
      File file = new File(this.getServletContext().getRealPath("/") + getUrl());  
      return file.exists();// �жϸ�ҳ���Ƿ����  
     }  
}

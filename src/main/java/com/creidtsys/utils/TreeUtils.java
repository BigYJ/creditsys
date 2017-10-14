package com.creidtsys.utils;

import java.lang.reflect.Method;
/**
 * 
* @ClassName: TreeUtils
* @Description: TODO ���ι�����
* @author liuyj
* @date 2017��9��9�� ����8:41:43
*
 */
public class TreeUtils {  
	  
	  
    /** 
     * �������ݵ���model 
     * @param tm ��model 
     * @param o �����ƵĶ��� 
     * @param s �䳤�����������������ַ��� 
     *          Լ����1��Ϊid����2��Ϊtext�� 
     *          ��3��ΪlinkUrl����4��ΪiconCls�� 
     *          ��5��ΪsplitNum 
     */  
    public static void copyModel(TreeModel tm, Object o, String... s) {  
        Class<?> clazz = o.getClass();// ��ȡ�����  
        int l = s.length;  
  
        try {  
            if(l - 0 > 0 && s[0] != null) {  
                Method id = clazz.getMethod(s[0]);// Լ����1��Ϊid  
                tm.setId(String.valueOf(id.invoke(o)));  
            }  
            if(l - 1 > 0 && s[1] != null) {  
                Method text = clazz.getMethod(s[1]);// Լ����2��Ϊtext  
                tm.setText(String.valueOf(text.invoke(o)));  
            }  
            if(l - 2 > 0 && s[2] != null) {  
                Method url = clazz.getMethod(s[2]);// Լ����3��ΪfuncUrl  
                tm.setLinkUrl(String.valueOf(url.invoke(o)));  
            }  
            if(l - 3 > 0 && s[3] != null) {  
                Method cls = clazz.getMethod(s[3]);// Լ����4��ΪiconCls  
                tm.setIconCls(String.valueOf(cls.invoke(o)));  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  

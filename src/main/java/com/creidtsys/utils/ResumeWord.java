package com.creidtsys.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class ResumeWord {

    private static Configuration configuration = null;
    private static Map<String,Template> allTemplate = null;

    static{
        configuration = new Configuration(Configuration.VERSION_2_3_0);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setClassForTemplateLoading(ResumeWord.class, "/temp");
        allTemplate = new HashMap<String,Template>();
        try{
            allTemplate.put("paperDetial", configuration.getTemplate("paperDetial.ftl"));
        }catch(IOException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private ResumeWord(){
    }

    public static File createDoc(Map<?,?> dataMap,String type){
        String name = "E://temp"+(int)(Math.random()*100000)+".doc";
        File f = new File(name);
        Template t = allTemplate.get(type);
        try{
            //����ط�����ʹ��FileWriter��Ϊ��Ҫָ���������ͷ���������word�ĵ�����Ϊ���޷�ʶ��ı�����޷���
            Writer w = new OutputStreamWriter(new FileOutputStream(f),"utf-8");
            t.process(dataMap,w);
            w.close();
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return f;
    }
}

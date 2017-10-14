package com.creidtsys.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
* @ClassName: TreeModel
* @Description: TODO(������һ�仰��������������)
* @author liuyj
* @date 2017��9��9�� ����8:42:14
*
 */
public class TreeModel {  
  
    private String id;  
    private String text;// ����  
    private String iconCls;// ͼ��  
    private String linkUrl;// ���ӵ�ַ  
      
    private List<TreeModel> children;// ���ӽڵ㼯��  
  
    public TreeModel() {  
        this.children = new ArrayList<TreeModel>();  
    }  
  
    public String getId() {  
        return id;  
    }  
  
    public void setId(String id) {  
        this.id = id;  
    }  
  
    public String getText() {  
        return text;  
    }  
  
    public void setText(String text) {  
        this.text = text;  
    }  
  
    public String getLinkUrl() {  
        return linkUrl;  
    }  
  
    public void setLinkUrl(String linkUrl) {  
        this.linkUrl = linkUrl;  
    }  
  
    public String getIconCls() {  
        return iconCls;  
    }  
  
    public void setIconCls(String iconCls) {  
        this.iconCls = iconCls;  
    }  
  
    public List<TreeModel> getChildren() {  
        return children;  
    }  
  
    public void setChildren(List<TreeModel> children) {  
        this.children = children;  
    }  
      
}  
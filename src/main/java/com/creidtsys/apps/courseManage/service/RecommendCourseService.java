package com.creidtsys.apps.courseManage.service;

import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.creidtsys.apps.courseManage.entity.HTMLInfo;
import com.creidtsys.apps.manage.entity.Relation;

public interface RecommendCourseService {

	List<Map<String, String>> getCourseGra(Relation relation);
	//�ݹ��ѯ���пγ̵������γ�
	public List<String> getList(List<String> list,Queue<String> queue) ;
	//ƴ�����ݸ�ʽ
	public List<Map<String,String>> initData(List<String> list)  ;
	//���ȫ����Ҫ�γ�
	public List<String> getAllNeedCourse(Relation relation) ;
	
	public List<Map<String,String>> getTreeDate(List<String> list ,String positionName) ;
	//��ʼ������ѧϰ���Ȳ�ѯ����
	List<Map<String, String>> getChoosedList(String userId, String relationId);
	
	HTMLInfo getRecInfo(String userId, String relationId);
}
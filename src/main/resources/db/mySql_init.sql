--������ԴȨ�޸����ӽڵ��ѯ���ڵ㺯��
CREATE FUNCTION `getResPid`(rootId VARCHAR(32)) 
     RETURNS LONGTEXT 
     BEGIN 
      declare fid LONGTEXT default  '0';
      declare str VARCHAR(32) default rootId;
      while rootId>0 do
      set fid=(SELECT res_parent_id FROM sys_res_info  WHERE rootId=res_id); 
     IF fid > 0 THEN  
     SET str=concat(str,',',fid);   
     SET rootId=fid;  
     ELSE SET rootId=fid;  
     END IF;  
     END WHILE;
 return str;
     END 
     
     --���� select getResPid(7)
     --select * from treenodes where FIND_IN_SET (id ,getParentList(#{id}))
--������ԴȨ�޸��ݸ��ڵ��ѯ�ӽڵ㺯��
CREATE FUNCTION `getResChild`(rootId VARCHAR(32)) 
     RETURNS LONGTEXT 
     BEGIN 
       DECLARE str LONGTEXT ; 
       DECLARE cid LONGTEXT ; 
       SET str = ''; 
       SET cid =rootId; 
       WHILE cid is not null DO 
         SET str= concat(str,',',cid); 
         SELECT group_concat(res_id) INTO cid FROM sys_res_info where FIND_IN_SET(res_parent_id,cid)>0; 
       END WHILE; 
       RETURN str; 
     END 
	--���� select getResChild(0) ;
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'west',border:true" class="easyui-panel" 
  					style="width: 800px">
  				<input type="hidden" id="companyId"  />				
  					<table id="areaList" calss="form" style="margin-left:20px;margin-top:20px;border-collapse:separate; border-spacing:10px 10px;">
		  				<tr>
							<td class="form-label" align="right">单元名称：</td>
							<td class="form-control" ><input id="unitName"
								 class="easyui-textbox"
								data-options="required:true" style="width:250px"></td>
								<td class="form-label" align="right">单元内容：</td>
							<td class="form-control" ><input id="unitContent"
								 class="easyui-textbox"
								data-options="required:true" style="width:250px"></td>	
										
						</tr>
  				</table>
  				<table style="margin-left:20px;margin-top:20px;">
  					<tr style="width:800px">
							<td class="form-label" align="right">单元备注：</td>
							<td>
								<input class="easyui-textbox" name="unitRemake"  id="unitRemake" data-options="multiline:true" style="height:100px;width:600px"/>
							</td>
						</tr>	
  				</table>
  				</div>
  				</div>	
  	<script type="text/javascript">

	  	function doInit(dialog){
	  		initCobbobox() ;
	  	}
	  	//初始化类型下拉框
	  	function initCobbobox(){
	  		$('#unCourseId').combobox({    
	  		    url:'course/initCourse',    
	  		    valueField:'id',    
	  		    textField:'text'   
	  		});  
	  	}
	  	function doSave(dialog){
	  		if(!vailNull()){
	  			$.messager.alert('提示','请填写必填项!','warning');
	  			return
	  		}
  			$.ajax({
  				type : "POST",
  				//提交的网址
  				url : "unit/add",
  				datatype:"json",
  				//提交的数据
  				data :{
  					"data":JSON.stringify({
  						"unitName":$('#unitName').textbox('getValue'),
  						"unitContent":$('#unitContent').textbox('getValue'),
  						"unitRemake":$('#unitRemake').textbox('getValue')
  						})					
  					},
  				//成功返回之后调用的函数             
  				success : function(data) {
  					if(data.meta.success){
  						$.messager.alert('提示','保存成功!','warning');
  						initdatagrid();
  		           		dialog.close();
  		               }else{
  		                   $.messager.alert('error', 'error');
  		               }
  				},
  				//调用出错执行的函数
  				error: function(XMLHttpRequest, textStatus, errorThrown) {
  					$.messager.alert('提示','保存失败!','warning');
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);
                }

  			});
  		}
	  	function vailNull(){        
			var unitName =$('#unitName').textbox('getValue')  ? true : false;
			var unitContent=$('#unitContent').textbox('getValue')  ? true : false;
			var unitRemake=$('#unitRemake').textbox('getValue')  ? true : false;
			
			return (unitName && unitContent && unitRemake );
		}
  	</script>
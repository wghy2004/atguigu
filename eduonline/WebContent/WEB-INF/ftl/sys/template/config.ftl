<!DOCTYPE html>
<html lang="zh-cn">
<head>
<#include "/common/common.ftl">
<@pnotify/>
<@easyui/>
<title>后台管理</title>
</head>
<body>
	<#include "/common/navbar.ftl"> 
	<@nav nav="templateNav"/>
	<#-- 内容开始 -->
	<div id="content">
		<@breadcrumb crumb1="系统设置" crumb2="静态化"/>
		<div class="warp">
			<!-- 工具栏 -->
			<div class='buttonArea'>
				<span id="searchbtn">	
					<a href="javascript:" onclick="append()" class="button blueButton">生成全站</a>
					<a href="javascript:" onclick="createIndex(this)" class="button blueButton">生成首页</a>
				</span>
			</div>
			<div class="table-container">
				<h5>&nbsp;&nbsp;生成课程:</h5>
				<table id="dg"  style="width:auto;height:250px;border:1px solid #ccc;" >
					<thead>
						<tr>
							<th data-options="field:'id',width:5,align:'center'">ID</th>
							<th data-options="field:'name',width:25">名称</th>
							<th data-options="field:'createCourse',width:10,align:'center'"
								formatter="formatCreateCourse">课程首页</th>
							<th data-options="field:'createDetail',width:10,align:'center'"
								formatter="formatCreateDetail">课程下所有课时页面</th>
						</tr>
					</thead>
				</table>
			</div>	
		</div>
	</div>
	<script>
		function formatCreateCourse(value, row, index) {
			var val = "<a  href='javascript:void(0);' onclick='append("
					+ row.id + ",2)' >生成</a>";
			return val;
		}
		
		function formatCreateDetail(value, row, index) {
			var val = "<a  href='javascript:void(0);' onclick='append("
					+ row.id + ",2)' >生成</a>";
			return val;
		}
	
		$(function(){
			$('#dg').treegrid({
					url: '${base}/sys/category/list?groupId=1&format=json',
	                method: 'get',
	                idField: 'id',
	                treeField: 'name',
	                fit:true,
	                fitColumns:'true'
			});
			$(window).resize(function(){
				$('#dg').datagrid('resize');
			});
		});
		
		function createIndex(obj){
			if($(obj).hasClass('disable')){
				return;
			}
			$.Loading.show("正在生成首页,请稍后...");
			$(obj).addClass("disable");	
			$.get('${base}/sys/template/index',function(data){
				if(data.status=='OK'){
					$.Loading.success(data.message);
					$(obj).removeClass("disable");
				}else{
					$.Loading.error(data.message);
				}
			});
		}
	</script>
	<#-- 内容结束 --> 
	<#include "/common/footer.ftl"> 
	<@modal/>
</body>
</html>

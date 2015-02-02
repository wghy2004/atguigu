<!DOCTYPE html>
<html lang="zh-cn">
<head>
<#include "/common/common.ftl">
<@pnotify/>
<@easyui/>
<title>用户列表</title>
</head>
<body>
	<#include "/common/navbar.ftl">
	<#if query.roles=="teacher">
		<@nav nav="teacherNav"/>
	<#elseif query.roles=="admin">
		<@nav nav="adminNav"/>
	<#else>
		<@nav nav="userNav"/>	
	</#if>
	<#-- 内容开始 -->
	<div id="content">
		<@breadcrumb crumb1="用户" crumb2="用户列表"/>
		<div class="warp">	
			<!-- 工具栏 -->
			<div class='buttonArea'>
				<span id="searchbtn">	
					<a href="${base}/sys/user/add" class="button blueButton" >新用户</a>
				</span>
				<span class="fr"> 
					<input id="searchKeyword" class="input_text  mr5" type="text" value="" size="30"	placeholder="请输入模糊关键字" name="searchKeyWord">
					<a href="javascript:void(0)" class="button " id="aAdvanced"  >高级搜索</a>
					<a href="javascript:void(0)" class="button " onclick="searchGoods()">搜索</a>
				</span>
			</div>
			<#-- 结果列表 -->
			<div class="table-container">
				<table id="dg"  style="border:1px solid #ccc;">
			        <thead>
			            <tr>
			                <th data-options="field:'id',width:10,align:'center'">id</th>
			                <th data-options="field:'title',width:10,align:'center'" formatter="formatTitle">头像</th>
			                <th data-options="field:'nickname',width:10,align:'center'">用户名</th>
			                <th data-options="field:'roles',width:10,align:'center'" formatter="formatRoles">角色</th>
			                <th data-options="field:'locked',width:10,align:'center'" formatter="formatLocked" >是否禁止</th>
			                <th data-options="field:'createdTime',width:15,align:'center'">注册时间</th>
			                <th data-options="field:'detail',width:10,align:'center'" formatter="formatDetail">资料</th>
			                <th data-options="field:'edit',width:10,align:'center'" formatter="formatEdit">编辑</th>
			            </tr>
			        </thead>
			    </table>
			 </div>
			 <@easyuiPage/>
	    </div>
	</div>
	<#-- 内容结束 -->
	<#include "/common/footer.ftl"> 
	<@modal/>
	<script type="text/javascript">
		function append(id, obj) {
			var map = {}; // Map map = new HashMap();
			if (!id) {
				map["href"] = "${base}/sys/course/add";
				map["formId"] = "#addForm";
				map["method"] = "post";
				map["url"] = "${base}/sys/course";
				map["title"] = "添加分类";
				map["loadshow"] = "正在添加......";
			} else {
				if (obj == 1) {
					map["href"] = "${base}/sys/course/add/"+id;
					map["formId"] = "#addForm";
					map["method"] = "post";
					map["url"] = "${base}/sys/course";
					map["title"] = "添加子分类";
					map["loadshow"] = "正在添加......";
				} else {
					map["href"] = "${base}/sys/course/edit/" + id;
					map["formId"] = "#editForm";
					map["method"] = "post";
					map["url"] = "${base}/sys/course";
					map["title"] = "修改分类";
					map["loadshow"] = "正在修改......";
				}
	
			}
			map["divDialog"] = "#divdia";
			map["gridreload"] = "#dg";
			addDialog(map);
		}
		function addDialog(map) {
			$(map["divDialog"]).show();
			$(map["divDialog"]).dialog({
				title : map["title"],
				width : 420,
				height : 280,
				closed : false,
				cache : false,
				href : map["href"],
				modal : true,
				buttons : [ {
					text : '保存',
					handler : function() {
						var savebtn = $(this);
		　　				var disabled=savebtn.hasClass("l-btn-disabled");
		　　				if(!disabled){
							 submitForm(map,savebtn);
						}
					}
				}, {
					text : '清空',
					handler : function() {
						clearForm(map);
					}
				} ]
			});
		}
		
		function submitForm(map,savebtn) {
			var formflag = $(map["formId"]).form().form('validate');
			if (formflag) {
				$.Loading.show("正在保存请稍后...");
				savebtn.linkbutton("disable");	
				$(map["formId"]).ajaxSubmit({
					url : map["url"],
					type : map["method"],
					dataType : 'json',
					success : function(result) {
						if (result.status == 'OK') {
							$(map["divDialog"]).dialog('close');
							$(map["gridreload"]).datagrid('reload');
							$.Loading.success(map["title"]+':'+result.message.name+'!');
						}
						if (result.status == 'ERROR') {
							$.Loading.error(result.message);
						}
						savebtn.linkbutton("enable");
					},
					error : function(e) {
						$.Loading.error("出现错误 ，请重试");
						savebtn.linkbutton("enable");
					}
				});
			}else{
				savebtn.linkbutton("enable");
				$.Loading.hide();
			}
		}
	
		function clearForm(map) {
			$(map["formId"]).form('clear');
		}
		
		function del(id){
			  deleteOne('${base}/sys/course/lesson/'+id , function(result){
				  	$('#dg').datagrid('reload');
					$.Loading.success('删除成功!');
			  });
		}		
		
		function formatTitle(value, row, index){
			var src='${base}/resources/images/user.png';
			if(row.title){
				src='${base}'+row.title;
			}
			return '<img src="'+src+'" style="max-width:50px;margin:5px;"/>';
		}
		function formatDetail(value, row, index){
				return "<a title='编辑' href='${base}/sys/user/profile/edit/"+row.id+"'>编辑</a>";
		}
		function formatLocked(value, row, index){
			
			var locked = row.locked;
			
			var str = '<input type="checkbox"';
			
			if(locked == 1){
				str +=' checked ';
			}
			str +=' data-id="'+row.id+'" onchange="setLocked(this)">';
			
			return str;
			
		}
		
		function formatRoles(value, row, index){
			if(row.roles=='teacher'){
				return '老师';
			}else if(row.roles=='member'){
				return '学员';
			}else if(row.roles=='admin'){
				return '管理员';
			}
		}
		
		
		function formatEdit(value, row, index) {
			var val = "<a class='edit' title='修改' href='${base}/sys/course/lesson/edit/"+row.id+"'></a>";
			return val;
		}
		function formatDelete(value, row, index) {
			var val = '<a href="javascript:" class="delete" onclick="del('+row.id+')"><img catid="'+row.cat_id+'" src="${base}/resources/images/transparent.gif"></a>';
			return val;
		}
		
		//设置禁止
		function setLocked(obj){
			var isLocked = $(obj).is(':checked'),
					  id = $(obj).attr('data-id');
			$.post('${base}/sys/user/edit',{
				_method : 'put',
				     id : id,
				 locked : isLocked?1:0
			},function(data){
				$.Loading.success('成功设置用户状态!');
			});
		}
		
		$(function(){
			var roles = '${(query.roles)!0}';
			var params = {};
			if(roles){
				params.roles = roles;
			}
			
			$('#dg').datagrid({
				url : '${base}/sys/user/list',
				queryParams:params,
				method : 'get',
				fit : true,
				fitColumns : true,
				onLoadSuccess : function(data){
					//设置分页控件 
				    $('#pp').pagination({ 
				    	total : data.total,
				    	pageList :[data.pageSize],
				    	pageSize : data.pageSize,
				    	pageNumber : data.pageNumber+1,
				        onSelectPage:function(pageNumber, pageSize){
							$(this).pagination('loading');
							$('#dg').datagrid('reload',{
								page : pageNumber-1
							});
							$(this).pagination('loaded');
						}
				    });                
           		}
			});
			$(window).resize(function(){
				$('#dg').datagrid('resize');
			});
		});	
	</script>
</body>
</html>

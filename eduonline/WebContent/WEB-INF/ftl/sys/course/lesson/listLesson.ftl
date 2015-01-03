<!DOCTYPE html>
<html lang="zh-cn">
<head>
<#include "/common/common.ftl">
<@pnotify/>
<@easyui/>
<title>课时</title>
</head>
<body>
	<#include "/common/navbar.ftl"> 
	<@nav nav="lessonNav"/>
	<#-- 内容开始 -->
	<div id="content">
		<@breadcrumb crumb1="课时" crumb2="课时列表"/>
		<div class="warp">	
			<!-- 工具栏 -->
			<div class='buttonArea'>
				<span id="searchbtn">	
					<a href="${base}/sys/course/lesson/add" class="button blueButton" >新课时</a>
					<a href="javascript:void(0)" class="button"  onclick="del()">删除</a>
					<a href="javascript:void(0)" class="button"  onclick="newTab('商品回收站','/version4/shop/admin/goods!trash_list.do')">回收站</a>
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
			                <th data-options="field:'title',width:30">标题</th>
			                <th data-options="field:'status',width:10" formatter="formatStatus">状态</th>
			                <th data-options="field:'sysCourse.title',width:15" formatter="formatCourse">所属课程</th>
			                <th data-options="field:'createdTime',width:15" formatter="formatTime">创建时间</th>
			                <th data-options="field:'edit',width:10,align:'center'" formatter="formatEdit">编辑</th>
			                <th data-options="field:'delete',width:10,align:'center'" formatter="formatDelete">删除</th>
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
		
		function formatStatus(value, row, index){
			
			var status = row.status;
			if(status == 'unpublished'){
				status = '未发布';
			}else if(status == 'published'){
				status = '已发布';
			}
			
			return status;
		}
		
		function formatCourse(value, row, index){
	
			return row.sysCourse?row.sysCourse.title : '未知'
		}
		
		function formatTime(value, row, index){
			var time = row.createdTime; 
			var date = new Date(time.year,time.month,time.date,time.hours,time.minutes,time.seconds);
			return util.formatDate(date,'YYYY-MM-DD hh:mm:ss');
		}
		
		function formatEdit(value, row, index) {
			var val = "<a class='edit' title='修改' href='${base}/sys/course/lesson/edit/"+row.id+"'></a>";
			return val;
		}
		function formatDelete(value, row, index) {
			var val = '<a href="javascript:" class="delete" onclick="del('+row.id+')"><img catid="'+row.cat_id+'" src="${base}/resources/images/transparent.gif"></a>';
			return val;
		}
		
		$(function(){
			var courseId = ${(query.courseId)!0};
			var params = {};
			if(courseId>0){
				params.courseId = courseId;
			}
			
			console.log(params);
			$('#dg').datagrid({
				url : '${base}/sys/course/lesson/list',
				queryParams:params,
				method : 'get',
				fit : true,
				fitColumns : true,
				onLoadSuccess : function(data){
					//设置分页控件 
				    $('#pp').pagination({ 
				    	total : data.total,
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

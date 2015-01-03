<!DOCTYPE html>
<html lang="zh-cn">
<head>
<#include "/common/common.ftl">
<@pnotify/>
<@easyui/>
<title>分组类型</title>
</head>
<body>
	<#include "/common/navbar.ftl"> 
	<@nav nav="courseCategoryNav"/>
	<#-- 内容开始 -->
	<div id="content">
		<@breadcrumb crumb1="课程" crumb2="课程分类"/>
		<div class="warp">
			<!-- 工具栏 -->
			<div class='buttonArea'>
				<span id="searchbtn">	
					<a href="javascript:" onclick="append()" class="button blueButton">添加分类</a>
					<a href="javascript:void(0)" class="button"  onclick="del()">保存排序</a>
				</span>
			</div>
			<#-- 结果列表 -->
			<div  class="table-container">
			<table id="dg"  style="width:auto;height:250px;border:1px solid #ccc;" >
				<thead>
					<tr>
						<th data-options="field:'id',width:5,align:'center'">ID</th>
						<th data-options="field:'name',width:25">名称</th>
						<th data-options="field:'code',width:10">代码</th>
						<th data-options="field:'weight',width:20"
							formatter="formatGoodscount">排序</th>
						<th data-options="field:'add',width:10,align:'center'"
							formatter="formatAdd">添加子</th>
						<th data-options="field:'edit',width:10,align:'center'"
							formatter="formatEdit">编辑</th>
						<th data-options="field:'delete',width:10,align:'center'"
							formatter="formatDelete">删除</th>
					</tr>
				</thead>
			</table>
			</div>
			<div id="divdia" style="display: none;"></div>
			
		</div>
	</div>
	<#-- 内容结束 --> 
	<#include "/common/footer.ftl"> 
	<@modal/>
	<script type="text/javascript">
	function append(id, obj) {
		var map = {}; // Map map = new HashMap();
		if (!id) {
			map["href"] = "${base}/sys/category/add";
			map["formId"] = "#addForm";
			map["method"] = "post";
			map["url"] = "${base}/sys/category";
			map["title"] = "添加分类";
			map["loadshow"] = "正在添加......";
		} else {
			if (obj == 1) {
				map["href"] = "${base}/sys/category/add/"+id;
				map["formId"] = "#addForm";
				map["method"] = "post";
				map["url"] = "${base}/sys/category";
				map["title"] = "添加子分类";
				map["loadshow"] = "正在添加......";
			} else {
				map["href"] = "${base}/sys/category/edit/" + id;
				map["formId"] = "#editForm";
				map["method"] = "post";
				map["url"] = "${base}/sys/category";
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
						$(map["gridreload"]).treegrid('reload');
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
		  deleteOne('${base}/sys/category/'+id , function(result){
			  	console.log(result);
			  	$('#dg').treegrid('reload');
				$.Loading.success('成功删除'+result.message+'!');
		  });
	}	
		
	function formatAdd(value, row, index) {
		var val = "<a href='javascript:void(0);' class='add' onclick='append(" + row.id
				+ ",1)'><img src='${base}/resources/images/transparent.gif'></a>";
		return val;
	}
	function formatEdit(value, row, index) {
		var val = "<a class='edit' title='修改' href='javascript:void(0);' onclick='append("
				+ row.id + ",2)' ></a>";
		return val;
	}
	function formatDelete(value, row, index) {
		var val = '<a href="javascript:" class="delete" onclick="del('+row.id+')"><img catid="'+row.cat_id+'" src="${base}/resources/images/transparent.gif"></a>';
		return val;
	}

	function formatGoodscount(value, row, index) {
		var val = '<input type="text" class="receiptsInputText" autocomplete="off" value="'+value+'" style="width:30px" name="cat_sorts">';
		val+='<input type="hidden" name="cat_ids" value="'+row.id+'" > '
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
			$('#dg').treegrid('resize',{
				width  : $('.container').width()-150 ,
				height : $('.container').height()
			});
		});
		
	});	
	</script>
</body>
</html>

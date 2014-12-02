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
	<#-- 内容开始 -->
	<div id="content">
		<div id="breadcrumb">
			<a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
			<a href="#" class="current">Tables</a>
		</div>
		<div class="warp container">
			<!-- 工具栏 -->
			<div class='buttonArea'>
				<span id="searchbtn">	
					<a href="javascript:" onclick="append()" class="button blueButton">添加分类</a>
					<a href="javascript:void(0)" class="button"  onclick="del()">保存排序</a>
				</span>
			</div>
			<#-- 结果列表 -->
			<table id="dg"  class="easyui-treegrid" style="width:100%;height:250px;border:1px solid #ccc;" data-options="url:'${base}/sys/category/list?groupId=1&parentId=0&format=json',fitColumns:'true',idField: 'id',treeField: 'name'">
				<thead>
					<tr>
						<th data-options="field:'id',width:5">ID</th>
						<th data-options="field:'name',width:25">名称</th>
						<th data-options="field:'code',width:10">代码</th>
						<th data-options="field:'path',width:10">路径</th>
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
			map["url"] = "cat!saveAdd.do?ajax=yes";
			map["title"] = "添加分类";
			map["loadshow"] = "正在添加......";
		} else {
			if (obj == 1) {
				map["href"] = "${base}/sys/category/edit/" + id;
				map["formId"] = "#addchildrenForm";
				map["url"] = "cat!saveAdd.do?ajax=yes";
				map["title"] = "添加子列表";
				map["loadshow"] = "正在添加......";
			} else {
				map["href"] = "${base}/sys/category/edit/" + id;
				map["formId"] = "#editForm";
				map["url"] = "cat!saveEdit.do?ajax=yes";
				map["title"] = "修改分类";
				map["loadshow"] = "正在修改......";
			}

		}
		map["divDialog"] = "#divdia";
		map["gridreload"] = "#catdata";
		addDialog(map);
	}
	function addDialog(map) {
		$(map["divDialog"]).show();
		$(map["divDialog"]).dialog({
			title : map["title"],
			width : 520,
			height : 380,
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
			var val = '<a href="javascript:;" class="delete" onclick="del('
					+ row.id
					+ ')"><img catid="'+row.cat_id+'" src="${base}/resources/images/transparent.gif"></a>';
			return val;
		}
	
		function formatGoodscount(value, row, index) {
			var val = '<input type="text" class="receiptsInputText" autocomplete="off" value="'+value+'" style="width:30px" name="cat_sorts">';
			val+='<input type="hidden" name="cat_ids" value="'+row.id+'" > '
			return val;
		}
		$(function(){
			$('#dg').treegrid({
					url: '${base}/sys/category/list?groupId=1&parentId=0&format=json',
	                method: 'get',
	                fit:true,
	                idField: 'id',
	                treeField: 'name',
	                toolbar:'#tb',
				    onBeforeLoad:function(row,param){
						if(row){
							$(this).treegrid('options').url='${base}/sys/category/list?parentId='+row.id+'&format=json';
						}
					},
					onLoadSuccess:function(row, data){
						for(var i=0, len = data.length; i<len; i++){
							data[i].groupName = data[i].sysCategoryGroup.name;
						}
						console.log(row,data);
					}
			});
						
			$('#group').combobox({
			     onSelect: function(rec){
			     	var groupId = rec.value;
			     	console.log(1,groupId);
					$('#dg').treegrid('load',{
						groupId: groupId
					});
			     }
			});
			//编辑
			$('#btnEdit').on('click',function(){
				var row = $('#dg').treegrid('getSelected');
				console.log(row)
			});
		});	
	</script>
</body>
</html>

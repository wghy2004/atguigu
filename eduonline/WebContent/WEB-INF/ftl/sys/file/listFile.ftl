<!DOCTYPE html>
<html lang="zh-cn">
<head>
<#include "/common/common.ftl">
<@pnotify/>
<@easyui/>
<title>文件列表</title>
</head>
<body>
	<#include "/common/navbar.ftl"> 
	<@nav nav="fileNav"/>
	<#-- 内容开始 -->
	<div id="content">
		<@breadcrumb crumb1="文件" crumb2="文件列表"/>
		<div class="warp">
			<!-- 工具栏 -->
			<div class='buttonArea'>
				<span id="searchbtn">	
					<a href="javascript:" onclick="append()" class="button blueButton">上传文件</a>
				</span>
			</div>
			<#-- 结果列表 -->
			<div class="table-container">
				<table id="dg"  style="border:1px solid #ccc;" >
					<thead>
						<tr>
							<th data-options="field:'id',width:5,align:'center'">ID</th>
							<th data-options="field:'uri',width:30"">uri</th>
							<th data-options="field:'mime',width:10">mime</th>
							<th data-options="field:'size',width:10">大小</th>
							<th data-options="field:'status',width:10">状态</th>
							<th data-options="field:'sysFileGroup.name',width:10" formatter="formatGroup">文件组</th>
							<th data-options="field:'userId',width:10">用户</th>
							<th data-options="field:'createdTime',width:15" formatter="formatTime">创建时间</th>
							<th data-options="field:'edit',width:10,align:'center'"
								formatter="formatEdit">编辑</th>
							<th data-options="field:'delete',width:10,align:'center'"
								formatter="formatDelete">删除</th>
						</tr>
					</thead>
				</table>
			</div>
			<@easyuiPage/>
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
			map["href"] = "${base}/sys/file/add";
			map["formId"] = "#addForm";
			map["method"] = "post";
			map["url"] = "${base}/sys/file/upload";
			map["title"] = "上传文件";
			map["loadshow"] = "正在上传......";
		} else {
			map["href"] = "${base}/sys/file/edit/" + id;
			map["formId"] = "#editForm";
			map["method"] = "post";
			map["url"] = "${base}/sys/file";
			map["title"] = "修改文件";
			map["loadshow"] = "正在修改......";

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
						$.Loading.success(map["title"]+':'+result.message.id+'!');
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
		  deleteOne('${base}/sys/file/'+id , function(result){
			  	console.log(result);
			  	$('#dg').datagrid('reload');
				$.Loading.success('成功删除'+result.message+'!');
		  });
	}	
	

	
	function formatTime(value, row, index){
		var time = row.createdTime; 
		var date = new Date(time.year,time.month,time.date,time.hours,time.minutes,time.seconds);
		return util.formatDate(date,'YYYY-MM-DD hh:mm:ss');
	}
	
	function formatGroup(value, row, index){
	
		return row.sysFileGroup?row.sysFileGroup.name : '未分组';
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
		$('#dg').datagrid({
				url: '${base}/sys/file/list',
                method: 'get',
                idField: 'id',
                fit:true,
                fitColumns:'true',
                onLoadSuccess : function(data){
                	console.log(data.total)
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

<#assign base=request.contextPath />
<#include "/common/common.ftl">
<@jstree/>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
</head>
<body>
	<form class="form-horizontal" role="form" method="post" action="${base}/sys/category">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title" id="myModalLabel">编辑</h4>
		</div>
		<div class="modal-body">
			<input type="hidden" name="_method" value="put"> <input type="hidden" name="id" value="${model.category.id}">
			<div class="form-group">
				<label for="dicName" class="col-md-2 control-label">名称</label>
				<div class="col-md-5">
					<input type="text" name="name" class="form-control" value="${model.category.name}" id="dicName" placeholder="名称">
				</div>
			</div>
			<div class="form-group">
				<label for="dicValue" class="col-md-2 control-label">代码</label>
				<div class="col-md-5">
					<input type="text" name="code" class="form-control" value="${model.category.code}" id="dicValue" placeholder="值">
				</div>
			</div>
			<div class="form-group">
				<label for="dicValue" class="col-md-2 control-label">路径</label>
				<div class="col-md-5">
					<input type="text" name="path" class="form-control" value="${model.category.path}"  placeholder="值">
				</div>
			</div>
			<div class="form-group">
				<label for="dicValue" class="col-md-2 control-label">父分类</label>
				<div class="col-md-5">
					<input type="text" name="parentId" id="parentId"  class="form-control hide" value="${model.category.parentId}"  placeholder="值">
					<input type="text" name="parentName"   id="parentName" disabled class="form-control" value="${model.category.parentName}"  placeholder="值">
					<div id="categoryTree">
					<select name="parentId" class="form-control">
							<option value="0">请选择</option>
						<#list model.rootCategorys as rootCategory>
							<option value="${rootCategory.id}">${rootCategory.name}</option> 
						</#list>
					</select>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label for="diccategory" class="col-md-2 control-label">分组</label>
				<div class="col-md-5">
					<select name="groupId" class="form-control">
							<option value="0">请选择</option>
						<#list model.groups as group>
							<option value="${group.id}" <#if model.category.sysCategoryGroup.id == group.id>selected</#if> >${group.name}</option> 
						</#list>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="diccategory" class="col-md-2 control-label">权重</label>
				<div class="col-md-5">
					<input type="text" name="weight" class="form-control" value="${model.category.weight}" id="diccategory" placeholder="值">
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" id="saveBtn" class="btn btn-primary">保存</button>
			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		</div>
	</form>
</body>
<script type="text/javascript">
	$(function() {
		$('#categoryTree').jstree({
			'core' : {
				  'data' : {
				      'url' : function (node) {
				        return node.id === '#' ?
				          '${base}/sys/category/child/0?format=json' : '${base}/sys/category/child/'+node.id+'?format=json';
				      },
				      'data' : function (node) {
				        return { 'id' : node.id ,name:node.text};
				      }
			    }
		    }
		});
		$('#categoryTree').on("changed.jstree", function (e, data) {
		   console.log(data.selected,data.instance.get_node(data.selected[0]).text);
		   $('#parentId').val(data.selected[0]);
		    $('#parentName').val(data.instance.get_node(data.selected[0]).text);
		});

		$("#saveBtn").click(function() {
			$.post($('form').attr('action'), $('form').serialize(), function(data) {
				$('[data-dismiss]').click();
			}, 'json');
		});
	});
</script>
</html>

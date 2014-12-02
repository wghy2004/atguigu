<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-cn">
<head>
</head>
<body>
	<form class="form-horizontal" role="form" method="post" action="${base}/sys/category/group">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title" id="myModalLabel">编辑</h4>
		</div>
		<div class="modal-body">
			<input type="hidden" name="_method" value="put"> <input type="hidden" name="id" value="${group.id}">
			<div class="form-group">
				<label for="dicName" class="col-md-2 control-label">名称</label>
				<div class="col-md-5">
					<input type="text" name="name" class="form-control" value="${group.name}" id="dicName" placeholder="名称">
				</div>
			</div>
			<div class="form-group">
				<label for="dicValue" class="col-md-2 control-label">代码</label>
				<div class="col-md-5">
					<input type="text" name="code" class="form-control" value="${group.code}" id="dicValue" placeholder="值">
				</div>
			</div>
			<div class="form-group">
				<label for="dicGroup" class="col-md-2 control-label">深度</label>
				<div class="col-md-5">
					<input type="text" name="depth" class="form-control" value="${group.depth}" id="dicGroup" placeholder="值">
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
		$("#saveBtn").click(function() {
			$.post($('form').attr('action'), $('form').serialize(), function(data) {
				$('[data-dismiss]').click();
			}, 'json');
		});
	});
</script>
</html>

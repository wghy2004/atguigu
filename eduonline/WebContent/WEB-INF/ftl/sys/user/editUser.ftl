<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-cn">
<head>
</head>
<body>
	<form class="form-horizontal" role="form" method="post" action="${base}/sys/user">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title" id="myModalLabel">编辑</h4>
		</div>
		<div class="modal-body">
			<input type="hidden" name="_method" value="put"> <input type="hidden" name="id" value="${user.dicId}">
			<div class="form-group">
				<label for="dicName" class="col-md-2 control-label">名称</label>
				<div class="col-md-5">
					<input type="text" name="dicName" class="form-control" value="${user.nickname}" id="dicName" placeholder="名称">
				</div>
			</div>
			<div class="form-group">
				<label for="dicValue" class="col-md-2 control-label">角色</label>
				<div class="col-md-5">
					<input type="text" name="dicValue" class="form-control" value="${user.roles}" id="dicValue" placeholder="值">
				</div>
			</div>
			<div class="form-group">
				<label for="dicGroup" class="col-md-2 control-label">组</label>
				<div class="col-md-5">
					<input type="text" name="dicGroup" class="form-control" value="${user.dicGroup}" id="dicGroup" placeholder="值">
				</div>
			</div>
			<div class="form-group">
				<label for="dicType" class="col-md-2 control-label">邮箱是否验证</label>
				<div class="col-md-5">
					<input type="text" name="dicType" class="form-control" value="${user.emailVerified}" id="dicType" placeholder="值">
				</div>
			</div>
			<div class="form-group">
				<label for="dicOrder" class="col-md-2 control-label">排序</label>
				<div class="col-md-5">
					<input type="text" name="dicOrder" class="form-control" value="${user.dicOrder}" id="dicOrder" placeholder="值">
				</div>
			</div>
			<div class="form-group">
				<label for="dicStatus" class="col-md-2 control-label">状态</label>
				<div class="col-md-5">
					<input type="text" name="dicStatus" class="form-control" value="${user.dicStatus}" id="dicStatus" placeholder="值">
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

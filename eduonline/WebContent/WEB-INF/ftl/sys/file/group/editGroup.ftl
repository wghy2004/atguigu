<#assign base=request.contextPath />
<div class="main" style="background-color: white;">
	<div class="easyui-panel" style="border-style: none;">
		<form class="validate" method="put" id="editForm">
			<table>
					<tbody><tr>
						<th>文件组名称</th>
						<td>
							<input class="input_text" type="text" id="name" name="name" value="${group.name}">
							<input type="hidden"  name="id" value="${group.id}">
							<input type="hidden"  name="groupId" value="${group.groupId}">
							 <input type="hidden" name="_method" value="put"/>
						</td>
					</tr>
					<tr>
						<th>代码</th>
						<td>
							<input type="text" class="input_text" name="code"  value="${group.code}" id="code" >
						</td>
					</tr>
					<tr>
						<th>排序</th>
						<td>
							<input type="text" class="input_text" name="isPublic"  value="${group.isPublic}" id="weight" >
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</div>
<script type="text/javascript">
	$(function() {
	});
</script>

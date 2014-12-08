<#assign base=request.contextPath />
<div class="main" style="background-color: white;">
	<div class="easyui-panel" style="border-style: none;">
		<form class="validate" method="put" id="editForm">
			<table>
					<tbody>
					<tr>
						<th>文件组</th>
						<td>
							<input name="groupId"   class="easyui-combobox" id="groupId" value="${file.groupId}" data-options="value:'${file.groupId}',valueField:'id',method:'get',textField:'name',url:'${base}/sys/file/group/list'">
							<input type="hidden"  name="id" value="${file.id}">
							 <input type="hidden" name="_method" value="put"/>
						</td>
					</tr>
					<tr>
						<th>选择文件</th>
						<td>
							<input class="input_text" type="file" id="files" name="files" value="${file.uri}">
						</td>
					</tr>
					<tr>
						<th>状态</th>
						<td>
							<input type="text" class="input_text" name="status"  value="${file.status}" id="status" >
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</div>

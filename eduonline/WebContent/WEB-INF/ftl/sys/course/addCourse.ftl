<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<#include "/common/common.ftl">
<@pnotify/>
<@easyui/>
<@kindeditor/>
</head>
<body>
	<#include "/common/navbar.ftl"> 
	<@nav nav="newCourseNav"/>
	<div id="content">
		<@breadcrumb crumb1="课程" crumb2="新课程"/>
		<div class="main">
		<div class="input">
			<div class="easyui-panel" style="border-style: none;">
			<form  method="post" action="${base}/sys/course/add" class="validate" id="addForm">
				<div style="display: block;" class="goods_input">
					<div class="contentTab">
						<ul class="tab">
							<li tabid="1" class="contentTabS">基本信息</li>
							<li tabid="3" class="">封面</li>
						</ul>
					</div>
					<div class="shadowBoxWhite wf100 whiteBox">
						<div class="text">
							<div class="tab-page">
								<div tabid="1" class="tab-panel" style="display: block;">
									<table class="form-table" width="100%">
										<tbody>
											<tr>
												<th style="width: 20%;">课程分类：</th>
												<td style="width: 80%; text-align: left;">
													<input name="categoryId" id="categoryId">
												</td>
											</tr>
											<tr>
												<th>标题：</th>
												<td style="text-align: left;"><input
													class="easyui-validatebox input_text  validatebox-text validatebox-invalid"
													type="text" name="title" data-options="required:true"
													datatype="string" isrequired="true" autocomplete="off"
													title=""></td>
											</tr>
											<tr>
												<th>副标题：</th>
												<td style="text-align: left;"><input type="text"
													name="subtitle"
													class="input_text">
												</td>
											</tr>

											<tr>
												<th>课程状态：</th>
												<td style="text-align: left;"><input type="radio"
													name="status" checked="checked" value="draft"
													class="market_enable"> 草稿&nbsp;&nbsp; <input
													type="radio" name="status" value="published"
													class="market_enable"> 发布&nbsp;&nbsp; <input
													type="radio" name="status" value="closed"
													class="market_enable"> 关闭</td>
											</tr>
											<tr style="display: none">
												<th>课时数：</th>
												<td style="text-align: left;"><input type="text"
													class="nodiscount" name="lessonNum" value="0"></td>
											</tr>
											<tr>
												<th>简介：</th>
												<td><textarea id="intro" name="content1" cols="100"
														rows="8"
														style="width: 98%; height: 300px; "></textarea>
												</td>
											</tr>

										</tbody>
									</table>

								</div>
								<div tabid="3" style="display: none;" class="tab-panel">
									<div id="album_tab" class="form-table albumbox">
										<input type="hidden" name="largePicture" id="largePicture">
										<form  method="post" action="${base}/sys/file/upload" class="validate" id="addForm" enctype="multipart/form-data">
											<table>
													<tbody>
													<tr>
														<th>文件组</th>
														<td><input id="groupId" class="easyui-combobox" name="groupId"   data-options="valueField:'id',method:'get',textField:'name',url:'${base}/sys/file/group/list'"></td>
													</tr>
													<tr>
														<th>选择文件</th>
														<td>
															<input class="input_text" type="file" id="files" name="files" >
														</td>
													</tr>
													<tr>
														<th>状态</th>
														<td>
															<input type="text" class="input_text" name="status"  value="0" id="status" >
														</td>
													</tr>
												</tbody>
											</table>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
			<div class="buttonWrap">
				<a href="javascript:;" class="easyui-linkbutton" id="courseAddBtn">确定</a>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {

			$(".goods_input .contentTab>ul>li").click(function() {
				var tabid = $(this).attr("tabid");
				$(".goods_input .contentTab>ul>li").removeClass("contentTabS");
				$(this).addClass("contentTabS");
				$(".tab-page .tab-panel").hide();
				$(".tab-panel[tabid=" + tabid + "]").show();
			});

			$("#courseAddBtn").click(function() {
				var formflag = $("#addForm").form('validate');
				if (formflag) {
					$("#courseAddBtn").linkbutton("disable");
					$.Loading.show("正在保存请稍后..");
					var options = {
						url : '${base}/sys/course',
						type : "POST",
						dataType : "json",
						success : function(result) {
							$.Loading.success(result.message);
							if (result.result == 1) {
								window.location.href = "${base}/sys/course";
							}
						},
						error : function(e) {
							$.Loading.error("出错了,请重试");
							$("#courseAddBtn").linkbutton("enable");
						}
					};
					$('#addForm').ajaxSubmit(options);
				}
			});
		});
	</script>
	</div>
	</div>
	<#include "/common/footer.ftl"> 
	<@modal/>
	<script>
		$(function(){
			$('#categoryId').combotree({
				url:'${base}/sys/course/combotree?format=json',
				method:'get',
				required:false,
				width : 300,
				height:28,
				value :  <#if course>${course.categoryId}<#else>0</#if>,
				onSelect : function(rec){
				  $('#path').val(rec.path+rec.id+'|');
				}
			});
			$(".contentTab>ul>li").on('click',function() {
				var tabid = $(this).attr("tabid");
				$(".contentTab>ul>li").removeClass("contentTabS");
				$(this).addClass("contentTabS");
				$(".tab-page .tab-panel").hide();
				$(".tab-panel[tabid=" + tabid + "]").show();
			});
			KindEditor.ready(function(K) {
				var editor1 = K.create('textarea[name="content1"]', {
					items :['source','undo','redo','cut','copy','paste','selectall','plainpaste'],
					newlineTag : 'br'
				});
				prettyPrint();
			});
		});
	</script>
</body>
</html>

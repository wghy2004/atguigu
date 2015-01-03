<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<title>后台管理</title>
<#include "/common/common.ftl">
<@pnotify/>
<@easyui/>
<@kindeditor/>
</head>
<body>
	<#include "/common/navbar.ftl"> 
	<@nav nav="newCourseNav"/>
	<div id="content">
		<@breadcrumb crumb1="课程" crumb2="编辑课程"/>
		<div class="main">
		<div class="input">
			<div class="easyui-panel" style="border-style: none;">
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
								<form  method="post" action="${base}/sys/course/edit" class="validate" id="addForm">
								<input type="hidden" name="_method" value="put">
								<input type="hidden" name="id" value="${course.id}">
								<div tabid="1" class="tab-panel" style="display: block;">
									<table class="form-table" width="100%">
										<tbody>
											<tr>
												<th style="width: 20%;">课程分类：</th>
												<td style="width: 80%; text-align: left;">
													<input name="categoryId" id="categoryId" value="${course.categoryId}">
												</td>
											</tr>
											<tr>
												<th>标题：</th>
												<td style="text-align: left;"><input
													class="easyui-validatebox input_text  validatebox-text validatebox-invalid"
													type="text" name="title" data-options="required:true"
													datatype="string" isrequired="true" autocomplete="off"
													value="${course.title}"></td>
											</tr>
											<tr>
												<th>副标题：</th>
												<td style="text-align: left;">
													<input type="text"	name="subtitle"	class="input_text" value="${course.subtitle}">
												</td>
											</tr>
											<tr>
												<th>课程状态：</th>
												<td style="text-align: left;">
													<input type="radio"	name="status"  <#if course.status =="draft">checked</#if>  value="draft" class="market_enable"> 草稿&nbsp;&nbsp;
													<input type="radio" name="status"  <#if course.status =="published">checked</#if> value="published"	class="market_enable"> 发布&nbsp;&nbsp; 
													<input type="radio" name="status"  <#if course.status =="closed">checked</#if> value="closed" class="market_enable"> 关闭
												</td>
											</tr>
											<tr>
												<th>课程类型：</th>
												<td style="text-align: left;"><input type="radio"
													name="type" checked="checked" value="normal"
													class="market_enable"> 视频</td>
											</tr>
											<tr>
												<th>课时数：</th>
												<td style="text-align: left;">
													<input type="text"	class="nodiscount" name="lessonNum" value="${course.lessonNum}">
												</td>
											</tr>
											<tr>
												<th>推荐：</th>
												<td style="text-align: left;">
													<input type="radio"	name="recommended" <#if course.recommended ==1>checked</#if> value="1"	class="market_enable"> 是&nbsp;&nbsp; 
													<input type="radio" name="recommended" <#if course.recommended ==0>checked</#if> value="0" class="market_enable"> 否
												</td>
											</tr>
											<tr>
												<th>推荐序号：</th>
												<td style="text-align: left;">
													<input type="text" class="nodiscount" name="recommendedSeq" value="${course.recommendedSeq}">
												</td>
											</tr>
											<tr>
												<th>简介：</th>
												<td>
													<textarea id="about" name="about" cols="100" rows="8" style="width: 98%; height: 300px;">${course.about}</textarea>
												</td>
											</tr>
											<tr>
												<td colspan="2">
													<input type="hidden" name="largePicture" id="largePicture" value="${course.largePicture}">
													<input type="hidden" name="maxStudentNum" value="0">
													<input type="hidden" name="price" value="0.0">
													<input type="hidden" name="expiryDay" value="30">
													<input type="hidden" name="showStudentNumType" value="opened">
													<input type="hidden" name="serializeMode" value="none">
													<input type="hidden" name="income" value="0">
													<input type="hidden" name="giveCredit" value="0">
													<input type="hidden" name="rating" value="0">
													<input type="hidden" name="ratingNum" value="0">
													<input type="hidden" name="vipLevelId" value="0">
													<input type="hidden" name="smallPicture" value="">
													<input type="hidden" name="middlePicture" value="">
													<input type="hidden" name="locationId" value="0">
													<input type="hidden" name="address" value="">
													<input type="hidden" name="studentNum" value="0">
													<input type="hidden" name="hitNum" value="0">
												</td>
											</tr>

										</tbody>
									</table>
								</div>
								</form>
								<div tabid="3" style="display: none;" class="tab-panel">
									<div id="album_tab" class="form-table albumbox">
										<div ><img style="max-height:300px;" id="largePicturePreview" src="${base}/${course.largePicture}" /></div>
										<form  method="post" action="${base}/sys/file/upload" class="validate" id="addFileForm" enctype="multipart/form-data">
											<table>
													<tbody>
													<tr>
														<th>选择文件</th>
														<td>
															<input class="input_text" type="file" id="files" name="files" >
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
			<div class="buttonWrap">
				<a href="javascript:;" class="easyui-linkbutton" id="courseAddBtn">确定</a>
			</div>
		</div>
	</div>
	</div>
	</div>
	<#include "/common/footer.ftl"> 
	<@modal/>
	<script>
		$(function(){
			var aboutEditor ;  
			$(".contentTab>ul>li").on('click',function() {
				var tabid = $(this).attr("tabid");
				$(".contentTab>ul>li").removeClass("contentTabS");
				$(this).addClass("contentTabS");
				$(".tab-page .tab-panel").hide();
				$(".tab-panel[tabid=" + tabid + "]").show();
			});
			KindEditor.ready(function(K) {
				aboutEditor = K.create('textarea[name="about"]', {
					items :['source','bold','italic','underline','strikethrough','|','undo','redo','cut','copy','paste','selectall','plainpaste'],
					newlineTag : 'br'
				});
				prettyPrint();
				// 设置HTML内容
				aboutEditor.html('${course.about}');
			});
			
			$('#categoryId').combotree({
				url:'${base}/sys/category/combotree?format=json',
				method:'get',
				required:false,
				width : 300,
				height:28,
				value :  ${course.categoryId},
				onSelect : function(rec){
				  $('#path').val(rec.path+rec.id+'|');
				}
			});
			//封面
			$('#files').on('change',function(){
				var formflag = $("#addFileForm").form('validate');
				if (formflag) {
					$.Loading.show("正在上传封面请稍后..");
					var options = {
						url : '${base}/sys/file/upload',
						type : "POST",
						dataType : "json",
						success : function(result) {
							if (result.status == 'OK') {
								$.Loading.success('图片上传成功!');
								$('#largePicturePreview').attr('src','${base}/'+result.message.uri);
								$('#largePicture').val(result.message.uri);
							}
						},
						error : function(e) {
							$.Loading.error("出错了,请重试");
						}
					};
					$('#addFileForm').ajaxSubmit(options);
				}
			});
			
			$("#courseAddBtn").click(function() {
			
				$('#about').val(aboutEditor.html());
				
				var formflag = $("#addForm").form('validate');
				if (formflag) {
					$("#courseAddBtn").linkbutton("disable");
					$.Loading.show("正在保存请稍后..");
					var options = {
						url : '${base}/sys/course',
						type : "POST",
						dataType : "json",
						success : function(result) {
							$.Loading.success('成功添加课程:'+result.message.title);
							if (result.status == 'OK') {
								window.location.href = "${base}/sys/course";
							}else{
								$.Loading.error("出错了,请重试");
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
</body>
</html>

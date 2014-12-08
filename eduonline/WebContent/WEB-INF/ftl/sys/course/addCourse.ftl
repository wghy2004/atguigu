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
	<div id="content">
		<div id="breadcrumb">
			<a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> 课程</a>
			<a href="#" class="current">新课程</a>
		</div>
		<div class="main">
		<div class="input">
			<div class="easyui-panel" style="border-style: none;">
			<form  method="post" action="${base}/sys/category/add" class="validate" id="addForm">
				<input value="goods!saveAdd.do" type="hidden" id="goods_inputAction">

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
													<input name="categoryId" id="categoryId" <#if category>value="${category.id}"<#else>value="0"</#if>>
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
									<script type="text/javascript">
										var ext = 'do';
									</script>
									<link type="text/css" rel="stylesheet"
										href="./add_files/album.css">
									<script type="text/javascript"
										src="./add_files/fileprogress.js"></script>
									<script type="text/javascript"
										src="./add_files/photo_handlers.js"></script>
									<script type="text/javascript"
										src="./add_files/swfupload.cookies.js"></script>
									<script type="text/javascript" src="./add_files/swfupload.js"></script>
									<script type="text/javascript"
										src="./add_files/swfupload.queue.js"></script>
									<div id="album_tab" class="form-table albumbox">
										<input type="hidden" name="image_default" id="defaultpic"
											value="">
										<table style="width: 100%; height: auto;">
											<tbody>
												<tr>
													<td align="left" style="padding-left: 150px" id="up">
														<object id="SWFUpload_0"
															type="application/x-shockwave-flash"
															data="http://www.javamall.com.cn/version4/resource/com/enation/app/shop/component/gallery/plugin/js/swfupload.swf?swfuploadrnd=416211448"
															width="61" height="22" class="swfupload">
															<param name="wmode" value="window">
															<param name="movie"
																value="/version4/resource/com/enation/app/shop/component/gallery/plugin/js/swfupload.swf?swfuploadrnd=416211448">
															<param name="quality" value="high">
															<param name="menu" value="false">
															<param name="allowScriptAccess" value="always">
															<param name="flashvars"
																value="movieName=SWFUpload_0&amp;uploadURL=%2Fversion4%2Fapi%2Fshop%2Fgoods-gallery!upload.do&amp;useQueryString=false&amp;requeueOnError=false&amp;httpSuccess=&amp;params=ajax%3Dyes&amp;filePostName=Filedata&amp;fileTypes=*.gif%3B*.jpg%3B*.bmp&amp;fileTypesDescription=gif%20jpg%20bmp&amp;fileSizeLimit=10%20MB&amp;fileUploadLimit=100&amp;fileQueueLimit=0&amp;debugEnabled=false&amp;buttonImageURL=%2Fversion4%2Fresource%2Fcom%2Fenation%2Fapp%2Fshop%2Fcomponent%2Fgallery%2Fplugin%2Fimages%2FXPButtonUploadText_61x22.png&amp;buttonWidth=61&amp;buttonHeight=22&amp;buttonText=&amp;buttonTextTopPadding=3&amp;buttonTextLeftPadding=12&amp;buttonTextStyle=color%3A%20%23000000%3B%20font-size%3A%2016pt%3B&amp;buttonAction=-110&amp;buttonDisabled=false&amp;buttonCursor=-1">
														</object>
													</td>
												</tr>
												<tr>
													<td height="179" align="left" style="padding-left: 50px;">
														<div class="imgPrivew" id="imgPrivew">
															<p style="margin-top: 100px">
																此处显示商品页默认图片<br> [您还未上传商品图片！]
															</p>
														</div>
													</td>
												</tr>
												<tr>
													<td id="uploadProgress" align="left"
														style="padding-left: 25px"></td>
												</tr>

											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
			<div class="buttonWrap">
				<a href="javascript:;" class="easyui-linkbutton">确定</a>
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

			$("input[type=text]").attr("autocomplete", "off");
			$("#goodsinput").click(function() {
				var formflag = $("#theForm").form('validate');
				if (formflag) {
					$("#goodsinput").linkbutton("disable");
					$.Loading.show("正在保存请稍后..");
					var options = {
						url : $("#goods_inputAction").val() + "?ajax=yes",
						type : "POST",
						dataType : "json",
						success : function(result) {
							$.Loading.success(result.message);
							if (result.result == 1) {
								window.location.href = "goods!list.do";
							}
						},
						error : function(e) {
							$.Loading.error("出错了,请重试");
							$("#goodsinput").linkbutton("enable");
						}
					};
					$('#theForm').ajaxSubmit(options);
				}
			});
		});
	</script>


	<div class="panel combo-p"
		style="position: absolute; z-index: 10; display: none; width: 200px;">
		<div class="combo-panel panel-body panel-body-noheader" title=""
			style="width: 198px; height: 198px;">
			<div id="_easyui_combobox_1"
				class="combobox-item combobox-item-selected">请选择</div>
			<div id="_easyui_combobox_2" class="combobox-item">PomPotes/梦果鲜</div>
			<div id="_easyui_combobox_3" class="combobox-item">可康</div>
			<div id="_easyui_combobox_4" class="combobox-item">Hunts/汉斯</div>
		</div>
	</div>
	<div class="panel combo-p"
		style="position: absolute; z-index: 10; display: none; width: 200px;">
		<div class="combo-panel panel-body panel-body-noheader" title=""
			style="width: 198px; height: 198px;">
			<div id="_easyui_combobox_5"
				class="combobox-item combobox-item-selected">请选择</div>
			<div id="_easyui_combobox_6" class="combobox-item">袋装</div>
			<div id="_easyui_combobox_7" class="combobox-item">盒装</div>
			<div id="_easyui_combobox_8" class="combobox-item">托装</div>
			<div id="_easyui_combobox_9" class="combobox-item">卡通装</div>
			<div id="_easyui_combobox_10" class="combobox-item">杯装</div>
		</div>
	</div>
	<div class="panel combo-p"
		style="position: absolute; z-index: 10; display: none; width: 200px;">
		<div class="combo-panel panel-body panel-body-noheader" title=""
			style="width: 198px; height: 198px;">
			<div id="_easyui_combobox_11"
				class="combobox-item combobox-item-selected">请选择</div>
			<div id="_easyui_combobox_12" class="combobox-item">水果</div>
			<div id="_easyui_combobox_13" class="combobox-item">巧克力</div>
			<div id="_easyui_combobox_14" class="combobox-item">其他</div>
		</div>
	</div>
	<div class="panel combo-p"
		style="position: absolute; z-index: 10; display: none; width: 200px;">
		<div class="combo-panel panel-body panel-body-noheader" title=""
			style="width: 198px; height: 198px;">
			<div id="_easyui_combobox_15"
				class="combobox-item combobox-item-selected">请选择</div>
			<div id="_easyui_combobox_16" class="combobox-item">其他国家和地区</div>
			<div id="_easyui_combobox_17" class="combobox-item">美国</div>
			<div id="_easyui_combobox_18" class="combobox-item">中国台湾</div>
			<div id="_easyui_combobox_19" class="combobox-item">法国</div>
			<div id="_easyui_combobox_20" class="combobox-item">马来西亚</div>
		</div>
	</div>
	</div>
	</div>
	<#include "/common/footer.ftl"> 
	<@modal/>
	<script>
		$(function(){
			$('#categoryId').combotree({
				url:'${base}/sys/category/combotree?format=json',
				method:'get',
				required:false,
				width : 300,
				height:28,
				value :  <#if category>${category.id}<#else>0</#if>,
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

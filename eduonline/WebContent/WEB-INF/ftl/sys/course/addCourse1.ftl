<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<#include "/common/common.ftl">
<@pnotify/>
<@easyui/>
<script>
$(function(){
	$(".contentTab>ul>li").on('click',function() {
		console.log('sdfsfd');
		var tabid = $(this).attr("tabid");
		$(".contentTab>ul>li").removeClass("contentTabS");
		$(this).addClass("contentTabS");
		$(".tab-page .tab-panel").hide();
		$(".tab-panel[tabid=" + tabid + "]").show();
	});
});

</script>
</head>
<body>
	<#include "/common/navbar.ftl"> 
	<div id="content">
		<div id="breadcrumb">
			<a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
			<a href="#" class="current">Tables</a>
		</div>
		<div class="main">
		<div class="input">
			<form method="post" name="theForm" id="theForm">
				<input value="goods!saveAdd.do" type="hidden" id="goods_inputAction">

				<div style="display: block;" class="goods_input">
					<div class="contentTab">
						<ul class="tab">
							<li tabid="1" class="contentTabS">基本信息</li>
							<li tabid="3" class="">相册</li>
							<li tabid="4">规格</li>
							<li tabid="7" class="">属性</li>
							<li tabid="9" class="">参数</li>
							<li tabid="11" class="">SEO</li>
							<li tabid="13" class="">标签</li>
						</ul>
					</div>
					<div class="shadowBoxWhite wf100 whiteBox">
						<div class="text">
							<div class="tab-page">
								<div tabid="1" class="tab-panel" style="display: block;">
									<table class="form-table" width="100%">
										<tbody>
											<tr>
												<th style="width: 10%;">商品分类：</th>
												<td style="width: 90%; text-align: left;"><span>营养保健、健康器械</span>
													<span>&nbsp;&gt;&nbsp;</span> <span>进口食品、进口牛奶</span> <span>&nbsp;&gt;&nbsp;</span>
													<span>进口休闲零食</span> <span>&nbsp;&gt;&nbsp;</span> <span>进口果冻/布丁</span>
													<input type="hidden" name="goods.cat_id" value="34">
													<input type="hidden" name="goods.type_id" value="22"></td>
											</tr>
											<tr>
												<th>商品名称：</th>
												<td style="text-align: left;"><input
													class="easyui-validatebox input_text  validatebox-text validatebox-invalid"
													type="text" name="goods.name" data-options="required:true"
													datatype="string" isrequired="true" autocomplete="off"
													title=""></td>
											</tr>
											<tr>
												<th>商品编号：</th>
												<td style="text-align: left;"><input type="text"
													name="goods.sn"
													class="input_text easyui-validatebox validatebox-text validatebox-invalid"
													data-options="required:true" autocomplete="off" title="">
												</td>
											</tr>

											<tr>
												<th>是否上架销售：</th>
												<td style="text-align: left;"><input type="radio"
													name="goods.market_enable" checked="checked" value="1"
													class="market_enable"> 是&nbsp;&nbsp; <input
													type="radio" name="goods.market_enable" value="0"
													class="market_enable"> 否</td>
											</tr>
											<tr style="display: none">
												<th>是否支持打折：</th>
												<td style="text-align: left;"><input type="radio"
													class="nodiscount" name="goods.no_discount"
													checked="checked" value="0"> 是&nbsp;&nbsp; <input
													type="radio" class="nodiscount" name="goods.no_discount"
													value="1"> 否</td>
											</tr>



											<tr>
												<th>市场价格：</th>
												<td style="text-align: left;"><input type="text"
													name="goods.mktprice" id="mktprice"
													class="input_text easyui-validatebox validatebox-text"
													validtype="money" data-options="required:true" value="0"
													style="width: 100px" autocomplete="off"></td>
											</tr>
											<tr>
												<th>获得积分：</th>
												<td style="text-align: left;"><input type="text"
													class="input_text easyui-numberbox numberbox-f validatebox-text"
													datatype="float" data-options="required:true" value="0"
													style="width: 100px" numberboxname="goods.point"
													autocomplete="off"><input type="hidden"
													name="goods.point" value="0"></td>
											</tr>
											<tr>
												<th>详细描述：</th>
												<td><textarea id="intro" name="content1" cols="100"
														rows="8"
														style="width: 98%; height: 300px; visibility: hidden; display: none;"></textarea>
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
								<div tabid="4" style="display: none;" class="tab-panel">
									<style>
#spec-input {
	display: none
}
</style>
									<link href="./add_files/spec2.css" rel="stylesheet"
										type="text/css">
									<script>
										var ctx = "/version4";
									</script>

									<script type="text/javascript" src="./add_files/memberprice.js"></script>
									<script type="text/javascript" src="./add_files/spec-v2.js"></script>
									<input type="hidden" name="haveSpec" id="haveSpec" value="0">
									<table id="no-spec-input" class="form-table" width="100%">
										<tbody>
											<tr>
												<th style="width: 10%">销售价：</th>
												<td style="text-align: left; width: 90%"><input
													type="text" maxlength="25" style="width: 60px;"
													name="price" id="price" class="price input_text"
													autocomplete="off" datatype="float" value="0"> <!-- <input type="button" class="mempriceBtn button" value="编辑会员价格"/> -->
													<div class="member_price_box">
														<!-- 声明控件，稍后初始化 -->

													</div></td>
											</tr>
											<tr>
												<th>成本价：</th>
												<td style="text-align: left;"><input type="text"
													style="width: 60px;" maxlength="30" name="cost" id="cost"
													autocomplete="off" value="0" class="input_text"></td>
											</tr>
											<tr>
												<th>重量：</th>
												<td style="text-align: left;"><input type="text"
													maxlength="25" style="width: 60px;" name="weight"
													id="weight" autocomplete="off" value="0" class="input_text">克(g)</td>
											</tr>

											<tr class="advui">
												<th>规格：</th>
												<td style="padding: 4px 0pt; text-align: left;"><input
													type="button" id="specOpenBtn" value="开启规格" class="button">
												</td>
											</tr>

										</tbody>
									</table>

									<div id="spec-input" style="text-align: left;">
										<input type="button" id="specCloseBtn" value="关闭规格"
											goodsid="0" class="button">
										<table class="form-table">
											<tbody>
												<tr>
													<th>颜色：</th>
													<td>
														<ul class="spec" specname="颜色">
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="41"
																	spec_value="黄色" specid="1"> </span> <span> <img
																	alt="黄色" src="./add_files/201411091753560383.jpg">
															</span> <span>黄色</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="42"
																	spec_value="绿色" specid="1"> </span> <span> <img
																	alt="绿色" src="./add_files/201411091802033178.jpg">
															</span> <span>绿色</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="43"
																	spec_value="黑色" specid="1"> </span> <span> <img
																	alt="黑色" src="./add_files/201003231758466829.gif">
															</span> <span>黑色</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="44"
																	spec_value="红色" specid="1"> </span> <span> <img
																	alt="红色" src="./add_files/201003231758540529.gif">
															</span> <span>红色</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="45"
																	spec_value="蓝色" specid="1"> </span> <span> <img
																	alt="蓝色" src="./add_files/201003231759056186.gif">
															</span> <span>蓝色</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="46"
																	spec_value="白色" specid="1"> </span> <span> <img
																	alt="白色" src="./add_files/201003231759165477.gif">
															</span> <span>白色</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="47"
																	spec_value="花色" specid="1"> </span> <span> <img
																	alt="花色" src="./add_files/201003231759251588.gif">
															</span> <span>花色</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="48"
																	spec_value="灰色" specid="1"> </span> <span> <img
																	alt="灰色" src="./add_files/201003231759361219.gif">
															</span> <span>灰色</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="49"
																	spec_value="肤色" specid="1"> </span> <span> <img
																	alt="肤色" src="./add_files/201003231752553635.gif">
															</span> <span>肤色</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="50"
																	spec_value="粉黄色" specid="1"> </span> <span> <img
																	alt="粉黄色" src="./add_files/201005191140150035.jpg">
															</span> <span>粉黄色</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="51"
																	spec_value="橙色" specid="1"> </span> <span> <img
																	alt="橙色" src="./add_files/201005191141088633.jpg">
															</span> <span>橙色</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="52"
																	spec_value="浅绿" specid="1"> </span> <span> <img
																	alt="浅绿" src="./add_files/201005191142251911.jpg">
															</span> <span>浅绿</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="53"
																	spec_value="浅蓝" specid="1"> </span> <span> <img
																	alt="浅蓝" src="./add_files/201005191143231991.jpg">
															</span> <span>浅蓝</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="54"
																	spec_value="粉红色" specid="1"> </span> <span> <img
																	alt="粉红色" src="./add_files/201005191144208127.jpg">
															</span> <span>粉红色</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="55"
																	spec_value="浅玫红" specid="1"> </span> <span> <img
																	alt="浅玫红" src="./add_files/201005191145294591.jpg">
															</span> <span>浅玫红</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="56"
																	spec_value="西瓜红" specid="1"> </span> <span> <img
																	alt="西瓜红" src="./add_files/201005191146439979.jpg">
															</span> <span>西瓜红</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="57"
																	spec_value="粉紫色" specid="1"> </span> <span> <img
																	alt="粉紫色" src="./add_files/201411200939095116.jpg">
															</span> <span>粉紫色</span></li>
														</ul>
													</td>
												</tr>
												<tr>
													<th>尺寸：</th>
													<td>
														<ul class="spec" specname="尺寸">
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="9"
																	spec_value="均码" specid="2"> </span> <span>均码</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="10"
																	spec_value="XXS" specid="2"> </span> <span>XXS</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="11"
																	spec_value="XS" specid="2"> </span> <span>XS</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="12"
																	spec_value="S" specid="2"> </span> <span>S</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="13"
																	spec_value="M" specid="2"> </span> <span>M</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="14"
																	spec_value="L" specid="2"> </span> <span>L</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="15"
																	spec_value="XL" specid="2"> </span> <span>XL</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="16"
																	spec_value="XXL" specid="2"> </span> <span>XXL</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="17"
																	spec_value="XXXL" specid="2"> </span> <span>XXXL</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="29"
																	spec_value="70B" specid="2"> </span> <span>70B</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="30"
																	spec_value="70C" specid="2"> </span> <span>70C</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="31"
																	spec_value="70D" specid="2"> </span> <span>70D</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="32"
																	spec_value="75B" specid="2"> </span> <span>75B</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="33"
																	spec_value="75C" specid="2"> </span> <span>75C</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="34"
																	spec_value="75D" specid="2"> </span> <span>75D</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="35"
																	spec_value="80C" specid="2"> </span> <span>80C</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="36"
																	spec_value="80D" specid="2"> </span> <span>80D</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="37"
																	spec_value="80E" specid="2"> </span> <span>80E</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="38"
																	spec_value="85C" specid="2"> </span> <span>85C</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="39"
																	spec_value="85D" specid="2"> </span> <span>85D</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="40"
																	spec_value="85E" specid="2"> </span> <span>85E</span></li>
														</ul>
													</td>
												</tr>
												<tr>
													<th>容量：</th>
													<td>
														<ul class="spec" specname="容量">
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="58"
																	spec_value="1GB" specid="3"> </span> <span>1GB</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="59"
																	spec_value="2GB" specid="3"> </span> <span>2GB</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="60"
																	spec_value="4GB" specid="3"> </span> <span>4GB</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="61"
																	spec_value="8GB" specid="3"> </span> <span>8GB</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="62"
																	spec_value="16GB" specid="3"> </span> <span>16GB</span></li>
														</ul>
													</td>
												</tr>
												<tr>
													<th>是否方芳芳：</th>
													<td>
														<ul class="spec" specname="是否方芳芳">
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="65"
																	spec_value="方法" specid="4"> </span> <span>方法</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="66"
																	spec_value="发生的" specid="4"> </span> <span>发生的</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="67"
																	spec_value="uu" specid="4"> </span> <span>uu</span></li>
														</ul>
													</td>
												</tr>
												<tr>
													<th>2：</th>
													<td>
														<ul class="spec" specname="2">
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="68"
																	spec_value="4" specid="5"> </span> <span>4</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="70"
																	spec_value="44" specid="5"> </span> <span>44</span></li>
														</ul>
													</td>
												</tr>
												<tr>
													<th>颜色：</th>
													<td>
														<ul class="spec" specname="颜色">
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="69"
																	spec_value="2" specid="6"> </span> <span>2</span></li>
														</ul>
													</td>
												</tr>
												<tr>
													<th>ceshi1：</th>
													<td>
														<ul class="spec" specname="ceshi1">
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="71"
																	spec_value="111" specid="7"> </span> <span>111</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="72"
																	spec_value="" specid="7"> </span> <span></span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="73"
																	spec_value="" specid="7"> </span> <span></span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="74"
																	spec_value="" specid="7"> </span> <span></span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="75"
																	spec_value="" specid="7"> </span> <span></span></li>
														</ul>
													</td>
												</tr>
												<tr>
													<th>冬颐乌冬面500g：</th>
													<td>
														<ul class="spec" specname="冬颐乌冬面500g">
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="76"
																	spec_value="大" specid="8"> </span> <span>大</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="77"
																	spec_value="多" specid="8"> </span> <span>多</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="78"
																	spec_value="口味丰富" specid="8"> </span> <span>口味丰富</span></li>
															<li><span><input class="chk"
																	autocomplete="off" type="checkbox" value="79"
																	spec_value="" specid="8"> </span> <span></span></li>
														</ul>
													</td>
												</tr>
											</tbody>
										</table>
										<div class="detail">
											<table class="spec_table" cellspacing="0" cellpadding="0"
												border="0">
												<thead>
													<tr>

														<th class="w2">货号*</th>
														<th class="w2">销售价*</th>
														<th class="w3">重量</th>
														<th class="w3">成本价</th>
														<th class="w1">操作</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
									</div>


								</div>
								<div tabid="7" style="display: none;" class="tab-panel">
									<table class="form-table" style="width: 100%;">
										<tbody>
											<tr>
												<th>计价单位：</th>
												<td style="text-align: left;"><input name="goods.unit"
													style="width: 192px;" class="input_text" value="">
												</td>
											</tr>
											<tr id="brand_tr">
												<th>品牌：</th>
												<td id="brand_id_td" style="text-align: left;"><select
													class="easyui-combobox input_text combobox-f combo-f"
													style="width: 200px; height: 28px; display: none;"
													comboname="goods.brand_id">
														<option value="">请选择</option>
														<option value="51">PomPotes/梦果鲜</option>
														<option value="50">可康</option>
														<option value="49">Hunts/汉斯</option>
												</select></td>
											</tr>
											<input type="hidden" name="propnames" value="包装">
											<tr>
												<th>包装 ：</th>
												<td style="text-align: left;"><select
													style="width: 200px; height: 28px; display: none;"
													class="easyui-combobox input_text combobox-f combo-f"
													comboname="propvalues">
														<option value="">请选择</option>
														<option value="0">袋装</option>
														<option value="1">盒装</option>
														<option value="2">托装</option>
														<option value="3">卡通装</option>
														<option value="4">杯装</option>
												</select></td>
											</tr>
										</tbody>
									</table>

									<script type="text/javascript">
									<!--
										$(".check")
												.click(
														function() {
															var attrid = $(this)
																	.attr(
																			"attrid");
															var str = "";
															$(
																	"input[attrid="
																			+ attrid
																			+ "]")
																	.each(
																			function() {
																				if (this.checked) {
																					str += "#";
																					str += $(
																							this)
																							.val();
																				}
																			});
															$("#" + attrid)
																	.val(str);
														});
									//-->
									</script>
								</div>
								<div tabid="9" style="display: none;" class="tab-panel">
									<table class="form-table" width="100%">
										<tbody>
											<tr style="display: none;">
												<th style="text-align: left" align="left" colspan="2"
													class="groupname title"><input type="hidden"
													name="groupnames" value="基本参数"> <input
													type="hidden" name="paramnums" value="7"></th>
											</tr>
											<tr>
												<th style="font-weight: normal;"><input type="hidden"
													name="paramnames" value="规格(重量)"> 规格(重量)：</th>

												<td style="text-align: left;"><input type="text"
													name="paramvalues" class="input_text" value=""
													autocomplete="off"></td>
											</tr>
											<tr>
												<th style="font-weight: normal;"><input type="hidden"
													name="paramnames" value="产地"> 产地：</th>

												<td style="text-align: left;"><input type="text"
													name="paramvalues" class="input_text" value=""
													autocomplete="off"></td>
											</tr>
											<tr>
												<th style="font-weight: normal;"><input type="hidden"
													name="paramnames" value="保质期"> 保质期：</th>

												<td style="text-align: left;"><input type="text"
													name="paramvalues" class="input_text" value=""
													autocomplete="off"></td>
											</tr>
											<tr>
												<th style="font-weight: normal;"><input type="hidden"
													name="paramnames" value="储藏方法"> 储藏方法：</th>

												<td style="text-align: left;"><input type="text"
													name="paramvalues" class="input_text" value=""
													autocomplete="off"></td>
											</tr>
											<tr>
												<th style="font-weight: normal;"><input type="hidden"
													name="paramnames" value="商品形态"> 商品形态：</th>

												<td style="text-align: left;"><input type="text"
													name="paramvalues" class="input_text" value=""
													autocomplete="off"></td>
											</tr>
											<tr>
												<th style="font-weight: normal;"><input type="hidden"
													name="paramnames" value="食用方法"> 食用方法：</th>

												<td style="text-align: left;"><input type="text"
													name="paramvalues" class="input_text" value=""
													autocomplete="off"></td>
											</tr>
											<tr>
												<th style="font-weight: normal;"><input type="hidden"
													name="paramnames" value="成分"> 成分：</th>

												<td style="text-align: left;"><input type="text"
													name="paramvalues" class="input_text" value=""
													autocomplete="off"></td>
											</tr>
										</tbody>
									</table>
								</div>
								<div tabid="11" style="display: none;" class="tab-panel">
									<table class="form-table" width="100%">
										<tbody>
											<tr>
												<th style="width: 10%;">商品页面标题：</th>
												<td style="text-align: left; width: 90%"><input
													type="text" name="goods.page_title" class="input_text"
													value="" autocomplete="off"></td>
											</tr>

											<tr>
												<th>META_KEYWORDS：</th>
												<td style="text-align: left;"><textarea
														name="goods.meta_keywords"
														style="width: 300px; height: 100px"></textarea></td>
											</tr>

											<tr>
												<th>META_DESCRIPTION：</th>
												<td style="text-align: left;"><textarea
														name="goods.meta_description"
														style="width: 300px; height: 100px"></textarea></td>
											</tr>
										</tbody>
									</table>
								</div>
								<div tabid="13" style="display: none;" class="tab-panel">
									<table class="form-table" style="width: 100%">
										<tbody>
											<tr>
												<td style="text-align: left;"><input type="checkbox"
													name="tag_id" value="1" id="tag_1">热卖排行&nbsp;&nbsp;
													<input type="checkbox" name="tag_id" value="2" id="tag_2">首页广告下面的商品&nbsp;&nbsp;
													<input type="checkbox" name="tag_id" value="3" id="tag_3">首页推荐&nbsp;&nbsp;
												</td>
											</tr>
										</tbody>
									</table>
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
	<#include "/common/footer.ftl"> 
	<@modal/>
</body>
</html>

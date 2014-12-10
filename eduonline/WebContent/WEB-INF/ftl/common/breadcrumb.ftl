<#-- 模态窗口 --> 
<#macro breadcrumb crumb1 crumb2>
<div id="breadcrumb">
	<a href="#" title="返回首页" class="tip-bottom"><i class="icon-home"></i> 主页</a>
	<#if crumb2??>
		<a href="#">${crumb1}</a>
		<a href="#" class="current">${crumb2}</a>
	<#elseif crumb1??>
		<a href="#"  class="current">${crumb1}</a>
	</#if>
</div>
</#macro>

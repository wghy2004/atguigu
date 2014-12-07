<#macro easyuiPage>
<div id="pp" style="background:#efefef;border:1px solid #ccc;"></div>
<script>
$(function(){
	  $('#pp').pagination({ 
	  		pageList :[10],
	        beforePageText: '第',//页数文本框前显示的汉字 
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });                
});
</script>
</#macro>

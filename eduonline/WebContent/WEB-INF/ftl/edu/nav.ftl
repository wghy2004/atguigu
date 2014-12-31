<div class="nav">
  <div class="classification">
    <div class="classification-title">课程分类</div>
    <div class="course-type">
    <#list categorys as category >
    	<div class="course-title">${category.name}</div>
	      <ul>
	      	<#list category.children as child >
	      		<li><a href="#">${child.name}</a></li>
	      	</#list>
	      </ul>
    </#list>
    </div>
  </div>
  <div class="bannerbg">
    <div class="banner"><img src="${base}/resources/edu/images/banner.jpg" alt="java培训" /></div>
    <div class="features">
      <div class="features1"><p>挑灯夜学</p><span class="introduce">夜学堂每晚不见不散</span></div>
      <div class="features2"><p>求职季</p><span class="introduce">各种面试资格精英定制</span></div>
      <div class="features3"><p>群聚学习</p><span class="introduce">为你的群订阅精品课程</span></div>
    </div>
  </div>
</div>
<!-- 导航条结束 -->
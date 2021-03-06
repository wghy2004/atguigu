<!DOCTYPE html>
<html lang="zh-cn">
<head>
<#include "common.ftl">
<title>尚硅谷-中国java培训领航者|java培训0费用入学,颠覆贷款java培训</title>
<meta name="keywords" content="java培训,java就业培训,java课程,java视频教程" />
<meta name="description" content="java培训革命者，颠覆贷款学习，真正0费用入学，挑战java培训行业潜规则！观就业、拼口碑、较课程、比学费，尚硅谷5个月、高质量java培训最靠谱！" />
</head>
<body>
<#include "header.ftl">
<#include "nav.ftl">
<div class="recommend-video"><a href="#">更多视频 >></a>推荐视频</div>
<div class="main">
	<#list courses as course>
	  <div class="study-video-box">
	     <div class="study-video"><a href="#"><img src="${base}/${course.largePicture}" /></a></div>
	     <div class="video-course-name"><a href="#">${course.title}</a></div>
	     <div class="video-updata-time">${course.createdTime}</div>
	  </div>
	</#list>
</div>
<div class="students-evaluation">学员评价</div>
<div class="evaluation">
  <div class="evaluation-img"><img src="${base}/resources/edu/images/pj.jpg" /></div>
  <div class="evaluation-font"><b>我是比较看重教学质量、课程体系的在尚硅谷我真的的体会到了  什么是用良心做教育的这句话</b> 老师教课非常认真、课程内容非常完善、很有深度的  学习氛围同时也好从去年12月初我来北京再到尚硅谷学习，直到今年5月初的时候参加工作 这段时间是我人生中一个比较重要的转折点之一  。</div>
  <div class="evaluation-author">尚硅谷学员</div>
</div>
<div class="evaluation-list">
  <div class="evaluation-show">
    <div class="evaluation-show-left"><img src="${base}/resources/edu/images/pc.jpg" /></div>
    <div class="evaluation-show-right">程序媛一样给力，谢谢尚硅谷的这一段学习之旅，希望尚硅谷越来越好，能有更多的程序媛加入！</div>
  </div>
  <div class="evaluation-show"><p>不知不觉从尚硅谷毕业两个多月了，对现在的工作很是满意。回忆之前在尚硅谷学习的日子，心里一半感恩一半无悔，谢谢尚硅谷的老师在那段时间在学习和生活上对我的的照顾也给那时认真学习的自己点个赞</p></div>
  <div class="evaluation-show">
      <div class="evaluation-show-left"><img src="${base}/resources/edu/images/pc.jpg" /></div>
      <div class="evaluation-show-right">对于北京的培训机构来说，尚硅谷是一个性价比比较高的机构，不管从师资还是学生的就业来说都很好，也不是想给尚硅谷做广告，因为我本身就是做软件开发的，所以理解选一个好的培训机构对自己的以后职业生涯有多么重要!</div>
  </div>
</div>
<div class="evaluation-list-more"><a href="#">查看更多学员评价</a></div>
<#include "footer.ftl">
</body>
</html>

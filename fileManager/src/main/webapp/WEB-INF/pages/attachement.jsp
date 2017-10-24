<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1"	>
<title>页面</title>
<link href="css/page.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	body {
	font: normal 15px "Microsoft YaHei";
/* 	 color: #0C0C0C;  */
	font-size: 14px;
/* 	line-height: 20px; */
	
	
}

</style>
<script src="jquery/jquery-3.2.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jquery/jquery.form.js"></script>
<script src="js/attach.js"></script>
<script src="js/page.js"></script>
</head>
<body >
  <div class="header" style="padding:0px;">
	<nav class="navbar navbar-inverse" role="navigation"  >
   		<div class="navbar-header">
      		<button type="button" class="navbar-toggle" data-toggle="collapse" 
         		data-target="#example-navbar-collapse">
		         <span class="sr-only">切换导航</span><span class="icon-bar"></span>
		         <span class="icon-bar"></span><span class="icon-bar"></span>
		    </button>
      		<a class="navbar-brand " href="javascript:void(0)" style="margin:0px;padding:0px;">
      			<img id="img" src="images/bankledger.jpg" class="img-circle" style="height:100% ;">
      		</a>
   		</div>
   		<div class="collapse navbar-collapse" id="example-navbar-collapse">
      		<ul class="nav navbar-nav">
         		<li class="active"><a href="javascript:void(0)">bankledger</a></li>
         		<li><a href="javascript:void(0)">Homepage</a></li>
         		<li><a href="javascript:void(0)">Share</a></li>
         		<li><a href="javascript:void(0)">More</a></li>
         		<li><a href="javascript:void(0)">Personal</a></li>
         		<li class="dropdown">
            		<a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">
               			File <b class="caret"></b>
            		</a>
		            <ul class="dropdown-menu">
               			<li><a href="javascript:void(0)" data-toggle="modal" data-target="#modal-dialog">upload</a></li>
               			<li class="divider"></li>
               			<li><a href="javascript:void(0)">download</a></li>
		                <li class="divider"></li>
        		        <li><a href="#searchNameId" 
        		        onclick="document.getElementById('searchNameId').scrollIntoView();">search</a></li>
            		</ul>
         	    </li>
      		</ul>
      		<ul class="nav navbar-nav navbar-right">
				<li><a> <span class="glyphicon glyphicon-user"></span>欢迎您</a></li>
				<li><a href="logout.do">安全退出</a></li>
			</ul>
   		</div>
	</nav>
  </div>
   
  <div class="center" id="center" style="margin-bottom: 0px">
   	<div class="container-fiuld" style="width: 1903px;" >
   		<div class="row" >
   			<div class="col-xs-2 " style="text-align: center;width: 322px;">
			  	<a href="javascript:void(0)"  class="list-group-item" 
			  		 style="background:rgba(0,0,0,0);">image</a><br>
				<a href="javascript:void(0)" class="list-group-item"
					data-toggle="tooltip" dataplacement="right" title="文档" style="background:rgba(0,0,0,0);">document</a><br>
				<a href="javascript:void(0)" class="list-group-item"
					data-toggle="tooltip" dataplacement="right" title="视频" style="background:rgba(0,0,0,0);">video</a><br>
				<a href="javascript:void(0)" class="list-group-item"
					data-toggle="tooltip" dataplacement="right" title="种子" style="background:rgba(0,0,0,0);">seed</a><br>
				<a href="javascript:void(0)" class="list-group-item"
					data-toggle="tooltip" dataplacement="right" title="音乐" style="background:rgba(0,0,0,0);">music</a><br>
				<a href="javascript:void(0)" class="list-group-item"
					data-toggle="tooltip" dataplacement="right" title="我的分享"style="background:rgba(0,0,0,0);">my share</a><br>
				<a href="javascript:void(0)" class="list-group-item"
					data-toggle="tooltip" dataplacement="right" title="其它" style="background:rgba(0,0,0,0);">other</a><br>
				<a href="javascript:void(0)" class="list-group-item"
					data-toggle="tooltip" dataplacement="right" title="回收站" style="background:rgba(0,0,0,0);">recycle</a><br>
			</div>
			<div  class="col-xs-10 conment" style="width: 1581px;">
				<div class="row" style="height:60px" >
					<div class="col-xs-12">
					<div class="btn-group btn-group-lg">
	  					 <button type="button" class="btn btn-default"
	  					 		data-toggle="modal" data-target="#modal-dialog"  
	  					 		dataplacement="right" title="点击选择文件" >
	  					 	<span class="glyphicon glyphicon-open"></span> 
	  					 	上传
	  					 </button>
					</div>
					<div id="download" class="btn-group btn-group-lg">
						 <button type="button" class="btn btn-default "
						 data-toggle="tooltip" dataplacement="right" title="下载多文件">
						 	<span class="glyphicon glyphicon-plus"></span>下载</button>
					</div>
					<div class="btn-group btn-group-lg">
						 <button type="button" class="btn btn-default"
						 data-toggle="tooltip" dataplacement="right" title="新建文件">
						 	<span class="glyphicon glyphicon-plus"></span>新建</button>
					</div>
					<div class="btn-group btn-group-lg">
						<button type="button" class="btn btn-default dropdown-toggle"
						 	data-toggle="dropdown">我的设备<span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu">
					        <li><a href="#">推送任务列表</a></li>
					        <li><a href="#">添加设备</a></li>
					    </ul>
	 				</div>
	 				<div id="search" class="btn-group btn-group-lg pull-right" >
						<span>
							<input type="text" id="searchNameId" placeholder="文件名">
							<button class="btn btn-default-lg" type="button" >
								<span class="glyphicon glyphicon-search"></span>搜索
							</button>
					    </span> 				
	 			    </div>
	 			 	</div>
	 			</div>
	 			<div class="row" >
					<form method="post" id="uploadFormId" 
		      				enctype="multipart/form-data">
						<!-- 列表显示内容 -->
						<div class="table-responsive">
   							<table class="table">
						      <caption>全部文件</caption>
						      <thead>
								<tr>
					   			   <th ><input type="checkbox" id="checkAll" name="checkbox" onclick="checkAll2(selectItem)"/>选择</th>
								   <th >文件名</th>
								   <th>文件大小(KB)</th>
								   <th >创建日期</th>
							       <th >操作</th>
								</tr>
								</thead>
						      <tbody id="tbodyId"></tbody>
							</table>
							<div class="page">
						    <%@include file="page.jsp"%>
						    </div>
						</div>
					</form>
				</div> 
			</div>
		</div>
	</div>
  </div>
 
  <div class="footer" style="background-color: #FFFFE0;">
  	  <div class="big" >
		 <div class="erweima">
			<img src="images/icon_erweima.png" width="109" height="109">
		  	<p>扫描关注微信公众平台<p>
		 </div>
		 <div class="cont">
		 	  <h3>深圳银链科技有限公司</h3>
		 	  <div class="words">
		 		  <p>联系人：  　　　　　　邮箱：                   </p>
		 		  <p>电话：           </p>
		 		  <p>邮编：518017</p>
		 		  <p>地址：深圳市南山区高新科技园彩虹科技大厦2K</p>
		 		  <p style="margin-left: 53.5px;">南京市雨花台区润和创智中心4幢7楼 </p>
		 	  </div>
		 	  <div class="clear"></div>
		 </div>
	  </div>	
  </div>
	<!-- Modal(模态框) -->
		 <div class="modal fade" id="modal-dialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title" id="myModalLabel">上传文件</h4>
		      </div>
		      <div class="modal-body">
		      		<form method="post" id="saveFormId" 
		     			enctype="multipart/form-data">
								<input type="file" name="mFile" class="form-control">
					</form>
					
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-success btn-upload">save</button>
		      </div>
		    </div><!-- /.modal-content -->
		    </div><!-- /.modal-dialog -->
		  </div><!-- modal -->
	</body>

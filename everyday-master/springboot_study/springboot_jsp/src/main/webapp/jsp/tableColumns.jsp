<%--<%@page import="com.jzfy.dim.config.APPConfig"%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/img/favicon.ico">
<title>DataInsight数据监控管理平台</title>
<meta name="keywords" content="DataInsight数据监控管理平台">
<meta name="description" content="DataInsight数据监控管理平台">
<link href="<%=request.getContextPath()%>/css/frame.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/base.css" rel="stylesheet"
	type="text/css" />
<link href="<%=request.getContextPath()%>/css/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/jquery.min.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/base.js"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jq/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jq/jquery-ui.min.js"></script>
<!--/计数的柱形图-->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/plugins/charts/jquery.sparkline.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/plugins/ui/jquery.timepicker.min.js"></script>
<script src="<%=request.getContextPath()%>/js/base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/files/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/noty/packaged/jquery.noty.packaged.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/notice.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/validate_msg_zh.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/plugins/forms/jquery.select2.min.js"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/plugins/forms/jquery.form.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/plugins/forms/jquery.validation.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/plugins/forms/jquery.form.wizard.js"></script>
<script
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>

</head>
<body class="body-box">
	<!--搜索-->
	<form id="searchfrm" method="post" action="dataDetail"
		class="form-condensed clearfix clr">
		
		<input type="hidden" id="pageindex" name="pageindex" value="${pageBean.pageindex}" />
		<input type="hidden" id="pagesize" name="pagesize" value="${pageBean.pagesize}" />
		<input type="hidden" id="totalcount" name="totalcount" value="${pageBean.totalcount}" />
		
		<input type="hidden" id="data_date" name="data_date" value="${data_date}"/>
		<input type="hidden" id="brno" name="brno" value="${brno}"/>
		<input type="hidden" id="kmh" name="kmh" value="${kmh}"/>
		
		<input type="hidden" id="olddataDate" name="olddataDate" value="${olddataDate}"/>
		<input type="hidden" id="oldtbname" name="oldtbname" value="${oldtbname}"/>

		<div class="search-li">
			<span class="search-title">账号(合同号)</span>
			<input name="number" class="data-table" id="number" value="${number}" />
		</div>
		<div class="search-li">
			<button type="submit" class="btn-success inline" id="btn-submit-ie6"
				style="font-weight: bold">
				<span class="icon-search" style="padding: 0px 3px 0px 0px;"></span>查询
			</button>
		</div>
		<!--搜索右侧展开关闭-->
		<div class="moreOrLite noselect">
			<i class="searchmore icon-search-open"></i> <i
				class="searchlite icon-search-close"></i>
		</div>
		<!--/搜索右侧展开关闭-->


	</form>
	<!--/搜索-->

	<%--<style>--%>
		<%--.table{--%>
			<%--table-layout: fixed;--%>
		<%--}--%>
		<%--.table td:hover{--%>
			<%--overflow: visible;--%>
			<%--white-space: normal;--%>
		<%--}--%>
		<%--.table td {--%>
			<%--word-wrap: break-word;--%>
			<%--overflow: hidden;--%>
			<%--text-overflow: ellipsis;--%>
			<%--white-space: nowrap;--%>
		<%--}--%>
	<%--</style>--%>

	<!--数据内容box-->
	<div class="data-box clearfix clr">
		<div class="data-table-scroll ExchangeHistoryTable">
			<!--/*ExchangeHistoryTable样式 为控制table的单元格宽度-程序看着按需设置*/-->
			<style>
				table {
					table-layout:fixed;
				}
				table td {
					max-width: 58px;
					white-space:nowrap;
					overflow:hidden;
					text-overflow: ellipsis;
				}
				table td:hover {
					overflow: auto;
					white-space: pre-wrap;
				}
			</style>

			<div class="table-head">
				<table class=" clearfix clr" id="tables" >
					<!--把data-table这个类去掉之后就正常了-->

					<thead>
						<c:forEach items="${aa}" var="aa" varStatus="abc">
							<%--style=" display: block;overflow: hidden;text-overflow: ellipsis;white-space:pre-wrap;"--%>
							<%--style="word-wrap: break-word;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;"--%>

							<td id = "forTh" ><!-- 遍历th -->
								${aa}
								<%--<span style='display: block;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;' title='" + value + "'> ${aa} </span>--%>
							</td>
						</c:forEach>
					</thead>

					<%--<tbody>--%>
						<%--<c:forEach items="${fenDatas}" var="fenData" varStatus="st">--%>
							<%--<tr>--%>
								<%--<td>${fenData}</td>--%>
							<%--</tr>--%>
						<%--</c:forEach>--%>
					<%--</tbody>--%>
				</table>
			</div>
		</div>

		<br>
		<div class="dataTables_info">
                显示第 ${pageBean.startindex}	 到
				<c:if test="${pageBean.endindex < pageBean.totalcount}">
					${pageBean.endindex}
				</c:if>
				<c:if test="${pageBean.endindex >= pageBean.totalcount}">
					${pageBean.totalcount}
				</c:if>						
				条,共 ${pageBean.totalcount} 条,共 ${pageBean.totalpage} 页
				</div>
				<div class="dataTables_paginate paging_full_numbers"
					id="data-table_paginate">
					<a id="data-table_first" tabindex="0"
						class='first paginate_button 
						<c:if test="${pageBean.pageindex <= 1}"> paginate_button_disabled</c:if>'
						<c:if test="${pageBean.pageindex > 1}"> 
							onclick="javascript:gopage(1)"
						</c:if>
						 >第一页
					</a>
	
					<a id="data-table_previous" tabindex="0"
						class='previous paginate_button 
							<c:if test="${pageBean.pageindex <= 1}">paginate_button_disabled</c:if>'
							<c:if test="${pageBean.pageindex > 1}">
							onclick="javascript:gopage(${pageBean.pageindex-1})"
							</c:if>
						>&lt;
					</a>
	
					<span> 
						<c:forEach items="${pagedisplays}" var="pagedisplay" varStatus="st">
							<c:if test="${pagedisplay.page == pageBean.pageindex}">
								<a tabindex="0" class="paginate_active">
								${pagedisplay.display}</a>
							</c:if>
							<c:if test="${pagedisplay.page != pageBean.pageindex}">
								<a tabindex="0" class="paginate_button"
										onclick="javascript:gopage(${pagedisplay.page})">
											${pagedisplay.display}</a>
							</c:if>
						
						</c:forEach>
					</span> 
					
					<a id="data-table_next" tabindex="0"
						class='next paginate_button
						<c:if test="${pageBean.pageindex == pageBean.totalpage}"> paginate_button_disabled</c:if>'
						<c:if test="${pageBean.pageindex != pageBean.totalpage}">
						 onclick="javascript:gopage(${pageBean.pageindex-(-1)})"
						</c:if>
						>&gt;</a> 
					<a id="data-table_last" tabindex="0"
						class='last paginate_button
						<c:if test="${pageBean.pageindex == pageBean.totalpage}"> paginate_button_disabled</c:if>'
						<c:if test="${pageBean.pageindex != pageBean.totalpage}">
						 	onclick="javascript:gopage(${pageBean.totalpage})" 
	                 			</c:if>
	                 			>最后一页
	                  	</a>
		</div>
	</div>
	
	<!--底部-->
	<div class="footer clearfix clr">
		<div class="footbox">
			<div class="crumbs" style="background: #EEF4FE; height: 40px;">
				<%--<% --%>
					<%--if("db2".equalsIgnoreCase(APPConfig.getDBType())){--%>
				<%--%>--%>
					<%--<a href="home">首页</a>--%>
				<%--<%		--%>
					<%--}else{--%>
				<%--%>--%>
					<%--<a href="dataCheck">首页</a>--%>
				<%--<%} %>--%>
				 <%--&gt; <span class="current">数据核对</span>--%>
			</div>
			<div class="copyright">
				<em>&copy; </em>杭州九州方园科技有限公司<span class="xian">|</span><a
					href="javascript:;">联系管理员</a><span class="xian">|</span><a
					href="javascript:;">报告Bug</a>
			</div>
		</div>
	</div>
	<!--/底部-->

	<script type="text/javascript">
		$(function(){
			//设置日期选择
			 $( "#start" ).datepicker();
			 $( "#end" ).datepicker();
		})
		
		function checkDate(){
			 var start = $("#start").val();
			 var end = $("#end").val();
			 if(start>end){
				 alert("开始时间不能大于结束时间！");
				 $("#start").val(end);
			 }
		}
		
		function gopage(index) {
		    $("#pageindex").val(index);
		    $("#searchfrm").submit();
		}
		
		
		$(document).ready(function() {
			
			var dataDate = $("#olddataDate").val();
			var tbname = $("#oldtbname").val();
			
			$.ajax({
				type : "POST",
				url : "initpKeyConflictSample",
				data : "tbname="+tbname+"&dataDate="+dataDate,
				async : false,
				error : function(request) {
					noticeError("connection error",null);
				},
				success : function(data) {
					for(var i=0;i<data.length;i++){
						var colNameDesc=data[i];
						colNameDesc.substring(0,8)
						
						var schemali = '<th style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">'+colNameDesc+'</th>';
						$("#forTh").append(schemali);
					}
					
				}

			});	
			
			
			
		});





	//设置table内容滚动，并设置单元格宽度
	var o = new Array('200','100','90','100','120','120','80','90','100','150');
	DataTableScroll('.ExchangeHistoryTable',o);
	
	</script>

	<script type="text/javascript">
      $(document).ready(function () {
      	$("select").select2();
      	/* $('#lastprogress').sparkline('html', {
              type: 'bar',
              barColor: '#91c950',
              height: '35px',
              barWidth: "15px",
              barSpacing: "2px",
              zeroAxis: "false"
          }); */
          //
      	

      });
</script>
</body>
</html>

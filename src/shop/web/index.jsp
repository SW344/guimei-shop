<%@ page import="com.entity.ProductInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE	html PUBLIC	"-//W3C//DTD XHTML 1.0 transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html	xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"	/>
 <title>贵美商城</title>
 <link rel="stylesheet"	type="text/css"	href="css/global.css"	/>
 <link rel="stylesheet"	type="text/css"	href="css/layout.css?id=7"	/>
 <script type="text/JavaScript" src="js/index.js"></script>
	<script type="text/javascript">
			var index = 1;
			function lunbo(){
			index ++ ;
			//判断index是否大于3
			if(index > 4){
			index = 1;
		}
			//获取img对象
			var img = document.getElementById("lunbo_img");
			img.src = "images/ad-0"+index+".jpg";
		}
			//2.定义定时器
			setInterval(lunbo,2000);
	</script>
</head>
<%
	List<ProductInfo> productInfoList = (List<ProductInfo>)application.getAttribute("productInfoList");
	List<String> categoryList = new ArrayList<String>();
	for (ProductInfo productInfo : productInfoList) {
		if (!categoryList.contains(productInfo.getCategory())) {
			categoryList.add(productInfo.getCategory());
		}
	}
%>
<body> 
	<div id="container">
		<iframe id="header" runat="server" src="header.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
		<div id="main">


    <div class="cat">
			<ul>
				<%
					for(int i=0;i<categoryList.size();i++){
							String category = categoryList.get(i);
				%>
				<h1><%=category%></h1>
				<%
					for (int j=0;j<productInfoList.size();j++){
						ProductInfo productInfo = productInfoList.get(j);
						if (category.equals(productInfo.getCategory())){
				%>
				<li><a href="http://localhost:8080/shop_system/productController?action=showProduct&&category=<%=category%>"><%=productInfo.getName()%></a></li>
				<%
						}
					}
				%>
				<%
					}
				%>
			</ul>
    </div> <!--cat end-->
			<div id="content">
				<div class="content_top">
					<div class="lunbo">
						<img id="lunbo_img" src="img/ad-01.jpg" >
					</div>
				</div> <!-- content_top end -->
      <div class="content_list">

		  <%
			  for (int i=0;i<9;i++){
				  ProductInfo productInfo = productInfoList.get(i);
		  %>
		  	<dl>
			<dt><a href="http://localhost:8080/shop_system/productController?action=showInfo&&id=<%=productInfo.getId()%>"><img src="<%=productInfo.getImage()%>" width="100" height="80" alt="" /></a></dt>
			<dd><a href="http://localhost:8080/shop_system/productController?action=showInfo&&id=<%=productInfo.getId()%>"><%=productInfo.getName()%>-<%=productInfo.getDescription()%></a></dd>
            </dl>
		  <%
			}
		  %>
			</div><!-- content_list end -->
		</div><!-- content end -->
    <div class="sidebar">
         <div class="r1"></div>				
				 <div	class="r2">
					 <%
						 for (int i=9;i<13;i++){
							 ProductInfo productInfo = productInfoList.get(i);
					 %>
					 <dl>
                         <dt><a href="http://localhost:8080/shop_system/productController?action=showInfo&&id=<%=productInfo.getId()%>"><img src="<%=productInfo.getImage()%>" width="50" height="40" alt="" /></a></dt>
						 <dd><a href="http://localhost:8080/shop_system/productController?action=showInfo&&id=<%=productInfo.getId()%>"><%=productInfo.getName()%>-<%=productInfo.getDescription()%></a></dd>
					 </dl>
					 <%
						 }
					 %>
			</div> <!--r2	end-->	    
					<div id="tab">
					  <div id="tabtitle1" onmouseover="switchMe(1);"></div>
					  <div id="tabtitle2" onmouseover="switchMe(2);"></div>		
					  <div id="tabbody">
					  	<img src="img/tabbody2.gif" alt="手机充值" />
					  </div>											  
					</div>
				</div> <!--sidebar end-->				
		 </div>	<!--main end-->
     <iframe id="footer" runat="server" src="footer.jsp" width="980" height="150" frameborder="0" scrolling="no"></iframe>
<%--	<div id="pairflag">--%>
<%--		<a class="f_l" href="#" id="advLeft"><img src="images/list1.jpg" alt="alt" /></a>--%>
<%--		<img class="f_l" id="closeLeft" onclick="leftClose();" src="images/close.gif" alt="alt" />--%>
<%--		<a href="#" class="f_r" id="advRight"><img src="images/list2.jpg" alt="alt" /></a>--%>
<%--		<img id="closeRight" class="f_r" onclick="rightClose();" src="images/close.gif" alt="alt" />--%>
<%--	</div>	--%>
	</div><!--container	end-->		
</body>
</html>

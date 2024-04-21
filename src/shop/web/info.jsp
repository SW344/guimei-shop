<%@ page import="com.entity.ProductInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE	html PUBLIC	"-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html	xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>贵美商城-商品分类页</title>
 <link rel="stylesheet"	type="text/css"	href="css/global.css"	/>
 <link rel="stylesheet"	type="text/css"	href="css/layout.css"	/>
 <script type="text/JavaScript" defer="true">
	var oImg=document.getElementById("show").getElementsByTagName("img");
	for(var i=1;i<=(oImg.length-3);i++){
		oImg[i].onmouseover=function(){oImg[0].src=this.src.replace('.jpg','_big.jpg');
			this.style.border='2px #ff7300 solid';}
		oImg[i].onmouseout=function(){this.style.border='2px #ccc solid';}
 	}
 </script>
</head>
<%
	ProductInfo productInfo = (ProductInfo)request.getAttribute("productInfo");
%>
<body>
<div id="container">
	<iframe id="header" src="header.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
	<div class="good">
		<h1><%= productInfo.getName() %></h1>
		<ul class="f_l" id="show">
			<li class="bigimg"><a href="buy.jsp"><img src="<%=productInfo.getImage()%>" height="250" width="300" alt="<%=productInfo.getName()%>" /></a></li>
			<li class="smallimg"><img src="<%=productInfo.getImage()%>" height="30" width="30" alt="小图1" /></li>
			<li class="smallimg"><img src="<%=productInfo.getImage()%>" height="30" width="30" alt="小图2" /></li>
			<li class="smallimg"><img src="<%=productInfo.getImage()%>" height="30" width="30" alt="小图3" /></li>
			<li class="smallimg"><img src="<%=productInfo.getImage()%>" height="30" width="30" alt="小图4" /></li>
			<li class="smallimg"><img src="<%=productInfo.getImage()%>" height="30" width="30" alt="小图5" /></li>
			<li class="op clear f_l"><a href="#"><img src="img/share.gif" alt="分享" /></a></li>
			<li class="op f_l"><a href="#"><img src="img/favthis.gif" alt="藏" /></a></li>
		</ul>
		<ul class="goodinfo f_l">
			<li>一 口 价：<span><%=productInfo.getPrice()%> </span></li>
			<li>运　　费：<span><%=productInfo.getShippingCost()%>元</span></li>
			<li class="h74 buynow"><a href="http://localhost:8080/shop_system/productController?action=addShoppingCart&&id=<%=productInfo.getId()%>"><img src="img/buynow.gif" alt="alt" /></a></li>
			<li class="onlinepay">此商品支持<a href="#">网银支付</a>，网上汇款免手续费。<br />收货满意后出售者才能拿钱，货款都安全！</li>
			<li>剩余时间：<span><%=productInfo.getRemainTime()%></span></li>
			<li>本期售出：<span><%=productInfo.getSoldNumber()%>件</span></li>
			<li>累计售出：<span><%=productInfo.getAllSoldNumber()%>件</span></li>
			<li class="f_l w175">商品类型：<span><%=productInfo.getState()%></span></li>
			<li>所 在 地：<span><%=productInfo.getOrigin()%></span></li>
			<li class="f_l w175">商品数量：<span><%=productInfo.getNowNumber()%>件</span></li>
			<li>浏 览 量：<span><%=productInfo.getViews()%>次</span></li>
		</ul>
	</div>
	<iframe id="footer" src="footer.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
</div> <!--container end-->	
</body>
</html>

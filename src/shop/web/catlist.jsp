<%@ page import="com.entity.ProductInfo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE	html PUBLIC	"-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html	xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>贵美商城</title>
 <link rel="stylesheet"	type="text/css"	href="css/global.css"	/>
 <link rel="stylesheet"	type="text/css"	href="css/layout.css"	/>
 <script type="text/JavaScript">
 	function multiCheck(oThis){
 		var oInput=document.getElementsByTagName("input");
 		for (var i=1;i<oInput.length;i++){ 	
 				oInput[i].checked=oThis.checked;}
 	}
	</script>
</head>
<%
	List<ProductInfo> ProductInfoList = (List<ProductInfo>)request.getAttribute("productInfoList");
%>
<body>
<div id="container">
	<iframe id="header" runat="server" src="header.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
	<div class="catlist a_c">
		<ul class="w20p check">
			<h3><input type="checkbox" name="checkall" onclick="multiCheck(this)" />全选</h3>
			<%
				if(ProductInfoList!=null){
					for(ProductInfo productInfo : ProductInfoList){
			%>
			<li><input type="checkbox" /></li>
			<%
				}
			}
			%>
		</ul>
		<ul class="w20p">
			<h3>商品图片</h3>
			<%
				if(ProductInfoList!=null){
					for(ProductInfo productInfo : ProductInfoList){
			%>
			<li><a href="http://localhost:8080/shop_system/productController?action=showInfo&&id=<%=productInfo.getId()%>"><img src="<%=productInfo.getImage()%>" width="128" height="118" alt="" /></a></li>
			<%
				}
			}
			%>
		</ul>
		<ul class="w50p info">
			<h3>商品名称/出售者/联系方式</h3>
			<%
				if(ProductInfoList!=null){
					for(ProductInfo productInfo : ProductInfoList){
			%>
			<li><a href="http://localhost:8080/shop_system/productController?action=showInfo&&id=<%=productInfo.getId()%>"><%=productInfo.getName()%></a><br />出售者：<a href="#"><%=productInfo.getSeller()%><br /><a href="#"><img src="img/contactme.gif" alt="alt" /> <img src="img/addfav.gif" alt="收藏" />收藏</a></li>
			<%
					}
				}
			%>
			</ul>
		<ul class="w10p price">
			<h3>价格</h3>
			<%
				if(ProductInfoList!=null){
					for(ProductInfo productInfo : ProductInfoList){
			%>
			<li>一口价：<br /><%=productInfo.getPrice()%></li>
			<%
					}
				}
			%>
		</ul>
	</div>
	<iframe id="footer" runat="server" src="footer.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
</div> <!--container end-->	
</body>
</html>

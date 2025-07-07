<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="dto.Dvd"%>
<%@ page import="dao.DvdRepository"%>
<%@ page errorPage="exceptionNoDvdId.jsp"%>
<%@ page import="java.sql.*"%>

<html>
<head>
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
<title>DVD 정보</title>
<script type="text/javascript">
	function addToCart() {
		if (confirm("상품을 장바구니에 추가하시겠습니까?")) {
			document.addForm.submit();
		} else {
			document.addForm.reset();
		}
	}
</script>

</head>
<body>
	<div class="container py-4">
		<%@ include file="menu.jsp"%>

		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">DVD정보</h1>
				<p class="col-md-8 fs-4">Dvd Info</p>
			</div>
		</div>
		<%@ include file="dbconn.jsp"%>
		<%
		String dvdId = request.getParameter("id");
		/* BookRepository dao = BookRepository.getInstance();
		Book book = dao.getBookById(id); */

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from dvd_tbl where dvd_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dvdId);
		rs = pstmt.executeQuery();
		if (rs.next()) {
		%>
		<div class="row align-items-md-stretch">
			<div class="col-md-5">
				<img src="./resources/images/<%=rs.getString("dvd_thumbnailUrl")%>"
					style="width: 70%">
			</div>
			<div class="col-md-6">
				<h3>
					<b><%=rs.getString("dvd_name")%></b>
				</h3>
				<p><%=rs.getString("dvd_description")%>%>
				<p>
					<b>DVD코드 : </b><span class="badge text-bg-danger"> <%=rs.getString("dvd_id")%></span>
				<p>
					<b>원작자</b> :
					<%=rs.getString("dvd_author")%>
				<p>
					<b>제작사</b> :
					<%=rs.getString("dvd_publisher")%>
				<p>
					<b>제작일</b> :
					<%=rs.getString("dvd_releaseDate")%>
				<p>
					<b>분류</b> :
					<%=rs.getString("dvd_category")%>
				<p>
					<b>재고수</b> :
					<%=rs.getString("dvd_unitsInStock")%>
					<h4><%=rs.getString("dvd_unitPrice")%>원
				</h4>
				<p>
				<form name="addForm" action="./addCart.jsp?id=<%=rs.getString("dvd_id")%>" method="post">
					<a href="#" class="btn btn-info" onclick="addToCart()"> DVD주문&raquo;</a>
					<a href="./cart.jsp" class="btn btn-warning"> 장바구니&raquo;</a>
					<a href="./dvds.jsp" class="btn btn-secondary"> DVD목록&raquo;</a>
				</form>
			</div>
		</div>
		<%
		} // IF문 종료
		%>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.oreilly.servlet.*"%>
<%@ page import="com.oreilly.servlet.multipart.*"%>
<%@ page import="java.sql.*"%>
<%@ include file="dbconn.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");

	String thumbnailUrl = "";

	// 업로드 폴더 경로 (동적으로 웹 경로 기준으로 설정)
	String realFolder = application.getRealPath("/resources/images");
	String encType = "utf-8";
	int maxSize = 5 * 1024 * 1024;

	MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());

	// 폼 데이터
	String dvdId = multi.getParameter("dvdId");
	String name = multi.getParameter("name");
	String unitPrice = multi.getParameter("unitPrice");
	String author = multi.getParameter("author");
	String publisher = multi.getParameter("publisher");
	String releaseDate = multi.getParameter("releaseDate");	
	String description = multi.getParameter("description");	
	String category = multi.getParameter("category");
	String unitsInStock = multi.getParameter("unitsInStock");
	String condition = multi.getParameter("condition");

	// 이미지 파일명 추출
	Enumeration fileNames = multi.getFileNames();
	String fileName = (String) fileNames.nextElement();
	thumbnailUrl = multi.getFilesystemName(fileName);  // 업로드된 파일명

	int price = (unitPrice == null || unitPrice.trim().equals("")) ? 0 : Integer.parseInt(unitPrice);
	long stock = (unitsInStock == null || unitsInStock.trim().equals("")) ? 0 : Long.parseLong(unitsInStock);

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 기존 레코드 확인
	String sql = "SELECT dvd_thumbnailUrl FROM dvd_tbl WHERE dvd_id = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, dvdId);
	rs = pstmt.executeQuery();

	String oldThumbnail = "";
	if (rs.next()) {
		oldThumbnail = rs.getString("dvd_thumbnailUrl");
	}
	rs.close();
	pstmt.close();

	// 이미지 선택하지 않았으면 기존 값 유지
	if (thumbnailUrl == null || thumbnailUrl.trim().equals("")) {
		thumbnailUrl = oldThumbnail;
	}

	// UPDATE 실행
	sql = "UPDATE dvd_tbl SET dvd_name=?, dvd_unitPrice=?, dvd_author=?, dvd_description=?, dvd_publisher=?, dvd_category=?, dvd_unitsInStock=?, dvd_releaseDate=?, dvd_condition=?, dvd_thumbnailUrl=? WHERE dvd_id=?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, name);
	pstmt.setInt(2, price);
	pstmt.setString(3, author);
	pstmt.setString(4, description);
	pstmt.setString(5, publisher);
	pstmt.setString(6, category);
	pstmt.setLong(7, stock);
	pstmt.setString(8, releaseDate);		
	pstmt.setString(9, condition);	
	pstmt.setString(10, thumbnailUrl);	
	pstmt.setString(11, dvdId);	
pstmt.executeUpdate();

	if (pstmt != null) pstmt.close();
	if (conn != null) conn.close();

	response.sendRedirect("editDvd.jsp?id=" + dvdId + "&edit=update");
%>

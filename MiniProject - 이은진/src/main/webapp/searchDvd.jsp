<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*" %>
<%@ include file="dbconn.jsp" %>
<html>
<head>
 <link href = "./resources/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
  <title>DVD 검색 결과</title>
  
</head>
<body>
<div class="container py-4">
<%@ include file="menu.jsp"%>

 <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
            
        <%
  String name = request.getParameter("name");
  PreparedStatement pstmt = null;
  ResultSet rs = null;

  if (name != null && !name.trim().equals("")) {
    String sql = "SELECT * FROM dvd_tbl WHERE dvd_name LIKE ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, "%" + name + "%");
    rs = pstmt.executeQuery();

    boolean found = false;
%>
    <h3>검색 결과 : "<%= name %>"</h3> 
      </div>
    </div>
 <form action="searchDvd.jsp" method="get" class="mb-4">
    <div class="input-group">
        <input type="text" name="name" class="form-control" placeholder="DVD 제목을 입력하세요 (예: 범죄도시 / 범죄)">
        <button class="btn btn-primary" type="submit">검색</button>
    </div>
</form>


    
    <%-- <검색결과 박스 출력
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>DVD 코드</th>
          <th>DVD 이름</th>
          <th>가격</th>
          <th>제작사</th>
          <th>이미지</th>
        </tr>
      </thead>
      <tbody>
      --%>
      
<%
    while (rs.next()) {
      found = true;
%>


<%--  <검색결과 반스 안에 출력>
      <tr>
        <td><%= rs.getString("dvd_id") %></td>
        <td><%= rs.getString("dvd_name") %></td>
        <td><%= rs.getInt("dvd_unitPrice") %></td>
        <td><%= rs.getString("dvd_publisher") %></td>
        <td>
          <img src="resources/images/<%= rs.getString("dvd_thumbnailUrl") %>" width="100">
        </td>
      </tr>
      
      --%>
      <div class="col-md-4">
       		<div class="h-100 p-2">	
       			<img src="./resources/images/<%=rs.getString("dvd_thumbnailUrl")%>" style="width: 200; height:350" />		
				<h5><b><%=rs.getString("dvd_name")%></b></h5>
				<p><%=rs.getString("dvd_author")%>
				<br> <%=rs.getString("dvd_publisher")%> | <%=rs.getString("dvd_unitPrice")%>원
				<p> <%=rs.getString("dvd_description").substring(0,60)%>....
				<p><%=rs.getString("dvd_unitPrice")%>원
				<p><a href="./dvd.jsp?id=<%=rs.getString("dvd_id")%>" class="btn btn-secondary" role="button"> 상세 정보 &raquo;</a>	</div>	
		</div>
      
<%
    }
    if (!found) {
%>
      <tr>
        <td colspan="5" class="text-center">검색 결과가 없습니다.</td>
      </tr>
<%
    }
  } else {
%>
    <div class="alert alert-warning">DVD 이름을 입력하세요.</div>
<%
  }

  if (rs != null) rs.close();
  if (pstmt != null) pstmt.close();
  if (conn != null) conn.close();
%>
    </tbody>
  </table>
  <%@ include file="footer.jsp"%> 
</div>

</body>
</html>

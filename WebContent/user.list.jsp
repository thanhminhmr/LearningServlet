<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="_header.jsp">
	<jsp:param name="title" value="Hello World!" />
</jsp:include>
</head>
<body class="hold-transition skin-blue fixed sidebar-mini">
	<div class="wrapper">
		<jsp:include page="_navbar.jsp" />
		<jsp:include page="_sidebar.jsp" />
		<div class="content-wrapper">
			<section class="content">
				<div class="box box-success box-solid">
					<div class="box-header with-border">
						<h3 class="box-title">Danh sách người dùng</h3>
					</div>
					<div class="box-body table-responsive no-padding">
						<table class="table table-hover">
							<tr>
								<th>#</th>
								<th class="col-md-5 col-sm-5">Tên tài khoản</th>
								<th class="col-md-5 col-sm-5">Mật khẩu</th>
								<th class="col-md-2 col-sm-2">Hành động</th>
							</tr>
							<c:forEach items="${users}" var="user">
								<tr>
									<td>
										<c:out value="${user.getUserId()}" />
									</td>
									<td>
										<c:out value="${user.getUsername()}" />
									</td>
									<td>
										<c:out value="${user.getPassword()}" />
									</td>
									<td>
										<a href="/user/edit?userId=<c:out value="${user.getUserId()}" />" class="btn btn-default btn-xs">Sửa</a>
										<a href="/user/delete?userId=<c:out value="${user.getUserId()}" />" class="btn btn-default btn-xs">Xoá</a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</section>
		</div>
		<jsp:include page="_footer.jsp" />
	</div>
	<jsp:include page="_scripts.jsp" />
</body>
</html>
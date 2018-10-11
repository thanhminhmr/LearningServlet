<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<jsp:include page="_header.jsp">
	<jsp:param name="title" value="Login" />
</jsp:include>
</head>

<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<b>Learning</b>
			Servlet
		</div>
		<div class="login-box-body">
			<form action="/login" method="post">
				<c:if test="${isError}">
					<div class="alert alert-warning alert-dismissible">
						<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
						<c:choose>
							<c:when test="${isFailed}">Sai tên tài khoản hoặc mật khẩu.</c:when>
							<c:when test="${isEmpty}">Tên tài khoản và mật khẩu không được bỏ trống.</c:when>
						</c:choose>
					</div>
				</c:if>
				<div class="form-group has-feedback">
					<input type="text" class="form-control" placeholder="Tên tài khoản" name="username" value="<c:out value="${targetUsername}" />">
					<span class="form-control-feedback">
						<i class="fa fa-user"></i>
					</span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" placeholder="Mật khẩu" name="password">
					<span class="form-control-feedback">
						<i class="fa fa-lock"></i>
					</span>
				</div>
				<button type="submit" class="btn btn-primary btn-block btn-flat">Đăng nhập</button>
			</form>
		</div>
	</div>
	<jsp:include page="_scripts.jsp" />
</body>

</html>
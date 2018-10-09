<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="_linkTag.jsp">
	<jsp:param name="title" value="Login" />
</jsp:include>
</head>
<body>
	<div class="login">
		<div class="container">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<h2 align="center">Đăng nhập</h2>
					<form action="login" method="post">
						<div class="form-group">
							<label>Tài khoản</label>
							<input class="form-control" id="txtUser" type="text" name="username" placeholder="Tên đăng nhập" onblur="checkUser()" value="<c:out value="${typedUsername}"/>">
							<span id="msgUser"></span>
						</div>

						<div class="form-group">
							<label>Mật khẩu</label>
							<input class="form-control" id="txtPassword" type="password" name="password" placeholder="Mật khẩu" onblur="checkPassword()">
							<span id="msgBox">
								<c:choose>
									<c:when test="${isLoginFailed}">Tài khoản hoặc Mật khẩu không đúng.</c:when>
									<c:when test="${isEmptyUsernamePassword}">Tài khoản và Mật khẩu không được để trống.</c:when>
								</c:choose>
							</span>
						</div>

						<div class="button text-center">
							<button type="submit" class="btn btn-primary" onclick="return validateFormLogin()">Đăng nhập</button>
							<button type="reset" class="btn btn-default">Đặt lại</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
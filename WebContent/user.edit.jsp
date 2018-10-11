<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="_header.jsp">
	<jsp:param name="title" value="Sửa người dùng" />
</jsp:include>
</head>
<body class="hold-transition skin-blue fixed sidebar-mini">
	<div class="wrapper">
		<jsp:include page="_navbar.jsp" />
		<jsp:include page="_sidebar.jsp" />
		<div class="content-wrapper">
			<section class="content">
				<form method="post" action="/user/edit">
					<input type="hidden" name="userId" value="<c:out value="${targetUser.getUserId()}" />">
					<div class="box box-primary box-solid">
						<div class="box-header with-border">
							<h3 class="box-title">Sửa người dùng</h3>
						</div>
						<div class="box-body">
							<c:if test="${isError}">
								<div class="alert alert-danger alert-dismissible">
									<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
									<h4>
										<i class="icon fa fa-info"></i>
										Thông báo
									</h4>
									<c:choose>
										<c:when test="${isFailed}">Có lỗi khi chỉnh sửa thông tin tài khoản.</c:when>
										<c:when test="${isEmpty}">Tên tài khoản và mật khẩu không được bỏ trống.</c:when>
									</c:choose>
								</div>
							</c:if>
							<div class="row">
								<div class="col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="required" for="request_username">Tên đăng nhập</label>
										<input type="text" class="form-control" id="request_username" name="username" required value="<c:out value="${targetUser.getUsername()}" />">
									</div>
								</div>
								<div class="col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="required" for="request_password">Mật khẩu</label>
										<input type="text" class="form-control" id="request_password" name="password" required value="<c:out value="${targetUser.getPassword()}" />">
									</div>
								</div>
							</div>
						</div>
						<div class="box-footer">
							<div class="pull-right">
								<button type="submit" class="btn btn-primary">Sửa người dùng</button>
							</div>
						</div>
					</div>
				</form>
			</section>
		</div>
		<jsp:include page="_footer.jsp" />
	</div>
	<jsp:include page="_scripts.jsp" />
</body>
</html>
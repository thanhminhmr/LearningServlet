<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="_header.jsp">
	<jsp:param name="title" value="Xoá người dùng" />
</jsp:include>
</head>
<body class="hold-transition skin-blue fixed sidebar-mini">
	<div class="wrapper">
		<jsp:include page="_navbar.jsp" />
		<jsp:include page="_sidebar.jsp" />
		<div class="content-wrapper">
			<section class="content">
				<form method="post" action="/user/delete">
					<input type="hidden" name="userId" value="<c:out value="${targetUser.getUserId()}" />">
					<div class="box box-danger box-solid">
						<div class="box-header with-border">
							<h3 class="box-title">Xoá người dùng</h3>
						</div>
						<div class="box-body">
								<div class="alert alert-danger alert-dismissible">
									<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
									<h4>
										<i class="icon fa fa-info"></i>
										Thông báo
									</h4>
									<c:choose>
										<c:when test="${isError}">Có lỗi khi xoá tài khoản.</c:when>
										<c:otherwise>Xem xét kỹ yêu cầu xoá của bạn trước khi thực hiện.</c:otherwise>
									</c:choose>
								</div>
							<div class="row">
								<div class="col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="required" for="request_username">Tên đăng nhập</label>
										<label class="form-control" id="request_username"><c:out value="${targetUser.getUsername()}" /></label>
									</div>
								</div>
								<div class="col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="required" for="request_password">Mật khẩu</label>
										<label class="form-control" id="request_password"><c:out value="${targetUser.getPassword()}" /></label>
									</div>
								</div>
							</div>
						</div>
						<div class="box-footer">
							<div class="pull-right">
								<button type="submit" class="btn btn-danger">Xoá người dùng</button>
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
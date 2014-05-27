<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!--  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Le styles -->
    <title>Welcome to Weardex</title>

    <link href="${ctx}/misc/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="shortcut icon" type="image/x-icon" href="${ctx}/misc/favicon.ico"/>

    <script src="${ctx}/misc/js/jquery.js" type="text/javascript"></script>
    <script src="${ctx}/misc/bootstrap/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#username').focus();
            if ('${error}' == '') {
                $('.alert').alert('close');
            }

        });
    </script>
</head>
<body>

<div class="container" style="margin-top: 20px">
    <a class="brand" href="#"><img class="logoicon"
                                   src="${ctx}/misc/images/visenze_logo.jpg" alt="Visenze Logo"/></a>

</div>

<div class="container" style="margin-top: 20px">
    <div class="row-fluid">
        <div class="col-lg-3"></div>
        <div class="col-lg-6">
            <div id="legend">
                <legend class="">Login</legend>
            </div>


            <shiro:guest>
                <form name="loginform" action="" method="post">
                    <c:if test="${not empty error }">
                        <div id="error">
                            <div class='alert alert-danger'>
                                <button type='button' class='close' data-dismiss='alert'>×</button>
                                <strong> ${error}</strong>
                            </div>
                        </div>
                    </c:if>
                    <fieldset>

                        <div class="col-lg-6">
                            <input type="text" name="username" class="form-control"
                                   placeholder="Email or username" id="username"/>
                        </div>
                        <div class="col-lg-6">
                            <input name="password" class="form-control" type="password"
                                   placeholder="Password"/>

                        </div>
                        <br><br><br> <input type="checkbox" name="rememberMe" style="display: none">
                    </fieldset>
                    <div class="col-md-offset-10">
                        <input type="submit" class="btn btn-success" value="Login">
                    </div>
                    <br>
                </form>

            </shiro:guest>
            <div id="legend">
                <legend class=""></legend>
            </div>

            <shiro:authenticated>
                <shiro:user>Please
                </shiro:user>
                <a href="/logout">Logout</a> before login.
            </shiro:authenticated>


        </div>
    </div>
</div>
<br>
<br>
<br>
<br>
<br>
<br>

</body>
</html>



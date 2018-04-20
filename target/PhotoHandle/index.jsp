<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>UPL Photo Handle</title>
    <link rel="stylesheet" type="text/css" href="resources/core/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="resources/core/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="resources/core/css/form-elements.css"/>
    <link rel="stylesheet" type="text/css" href="resources/core/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="resources/core/images/favicon.png"/>
    <link rel="stylesheet" type="text/css" href="resources/core/images/apple-touch-icon-144-precomposed.png"/>
    <link rel="stylesheet" type="text/css" href="resources/core/images/apple-touch-icon-114-precomposed.png"/>
    <link rel="stylesheet" type="text/css" href="resources/core/images/apple-touch-icon-144-precomposed.png"/>
    <link rel="stylesheet" type="text/css" href="resources/core/images/apple-touch-icon-72-precomposed.png"/>
    <link rel="stylesheet" type="text/css" href="resources/core/images/apple-touch-icon-57-precomposed.png"/>
</head>

<body>
<%
    String message = (String) request.getSession().getAttribute("message");
    if ("".equals(message) || null == message) {
        message = "";
    }
%>
<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>UPL Photo Handle</h3>
                            <p>The address of the input picture:</p>
                            <p><a style="color: red;"><%=message%></a></p>
                        </div>
                        <div>

                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="${pageContext.request.contextPath}/photo" method="post" class="login-form">
                            <div class="form-group">
                                <input type="text" name="photoAddress" placeholder="请输入图片所在目录..." class="form-photoAddress form-control" id="form-photoAddress">
                            </div>
                            <button type="submit" class="btn">Sign in!</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="resources/core/js/jquery.backstretch.min.js"></script>
<script type="text/javascript" src="resources/core/js/scripts.js"></script>
<script type="text/javascript" src="resources/core/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="resources/core/js/bootstrap.min.js"></script>
</body>
</html>
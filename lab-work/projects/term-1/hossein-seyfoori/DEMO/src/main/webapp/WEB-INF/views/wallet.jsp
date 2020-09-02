<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fqx
  Date: 19.08.20
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>پنل مدیریت | کیف پول</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/adminlte.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/static/plugins/iCheck/square/blue.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">

    <!-- bootstrap rtl -->
    <link rel="stylesheet" href="/static/dist/css/bootstrap-rtl.min.css">
    <!-- template rtl version -->
    <link rel="stylesheet" href="/static/dist/css/custom-style.css">
</head>
<body class="hold-transition login-page">

<div class="wrapper">
    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand bg-white navbar-light border-bottom">
        <!-- Left navbar links -->
<%--        <ul class="navbar-nav">--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" data-widget="pushmenu" href="#"><i class="fa fa-bars"></i></a>--%>
<%--            </li>--%>
<%--            <li class="nav-item d-none d-sm-inline-block">--%>
<%--                <a href="index3.html" class="nav-link">خانه</a>--%>
<%--            </li>--%>
<%--            <li class="nav-item d-none d-sm-inline-block">--%>
<%--                <a href="#" class="nav-link">تماس</a>--%>
<%--            </li>--%>
<%--        </ul>--%>

<%--        <!-- SEARCH FORM -->--%>
<%--        <form class="form-inline ml-3">--%>
<%--            <div class="input-group input-group-sm">--%>
<%--                <input class="form-control form-control-navbar" type="search" placeholder="جستجو" aria-label="Search">--%>
<%--                <div class="input-group-append">--%>
<%--                    <button class="btn btn-navbar" type="submit">--%>
<%--                        <i class="fa fa-search"></i>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </form>--%>

        <!-- Right navbar links -->
        <ul class="navbar-nav mr-auto">
            <!-- Messages Dropdown Menu -->
            <li class="nav-item dropdown">


            </li>

        </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="index3.html" class="brand-link">

            <span class="brand-text font-weight-light">${user.first_name} خوش آمدی</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <div>
                <!-- Sidebar user panel (optional) -->
                <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                    <div class="image">
                    </div>
                    <div class="info">
                        <a href="#" class="d-block"></a>
                    </div>
                </div>

                <!-- Sidebar Menu -->
                <nav class="mt-2">
                    <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                        <!-- Add icons to the links using the .nav-icon class
                             with font-awesome or any other icon font library -->
                        <li class="nav-item active">
                            <a href="/dashboard" class="nav-link ">
                                <i class="nav-icon fa fa-dashboard "></i>
                                <p>
                                    داشبورد
                                    <i class="right fa fa-angle-left"></i>
                                </p>
                            </a>
<%--                            <ul class="nav nav-treeview" style="display: none;">--%>
<%--                                <li class="nav-item">--%>
<%--                                    <a href="./index.html" class="nav-link ">--%>
<%--                                        <i class="fa fa-circle-o nav-icon"></i>--%>
<%--                                        <p>مدیریت کاربران</p>--%>
<%--                                    </a>--%>
<%--                                </li>--%>
<%--                                <li class="nav-item">--%>
<%--                                    <a href="./index2.html" class="nav-link ">--%>
<%--                                        <i class="fa fa-circle-o nav-icon"></i>--%>
<%--                                        <p>اضافه کردن کاربر</p>--%>
<%--                                    </a>--%>
<%--                                </li>--%>
<%--                                <li class="nav-item">--%>
<%--                                    <a href="./index3.html" class="nav-link">--%>
<%--                                        <i class="fa fa-circle-o nav-icon"></i>--%>
<%--                                        <p>ورود خروج کاربران</p>--%>
<%--                                    </a>--%>
<%--                                </li>--%>
<%--                            </ul>--%>

                            <a href="/wallet" class="nav-link active">
                                <i class="nav-icon fa fa-money "></i>
                                <p>
                                    کیف پول
                                    <i class="right fa fa-angle-left"></i>
                                </p>
                            </a>
                        </li>
                    </ul>
                </nav>

                <!-- /.sidebar-menu -->
            </div>
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">


        <!-- Content Header (Page header) -->
        <div class="content-header">
            <a href="/logout" class="btn btn-danger float-left " >خروج</a>

            <div class="container-fluid">

                <div class="row mb-2">

                    <div class="col-sm-6">

                        <h1 class="m-0 text-dark">کیف پول </h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-left  ">
                            <li class="breadcrumb-item active"><a href="/dashboard">خانه</a></li>
                            <li class="breadcrumb-item  ">کیف پول </li>
<%--                            <li class="breadcrumb-item ">مدیریت کاربرها </li>--%>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">

                <form class="form form-group" action="/wallet/create" method="post">

                    <div class="row">
                        <div class="col-md-5">
                            <c:if test="${ message ne null}">
                                <div class="alert alert-danger ">
                                        ${message}
                                </div>
                            </c:if>
                            <input type="text" name="name" class="form form-control" placeholder="نام کیف پول خود را وارد کنید">
                        </div>
                        <div class="col-md-2">
                            <input type="submit" class="btn btn-success"  value="ثبت">
                        </div>
                    </div>

                </form>


                <div class="card-body p-0" style="display: block;">
                    <div class="table-responsive">
                        <table class="table m-0">
                            <thead>
                            <tr>
                                <th>شماره</th>
                                <th>نام</th>
                                <th>عملیات</th>


                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${wallets}" var="wallet">
                                <tr>
                                    <td><a href="user/${wallet.id}">${wallet.id}</a></td>
                                    <td>${wallet.name}</td>
                                    <td>
                                        <div class="btn-group">
                                            <a href="/wallet/${wallet.id}/edit"  class="btn btn-secondary">ویرایش</a>
                                            <form method="post" action="/wallet/delete"   >
                                                <input type="text" name="id" value="${wallet.id}" hidden>
                                                <input type="submit" class="btn btn-danger" value="حذف">
                                            </form>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.table-responsive -->
                </div>





            </div><!--/. container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->

    <!-- Main Footer -->
    <footer class="main-footer">
        <!-- To the right -->
        <div class="float-right d-sm-none d-md-block">

        </div>
        <!-- Default to the left -->

    </footer>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->
<!-- jQuery -->
<script src="/static/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="/static/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="/static/dist/js/adminlte.js"></script>

<!-- OPTIONAL SCRIPTS -->
<script src="/static/dist/js/demo.js"></script>

<!-- PAGE PLUGINS -->
<!-- SparkLine -->
<script src="/static/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jVectorMap -->
<script src="/static/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/static/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- SlimScroll 1.3.0 -->
<script src="/static/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- ChartJS 1.0.2 -->
<script src="/static/plugins/chartjs-old/Chart.min.js"></script>

<!-- PAGE SCRIPTS -->
<script src="/static/dist/js/pages/dashboard2.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass   : 'iradio_square-blue',
            increaseArea : '20%' // optional
        })
    })
</script>
</body>
</html>

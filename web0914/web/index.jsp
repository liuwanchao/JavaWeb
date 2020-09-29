<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/index.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <script src="js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/bootstrap.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>
<div class="container">
    <!-- 头部图片 -->
    <div id="header" class="row col-md-12 row">
        <img src="img/ia_100000401.jpg">
    </div>
    <!-- 导航栏 -->
    <div id="nav" class="col-md-12 row">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                            aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">小米商城</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="#">手机 <span class="sr-only">(current)</span></a></li>
                        <li><a href="#">电视</a></li>
                        <li><a href="#">笔记本</a></li>
                        <li><a href="#">家电</a></li>
                        <li><a href="#">智能</a></li>
                        <li><a href="#">服务</a></li>
                    </ul>
                    <form class="navbar-form navbar-right">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="请输入要查找的商品">
                        </div>
                        <button type="submit" class="btn btn-default">搜索</button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a id="uname" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">未登录
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="login.html">登录</a></li>
                                <li><a href="regs.html">注册</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="shopcar.html">购物车</a></li>
                            </ul>
                        </li>

                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <!-- 轮播图 -->
    <div id="picture" class="col-md-12 row">
        <!--轮播图图片-->
        <div id="content"></div>
        <!-- 轮播图上层内容 -->
        <div id="pic2" class="col-md-12 row">
            <!-- 轮播图左侧商品类型 -->
            <div id="type" class="col-md-2">
                <ul>
                    <li class="type"><a href="#">手机 电话卡</a></li>
                    <li class="type"><a href="#">电视 盒子</a></li>
                    <li class="type"><a href="#">笔记本 显示器</a></li>
                    <li class="type"><a href="#">家电 插线板</a></li>
                    <li><a href="#">出行 穿戴</a></li>
                    <li><a href="#">智能 路由器</a></li>
                    <li><a href="#">电源 配件</a></li>
                    <li><a href="#">健康 儿童</a></li>
                    <li><a href="#">耳机 音箱</a></li>
                    <li><a href="#">电视 盒子</a></li>
                    <li><a href="#">生活 箱包</a></li>
                </ul>
            </div>
            <!-- 右侧商品列表 -->
            <div id="chtype" class="col-md-10 type">
                <div class="row" id="json2">
                    <!-- <div class="pite col-sm-3">
                        <div>
                            <a href="productdetails.html">
                                <img src="img/ia_100003317.png">
                                <h3>111</h3>
                                <p class="prc">123</p>
                            </a>
                        </div>
                    </div>-->
                </div>
            </div>
        </div>
    </div>
    <!-- 轮播图下内容 -->
    <div id="photo" class="col-md-12 row">
        <div id="photo1" class="col-md-3">
            <div id="pp" class="col-md-11">
                <ul>
                    <li class="col-md-4"><a href="#"><img src="img/ia_100000226.png">
                        <p>小米秒杀</p>
                    </a></li>
                    <li class="col-md-4"><a href="#"><img src="img/ia_100000227.png">
                        <p>小米秒杀</p>
                    </a></li>
                    <li class="col-md-4"><a href="#"><img src="img/ia_100000228.png">
                        <p>小米秒杀</p>
                    </a></li>
                    <li class="col-md-4"><a href="#"><img src="img/ia_100000229.png">
                        <p>小米秒杀</p>
                    </a></li>
                    <li class="col-md-4"><a href="#"><img src="img/ia_100000230.png">
                        <p>小米秒杀</p>
                    </a></li>
                    <li class="col-md-4"><a href="#"><img src="img/ia_100000231.png">
                        <p>小米秒杀</p>
                    </a></li>
                </ul>
            </div>

        </div>
        <div id="photo2" class="col-md-9 row" style="padding: 0;">
            <div class="col-md-4">
                <a href="productdetails.html"><img src="img/ia_100000232.jpg"></a>
            </div>
            <div class="col-md-4">
                <a href="productdetails.html"><img src="img/ia_100000233.jpg"></a>
            </div>
            <div class="col-md-4">
                <a href="productdetails.html"><img src="img/ia_100000234.jpg"></a>
            </div>
        </div>

    </div>

    <!-- 横幅广告 -->
    <div id="advertising" class="col-md-12 row">
        <div class="col-md-12">
            <a href="productdetails.html"><img src="img/ia_100000260.webp"></a>
        </div>

    </div>

    <!-- 商品展示 -->
    <div id="pho-head" class="col-md-12 row">
        <div class="col-md-10">
            <h3>手机</h3>
        </div>
        <div id="findall" class="col-md-2 text-right">
            <a href="#">查看全部<span class="glyphicon glyphicon-chevron-right"></span></a>
        </div>
    </div>
    <div id="pho-show" class="col-md-12 row">
        <!-- 左侧广告 -->
        <div id="pho-show-l" class="col-md-2">
            <img src="img/phonel.jpg">
        </div>
        <div class="col-md-1">

        </div>
        <!-- 右侧商品 -->
        <div id="pho-show-r" class="col-md-9 row">
            <div class="row" id="json3">
                <!-- <div class="pitem col-sm-3">
                    <div>
                        <a href="productdetails.html">
                            <img src="img/ia_100003317.png">
                            <h3>111</h3>
                            <p class="prc">123</p>
                        </a>
                    </div>
                </div>-->

            </div>
        </div>
    </div>

    <!-- 底部 -->
    <div id="botton" class="col-md-12 row">
        <div class="col-md-2">
            <p>帮助中心</p>
            <ul>
                <li><a href="#">账户管理</a></li>
                <li><a href="#">购物指南</a></li>
                <li><a href="#">订单操作</a></li>
            </ul>
        </div>
        <div class="col-md-2">
            <p>服务支持</p>
            <ul>
                <li><a href="#">售后政策</a></li>
                <li><a href="#">自助服务</a></li>
                <li><a href="#">相关下载</a></li>
            </ul>
        </div>
        <div class="col-md-2">
            <p>线下门店</p>
            <ul>
                <li><a href="#">小米之家</a></li>
                <li><a href="#">服务网点</a></li>
                <li><a href="#">授权体验店</a></li>
            </ul>
        </div>
        <div class="col-md-2">
            <p>关于小米</p>
            <ul>
                <li><a href="#">了解我们</a></li>
                <li><a href="#">加入小米</a></li>
                <li><a href="#">投资者关系</a></li>
                <li><a href="#">企业社会责任</a></li>
                <li><a href="#">廉洁举报</a></li>
            </ul>
        </div>
        <div class="col-md-2">
            <p>关注我们</p>
            <ul>
                <li><a href="#">新浪微博</a></li>
                <li><a href="#">官方微博</a></li>
                <li><a href="#">联系我们</a></li>
                <li><a href="#">公益基金会</a></li>
            </ul>
        </div>
        <div class="col-md-2">
            <p>特色服务</p>
            <ul>
                <li><a href="#">F码通道</a></li>
                <li><a href="#">礼物码</a></li>
                <li><a href="#">防伪码</a></li>
            </ul>
        </div>
    </div>
</div>
<script src="js/index.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>

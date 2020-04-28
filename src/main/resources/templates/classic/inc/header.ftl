<!-- Login dialog BEGIN -->
<div id="login_alert" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document" style="width: 400px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">你还没有登陆</h4>
            </div>
            <div class="panel-heading">
                <span>
                    <a id="account_btn" onclick="account()" class="btn btn-primary btn-sm">用户名登录</a>&nbsp;
                    <a id="phone_btn" onclick="phone()" class="btn btn-default btn-sm">手机号登录</a>
                </span>
            </div>
            <div id="account" class="panel-body">
                <form id="username_form" accept-charset="UTF-8">
                    <div class="form-group">
                        <label class="control-label" for="username">用户名</label>
                        <input id="username" class="form-control" name="username" type="text" placeholder="请输入用户名"
                               required>
                    </div>
                    <div id="username_tex" class="text-danger"></div>
                    <div class="form-group">
                        <label class="control-label" for="password">密码</label>
                        <input id="password" class="form-control" name="password" type="password" placeholder="请输入密码"
                               required>
                    </div>
                    <div id="password_tex" class="text-danger"></div>
                    <div>&nbsp;</div>
                    <div class="form-group">
                        <label>
                            <input type="checkbox" name="rememberMe" value="1"> 记住登录
                        </label>
                        <span class="pull-right">
                            <a class="forget-password" href="${base}/user/forget">忘记密码？</a>
                        </span>
                    </div>
                    <div class="form-group">
                        <button id="username_login" type="button" class="btn btn-primary btn-block">
                            登录
                        </button>
                    </div>
                </form>
            </div>
            <div id="phone" style="display: none" class="panel-body">
                <div class="form-group">
                    <label class="control-label" for="username">手机号</label>
                    <div class="input-group">
                        <input id="phone_inp" type="text" class="form-control" name="phone" maxlength="64"
                               placeholder="请输入手机号"
                               required>
                        <div id="phone_tex" class="text-danger"></div>
                        <span class="input-group-btn">
                                    <a class="btn btn-primary" href="javascript:void(0);" id="sendCode">
                                        <span id="dyMobileButton">获取验证码</span>
                                    </a>
                                </span>
                    </div>
                </div>
                <div id="message_tex" class="text-danger"></div>
                <div class="form-group ">
                    <label class="control-label" for="code">验证码</label>
                    <input id="captcha_inp" class="form-control" id="code" name="code" type="text" placeholder="请输入验证码"
                           maxlength="6" required>
                </div>
                <div id="captcha_tex" class="text-danger"></div>
                <div class="form-group">
                    <button id="phone_login" type="button" class="btn btn-primary btn-block">
                        登录
                    </button>
                </div>
            </div>
            <#--                    <@controls name="register">-->
            <fieldset class="form-group">
                <#--			    <#if site.hasValue("weibo_client_id")>-->
                <#--                            <a class="btn btn-default btn-block" href="${base}/oauth/callback/call_weibo">-->
                <#--                                <i class="fa fa-weibo"></i> 微博帐号登录-->
                <#--                            </a>-->
                <#--                            </#if>-->
                <#--                            <#if site.hasValue("qq_app_id")>-->
                <#--                            <a class="btn btn-default btn-block" href="${base}/oauth/callback/call_qq">-->
                <#--                                <i class="fa fa-qq"></i> QQ帐号登录-->
                <#--                            </a>-->
                <#--                            </#if>-->
                <#--                            <#if site.hasValue("github_client_id")>-->
                <#--                            <a class="btn btn-default btn-block" href="${base}/oauth/callback/call_github">-->
                <#--                                <i class="fa fa-github"></i> Github帐号登录-->
                <#--                            </a>-->
                <#--                            </#if>-->
            </fieldset>
            <#--                    </@controls>-->
            </form>
        </div>
    </div><!-- /.modal-content -->
</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- Login dialog END -->

<!--[if lt IE 9]>
<div class="alert alert-danger alert-dismissible fade in" role="alert" style="margin-bottom:0">
    <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">×</span><span class="sr-only">Close</span>
    </button>
    <strong>您正在使用低版本浏览器，</strong> 在本页面的显示效果可能有差异。
    建议您升级到
    <a href="http://www.google.cn/intl/zh-CN/chrome/" target="_blank">Chrome</a>
    或以下浏览器：
    <a href="www.mozilla.org/en-US/firefox/‎" target="_blank">Firefox</a> /
    <a href="http://www.apple.com.cn/safari/" target="_blank">Safari</a> /
    <a href="http://www.opera.com/" target="_blank">Opera</a> /
    <a href="http://windows.microsoft.com/en-us/internet-explorer/download-ie" target="_blank">Internet Explorer 9+</a>
</div>
<![endif]-->

<!-- Fixed navbar -->
<header class="site-header headroom">
    <div class="container">
        <nav class="navbar" role="navigation">
            <div class="navbar-header">
                <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/index">
                    <img src="http://pic.yupoo.com/lhon/53777037/e6745296.png"/>
                </a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <#if profile??>
                        <li data="user">
                            <a href="${base}/users/${profile.id}" nav="user">我的主页</a>
                        </li>
                    </#if>
                    <li>
                        <a href="${base}/index" nav="msgs">最新</a>
                    </li>
                    <li>
                        <a href="${base}/followmsgs" nav="follow">关注</a>
                    </li>
                    <li>
                        <a href="${base}/popularmsgs" nav="popular">热门</a>
                    </li>
                    <li>
                        <a href="${base}/tags" nav="tags">标签</a>
                    </li>
                </ul>
                <ul class="navbar-button list-inline" id="header_user">
                    <li view="search" class="hidden-xs hidden-sm">
                        <form method="GET" action="${base}/search" accept-charset="UTF-8"
                              class="navbar-form navbar-left">
                            <div class="form-group">
                                <input class="form-control search-input mac-style" placeholder="搜索" name="kw"
                                       type="text" value="${kw}">
                                <button class="search-btn" type="submit"><i class="fa fa-search"></i></button>
                            </div>
                        </form>
                    </li>

                    <#if profile??>
                    <#--                    <@controls name="post">-->
                        <li>
                            <a href="${base}/texts/editing" class="plus"><i class="icon icon-note"></i> 写文章</a>
                        </li>
                    <#--                    </@controls>-->
                        <li class="dropdown">
                            <a href="#" class="user dropdown-toggle" data-toggle="dropdown">
                                <img class="img-circle" src="${profile.photoUrl}">
                                <span>${profile.nickname}</span>
                            </a>
                            <ul class="dropdown-menu" role="menu">
                                <li>
                                    <a href="${base}/users/${profile.id}">我的主页</a>
                                </li>
                                <li>
                                    <a href="${base}/user/setting">编辑资料</a>
                                </li>
                                <#--                            <@shiro.hasPermission name="admin">-->
                                <li><a href="${base}/admin">后台管理</a></li>
                                <#--                            </@shiro.hasPermission>-->
                                <li><a href="${base}/user/logout">退出</a></li>
                            </ul>
                        </li>
                    <#else>
                        <li><a href="${base}/user/login" class="btn btn-default btn-sm signup">登录</a></li>
                    <#--&lt;#&ndash;                    <@controls name="register">&ndash;&gt;-->
                        <li><a href="${base}/user/register" class="btn btn-primary btn-sm signup">注册</a></li>
                    <#--&lt;#&ndash;                    </@controls>&ndash;&gt;-->
                    </#if>

                </ul>
            </div>
        </nav>
    </div>
</header>

<script type="text/javascript">
	$(function () {
		$('a[nav]').each(function () {
			$this = $(this);
			if ($this[0].href == String(window.location)) {
				$this.closest('li').addClass("active");
			}
		});
	});

	var time = 60;
	var flag = true;   //设置点击标记，防止60内再次点击生效

	//发送验证码
	$('#sendCode').click(function () {
		$(this).attr("disabled", true);
		var phone = $('#phone_inp').val();
		if (flag) {
			var timer = setInterval(function () {

				if (time == 60 && flag) {
					flag = false;

					$.ajax({
						type: 'get',
						async: false,
						url:"http://localhost:11111/user/sendMessage",
						data: {
							"phone": phone,
							"msgType": 1
						},
						dataType: "json",
						success: function (data) {
							if (data.code == 200) {
								$('#message_tex').html(data.data);
							} else {
								$('#message_tex').html(data.message);
								flag = true;
								time = 60;
								clearInterval(timer);
							}
						}
					});
				} else if (time == 0) {
					$("#sendCode").removeAttr("disabled");
					$("#sendCode").html("免费获取验证码");
					clearInterval(timer);
					time = 60;
					flag = true;
				} else {
					$("#sendCode").html(time + " s 重新发送");
					time--;
				}
			}, 1000);
		}

	});

	//账号密码登陆
	$('#username_login').click(function () {
		var username = $('#username').val();
		var password = $('#password').val();
		if (username == "") {
			$('#username_tex').html("请输入账号");
			return false;
		} else if (password == "") {
			$('#password_tex').html("请输入密码");
			return  false;
		}
		$.ajax({
			url: "http://localhost:11111/user/toLoginR",
			type: "post",
			async: false,
			data: {
				"username" : username,
				"password" : password,
				"loginType" : 1
			},
			dataType: "json",
			success: function (data) {
				if (data.code == 200) {
					window.location.href="http://localhost:11111/users/"+ data.data.id;
				} else  {
					$('#password_tex').html(data.message);
				}
			},
			error: function (data) {
				$('#password_tex').html("服务器错误");
			}
		});
	});

	//手机号登陆
	$('#phone_login').click(function () {
		var username = $('#phone_inp').val();
		var password = $('#captcha_inp').val();
		$.ajax({
			url: "http://localhost:11111/user/toLoginR",
			type: "post",
			async: false,
			data: {
				"username" : username,
				"password" : password,
				"loginType" : 2
			},
			dataType: "json",
			success: function (data) {
				if (data.code == 200) {
					window.location.href="http://localhost:11111/users/"+ data.data.id;
				} else  {
					$('#captcha_tex').html(data.message);
				}
			},
			error: function (data) {
				$('#captcha_tex').html("服务器错误");
			}
		});
	});




	function account() {
		document.getElementById('account').style.display= 'block';
		document.getElementById('phone').style.display='none';
		document.getElementById('account_btn').className = 'btn btn-primary btn-sm';
		document.getElementById('phone_btn').className = 'btn btn-default btn-sm';
	}
	function phone() {
		document.getElementById('account').style.display= 'none';
		document.getElementById('phone').style.display='block';
		document.getElementById('account_btn').className = 'btn btn-default btn-sm';
		document.getElementById('phone_btn').className = 'btn btn-primary btn-sm';
	}
</script>
<!-- Header END -->

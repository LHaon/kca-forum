<#include "/classic/inc/layout.ftl"/>
<@layout>

<div class="row">
    <div class="col-md-4 col-md-offset-4 floating-box">
        <div class="panel panel-default">
            <div class="panel-heading">
                <span>
                    <a id="laccount_btn" onclick="laccount()" class="btn btn-primary btn-sm">用户名登录</a>&nbsp;
                    <a id="lphone_btn" onclick="lphone()" class="btn btn-default btn-sm">手机号登录</a>
                </span>
            </div>
            <div id="laccount" class="panel-body">
                <form id="lusername_form" accept-charset="UTF-8">
                    <div class="form-group">
                        <label class="control-label" for="username">用户名</label>
                        <input id="lusername" class="form-control" name="username" type="text" placeholder="请输入用户名"
                               required>
                    </div>
                    <div id="lusername_tex" class="text-danger"></div>
                    <div class="form-group">
                        <label class="control-label" for="password">密码</label>
                        <input id="lpassword" class="form-control" name="password" type="password" placeholder="请输入密码"
                               required>
                    </div>
                    <div id="lpassword_tex" class="text-danger"></div>
                    <div>&nbsp;</div>
                    <div class="form-group">
                        <label>
                            <input type="checkbox" name="rememberMe" value="1"> 记住登录
                        </label>
                        <span class="pull-right">
                            <a class="forget-password" href="${http}/user/forget">忘记密码？</a>
                        </span>
                    </div>
                    <div class="form-group">
                        <button id="lusername_login" type="button" class="btn btn-primary btn-block">
                            登录
                        </button>
                    </div>
                </form>
            </div>
            <div id="lphone" style="display: none" class="panel-body">
            <div class="form-group">
                <label class="control-label" for="username">手机号</label>
                <div class="input-group">
                    <input id="lphone_inp" type="text" class="form-control" name="phone" maxlength="64"
                           placeholder="请输入手机号"
                           required>
                    <div id="lphone_tex" class="text-danger"></div>
                    <span class="input-group-btn">
                                    <a class="btn btn-primary" href="javascript:void(0);" id="lsendCode">
                                        <span id="dyMobileButton">获取验证码</span>
                                    </a>
                                </span>
                </div>
            </div>
                <div id="lmessage_tex" class="text-danger"></div>
            <div class="form-group ">
                <label class="control-label" for="code">验证码</label>
                <input id="lcaptcha_inp" class="form-control" id="code" name="code" type="text" placeholder="请输入验证码"
                       maxlength="6" required>
            </div>
                <div id="lcaptcha_tex" class="text-danger"></div>
                <div class="form-group">
                    <button id="lphone_login" type="button" class="btn btn-primary btn-block">
                        登录
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">

    var time = 60;
    var flag = true;   //设置点击标记，防止60内再次点击生效


    $('#lsendCode').click(function () {
		$(this).attr("disabled", true);
        var phone = $('#lphone_inp').val();
        if (flag) {
            var timer = setInterval(function () {

                if (time == 60 && flag) {
                    flag = false;

                    $.ajax({
                        type: 'get',
                        async: false,
                        url:"${http}/user/sendMessage",
                        data: {
                            "phone": phone,
                            "msgType": 1
                        },
                        dataType: "json",
                        success: function (data) {
                            if (data.code == 200) {
                                $('#lmessage_tex').html(data.data);
                            } else {
								$("#lsendCode").removeAttr("disabled");
								$('#lmessage_tex').html(data.message);
                                flag = true;
                                time = 60;
                                clearInterval(timer);
                            }
                        }
                    });
                } else if (time == 0) {
                    $("#lsendCode").removeAttr("disabled");
                    $("#lsendCode").html("免费获取验证码");
                    clearInterval(timer);
                    time = 60;
                    flag = true;
                } else {
                    $("#lsendCode").html(time + " s 重新发送");
                    time--;
                }
            }, 1000);
        }

    });

	//账号密码登陆
	$('#lusername_login').click(function () {
		var username = $('#lusername').val();
		var password = $('#lpassword').val();
		if (username == "") {
            $('#lusername_tex').html("请输入账号");
			return false;
        } else if (password == "") {
            $('#lpassword_tex').html("请输入密码");
			return  false;
        }
		$.ajax({
			url: "${http}/user/toLoginR",
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
					window.location.href="${http}/users/"+ data.data.id;
				} else  {
					$('#lpassword_tex').html(data.message);
				}
			},
			error: function (data) {
                $('#lpassword_tex').html("服务器错误");
			}
		});
	});

	//手机号登陆
	$('#lphone_login').click(function () {
		var username = $('#lphone_inp').val();
        var password = $('#lcaptcha_inp').val();
		var myreg = /^[1][3,4,5,7,8,9][0-9]{9}$/;
		if (!myreg.test(username)) {
			$('#lmessage_tex').html("手机号格式不正确");
			return false;
		}
		$.ajax({
			url: "${http}/user/toLoginR",
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
					window.location.href="${http}/users/"+ data.data.id;
				} else  {
					$('#lcaptcha_tex').html(data.message);
				}
			},
			error: function (data) {
				$('#lcaptcha_tex').html("服务器错误");
			}
		});
	});




	function laccount() {
        document.getElementById('laccount').style.display= 'block';
        document.getElementById('lphone').style.display='none';
        document.getElementById('laccount_btn').className = 'btn btn-primary btn-sm';
        document.getElementById('lphone_btn').className = 'btn btn-default btn-sm';
    }
    function lphone() {
        document.getElementById('laccount').style.display= 'none';
        document.getElementById('lphone').style.display='block';
        document.getElementById('laccount_btn').className = 'btn btn-default btn-sm';
        document.getElementById('lphone_btn').className = 'btn btn-primary btn-sm';
    }
</script>

</@layout>


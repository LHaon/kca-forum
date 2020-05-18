<#include "/classic/inc/layout.ftl"/>

<@layout "注册">
    <div class="row">
        <div class="col-md-4 col-md-offset-4 floating-box">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">注册</h3>
                </div>
                <div class="panel-body">
                    <#include "/classic/inc/action_message.ftl"/>
                    <div id="message">
                    </div>
                    <form id="registerForm">
                        <div class="form-group ">
                            <label class="control-label" for="username">用户名</label>
                            <input class="form-control" id="username" name="username" type="text"
                                   placeholder="4到15位字母或数字" required>
                        </div>
						<div id="rusername_tex" class="text-danger"></div>
                        <div class="form-group">
                            <label class="control-label" for="username">手机号</label>
                            <div class="input-group">
                                <input id="rphone" type="text" class="form-control" name="phone" maxlength="64"
                                       placeholder="请输入手机号"
                                       required>
                                <span class="input-group-btn">
                                    <a class="btn btn-primary" href="javascript:void(0);" id="rsendCode">
                                        <span id="dyMobileButton">获取验证码</span>
                                    </a>
                                </span>
                            </div>
                        </div>
                        <div id="rmessage_tex" class="text-danger"></div>
                        <div class="form-group ">
                            <label class="control-label" for="code">验证码</label>
                            <input class="form-control" id="code" name="code" type="text" placeholder="请输入验证码"
                                   maxlength="6" required>
                        </div>
						<div id="code_tex" class="text-danger"></div>
                        <div class="form-group ">
                            <label class="control-label" for="username">密码</label>
                            <input class="form-control" id="rpassword" name="password" type="password"
                                   maxlength="18"
                                   placeholder="请输入密码" required>
                        </div>
                        <div class="form-group ">
                            <label class="control-label" for="username">确认密码</label>
                            <input class="form-control" id="rpasswordr" name="passwordr" type="password"
                                   placeholder="请再一次输入密码" maxlength="18">
                        </div>
						<div id="rpassword_tex" class="text-danger"></div>
						<div>&nbsp;</div>
                        <button id="to_register" type="button" class="btn btn-primary btn-block">
                            提交
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">
		var time = 60;
		var flag = true;   //设置点击标记，防止60内再次点击生效

		//发送验证码
		$('#rsendCode').click(function () {
			$(this).attr("disabled", true);
			var phone = $('#rphone').val();
			if (flag) {
				var timer = setInterval(function () {

					if (time == 60 && flag) {
						flag = false;

						$.ajax({
							type: 'get',
							async: false,
							url: "http://localhost:11111/user/sendMessage",
							data: {
								"phone": phone,
								"msgType":2
							},
							dataType: "json",
							success: function (data) {
								if (data.code == 200) {
									$("#rmessage_tex").html("短信发送成功！");
								} else if (data.code == 400) {
									$("#rmessage_tex").html(data.message);
									flag = true;
									time = 60;
									clearInterval(timer);
									$("#rsendCode").removeAttr("disabled");
								} else {
									$("#rmessage_tex").html(data.message);
									flag = true;
									time = 60;
									clearInterval(timer);
									$("#rsendCode").removeAttr("disabled");
								}
							}
						});
					} else if (time == 0) {
						$("#rsendCode").removeAttr("disabled");
						$("#rsendCode").html("免费获取验证码");
						clearInterval(timer);
						time = 60;
						flag = true;
					} else {
						$("#rsendCode").html(time + " s 重新发送");
						time--;
					}
				}, 1000);
			}

		});

		//手机号注册
		$('#to_register').click(function () {

			var password = $('#rpassword').val();
			var passwordr = $('#rpasswordr').val();
			if (password != passwordr) {
				$('#rpassword_tex').html('两次密码输入不一致');
				$('#rpassword').val("");
				$('#rpasswordr').val("");
				return false;
			}
			var data = new FormData($( "#registerForm" )[0]);
			$.ajax({
				url: "http://localhost:11111/user/toRegister",
				type: "post",
				async: false,
				data: data,
				processData: false,
				contentType: false,
				dataType: "json",
				success: function (data) {
					if (data.code == 200) {
						alert(data.data+"，即将跳转到登陆界面。");
						window.location.href = "http://localhost:11111/user/login";
					} else  {
						$('#rpassword_tex').html(data.message)
					}
				},
				error: function (e) {

				}
			});
		});

	</script>

</@layout>
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
                    <form id="submitForm" method="POST" action="register" accept-charset="UTF-8">
                        <div class="form-group ">
                            <label class="control-label" for="username">用户名</label>
                            <input class="form-control" id="username" name="username" type="text"
                                   placeholder="字母和数字的组合, 不少于5位" required>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="username">手机号</label>
                            <div class="input-group">
                                <input type="text" class="form-control" name="phone" maxlength="64" placeholder="请输入手机号"
                                       required>
                                <span class="input-group-btn">
                                    <a class="btn btn-primary" href="javascript:void(0);" id="sendCode">
                                        <span id="dyMobileButton">获取验证码</span>
                                    </a>
                                </span>
                            </div>
                        </div>
                        <div class="form-group ">
                            <label class="control-label" for="code">验证码</label>
                            <input class="form-control" id="code" name="code" type="text" placeholder="请输入验证码"
                                   maxlength="6" required>
                        </div>
                        <div class="form-group ">
                            <label class="control-label" for="username">密码</label>
                            <input class="form-control" id="password" name="password" type="password" maxlength="18"
                                   placeholder="请输入密码" required>
                        </div>
                        <div class="form-group ">
                            <label class="control-label" for="username">确认密码</label>
                            <input class="form-control" id="password2" name="password2" type="password"
                                   placeholder="请再一次输入密码" maxlength="18">
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">
                            提交
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">
		seajs.use('validate', function (validate) {
			validate.register('#submitForm', '#sendCode');
		});
		var vercode = 0;
		var time = 60;
		var flag = true;   //设置点击标记，防止60内再次点击生效

		//发送验证码
		$('#sendCode').click(function () {
			$(this).attr("disabled", true);
			var phone = $('#phone').val();
			if (flag) {
				var timer = setInterval(function () {

					if (time == 60 && flag) {
						flag = false;

						$.ajax({
							type: 'get',
							async: false,
							url: 'sms.do',
							data: {
								"phone": phone
							},
							dataType: "json",
							success: function (data) {
								if (data.status == 0) {
									vercode = data.data;
									$("#send").html("已发送");
								} else {
									alert(data.msg);
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

		//手机号注册
		$('input[name= "submit_phone"]').click(function () {
			var reader_com_check = $('#reader-me').attr("checked");
//            if(reader_com_check != true) {
//                alert("请先点击确认商城服务协议再进行注册");
//                return false;
//			}
			var code = $('#code').val();
			if (vercode != code) {
				alert("请输入正确的验证码");
				$('#code').val("");
			} else {
				var phone = $('#phone').val();
				var password = $('#password1').val();
				var passwordRepeat = $('#passwordRepeat1').val();
				if (password != passwordRepeat) {
					alert("您输入的密码不一致，请从新输入");
					$('#password1').val("");
					$('#passwordRepeat1').val("");
					return false;
				}
				var form = new FormData();
				form.append("phone", phone);
				form.append("password", password);

				$.ajax({
					url: "register.do",
					type: "post",
					data: form,
					processData: false,
					contentType: false,
					success: function (data) {
						if (data.status == 0) {
							alert(data.msg);
							window.location.href = "init_login_page.do";
						} else if (data.status == 1) {
							alert(data.msg);
						}

					},
					error: function (e) {
						alert("错误提交！");

					}
				});
			}
		});


    </script>
	</script>

</@layout>
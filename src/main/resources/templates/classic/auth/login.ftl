<#include "/classic/inc/layout.ftl"/>
<@layout>

<div class="row">
    <div class="col-md-4 col-md-offset-4 floating-box">
        <div class="panel panel-default">
            <div class="panel-heading">
                <span>
                    <a id="account_btn" onclick="account()" class="btn btn-primary btn-sm">用户名登录</a>&nbsp;
                    <a id="phone_btn" onclick="phone()" class="btn btn-default btn-sm">手机号登录</a>
                </span>
            </div>
            <div id="account" class="panel-body">
                <form method="POST" action="login" accept-charset="UTF-8">
                    <div class="form-group">
                        <label class="control-label" for="username">用户名</label>
                        <input class="form-control" name="username" type="text" placeholder="请输入用户名" required>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="password">密码</label>
                        <input class="form-control" name="password" type="password" placeholder="请输入密码" required>
                    </div>
                    <div class="form-group">
                        <label>
                            <input type="checkbox" name="rememberMe" value="1"> 记住登录
                        </label>
                        <span class="pull-right">
                            <a class="forget-password" href="${base}/user/forget">忘记密码？</a>
                        </span>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block">
                            登录
                        </button>
                    </div>
                </form>
            </div>
            <div id="phone" style="display: none" class="panel-body">
            <div class="form-group">
                <label class="control-label" for="username">手机号</label>
                <div class="input-group">
                    <input id="phone_inp" type="text" class="form-control" name="phone" maxlength="64" placeholder="请输入手机号"
                           required>
                    <span class="input-group-btn">
                                    <a class="btn btn-primary" href="javascript:void(0);" id="sendCode">
                                        <span id="dyMobileButton">获取验证码</span>
                                    </a>
                                </span>
                </div>
            </div>
                <div id="message_tex" style="color: red"></div>
            <div class="form-group ">
                <label class="control-label" for="code">验证码</label>
                <input class="form-control" id="code" name="code" type="text" placeholder="请输入验证码"
                       maxlength="6" required>
            </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">
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
                            "msgType": 2
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

</@layout>


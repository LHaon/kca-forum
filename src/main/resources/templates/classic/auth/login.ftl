<#include "/classic/inc/layout.ftl"/>
<@layout>

<div class="row">
    <div class="col-md-4 col-md-offset-4 floating-box">
        <div class="panel panel-default">
            <ul id="reset-method" class="nav tab-underline border-bottom">
                <li class="active border-primary"><a class="text-active-primary" href="#account"
                                                     data-toggle="tab">账号登录</a></li>
                <li class="border-primary"><a class="text-active-primary" href="#phone" data-toggle="tab">手机登录</a></li>
            </ul>
            <div id="account">
                <form method="POST" action="login" accept-charset="UTF-8">
                    <div class="form-group">
                        <label class="control-label" for="username">账号</label>
                        <input class="form-control" name="username" type="text" required>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="password">密码</label>
                        <input class="form-control" name="password" type="password" required>
                    </div>
                    <div class="form-group">
                        <label>
                            <input type="checkbox" name="rememberMe" value="1"> 记住登录
                        </label>
                        <span class="pull-right">
                            <a class="forget-password" href="${base}/forgot">忘记密码？</a>
                        </span>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block">
                            登录
                        </button>
                    </div>
                </form>
            </div>
            <div id="phone" style="display: none">
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

</script>

</@layout>


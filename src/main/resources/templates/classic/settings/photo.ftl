<#include "/classic/inc/layout.ftl"/>
<@layout "修改用户信息">

<div class="panel panel-default stacked">
	<div class="panel-heading">
		<ul class="nav nav-pills account-tab">
			<li class="active"><a href="/user/setting">基本信息</a></li>
			<li><a href="/user/setting/photo">修改头像</a></li>
			<li><a href="/user/setting/password">修改密码</a></li>
		</ul>
	</div>
	<div class="panel-body">
		<div id="message">
			<#include "/classic/inc/action_message.ftl"/>
		</div>
			<div class="upload-btn">
				<label>
					<span>点击选择一张图片</span>
					<input id="upload_btn" type="file" name="file" accept="image/*" title="点击添加图片">
				</label>
			</div>
			<div class="update_ava">
				<img style="width: 180px; height: 180px;" src="${profile.photoUrl}" id="target"
					 alt="[Example]" />
			</div>
	</div><!-- /panel-content -->
</div><!-- /panel -->

<script type="text/javascript">
    seajs.use('avatar');
</script>
</@layout>
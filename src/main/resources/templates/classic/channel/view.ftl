<#include "/classic/inc/layout.ftl"/>

<#assign title = view.title + ' - ' + view.user.nickname />
<#assign keywords = view.keywords?default(options['site_keywords']) />
<#assign description = view.description?default(options['site_description']) />

<@layout title>
<div class="row main">
    <div class="col-xs-12 col-md-9 side-left topics-show">
        <!-- view show -->
        <div class="topic panel panel-default">
            <div class="infos panel-heading">
                <h1 class="panel-title topic-title">${view.title}</h1>
                <div class="meta inline-block">
                    <a class="author" href="${http}/users/${view.user.id}">
                    ${view.user.nickname}
                    </a>
<#--                    <abbr class="timeago">${timeAgo(view.created)}</abbr>-->
                    <abbr>⋅ ${view.readCount} 阅读</abbr>
                </div>
                <div class="clearfix"></div>
            </div>

            <div class="content-body entry-content panel-body ">
                <div class="markdown-body">
                ${view.content}
                </div>
            </div>
            <div class="panel-footer operate">
                <#list view.tagsArray as tag>
                    <span>
                        <a class="label label-default" href="${http}/tag/${tag}/">#${tag}</a>
                    </span>
                </#list>
            </div>
            <div class="panel-footer">
                <div class="hidden-xs">
                    <div class="social-share" data-sites="qq, weibo, wechat, qzone, facebook, twitter, google"></div>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="more-box">
                <a class="btn btn-fulltext" data-toggle="fulltext">
                    <i class="icon icon-arrow-down" aria-hidden="true"></i> 阅读全部
                </a>
            </div>
        </div>

        <!-- Comments -->
<#--        <@controls name="comment">-->
        <div id="chat" class="chats shadow-box">
            <div class="chat_header">
                <h4>全部评论: <span id="chat_count">${view.commentCount}</span> 条</h4>
            </div>
            <ul id="comments" class="its">

            </ul>
            <div id="pager" class="text-center"></div>
            <div class="chat_post">
                <div class="cbox-title">我有话说: <span id="chat_reply" style="display:none;">@<i
                        id="chat_to"></i></span>
                </div>
                <div class="cbox-post">
                    <div class="cbox-input">
                        <textarea id="chat_text" rows="3" placeholder="请输入评论内容"></textarea>
                        <input type="hidden" value="0" name="chat_pid" id="chat_pid"/>
                    </div>
                    <div class="cbox-ats clearfix">
                        <div class="ats-func">
                            <div class="OwO" id="face-btn"></div>
                        </div>
                        <div class="ats-issue">
                            <button id="btn-chat" class="btn btn-success btn-sm bt">发送</button>
                        </div>
                    </div>
                </div>
                <div class="phiz-box" id="c-phiz" style="display:none">
                    <div class="phiz-list" view="c-phizs"></div>
                </div>
            </div>
        </div>
<#--        </@controls>-->
        <!-- /view show -->
    </div>
    <div class="col-xs-12 col-md-3 side-right hidden-xs hidden-sm">
        <ul class="list-group about-user">
            <li class="list-group-item user-card" >
                <div class="user-avatar">
                    <@utils.showAva view.user "img-circle"/>
                </div>
                <div class="user-name">
                    <span>${view.user.nickname}</span>
                </div>
            </li>

            <li class="list-group-item">
                <div class="user-datas">
                    <ul>
                        <li><strong>${view.user.textCount}</strong><span>发布</span></li>
                        <li class="noborder"><strong>${view.user.commentCount}</strong><span>评论</span></li>
                    </ul>
                </div>
            </li>
            <#if view.userLikeIds??>
                <li class="list-group-item">
                    <div class="text-center">
                        <a id="like_btn" class="btn btn-default btn-sm" href="#" text-id="${view.id}">
                            <i id="icon_control" class="iconfont icon-xihuan4"></i> 收藏 <strong
                                    id="like_count_val" likeCount="${view.likeCount}">${view.likeCount}</strong>
                        </a>
                    </div>
                </li>
            <#else>
                <li class="list-group-item">
                    <div class="text-center">
                        <a id="like_btn" class="btn btn-default btn-sm" href="#" text-id="${view.id}">
                            <i id="icon_control" class="iconfont icon-xihuan2"></i> 收藏 <strong
                                    id="like_count_val" likeCount="${view.likeCount}">${view.likeCount}</strong>
                        </a>
                    </div>
                </li>
            </#if>
        </ul>
        <#include "/classic/inc/right.ftl"/>
    </div>
</div>

<script type="text/plain" id="chat_template">
    <li id="chat{5}">
        <a class="avt fl" target="_blank" href="${http}/users/{0}">
            <img src="{1}">
        </a>
        <div class="chat_body">
            <h5>
                <div class="fl"><a class="chat_name" href="${http}/users/{0}">{2}</a><span>{3}</span></div>
                <div class="fr reply_this"><a href="javascript:void(0);" onclick="goto('{5}', '{2}')"><i class="icon icon-action-redo"></i></a></div>
                <div class="clear"></div>
            </h5>
            <div class="chat_p">
                <div class="chat_pct">{4}</div> {6}
            </div>
        </div>
        <div class="clear"></div>
        <div class="chat_reply"></div>
    </li>
</script>

<script type="text/javascript">

    function initComments() {
		$.ajax
		({
			cache: false,
			async: false,
			dataType: 'json', type: 'post',
			url: "${http}/comment/list/${view.id}",
			success: function (data) {
				var list = data.data;
				var htm = "";
				if (list.length < 1) {
					htm = '<li><p>还没有评论, 快来占沙发吧!</p></li>';
				} else {
					$('#comments').find("li").remove();
					$.each(list, function (index, item) {
						htm += ('<li id="chat3"><a class="avt fl" target="_blank" href="/users/' + item.user.id +
							'"><img src="' + item.user.photoUrl + '"> </a><div class="chat_body"><h5><div ' +
							'class="fl"><a class="chat_name" href="/users/' + item.user.id + '">' +
							item.user.nickname + '</a><span>' + item.createTime + '</span></div>' +
							'<div class="fr reply_this"><a href="javascript:void(0);" onclick="goto(\'' + item.id
                            +'\', ' +
                        '\''+ item.user.nickname +'\')' +
							'"><i class="icon icon-action-redo"></i></a></div>' +
							'<div class="clear"></div></h5><div class="chat_p"><div class="chat_pct">' +
							item.content + '</div></div></div><div class="clear"></div><div class="chat_reply"></div></li>');
					})
				}
				$('#comments').append(htm);
			}
		});
	}

	initComments();

	//收藏
	$('#like_btn').click(function () {
		$('#like_btn').removeAttr("disabled");
		if (!Authc.isAuthced()) {
			Authc.showLogin();
			return false;
		}
		var id = $(this).attr('text-id');
		var valu = $('#like_count_val').attr('likeCount');
		$.ajax({
			url: "${http}/user/like",
			type: "post",
			async: false,
			data: {
				"id" : id
			},
			dataType: "json",
			success: function (data) {
				if (data.code == 200) {
					layer.msg(data.message,{icon : 1});
					document.getElementById('icon_control').className = 'iconfont icon-xihuan4';
					$('#like_count_val').html(data.data);
				} else if(data.code == 202) {
					layer.msg(data.message,{icon : 2});
					document.getElementById('icon_control').className = 'iconfont icon-xihuan2';
					$('#like_count_val').html(data.data);
					// $('#like_count_val').html(data.data);
					// window.location.reload();
                }
				else  {
					layer.msg(data.data,{icon : 2});
				}
			},
			error: function (data) {
				layer.msg("服务器错误",{icon : 1});
			}
		});
	});

    function goto(pid, user) {
        document.getElementById('chat_text').scrollIntoView();
        $('#chat_text').focus();
        $('#chat_text').val('');
        $('#chat_to').text(user);
        alert(pid);
        $('#chat_pid').val(pid);

        $('#chat_reply').show();
    }
    var container = $("#chat_container");
    var template = $('#chat_template')[0].text;

    seajs.use(['comment', 'view'], function (comment) {
        comment.init({
            load_url: '${http}/comment/list/${view.id}',
            post_url: '${http}/comment/submit',
            toId: '${view.id}',
            onLoad: function (i, data) {
            	alert(i);
            	alert(data);
                var content = data.content;
                var quoto = '';
                alert(content);
                if (data.pid > 0 && !(data.parent === null)) {
                    var pat = data.parent;
                    var pcontent = pat.content;
                    quoto = '<div class="quote"><a href="${http}/users/' + pat.user.id + '">@' + pat.user.nickname +
                        '</a>: ' + pcontent + '</div>';
                }
                var item = jQuery.format(template,
                        data.user.id,
                        data.user.photoPreview,
                        data.user.nickname,
                        data.createTime,
                        content,
                        data.id, quoto);
                return item;
            }
        });
    });

	var Authc = {
		isAuthced: function () {
			return (typeof(_MTONS.LOGIN_TOKEN) !== 'undefined' && _MTONS.LOGIN_TOKEN.length > 0);
		},
		showLogin : function () {
			var that = this;
			$('#login_alert').modal();
			$('#ajax_login_submit').unbind().click(function () {
				that.doPostLogin();
			});
		},
		doPostLogin: function () {
			var un = $('#ajax_login_username').val();
			var pw = $('#ajax_login_password').val();
			jQuery.post(_MTONS.BASE_PATH + '/user/login', {'username': un, 'password': pw}, function (ret) {
				if (ret && ret.code == 200) {
					window.location.reload();
				} else {
					$('#ajax_login_message').text(ret.message).show();
				}
			});
		}
	};

</script>
</@layout>

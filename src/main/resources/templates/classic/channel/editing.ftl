<#include "/classic/inc/layout.ftl"/>
<@layout "编辑文章">

<form id="submitForm" class="form" action="${base}/texts/submit" method="post" enctype="multipart/form-data">
    <input type="hidden" name="status" value="${view.status!0}"/>
    <input type="hidden" name="editor" value="${editor!'tinymce'}"/>
    <div class="row">
        <div class="col-xs-12 col-md-8 side-left">
            <div id="message"></div>
            <#if view??>
                <input type="hidden" name="id" value="${view.id}"/>
                <input type="hidden" name="authorId" value="${view.authorId}"/>
            </#if>
            <input type="hidden" id="thumbnail" name="thumbnail" value="${view.photoPreview}"/>

            <div class="form-group">
                <input type="text" class="form-control" name="title" maxlength="128" value="${view.title}" placeholder="请输入标题" required>
            </div>
            <div class="form-group">
                <#include "/classic/channel/editor/markdown.ftl"/>
            </div>
        </div>
        <div class="col-xs-12 col-md-4 side-right">
            <div class="panel panel-default">
                <div class="thumbnail-box">
                    <div class="convent_choice" id="thumbnail_image"  <#if view.photoPreview?? && view.photoPreview?length
                    gt 0>
                        style="background: url(${view.photoPreview})" </#if>>
                        <div class="upload-btn">
                            <label>
                                <span>点击选择一张图片</span>
                                <input id="upload_btn" type="file" name="file" accept="image/*" title="点击添加图片">
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">标签(不同标签用空格分隔)&nbsp;</h3>
                </div>
                <div class="panel-body">
                    <input type="text" id="tags" name="tags" class="form-control" value="${view.tags}">
                </div>
            </div>
            <div id="text_judge_text" class="text-danger"></div>
            <div class="col-xs-12 col-md-12">
                <div class="form-group">
                    <div class="text-center">
                        <button id="sub" type="button" data-status="0" class="btn btn-primary" event="post_submit"
                                 style="padding-left: 30px; padding-right: 30px;">发布</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<!-- /form-actions -->
<script type="text/javascript">
	//文章内容验证
	$('#sub').click(function () {
		var text = $('#content').val();
		$.ajax({
			url: "http://localhost:11111/texts/judgeText",
			type: "post",
			async: false,
			data: {
				"text" : text,
			},
			dataType: "json",
			success: function (data) {
				if (data.code == 200) {
                    window.location.reload();
				} else  {
					$('#text_judge_text').html(data.message);
				}
			},
			error: function (data) {
				$('#text_judge_text').html("服务器错误");
			}
		});
	});


	seajs.use('post', function (post) {
	post.init();
});
</script>
</@layout>

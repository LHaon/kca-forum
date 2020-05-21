<#macro posts_item row escape=true>
<li class="content">
    <#if row.photoPreview?? && row.photoPreview?length gt 0>
        <div class="content-box">
            <div class="posts-item-img">
                <a href="${http}/texts/${row.id}" />
                    <div class="overlay"></div>
                    <img class="lazy thumbnail" src="${row.photoPreview}" style="display: inline-block;">
                </a>
            </div>
            <div class="posts-item posts-item-gallery">
                <h2><a href="${http}/texts/${row.id}"><#if escape>${row.title?html}<#else>${row.title}</#if></a></h2>
                <div class="item-text">${row.preview}</div>
                <div class="item-info">
                    <ul>
                        <li class="post-author hidden-xs">
                            <div class="avatar">
                                <img src="${row.user.photoUrl}" class="lazy avatar avatar-50 photo" height="50" width="50">
                            </div>
                            <a href="${http}/users/${row.userId}" target="_blank">${row.user.nickname}</a>
                        </li>
<#--                        <li class="ico-cat"><@utils.showChannel row/></li>-->
                        <li class="ico-time"><i class="icon-clock"></i>${row.createTime}</li>
                        <li class="ico-eye hidden-xs"><i class="icon-book-open"></i>${row.readCount}</li>
                        <li class="ico-like hidden-xs"><i class="icon-bubble"></i>${row.commentCount}</li>
                    </ul>
                </div>
            </div>
        </div>
    <#else>
        <div class="content-box posts-aside">
            <div class="posts-item">
                <div class="item-title">
                    <h2><a href="${http}/texts/${row.id}"><#if escape>${row.title?html}<#else>${row.title}</#if></a></h2>
                </div>
                <div class="item-text">${row.preview}</div>
                <div class="item-info">
                    <ul>
                        <li class="post-author hidden-xs">
                            <div class="avatar">
                                <img src="${row.user.photoUrl}" class="lazy avatar avatar-50 photo" height="50" width="50">
                            </div>
                            <a href="${http}/users/${row.userId}" target="_blank">${row.user.nickname}</a>
                        </li>
<#--                        <li class="ico-cat"><@utils.showChannel row/></li>-->
                        <li class="ico-time"><i class="icon-clock"></i>${row.createTime}</li>
                        <li class="ico-eye hidden-xs"><i class="icon-book-open"></i>${row.readCount}</li>
                        <li class="ico-like hidden-xs"><i class="icon-bubble"></i>${row.commentCount}</li>
                    </ul>
                </div>
            </div>
        </div>
    </#if>
</li>
</#macro>
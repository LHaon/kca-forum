<#include "/classic/inc/layout.ftl"/>

<@layout>

<div class="row">
    <div class="col-xs-12 col-md-9 side-left">
        <div class="posts">
            <@contents pageType=0>
            <ul class="posts-list">
                <#include "/classic/inc/posts_item.ftl"/>
                <#list results.data as row>
                    <@posts_item row/>
                </#list>
                <#if  results.data?size == 0>
                    <li class="content">
                        <div class="content-box posts-aside">
                            <div class="posts-item">该目录下还没有内容!</div>
                        </div>
                    </li>
                </#if>
            </ul>
            </@contents>
        </div>
        <#assign idx =0  />
        <div class="text-center">
            <ul class="pagination">
                <li class="disabled"><span>上一页</span></li>
                <#if (idx == 1)>
                    <li><span>...</span></li>
                <#elseif (pageNo == idx)>
                    <li class="active"><span>${idx}</span></li>
                <#else>
                    <li><a href="${url}${idx}">${idx}</a></li>
                </#if>
                <li class="disabled"><span>下一页</span></li>
            </ul>
<#--            <!-- Pager &ndash;&gt;-->
<#--            <@utils.pager request.requestURI!"", results, 5/>-->
        </div>
    </div>
    <div class="col-xs-12 col-md-3 side-right">
        <#include "/classic/inc/right.ftl"/>
    </div>
</div>

</@layout>
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
        <div class="text-center">
<#--            <!-- Pager &ndash;&gt;-->
<#--            <@utils.pager request.requestURI!"", results, 5/>-->
        </div>
    </div>
    <div class="col-xs-12 col-md-3 side-right">
        <#include "/classic/inc/right.ftl"/>
    </div>
</div>

</@layout>
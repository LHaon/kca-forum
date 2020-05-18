<#include "/classic/inc/layout.ftl"/>
<@layout>
    <div class="row">
        <div class="col-xs-12 col-md-9 side-left">
                <div class="posts">
                    <ul class="posts-list">
                        <#include "/classic/inc/posts_item.ftl"/>
                        <#list likes as row>
                            <@posts_item row/>
                        </#list>
                        <#if  likes?size == 0>
                            <li class="content">
                                <div class="content-box posts-aside">
                                    <div class="posts-item">你还没有收藏任何文章哦!</div>
                                </div>
                            </li>
                        </#if>
                    </ul>
                </div>

                <!-- Pager -->
<#--                <div class="text-center">-->
<#--                    <@utils.pager request.requestURI!"", likes, 5/>-->
<#--                </div>-->

        </div>

        <#--        <div class="col-xs-12 col-md-3 side-right">-->
        <#--            <#include "/classic/inc/right.ftl" />-->
        <#--        </div>-->

    </div>

</@layout>


<#include "/classic/inc/layout.ftl"/>
<@layout>
    <div class="row">
        <div class="col-xs-12 col-md-9 side-left">
            <div class="posts">
                <ul class="posts-list">
                    <#include "/classic/inc/posts_item.ftl"/>
                    <#list populars as row>
                        <@posts_item row/>
                    </#list>
                    <#if  populars?size == 0>
                        <li class="content">
                            <div class="content-box posts-aside">
                                <div class="posts-item">暂时还没有热门文章哦!</div>
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


<#import "parts/common.ftlh" as c>
<#import "parts/header.ftlh" as h>
<#import "parts/footer.ftlh" as f>

<@c.page "Rating", "/static/css/rating.css">
    <@h.page '0'></@h.page>

    <section class="rating">
        <div class="row col-lg-12 justify-content-center">
            <h1 class="rating__title">
                Rating
            </h1>
        </div>
        <div class="rating__table">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Username</th>
                    <th scope="col">Games</th>
                    <th scope="col">Average moves</th>
                </tr>
                </thead>
                <tbody>
                <#list ratings as rating >
                    <tr>
                        <th scope="row">${rating?index + 1}</th>
                        <td>${rating.user.username}</td>
                        <td>${rating.quantityGame}</td>
                        <td>${rating.averageQuantityMove}</td>
                    </tr>
                <#else>
                </#list>
                </tbody>
            </table>
        </div>
    </section>



<#--    <#list ratings as rating>-->
<#--        <div class="rating">-->
<#--            <div class="rating__username">-->
<#--                ${rating.user.username}-->
<#--            </div>-->
<#--            <div class="rating__quantity">-->
<#--                ${rating.quantityGame}-->
<#--            </div>-->
<#--            <div class="rating__average">-->
<#--                ${rating.averageQuantityMove}-->
<#--            </div>-->
<#--        </div>-->
<#--    </#list>-->
    <@f.page></@f.page>
</@c.page>
<#import "parts/common.ftlh" as c>
<#import "parts/header.ftlh" as h>
<#import "parts/footer.ftlh" as f>
<@c.page "Game", "/static/css/game.css">
    <@h.page '0'>
    </@h.page>

    <section class="primary">
        <div class="row">
            <div class="game col-lg-5">
                <form class="game__form d-flex" action="/game" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="hidden" name="gameId" value="${game.id}">
                    <label class="game__label">Enter number:</label>
                    <input class="game__input form-control" type="text"
                           name="number">


                    <input class="game_button" type="submit" value="run">
                </form>
            </div>
            <div class="game__table">
                <table class="table col-lg-5 table-sm">
                    <thead>

                    <tr>

                        <th scope="col">Number</th>
                        <th scope="col">Bulls</th>
                        <th scope="col">Cows</th>
                    </tr>


                    </thead>
                    <tbody>
                    <#list moves as move>
                        <tr>
                            <th scope="col">${move.number}</th>
                            <th scope="col">${move.bulls}</th>
                            <th scope="col">${move.cows}</th>
                        </tr>
                    <#else>

                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </section>

<#--    <form action="/game" method="post">-->
<#--        <input type="hidden" name="_csrf" value="${_csrf.token}">-->
<#--        <input type="hidden" name="gameId" value="${game.id}">-->
<#--        <label>enter number: <input type="text" name="number"></label>-->
<#--        <input type="submit" value="run">-->
<#--    </form>-->
<#--    <div class="container">-->

<#--        <#list moves as move>-->

<#--            <div class="container">-->
<#--                <p>${move.number}</p>-->
<#--                <p>${move.bulls}</p>-->
<#--                <p>${move.cows}</p>-->
<#--            </div>-->
<#--        <#else>-->

<#--        </#list>-->

    <@f.page>
    </@f.page>
</@c.page>
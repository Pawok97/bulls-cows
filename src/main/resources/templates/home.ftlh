<#import "parts/common.ftlh" as c>
<#import "parts/header.ftlh" as h>
<#import "parts/footer.ftlh" as f>


<@c.page "Home", "/static/css/home.css">
    <@h.page '0'></@h.page>
    <section class="preview">
        <div class="row col-lg-12 justify-content-center">
            <h1 class="preview__title">Hello, ${user.firstName}</h1>
        </div>
        <div class="row col-lg-12 justify-content-center">
            <div class="rating d-flex">
                <div class="rating__item">
                    games won: ${rating.quantityGame}
                </div>
                <div class="rating__item">
                    average quantity moves: ${rating.averageQuantityMove}
                </div>
            </div>
            <div class="rating__text col-lg-8">
                Bulls and Cows Game is also known as MasterMind. Computer selects a four digit number, all four digits
                are
                different. In current implementation number may not begin with 0.
                <br> Play by entering your guess in the input and click "Run" to validate your entry. You
                may also click <br>"New Game" to start game.
            </div>
        </div>
        <div class="button col-lg-12">
            <form action="/" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input class="btn btn-secondary" type="submit" value="New Game">
            </form>
        </div>
    </section>

    <@f.page>
    </@f.page>
</@c.page>
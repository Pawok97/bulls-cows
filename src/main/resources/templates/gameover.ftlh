<#import "parts/common.ftlh" as c>
<#import "parts/header.ftlh" as h>
<#import "parts/footer.ftlh" as f>

<@c.page "Game", "/static/css/gameover.css">
<@h.page '0'></@h.page>
    <div class="offer col-lg-12">
        <h1 class="offer__title">You won!</h1>
        <h3 class="offer_return">Press to the home?</h3>
        <a class="offer__yes btn btn-secondary" href="/">Yes</a>
    </div>
    <@f.page></@f.page>
</@c.page>
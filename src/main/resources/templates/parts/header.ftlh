<#macro page boolean>
    <#if boolean=='1'>
        <header class="header">
            <div class="row">
                <div class="col-lg-10 d-flex">
                    <div class="header__logo">
                        <img src="/static/img/logo.png" alt="logo">
                    </div>
                    <div class="header__title">Bulls and Cows</div>
                </div>
                <div class="header__login">
                    <div class="col-lg-2 ml-auto">
                        <a href="/registration" class="btn btn-light">Sign Up</a>
                    </div>
                </div>
            </div>
        </header>
    <#elseif boolean=='2'>
        <header class="header">
            <div class="row">
                <div class="col-lg-10 d-flex">
                    <div class="header__logo">
                        <img src="/static/img/logo.png" alt="logo">
                    </div>
                    <div class="header__title">Bulls and Cows</div>
                </div>
                <div class="header__login">
                    <div class="col-lg-2 ml-auto">
                        <a href="/login" class="btn btn-light">Sign In</a>
                    </div>
                </div>
            </div>
        </header>
    <#else>
        <header class="header">
            <div class="row">
                <div class="col-lg-10 d-flex">
                    <div class="header__logo">
                        <img src="/static/img/logo.png" alt="logo">
                    </div>
                    <div class="header__title">
                        Bulls and Cows
                    </div>
                    <nav>
                        <ul class="menu d-flex">
                            <li class="menu__item">
                                <a href="/">Home</a>
                            </li>
                            <li class="menu__item">
                                <a href="/rating">Rating</a>
                            </li>
                        </ul>
                    </nav>
                </div>
                <div class="header__login">
                    <div class="col-lg-2 ml-auto">
                        <form action="/logout" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <input class="btn btn-light" type="submit" value="sign out">
                        </form>
                    </div>
                </div>
            </div>
        </header>
    </#if>


</#macro>
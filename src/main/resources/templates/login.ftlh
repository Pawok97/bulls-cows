<#import "parts/common.ftlh" as c>
<#import "parts/header.ftlh" as h>
<#import "parts/footer.ftlh" as f>
<@c.page "login", "/static/css/login.css">
    <@h.page '1'>
    </@h.page>
    <section class="login">
        <div class="row col-lg-12 d-block">
            <h1 class="login__title">Sing In</h1>
        </div>
        <div class="login__form">
            <form action="/login" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <div class="form__username d-flex col-lg-4 ml-4">
                    <label class="form__label">
                        Username
                    </label>
                    <input type="text" name="username"
                           class="form__input form-control ${(usernameError??)?string('is-invalid','')}">

                </div>
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>


                <div class="form__password d-flex col-lg-4 ml-4">
                    <label class="form__label">Password</label>
                    <input type="password" name="password"
                           class="form__input form-control ${(passwordError??)?string('is-invalid','')}">
                </div>
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>


                <div class="row">
                    <input class="form__submit btn btn-secondary col-lg-1" type="submit" value="Sign in">
                </div>
            </form>
        </div>
    </section>
    <@f.page>
    </@f.page>
</@c.page>
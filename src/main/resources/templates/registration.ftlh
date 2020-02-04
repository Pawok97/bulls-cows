<#import "parts/common.ftlh" as c>
<#import "parts/header.ftlh" as h>
<#import "parts/footer.ftlh" as f>


<@c.page "Registration", "/static/css/login.css">
    <@h.page '2'>

    </@h.page>
    <section class="registration">

        <div class="registration__title">
            Create new user
        </div>
        <div class="form">
            <form action="/registration" method="post">

                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <div class="row form__item d-flex col-lg-5 ml-4">
                    <label class="registration__formLabel">
                        First Name:
                    </label>
                    <input type="text" name="firstName"
                           class="form__input form-control ${(firstNameError??)?string('is-invalid', '')}">
                    <#if firstNameError??>
                        <div class="row feed">
                    <span class="feed__text">
                        ${firstNameError}
                    </span>
                        </div>
                    </#if>
                </div>
                <div class="row form__item d-flex col-lg-5 ml-4">
                    <label class="registration__formLabel">
                        Last Name:
                    </label>
                    <input type="text" name="lastName"
                           class="form__input form-control ${(lastNameError??)?string('is-invalid', '')}">
                    <#if lastNameError??>
                        <div class="row feed">
                    <span class="feed__text">
                        ${lastNameError}
                    </span>
                        </div>
                    </#if>
                </div>
                <div class="row form__item d-flex col-lg-5 ml-4">
                    <label class="registration__formLabel">
                        Username:
                    </label>
                    <input type="text" name="username"
                           class="form__input form-control ${(usernameError??)?string('is-invalid', '')}">
                    <#if usernameError??>
                        <div class="row feed">
                    <span class="feed__text">
                        ${usernameError}
                    </span>
                        </div>
                    </#if>
                </div>
                <div class="row form__item d-flex col-lg-5 ml-4">
                    <label class="registration__formLabel">
                        Password:
                    </label>
                    <input type="password" name="password"
                           class="form__input form-control ${(passwordError??)?string('is-invalid','')}">
                    <#if passwordError??>
                        <div class="row feed">
                    <span class="feed__text">
                        ${passwordError}
                    </span>
                        </div>
                    </#if>
                </div>
                <div class="row form__item d-flex col-lg-5 ml-4">
                    <label class="registration__formLabel">
                        Password check:
                    </label>
                    <input type="password" name="passwordCheck"
                           class="form__input form-control ${(passwordCheckError??)?string('is-invalid','')}">
                    <#if passwordCheckError??>
                        <div class="row feed">
                    <span class="feed__text">
                        ${passwordCheckError}
                    </span>
                        </div>
                    </#if>
                </div>

                <div class="row">
                    <input class="registration__submit btn btn-dark col-lg-1" type="submit" value="Sign up">
                </div>
            </form>
        </div>
    </section>

    <@f.page>
    </@f.page>
</@c.page>
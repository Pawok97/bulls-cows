<#macro page title, path>
    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">

        <title>${title}</title>
        <link href="https://fonts.googleapis.com/css?family=Miltonian+Tattoo&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=PT+Sans:400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="/static/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="/static/css/header.css">
        <link rel="stylesheet" href="${path}">
    </head>
    <body>

    <#nested>

    </body>
    </html>
</#macro>
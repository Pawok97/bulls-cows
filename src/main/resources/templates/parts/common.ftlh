<#macro page title, path>
    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

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

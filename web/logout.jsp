<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>        
        <title>WebOrganizer: Logout</title>
        
        <link rel="shortcut icon" type="image/vnd.microsoft.icon" href="VAADIN/themes/runo/favicon.ico" />
        <link rel="icon" type="image/vnd.microsoft.icon"          href="VAADIN/themes/runo/favicon.ico" />

        <link rel="stylesheet" type="text/css"                    href="style.css" />        
    </head>
    <body>
        <div id='pagecontainer'>
            <h1>Успешно излязохте от органайзера</h1>
            <p><a href=".">Влезте</a> пак.</p>
        </div>
    </body>
</html>
<% session.invalidate(); %>

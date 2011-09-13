<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebOrganizer Home Page</title>        
        
        <link rel="shortcut icon" type="image/vnd.microsoft.icon" href="VAADIN/themes/runo/favicon.ico" />
        <link rel="icon" type="image/vnd.microsoft.icon"          href="VAADIN/themes/runo/favicon.ico" />

        <link rel="stylesheet" type="text/css"                    href="style.css" />        
        
    </head>
    <body>
        <div id='pagecontainer'>
            <h1>Добре дошли в WebOrganizer</h1>

            Моля, въведете вашето потребителско име и парола:
            <form method="post" action="app/Home/loginHandler">
                <div class='lfloat r'>
                   Име:<br/>Парола: 
                </div>
                <div class='lfloat'>
                   <input type="text" name="username"/>         
                   <br/><input type="password" name="password"/>  
                </div>
                <div style='clear:both'></div>
                <input class='submit' type="submit" value="Вход"/>              
            </form>
        </div>
    </body>
</html>

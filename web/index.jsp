<%-- 
    Document   : index
    Created on : 26/09/2014, 13:31:14
    Author     : pablo.ferreira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="inicial.css"/>
        <title>Cadastro de Cliente</title>
    </head>
    <body>
        <form method="POST" id="formLogin">
            <fieldset>
                <legend>Cadastre-se</legend>
                <p><label for="cNome">Nome:</label>
                    <input type="text" name="tNome" id="cNome" size="40" maxlength="30"placeholder="Nome Completo"/></p>

                <p><lable>E-mail:</label>
                    <input type="email" name="tEmail" id="cEmail" size="30" maxlength="40"/></p>

                    <p><label for="cSenha">Senha:</label>
                        <input type="password" name="tSenha" id="cSenha" size="15" maxlength="8" placeholder="Digita uma senha"/></p>

                    <input type="submit" value="Enviar Dados"/>           
            </fieldset>
        </form>
    </body>
</html>

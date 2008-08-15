<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>DCE</title>
<link href="estilos/estilo.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/autenticacao.js"></script>
</head>
<body>
    <div id="container">
        <div id="topo">		
        	<div id="titulo">DCE - Diário de Classe Eletrônico</div>			
        </div>
        <div id="principal">
        	<div id="frmLogin">
            	<form id="formLogin" name="formLogin" method="get" action="autenticar" onSubmit="return validarCampos()">
                  	<label>Usuário:</label>
					<input type="text" id="usuario" name="usuario" ></input>
                  	<label>Senha:</label><input id="senha" type="password" name="senha" ></input>
                  	<label>Tipo:</label>
					<select name="tipoUsuario">
                    	<option value="professor">Professor</option>
                    	<option value="administrador">Administrador</option>
                  	</select>
                  	<input class="botao" id="ok" type="submit" name="ok" value="OK"></input>
                  	<input class="botao" id="lembrarSenha" type="submit" name="lembrarSenha" value="Lembrar Senha?"></input>
        	</div>
        </div>
        <div id="rodape"/>
        </div>	
    </div>
</body>
</html>
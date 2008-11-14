<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>DCE</title>
<link href="estilos/estilo.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/autenticacao.js"></script>
<% 
	String msgErro = "";
	if(request.getAttribute("msgErro") != null){
		msgErro = (String)request.getAttribute("msgErro");
	}
%>
</head>
<body>
    <div id="container">
        <div id="topo">			
        </div>
        <div id="principal">
        	<div id="frmLogin">
            	<form id="formLogin" name="formLogin" method="post" action="dce.do">
					<label class="labelErro"><%=msgErro%></label>
                  	<label>Usuário:</label>
					<input type="text" id="usuario" name="usuario" maxlength="20"/>
                  	<label>Senha:</label><input id="senha" type="password" name="senha" maxlength="20"/>
                  	<label>Tipo:</label>
					<select name="tipoUsuario">
                    	<option value="professor">Professor</option>
                    	<option value="administrador">Administrador</option>
                  	</select>
                  	<input OnClick="ok()" class="botao" type="button" value="OK"/>
                  	<input OnClick="lembrarSenha()" class="botao" type="button" value="Lembrar Senha?"/>
					<input type="hidden" name="acao" value=""/>
				</form>
        	</div>
        </div>
        <div id="rodape"/>
    </div>
</body>
</html>
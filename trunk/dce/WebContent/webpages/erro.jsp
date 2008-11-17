<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1" isErrorPage="true" %>  
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	String erro = (String) request.getAttribute("msgErro");
	if (erro == null || erro.equals("")) {
    	erro = "Erro ao realizar operação. Por favor contacte o suporte.";
    }
	String acao = "AutenticacaoAction";
	if(request.getParameter("acao") != null){
		acao = request.getParameter("acao");
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>DCE</title>
<link href="estilos/estilo.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/erro.js"></script>
</head>
<body>
    <div id="container">
        <div id="topo">	
        </div>
        <div id="principal">
			<div id="frmLogin">
				<form id="formErro" name="formErro">
					<span id="sair">
						<a onclick="sair()" href="#"><img style="float: right; border:0;" alt="SAIR" src="imagens/sair.jpg"/></a>
					</span>
					<input type="hidden" id="acao" name="acao" value="<%=acao%>"/>
					<label class="labelErro"><%=erro%></label>
					<br>
					<input class="botao" id="voltar" type="submit" name="voltar" value="Voltar"/>
				</form>
			</div>
        </div>
        <div id="rodape"/>	
    </div>
</body>
</html>
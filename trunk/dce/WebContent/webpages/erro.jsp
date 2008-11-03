<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1" isErrorPage="true" %>  
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	String erro = (String) request.getAttribute("msgErro");
	if (erro == null || erro.equals("")) {
    	erro = "Erro ao realizar operação. Por favor contacte o suporte.";
    }
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>DCE</title>
<link href="estilos/estilo.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div id="container">
        <div id="topo">	
        </div>
        <div id="principal">
			<div id="frmLogin">
				<label class="labelErro"><%=erro%></label>
				<br>
				<input class="botao" id="voltar" type="submit" onclick="javascript:history.go(-1)" name="voltar" value="Voltar"/>
			</div>
        </div>
        <div id="rodape"/>	
    </div>
</body>
</html>
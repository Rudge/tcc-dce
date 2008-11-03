<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>

<%@page import="com.unisa.tcc.form.ProfessorForm"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.unisa.tcc.form.AlunoForm"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>DCE</title>
<link href="estilos/estilo.css" rel="stylesheet" type="text/css" />
<% 
	List<AlunoForm> listaAlunos= null;
	ProfessorForm professor = (ProfessorForm)session.getAttribute("usuario");
	if(request.getAttribute("listaAlunos") != null){
		listaAlunos = (List<AlunoForm>)request.getAttribute("listaAlunos");
	}
%>
</head>
<body>
    <div id="container">
        <div id="topo">				
        </div>
        <div id="principal">
			<form id="formCalendar" name="formCalendar" method="post" action="dce.do">
            	<input type="hidden" id="dataEscolhida" name="dataEscolhida" value=""/>
				<input type="hidden" name="acao" value="ConsultaCalendarioChamadasAction"/>
				<input type="hidden" id="idChamada" name="idChamada" value="" />
				Olá, Professor <%=professor.getNome()%>.
				<div id="calendario">
				</div>
				<%
					if(listaAlunos != null && !listaAlunos.isEmpty()){
						for (AlunoForm aluno : listaAlunos) {
							
						}
					}
				%>
			</form>
        </div>
    	<div id="rodape">
		</div>	
</body>
</html>
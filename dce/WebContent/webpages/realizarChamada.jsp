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
<script type="text/javascript" src="js/realizarChamada.js"></script>
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
			<form id="formChamada" name="formChamada" method="post" action="dce.do">
            	<input type="hidden" id="dataEscolhida" name="dataEscolhida" value=""/>
				<input type="hidden" name="acao" value=""/>
				<input type="hidden" id="idChamada" name="idChamada" value="" />
				Olá, Professor <%=professor.getNome()%>.
				<table>
				<%
					if(listaAlunos != null && !listaAlunos.isEmpty()){%>
					   <tr>
							<th>Presença</th>
							<th>Matricula</th>
							<th>Nome</th>
					   </tr>
					   <% for (AlunoForm aluno : listaAlunos) {%>
						<tr>
							<td>SIM<input type="radio" id="<%=aluno.getMatricula()%>presenca" name="chamada<%=aluno.getMatricula()%>" value="true"/>
							NÃO<input type="radio" id="<%=aluno.getMatricula()%>falta" name="chamada<%=aluno.getMatricula()%>" value="false"/></td>
						<%
							if(aluno.isPresenca()){ %>
							<script>
								marcarOpcaoRadio(<%=aluno.getMatricula()%> + "presenca");
							</script>	
						<%	}else{  %>
							<script>
								marcarOpcaoRadio(<%=aluno.getMatricula()%> + "falta");
							</script>
						<%	} %>
							<td><%=aluno.getMatricula()%></td>
							<td><%=aluno.getNome()%></td>
						</tr>
					  <%}
					}
				%>
				</table>
			</form>
        </div>
    	<div id="rodape">
		</div>	
</body>
</html>
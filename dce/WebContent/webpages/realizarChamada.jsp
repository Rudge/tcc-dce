<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>

<%@page import="com.unisa.tcc.form.ProfessorForm"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.unisa.tcc.form.AlunoForm"%>


<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="com.unisa.tcc.form.ChamadaForm"%>
<%@page import="java.util.Date"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>DCE</title>
<script type="text/javascript" src="js/realizarChamada.js"></script>
<link href="estilos/estilo.css" rel="stylesheet" type="text/css" />
<%
	List<AlunoForm> listaAlunos = null;
	ProfessorForm professor = (ProfessorForm)session.getAttribute("usuario");
	if(request.getSession().getAttribute("listaAlunos") != null){
		listaAlunos = (List<AlunoForm>)request.getSession().getAttribute("listaAlunos");
	}
	String data = "";
	if(session.getAttribute("dataEscolhida") != null){
		data = (String) session.getAttribute("dataEscolhida");
	}
	int ano = 0, mes = 0, dia = 0;
	
	if(data != null && !"".equals(data)){
		String[] arrData = data.split("-");
		ano = Integer.parseInt(arrData[0]);
		mes = Integer.parseInt(arrData[1]);
		dia = Integer.parseInt(arrData[2]);
	}
	
	Calendar calendario = Calendar.getInstance();
	
	ChamadaForm chamada = null;
	if(request.getAttribute("chamada") != null){
		chamada = (ChamadaForm) request.getAttribute("chamada");
	}
%>
</head>
<body>
    <div id="container">
        <div id="topo">				
        </div>
        <div id="principal">
			<form id="formChamada" name="formChamada" method="post" action="dce.do">
				<span id="sair" style="width:365px;">
					<a onclick="sair()" href="#"><img style="float: right; border:0;" alt="SAIR" src="imagens/sair.jpg"/></a>
				</span>
				<input type="hidden" name="acao" value=""/>
				<input type="hidden" name="idChamada" value="<%=chamada.getId()%>"/>
				<input type="hidden" name="idClasse" value="<%=chamada.getClasse().getId()%>"/>
				<label class="labelTitulo">
				<% 
					if(chamada != null){ 
						out.print(chamada.getDisciplina().getNome() + " - " + chamada.getClasse().getSerie() + 
						"º" + chamada.getClasse().getTurma() + " - Sala:" + chamada.getClasse().getDescricaoSala() 
						+ " - " + dia + "/" + mes + "/" + ano);
					}
				%>
				</label>
				<br>
				<br>
				<table>
				<%
					if(listaAlunos != null && !listaAlunos.isEmpty()){
						int corLinha = 0;
					%>
						<tr>
							<th>Presença</th>
							<th>Matricula</th>
							<th>Nome</th>
					   </tr>
					   <% for (AlunoForm aluno : listaAlunos) {
					   	if(corLinha % 2 == 0){
					   %>
						<tr style="background:#DCDCDC">
						<%}else{%>
						<tr>
						<%}%>
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
						<%	} 
							if( calendario.get(Calendar.DAY_OF_MONTH) != dia || 
								calendario.get(Calendar.MONTH) != mes-1 ||
							    calendario.get(Calendar.YEAR) != ano){%>
								<script>
									desabilitarOpcaoRadio(<%=aluno.getMatricula()%>);
								</script>
						<%	} %>
							<td><%=aluno.getMatricula()%></td>
							<td><%=aluno.getNome()%></td>
						</tr>
					  <% corLinha++;
					   }
					}
				%>
				</table>
				<input OnClick="salvar()" class="botao" type="button" value="Salvar"/>
                <input OnClick="voltar()" class="botao" type="button" value="Voltar"/>
			</form>
        </div>
    	<div id="rodape">
		</div>	
</body>
</html>
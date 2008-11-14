<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>

<%@page import="com.unisa.tcc.form.ProfessorForm"%>
<%@page import="java.util.List"%>
<%@page import="com.unisa.tcc.form.ChamadaForm"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.HashMap"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>DCE</title>
<link href="estilos/estilo.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="estilos/demos.css" media="screen" type="text/css">
<% 
	List<ChamadaForm> listaChamadas = null;
	ProfessorForm professor = (ProfessorForm)session.getAttribute("usuario");
	if(request.getAttribute("listaChamadas") != null){
		listaChamadas = (List<ChamadaForm>)request.getAttribute("listaChamadas");
	}
	String data = "";
	if(session.getAttribute("dataEscolhida") != null){
		data = (String) session.getAttribute("dataEscolhida");
	}
	HashMap<Integer,ChamadaForm> mapChamadas = new HashMap<Integer,ChamadaForm>();
%>
<script type="text/javascript" src="js/consultaChamada.js"></script>
<script type="text/javascript" src="js/dhtmlSuite-common.js"></script>
<script type="text/javascript">
	DHTMLSuite.include("calendar");
</script>
</head>
<body>
    <div id="container">
        <div id="topo">				
        </div>
        <div id="principal">
			<form id="formCalendar" name="formCalendar" method="post" action="dce.do">
            	<input type="hidden" id="dataEscolhida" name="dataEscolhida" value="<%=data%>"/>
				<input type="hidden" name="acao" value="ConsultaCalendarioChamadasAction"/>
				<input type="hidden" id="idChamada" name="idChamada" value="" />
				Olá, Professor <%=professor.getNome()%>.
				<div id="calendario">
				</div>
				<%
					if(listaChamadas != null && !listaChamadas.isEmpty()){
						out.println("<BR>Aulas: <BR>");
						for (ChamadaForm chamada : listaChamadas) {
							out.println("<a onclick=\"escolherChamada("+ chamada.getId() + ")\" href=\"#\" >" + chamada.getHoraAula() + " - " + chamada.getDisciplina().getNome() + " - " + chamada.getClasse().getSerie() + 
										"º" + chamada.getClasse().getTurma() + " - Sala:" + chamada.getClasse().getDescricaoSala() + "</a>" + "<br>");
							mapChamadas.put(chamada.getId(),chamada);
						}
						request.getSession().setAttribute("mapChamadas",mapChamadas);
					}
				%>
			</form>
        </div>
    	<div id="rodape">
		</div>	
	<script type="text/javascript">	
		var moldeCalendar = new DHTMLSuite.calendarModel();
		moldeCalendar.setLanguageCode('pt-br');
		moldeCalendar.setInitialDateFromInput(document.getElementById("dataEscolhida"),'yyyy-mm-dd');
		var calendarioObj = new DHTMLSuite.calendar({minuteDropDownInterval:10,numberOfRowsInHourDropDown:5,callbackFunctionOnDayClick:'getDataCalendario',isDragable:false,displayTimeBar:false});
		calendarioObj.setCalendarModelReference(moldeCalendar);
		function carregarCalendario()
		{
			if(document.getElementById("dataEscolhida").value == ""){
				var date = new Date();
				var dataAtual = date.getFullYear() + '-' + (date.getMonth()+1) + '-' + date.getDate();
				document.getElementById("dataEscolhida").value = dataAtual;
			}
			moldeCalendar.setInitialDateFromInput(document.getElementById("dataEscolhida"),'yyyy-mm-dd');
			calendarioObj.addHtmlElementReference('dataEscolhida',document.formCalendar.dataEscolhida);
			calendarioObj.setDisplayCloseButton(false);
			if(!calendarioObj.isVisible()){
				calendarioObj.setTargetReference('calendario');
				calendarioObj.display();
			}
		}	
		function getDataCalendario(inputArray)
		{
			var referencia = calendarioObj.getHtmlElementReferences();
			referencia.dataEscolhida.value = inputArray.year + '-' + inputArray.month + '-' + inputArray.day;
			document.getElementById("formCalendar").acao.value = "ConsultaCalendarioChamadasAction";
			document.formCalendar.submit();
		}	
		window.onload = carregarCalendario;
	</script>
</body>
</html>
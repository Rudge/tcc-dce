<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>

<%@page import="com.unisa.tcc.form.ProfessorForm"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>DCE</title>
<link href="estilos/estilo.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="estilos/demos.css" media="screen" type="text/css">
<% 
	ProfessorForm professor = (ProfessorForm)session.getAttribute("usuario");
%>
<script type="text/javascript" src="js/dhtmlSuite-common.js"></script>
<script type="text/javascript">
	DHTMLSuite.include("calendar");
</script>
</head>
<body>
    <div id="container">
        <div id="topo">		
        	<div id="titulo">DCE - Diário de Classe Eletrônico</div>			
        </div>
        <div id="principal">
			<form id="formCalendar" name="formCalendar">
            	<input type="hidden" id="dataEscolhida" name="dataEscolhida" value=""/>
				Olá, Professor <%=professor.getNome()%>.
            </form>
			<div id="calendario">
			</div>
        </div>
    	<div id="rodape">
		</div>	
	<script type="text/javascript">	
		var moldeCalendar = new DHTMLSuite.calendarModel();
		moldeCalendar.setLanguageCode('pt-br')
		var calendarioObj = new DHTMLSuite.calendar({minuteDropDownInterval:10,numberOfRowsInHourDropDown:5,callbackFunctionOnDayClick:'getDataCalendario',isDragable:false,displayTimeBar:false});
		calendarioObj.setCalendarModelReference(moldeCalendar);
		function carregarCalendario()
		{
			var date = new Date();
			var dataAtual = date.getFullYear() + '-' + (date.getMonth()+1) + '-' + date.getDate();
			document.getElementById("dataEscolhida").value = dataAtual;
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
			referencia.dataEscolhida.value = inputArray.day + '-' + inputArray.month + '-' + inputArray.year;
		}	
		window.onload = carregarCalendario;
	</script>
</body>
</html>
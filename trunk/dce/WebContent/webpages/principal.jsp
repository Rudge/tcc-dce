<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1" isErrorPage="true" %>  
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>DCE</title>
<link href="estilos/estilo.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="estilos/demos.css" media="screen" type="text/css">
<script type="text/javascript" src="js/dhtmlSuite-common.js"></script>
<script type="text/javascript">
	this.DHTMLSuite.include("calendar");
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
            </form>
        </div>
		<script type="text/javascript">
			//var moldeCalendar = new this.DHTMLSuite.calendarModel({languageCode:'pt-br'});
			var calendarioObj = new this.DHTMLSuite.calendar({minuteDropDownInterval:10,numberOfRowsInHourDropDown:5,callbackFunctionOnDayClick:'getDataCalendario',isDragable:false,displayTimeBar:false});
			//calendarioObj.setCalendarModelReference(moldeCalendar);
			
			function carregarCalendario()
			{
				var date = new Date();
				var dataAtual = date.getFullYear() + '-' + (date.getMonth()+1) + '-' + date.getDate();
				document.getElementById("dataEscolhida").value = dataAtual;
			//	calendarioObj.addHtmlElementReference('dataEscolhida',document.formCalendar.dataEscolhida);
				calendarioObj.setDisplayCloseButton(false);
				if(!calendarioObj.isVisible()){
					calendarioObj.setTargetReference('principal');
					calendarioObj.display();
				}		
			}	
			function getDataCalendario(inputArray)
			{
				var referencia = calendarioObj.getHtmlElementReferences();
				referencia.dataEscolhida.value = inputArray.day + '-' + inputArray.month + '-' + inputArray.year;
			}	
		</script>
		<script type="text/javascript">
        	carregarCalendario();
        </script>
    	<div id="rodape"/>	
    </div>
</body>
</html>
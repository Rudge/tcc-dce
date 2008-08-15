<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1" isErrorPage="true" %>  
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SAE</title>
<link href="estilos/estilo.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="../estilos/demos.css" media="screen" type="text/css">
<script type="text/javascript" src="../js/dhtmlSuite-common.js"></script>
<script type="text/javascript">
	var dhtml = new DHTMLSuite();
	dhtml.include("calendar");
	var moldeCalendar = dhtml.calendarModel();
	moldeCalendar.setLanguageCode('pt-br');
	var calendarioObj = dhtml.calendar({minuteDropDownInterval:10,numberOfRowsInHourDropDown:5,callbackFunctionOnDayClick:'getDateFromCalendar',isDragable:false,displayTimeBar:false});
	calendarioObj.setCalendarModelReference(moldeCalendar);
	
	function pickDate()
	{
		var date = new Date();
		var dataAtual = date.getFullYear() + '-' + (date.getMonth()+1) + '-' + date.getDate();
		document.formCalendar.dataClick.value = dataAtual;
		calendarioObj.addHtmlElementReference('dataClick',document.formCalendar.dataClick);
		calendarioObj.setDisplayCloseButton(false);
		if(!calendarioObj.isVisible()){
			calendarioObj.display();
		}		
	}	
	/* inputArray is an associative array with the properties
	year
	month
	day
	hour
	minute
	calendarRef - Reference to the DHTMLSuite.calendar object.
	*/
	function getDateFromCalendar(inputArray)
	{
		var referencia = calendarioObj.getHtmlElementReferences();
		referencia.dataClick.value = inputArray.day + '-' + inputArray.month + '-' + inputArray.year  ;
		
	}	
</script>
</head>
<body>
    <div id="container">
        <div id="topo">		
        	<div id="titulo">SAE - Sistema de Administração Escolar</div>			
        </div>
        <div id="principal">
			<form id="formCalendar" name="formCalendar">
              <input type="hidden" name="dataClick" value=""/>
               <script type="text/javascript">
                    pickDate();
               </script> 
            </form>
        </div>
        <div id="rodape"/>	
    </div>
</body>
</html>
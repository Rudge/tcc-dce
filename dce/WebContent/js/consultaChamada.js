function escolherChamada(idChamada){
	document.getElementById("formCalendar").idChamada.value = idChamada;
	document.getElementById("formCalendar").acao.value = "RealizarChamadaAction";
	document.formCalendar.submit();
}
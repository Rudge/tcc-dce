function escolherChamada(idChamada){
	document.getElementById("formCalendar").idChamada.value = idChamada;
	document.getElementById("formCalendar").acao.value = "ConsultaChamadaAction";
	document.formCalendar.submit();
}
function escolherChamada(idChamada, idClasse){
	document.getElementById("formCalendar").idChamada.value = idChamada;
	document.getElementById("formCalendar").idClasse.value = idClasse;
	document.getElementById("formCalendar").acao.value = "RealizarChamadaAction";
	document.formCalendar.submit();
}

function sair(){
	document.getElementById("formCalendar").acao.value = "SairAction";
	document.formCalendar.submit();
}
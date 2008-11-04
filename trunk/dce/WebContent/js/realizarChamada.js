function marcarOpcaoRadio(idRadio) {
	var elementoRadio = "document.getElementById('"+ idRadio +"').checked = true;";
	eval(elementoRadio);
}

function voltar(){
	document.getElementById("formChamada").acao.value = "ConsultaCalendarioChamadasAction";
	document.formChamada.submit();
}

function salvar(){
	document.getElementById("formChamada").acao.value = "ConsultaCalendarioChamadasAction";
	document.formChamada.submit();
}
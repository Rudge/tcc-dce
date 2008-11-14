var radioDesabilitados = false;

function marcarOpcaoRadio(idRadio) {
	var elementoRadio = "document.getElementById('"+ idRadio +"').checked = true;";
	eval(elementoRadio);
}

function voltar(){
	document.getElementById("formChamada").acao.value = "ConsultaCalendarioChamadasAction";
	document.formChamada.submit();
}

function salvar(){
	if(/*radioDesabilitados != */ true){
		document.getElementById("formChamada").acao.value = "SalvarChamadaAction";
		document.formChamada.submit();
	}else{
		alert('Não é possível salvar a chamada, pois a data escolhida é diferente do dia atual.');
	}
}

function desabilitarOpcaoRadio(matricula) {
	var elementoRadioPresenca = "document.getElementById('" + matricula + "presenca').disabled = true;";
	var elementoRadioFalta = "document.getElementById('" + matricula + "falta').disabled = true;";
	eval(elementoRadioPresenca);
	eval(elementoRadioFalta);
	radioDesabilitados = true;
}
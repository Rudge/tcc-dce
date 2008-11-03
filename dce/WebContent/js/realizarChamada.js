function marcarOpcaoRadio(idRadio) {
	var elementoRadio = "document.getElementById('"+ idRadio +"').checked = true;";
	eval(elementoRadio);
}
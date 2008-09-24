function validarCampos(){
	if(document.getElementById("usuario").value == ""){
		alert("Por favor, preencha o campo do usuário!!");
		document.getElementById("usuario").focus();
		return false;
	}else if(document.getElementById("senha").value == ""){
		alert("Por favor, preencha o campo de senha!!");
		document.getElementById("senha").focus();
		return false;
	}else{
		return true;
	}
}

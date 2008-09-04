function validarCampos(){
	if(document.getElementById("usuario").value == "" || document.getElementById("senha").value == ""){
		alert("Por favor, preencha os campos corretamente!!");
		return false;
	}else{
		return true;
	}
}

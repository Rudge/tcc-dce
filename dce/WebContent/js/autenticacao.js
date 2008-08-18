function validarCampos(){
	if(document.formLogin.usuario.value == "" || document.formLogin.senha.value == ""){
		alert("Por favor, preencha os campos corretamente!!");
		return false;
	}else{
		return true;
	}
}

function validarCampos(){
	if(document.formLogin.usuario.value == "" || document.formLogin.senha.value == ""){
		alert("Login ou senha inv�lidos!!");
		return false;
	}else{
		return true;
	}
}

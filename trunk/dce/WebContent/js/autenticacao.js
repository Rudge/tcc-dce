function recuperarSenha(){
	if(document.getElementById("usuario").value == ""){
		alert("Por favor, preencha o campo do usuário!!");
		document.getElementById("usuario").focus();
	}else{
		document.getElementById("formLogin").acao.value = "RecuperaSenhaAction";
		document.formLogin.submit();
	}
}
function ok(){
	if(document.getElementById("usuario").value == ""){
		alert("Por favor, preencha o campo do usuário!!");
		document.getElementById("usuario").focus();

	}else if(document.getElementById("senha").value == ""){
		alert("Por favor, preencha o campo de senha!!");
		document.getElementById("senha").focus();
		
	}else{
		document.getElementById("formLogin").acao.value = "AutenticacaoAction";
		document.formLogin.submit();
	}
}
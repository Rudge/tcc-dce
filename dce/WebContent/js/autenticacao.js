function lembrarSenha(){
	if(document.getElementById("usuario").value == ""){
		alert("Por favor, preencha o campo do usu�rio!!");
		document.getElementById("usuario").focus();
	}
	document.getElementById("formLogin").acao.value = "AutenticacaoAction";
	document.formLogin.submit();
}
function ok(){
	if(document.getElementById("usuario").value == ""){
		alert("Por favor, preencha o campo do usu�rio!!");
		document.getElementById("usuario").focus();

	}else if(document.getElementById("senha").value == ""){
		alert("Por favor, preencha o campo de senha!!");
		document.getElementById("senha").focus();
		
	}
	document.getElementById("formLogin").acao.value = "AutenticacaoAction";
	document.formLogin.submit();
}
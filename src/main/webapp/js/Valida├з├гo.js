/*! jQuery v1.12.4 | (c) jQuery Foundation | jquery.org/license */
function enviardados(){

	if(document.dados.nome.value=="" || document.dados.nome.value.length < 8){
		alert( "Preencha campo NOME corretamente!" );
		document.dados.nome.focus();
		return false;
	}

	if(document.dados.cpf.value=="" || document.dados.cpf.value.length < 11){
		alert( "Preencha campo CPF corretamente!" );
		document.dados.cpf.focus();
		return false;
	}

	if(document.dados.senha.value=="" || document.dados.nome.value.length < 8){
		alert( "Preencha campo SENHA corretamente!" );
		document.dados.senha.focus();
		return false;
	}

	if( document.dados.email.value=="" || document.dados.email.value.indexOf('@')==-1 || document.dados.email.value.indexOf('.')==-1 ){
		alert( "Preencha campo E-MAIL corretamente!" );
		document.dados.email.focus();
		return false;
	}

	if (document.dados.endereco.value==""){
		alert( "Preencha o campo ENDEREÇO!" );
		document.dados.endereco.focus();
		return false;
	}

	if (document.dados.Numero_cartão_credito.value == "" ){
		alert( "É necessario preencher o campo Numero_cartão_credito" );
		document.dados.Numero_cartão_credito.focus();
		return false;
	}

	if (document.dados.validade.value == "" ){
		alert( "Preencha o campo validade" );
		document.dados.validade.focus();
		return false;
	}

	return true;
}

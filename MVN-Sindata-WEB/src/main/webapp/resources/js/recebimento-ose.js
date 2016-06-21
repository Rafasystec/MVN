function selecionarColaborador(xhr, status, args) {
	if(!args.validationFailed) {
    	atualizarColaborador();
    	PF('cdlg').hide();
    }
}
function adicionarFormaPagamento(xhr, status, args) {
	if(args.validationFailed || args.error) {
        PF("fpdlg").jq.effect("shake", {times:5}, 100);
    } else {
        PF("fpdlg").hide();
    }
}
function exibirFormulario(xhr, status, args) {	
	if(!args.validationFailed) {
		if (args.exibir) {
			PF('fdlg').show();
		}
	}	
}
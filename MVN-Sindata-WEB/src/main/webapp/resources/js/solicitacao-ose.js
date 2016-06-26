function selecionarCliente(xhr, status, args) {
	if(!args.validationFailed) {
    	atualizarCliente();
    	PF('cdlg').hide();
    }
}

function selecionarServico(xhr, status, args) {
	if(args.validationFailed || args.error) {
        PF("sdlg").jq.effect("shake", {times:5}, 100);
    } else {
        PF("sdlg").hide();
    }
}

function cancelarSolicitacaoOSE(xhr, status, args) {
    if(!args.validationFailed) {
        PF('csosedlg').hide();
        updateSolicitacoesOSE();				             
    }
}
function selecionarCliente(xhr, status, args) {
	if(!args.validationFailed) {
    	atualizarCliente();
    	PF('cdlg').hide();
    }
}
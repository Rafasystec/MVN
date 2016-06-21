function selecionarColaborador(xhr, status, args) {
	if(!args.validationFailed) {
    	atualizarColaborador();
    	PF('cdlg').hide();
    }
}
function cancelar(xhr, status, args) {
    if(!args.validationFailed) {
        PF('cdlg').hide();
        cancelarCliente();				             
    }
}

function ativar(xhr, status, args) {
    if(!args.validationFailed) {
        PF('adlg').hide();
        ativarCliente();				             
    }
}
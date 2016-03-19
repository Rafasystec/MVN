package br.com.barcadero.module.sat.devices.dimep;

import br.com.barcadero.module.sat.handle.InterfaceGeneralSAT;




public interface Functions extends InterfaceGeneralSAT {
    //Funcoes Especificas
    /**
     * AbreSerialSAT. Configura os parametros de comunicacao da porta serial apontada por commPort
     * @param commPort - Porta Serial 0 COM1 , 1 COM2, ....
     * @param baud : baudrate
     * @param nBits: Numero de stop bits
     * @param paridade: Paridade 0-Sem paridade, 1-Paridade par, 2- Impar
     * @param nStops
     * @return COMM_ERROR
     */
    public abstract int AbreSerialSAT (int commPort, int baud, int nBits, int paridade, int nStops) throws Exception;
    /**
     * Fecha a porta serial
     * @throws Exception
     */
    public abstract void CloseSerial() throws Exception;
    /**
     * Faz com que a DLL gere um numero de sessao valido.
     * @return numero da sessao gerada.
     * @throws Exception
     */
    public abstract int  GeraNumeroSessao() throws Exception;
    
}
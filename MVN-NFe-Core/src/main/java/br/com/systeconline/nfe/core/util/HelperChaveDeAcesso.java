package br.com.systeconline.nfe.core.util;

public class HelperChaveDeAcesso {
	
	
//Para implementar
	
	/*
	 A partir da versão 2.00 do leiaute da NF-e, o campo tpEmis (forma de emissão da NF-
e) passou a compor a chave de acesso da seguinte forma:

Desc                                qtd Caracteres
----------------------------------------------------
cod uf					02
AAMM da emissao			04
CNPJ do Emitente		14
Modelo					02
Serie					03
num da Nfe				09
forma emissao			01
cod numerico			08
digito verificador		01

	 
O tamanho do campo cNF - código numérico da NF-e foi reduzido para oito posições
para não alterar o tamanho da chave de acesso da NF-e de 44 posições que passa ser
composta pelos seguintes campos que se encontram dispersos na NF-e :

@ - cUF - Código da UF do emitente do Documento Fiscal
@ - AAMM - Ano e Mês de emissão da NF-e
@ - CNPJ - CNPJ do emitente
@ - mod - Modelo do Documento Fiscal
@ - serie - Série do Documento Fiscal
@ - nNF - Número do Documento Fiscal
@ - tpEmis – forma de emissão da NF-e
@ - cNF - Código Numérico que compõe a Chave de Acesso
@ - cDV - Dígito Verificador da Chave de Acesso
	 
Ate aqui sera um metodo - fazer o caso de teste primeiro	 
	 */
	
	/*
	 AQUI SERA OUTRO METODO
	 
	 CÁLCULO DO DÍGITO VERIFICADOR DA CHAVE DE ACESSO DA NF-e
O dígito verificador da chave de acesso da NF-e é baseado em um cálculo do
módulo 11. O módulo 11 de um número é calculado multiplicando-se cada algarismo pela
seqüência de multiplicadores 2,3,4,5,6,7,8,9,2,3, ... posicionados da direita para a esquerda.
A somatória dos resultados das ponderações dos algarismos é dividida por 11 e o
DV (dígito verificador) será a diferença entre o divisor (11) e o resto da divisão:
DV = 11 - (resto da divisão)

Somatória das ponderações = 644
Dividindo a somatória das ponderações por 11 teremos, 644 /11 = 58 restando 6.
Como o dígito verificador DV = 11 - (resto da divisão), portando 11 - 6 = 5
Neste caso o DV da chave de acesso da NF-e é igual a "5", valor este que deverá compor a
chave de acesso totalizando a uma seqüência de 44 caracteres.

VER MANUAL PAGINA 85 PARA MAIORES DETALHES


	 
	 
	 
	 
	 */

}

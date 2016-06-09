package br.com.barcadero.module.sat.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum EnumOrigICMS {
	/**
	 * 0 - Nacional, exceto as indicadas
nos códigos 3, 4, 5 e 8;
	 */
	@XmlEnumValue("0") NACIONAL,
	/**
	 * 1 - Estrangeira - Importação
direta, exceto a indicada no
código 6;
	 */
	@XmlEnumValue("1") ESTRANGEIRA_IMPORT,
	/**
	 * 2 - Estrangeira - Adquirida no
mercado interno, exceto a
indicada no código 7;
	 */
	@XmlEnumValue("2") ESTRANGEIRA_ADQUIR,
	/**
	 * 3 - Nacional, mercadoria ou bem
com Conteúdo de Importação
superior a 40% (quarenta por
cento) e inferior ou igual a 70%
(setenta por cento);
	 */
	@XmlEnumValue("3") NACIONAL_40_70,
	/**
	 * 4 - Nacional, cuja produção
tenha sido feita em conformidade
com os processos produtivos
básicos de que tratam as
legislações citadas nos Ajustes;
	 */
	@XmlEnumValue("4") NACIONAL_AJUSTES,
	/**
	 * 5 - Nacional, mercadoria ou bem
com Conteúdo de Importação
inferior ou igual a 40%;
	 */
	@XmlEnumValue("5") NACIONAL_INF_40,
	/**
	 * 6 - Estrangeira - Importação
direta, sem similar nacional,
constante em lista da CAMEX;
	 */
	@XmlEnumValue("6") ESTRANGEIRA_CAMEX,
	/**
	 * 7 - Estrangeira - Adquirida no
mercado interno, sem similar
nacional, constante em lista da
CAMEX;
	 */
	@XmlEnumValue("7") ESTRANGEIRA_ADQ_CAMEX,
	/**
	 * 
8 – Nacional, mercadoria ou bem
com Conteúdo de Importação
superior a 70% (setenta por
cento).
	 */
	@XmlEnumValue("8") NACIONAL_SUPER_70

}

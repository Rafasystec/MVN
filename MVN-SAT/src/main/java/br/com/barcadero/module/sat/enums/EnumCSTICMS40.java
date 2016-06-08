package br.com.barcadero.module.sat.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum EnumCSTICMS40 {
	
	//----------------------------------------------------
		//Para o ICMS 40
		//----------------------------------------------------
		/**
		 * 40 - Isenta
		 */
		@XmlEnumValue("40") ISENTA,
		/**
		 * 41 - Não tributada
		 */
		@XmlEnumValue("41") NAO_TRIBUTADA,
		/**
		 * 50 - Suspensão - nAO EXISTIRAR MAIS NA VERSAO 0.07
		 */
		@XmlEnumValue("50") SUSPENSAO,
		/**
		 * 60 - ICMS cobrado anteriormente por substituição tributária
		 */
		@XmlEnumValue("60") ICMS_COBRADO

}

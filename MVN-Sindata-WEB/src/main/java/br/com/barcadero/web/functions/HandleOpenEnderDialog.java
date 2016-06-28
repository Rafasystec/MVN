package br.com.barcadero.web.functions;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.map.HashedMap;

import br.com.barcadero.web.attributes.Attributs;

public class HandleOpenEnderDialog extends SuperHandle{
	
	public static void openCadCidade() throws Exception {
		//openDialog("cadCidade");
		HandleDialog.openDialog("PopCidade", "500", "500");
	}

	public static void openCadBairro() throws Exception {
		openDialog("cadBairro");
	}
	
	public static void openCadBairro(String... params) throws Exception {
		System.out.println("Abrindo popup de bairros e pondo os parametros");
		HashedMap<String, List<String>> allParams = new HashedMap<String, List<String>>();
		List<String> list = new ArrayList<String>();
		for (String string : params) {
			System.out.println("Parametro para ser adicionado: " + string);
			list.add(string);
		}
		System.out.println("Nome parametro: " + Attributs.POP_BAIRRO_PARAMS);
		allParams.put(Attributs.POP_BAIRRO_PARAMS, list);
		openDialog("cadBairro",allParams);
	}
}

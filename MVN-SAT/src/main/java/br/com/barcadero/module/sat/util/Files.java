package br.com.barcadero.module.sat.util;

import java.io.File;

import br.com.barcadero.commons.util.HandleFiles;
import br.com.barcadero.commons.util.HandleSystem;

public class Files {
	
	public static final String ROOT_DIR_XML_SAT = "XML" + File.separator + "SAT" + File.separator;
	public void writXMLVenda(String xmlBase64, String chaveAcesso) throws Exception{
		String filePath = HandleSystem.rootDirApp() + ROOT_DIR_XML_SAT + "venda" + File.separator;
		String fileName = "ENV_" + chaveAcesso + ".xml";
		HandleFiles.writFileBase64(xmlBase64, filePath, fileName);
	}

}

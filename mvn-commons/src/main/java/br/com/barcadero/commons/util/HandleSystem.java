package br.com.barcadero.commons.util;

import java.io.File;

public class HandleSystem {
	
	public static String rootDirApp() {
		return System.getProperty("user.dir") + File.separator;
	}

}

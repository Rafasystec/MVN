package br.com.barcadero.core.db.util;

public class HelperIniDataBase {

	public static IHelperDataBase helperDataBase;
	
	static{
		helperDataBase = new HelperDataBasePostgres();
	}
}

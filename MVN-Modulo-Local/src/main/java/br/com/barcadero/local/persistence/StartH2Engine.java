package br.com.barcadero.local.persistence;

import java.sql.SQLException;

import org.h2.tools.Console;
import org.h2.tools.Server;

public class StartH2Engine {
	
	private static Server server = null;
	private String dbPath		 = "/local/data/Local";
	public final static String PARAM_PORT		= "-tcpPort";
	public final static String PARAM_BASE_DIR	= "-baseDir";
	public final static String PARAM_PASS_WORD	= "-tcpPassword";
	
	
	public static void main(String[] args) {
		try {
			new Console().runTool(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public StartH2Engine() throws SQLException {
		// TODO Auto-generated constructor stub
		server = Server.createTcpServer(PARAM_BASE_DIR, dbPath);
		
	}
	
	
	public void start() throws SQLException {
		if(server != null){
			server.start();
		} 
	}
	
	public void stop() {
		if(server != null){
			server.stop();
			server = null;
		}
	}
	
	public static void runConsoleBrowser() {
		try {
			Console console = new Console();
			console.runTool(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

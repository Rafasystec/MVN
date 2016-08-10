package br.com.barcadero.frameworks.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import br.com.barcadero.dao.DaoNota;
import br.com.barcadero.tables.Nota;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class GerarRelatorio extends TesteSuperClass{
	
	DaoNota daoNota;
	public GerarRelatorio() {
		// TODO Auto-generated constructor stub
		//daoNota = new DaoNota(null, null, getSession());
	}
	
	//@Test
	public void testReport() throws JRException,SQLException {
		
		System.out.println("Gerando relatório");
		//UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Nota> listaUs = null;
		try {
			listaUs = daoNota.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JasperReport pathjrxml = JasperCompileManager.compileReport("br/com/barcadero/frameworks/test/dao/TesteReport.jrxml");
		JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, null, new JRBeanCollectionDataSource(listaUs));
		JasperExportManager.exportReportToPdfFile(printReport, "rel/reportex.pdf");
		System.out.println("Relatorio gerado");
	}

}
package br.com.barcadero.core.restful;

public class RESTServerURI {
	
	private boolean homo = false;
	public RESTServerURI(boolean homo) {
		this.homo = homo;
	}
	
	public String getAllProdutos() {
		if(homo){
			return "http://localhost:8080/Nautilus/rest/produtos/getAll";
		}else{
			return "";
		}
	}

}

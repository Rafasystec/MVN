package br.com.barcadero.core.handles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.barcadero.core.enums.EnumTipoUser;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Usuario;

public class HandleUsuarioPadrao {
	
	public static Usuario getUsuarioHomologacao() {
		Usuario user 		= new Usuario(null);
		Date dtCad 	 		= new Date();
		Empresa emp			= HandleEmpresaHomo.getEmpresaHomo();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(user);
		emp.setUsuarios(usuarios);
		List<Empresa> empresas = new ArrayList<Empresa>();
		empresas.add(emp);
		user.setCodigo(1);
		user.setCodPermissoes(1);
		user.setDtCadastro(dtCad);
		user.setEmpresas(empresas);
		user.setHrCadastro(dtCad);
		user.setNome("USER MASTER HOMO");
		user.setPassWord("123456");
		user.setTipoUser(EnumTipoUser.MASTER);
		user.setEmail("MASTER");
		
		return user;
	}

}

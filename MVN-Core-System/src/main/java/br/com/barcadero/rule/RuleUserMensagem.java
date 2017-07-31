package br.com.barcadero.rule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.commons.util.HandleDateHour;
import br.com.barcadero.dao.DaoUserMensagem;
import br.com.barcadero.dao.DaoUsuario;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.TmpUserMessage;
import br.com.barcadero.tables.UserMensagens;
import br.com.barcadero.tables.Usuario;

@Service
public class RuleUserMensagem extends RuleModelo <UserMensagens>{

	@Autowired
	private DaoUserMensagem daoMensagem;
	@Autowired
	private DaoUsuario daoUsuario;
	
//	@Autowired
//	public RuleUserMensagem(DaoUserMensagem daoMensagem,DaoUsuario daoUsuario) {
//		// TODO Auto-generated constructor stub
//		this.daoMensagem = daoMensagem;
//		this.daoUsuario = daoUsuario;
//	}

//	@Override
//	public String insert(Entidade entidade) throws Exception {
//		// TODO Auto-generated method stub
//		return daoMensagem.insert(entidade);
//	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoMensagem.delete(codigo);
	}

//	@Override
//	public String update(Entidade entidade) throws Exception {
//		// TODO Auto-generated method stub
//		return daoMensagem.update(entidade);
//	}

	@Override
	public UserMensagens find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List consultarMensagens(Usuario usuario) {
		return daoMensagem.consultarMensagens(usuario);
	}
	
	public List<TmpUserMessage> getMensagens(Usuario usuario) throws Exception{
		List<Object[]> list = consultarMensagens(usuario);
		List<TmpUserMessage> mensagens = new ArrayList<TmpUserMessage>();
		if(list != null){
			HandleDateHour datHour = new HandleDateHour();
			for (Object[] obj : list) {
				TmpUserMessage tmp = new TmpUserMessage();
				tmp.setNomeUser(String.valueOf(obj[0])); 
				tmp.setMensagem(String.valueOf(obj[1]));
				Date date = (Date)obj[2];
				Date time = (Date)obj[3];
				String strData = datHour.format(date, "dd/MM/yyyy");
				String strHora = datHour.format(time, "HH:mm");
				tmp.setDtMsg(strData);
				tmp.setHrMsg(strHora);
				mensagens.add(tmp);
			}
		}
		return mensagens;
	}
	
	/**
	 * Obtem nome e e-mail para o autocomplete 
	 * @param parametro
	 * @return
	 * @throws Exception
	 */
	public List<String> getNomeEmail(String parametro) throws Exception {
		List<String> list 	= new ArrayList<String>(); 
		List<Usuario> users = daoUsuario.find(parametro);
		if(users != null){
			for (Usuario usuario : users) {
				String nomeEmail = usuario.getNome() + " - " + usuario.getEmail();
				list.add(nomeEmail);
			}
		}
		return list;
	}

	@Override
	public List<UserMensagens> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserMensagens> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserMensagens> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserMensagens insert(UserMensagens entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserMensagens update(UserMensagens entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}

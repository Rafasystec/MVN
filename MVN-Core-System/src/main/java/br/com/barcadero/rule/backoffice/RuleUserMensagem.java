package br.com.barcadero.rule.backoffice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.backoffice.DaoUserMensagem;
import br.com.systeconline.core.handles.HandleDateHour;
import br.com.systeconline.rule.RuleModelo;
import br.com.systeconline.tables.basicos.Entidade;
import br.com.systeconline.tables.basicos.TmpUserMessage;

public class RuleUserMensagem extends RuleModelo {

	private DaoUserMensagem daoMensagem;
	public RuleUserMensagem(Session session) {
		super(session);
		daoMensagem = new DaoUserMensagem(session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoMensagem.insert(entidade);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoMensagem.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoMensagem.update(entidade);
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List consultarMensagens() {
		return daoMensagem.consultarMensagens();
	}
	
	public List<TmpUserMessage> getMensagens() throws Exception{
		List<Object[]> list = consultarMensagens();
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


}

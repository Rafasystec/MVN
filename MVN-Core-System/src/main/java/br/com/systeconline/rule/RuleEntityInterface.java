package br.com.systeconline.rule;

import br.com.systeconline.tables.basicos.Entidade;

public interface RuleEntityInterface {
	public String insert(Entidade entidade) throws Exception;
	public String delete(long codigo) throws Exception;
	public String update(Entidade entidade) throws Exception;
	public Entidade find(long codigo) throws Exception;
}

package br.com.barcadero.rule;

import br.com.barcadero.tables.Entidade;

public interface RuleEntityInterface {
	public String insert(Entidade entidade) throws Exception;
	public String delete(long codigo) throws Exception;
	public String update(Entidade entidade) throws Exception;
	public Entidade find(long codigo) throws Exception;
}


package br.com.barcadero.rule;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.core.enums.EnumUF;
import br.com.barcadero.dao.DaoRegraTributacao;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.RegraTributaria;
import br.com.barcadero.tables.Usuario;
@Service
public class RuleRegraTributaria extends RuleModelo<RegraTributaria> {

	private DaoRegraTributacao daoRegraTributacao;
	@Autowired
	public RuleRegraTributaria(DaoRegraTributacao daoRegraTributacao) {
		// TODO Auto-generated constructor stub
		this.daoRegraTributacao = daoRegraTributacao;
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoRegraTributacao.insert(entidade);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoRegraTributacao.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoRegraTributacao.update(entidade);
	}

	@Override
	public RegraTributaria find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoRegraTributacao.find(codigo);
	}

	@Override
	public List<RegraTributaria> findAll() throws Exception {
		// TODO Auto-generated method stub
		return daoRegraTributacao.findAll();
	}
	
	public void cargaDasRegras(Usuario usuario) throws Exception {
		//-----------------------------------
		//Deletar todos os registros primeiro
		//-----------------------------------
		System.out.println("Número de registros deletados: " + deleteAll());
		int[][] matrizICMS = {
				/*O       				DESTINO*/
				/*R*/
				/*I*///   AC  AL AM	 AP	 BA	 CE	 DF	 ES	 GO	 MA	 MT	 MS	 MG	 PA	 PB	 PR	 PE	 PI	 RN	 RS	 RJ	 RO	 RR	 SC	 SP	 SE	 TO
				/*AC*/	 {17, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12},
				/*AL*/	 {12, 17, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12},
				/*AM*/	 {12, 12, 17, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12},
				/*AP*/	 {12, 12, 12, 17, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12},
				/*BA*/	 {12, 12, 12, 12, 17, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12},
				/*CE*/	 {12, 12, 12, 12, 12, 17, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12},
				/*DF*/	 {12, 12, 12, 12, 12, 12, 17, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12},
				/*ES*/	 {12, 12, 12, 12, 12, 12, 12, 17, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12},
				/*GO*/	 {12, 12, 12, 12, 12, 12, 12, 12, 17, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12},
				/*MA*/	 {12, 12, 12, 12, 12, 12, 12, 12, 12, 17, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12},
				/*MT*/	 {12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 17, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12},
				/*MS*/	 {12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 17, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12},
				/*MG*/	 {7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 18, 7 , 7	, 12,  7, 7	, 7	, 12, 12, 7	, 7	, 12, 12,  7, 7 },
				/*PA*/	 {12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 17, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12},
				/*PB*/	 {12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 17, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12},
				/*PR*/	 {7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 12, 7 , 7	, 18,  7, 7	, 7	, 12, 12, 7	, 7	, 12, 12,  7, 7 },
				/*PE*/	 {12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 17, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12},
				/*PI*/	 {12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 17, 12, 12, 12, 12, 12, 12, 12, 12, 12},
				/*RN*/	 {12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 17, 12, 12, 12, 12, 12, 12, 12, 12},
				/*RS*/	 {7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 12, 7 , 7	, 12,  7, 7	, 7	, 17, 12, 7	, 7	, 12, 12,  7, 7 },
				/*RJ*/	 {7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 12, 7 , 7	, 12,  7, 7	, 7	, 12, 19, 7	, 7	, 12, 12,  7, 7 },
				/*RO*/	 {12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 17, 12, 12, 12, 12, 12},
				/*RR*/	 {12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 17, 12, 12, 12, 12},
				/*SC*/	 {7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 12, 7 , 7	, 12,  7, 7	, 7	, 12, 12, 7	, 7	, 17, 12,  7, 7 },
				/*SP*/	 {7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 7	, 12, 7 , 7	, 12,  7, 7	, 7	, 12, 12, 7	, 7	, 12, 18,  7, 7 },
				/*SE*/	 {12,12	, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 17, 12},
				/*TO*/	 {12,12	, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 17}

		};
		
		int i,j;
		for (i = 0; i < matrizICMS.length; i++) {
			System.out.printf("%d Linha",(i + 1));
			EnumUF enumUFOrig = getUFOrigem(i);
			EnumUF enumUFDest;
			for (j = 0; j < matrizICMS.length; j++) {
				System.out.printf("%d", matrizICMS[i][j]);
				enumUFDest = getUFOrigem(j);
				int aliquota  =  matrizICMS[i][j];
				RegraTributaria tributaria = new RegraTributaria();
				tributaria.setAliquotaICMS(new BigDecimal(aliquota));
				tributaria.setuFDestino(enumUFDest);
				tributaria.setuFOrigem(enumUFOrig);
				tributaria.setUsuario(usuario);
				insert(tributaria);
				
			}
		}
	}

	private static EnumUF getUFOrigem(int origem) {
		switch (origem) {
		case 0:
			return EnumUF.AC;
		case 1:
			return EnumUF.AL;
		case 2:
			return EnumUF.AM;
		case 3:
			return EnumUF.AP;
		case 4:
			return EnumUF.BA;
		case 5:
			return EnumUF.CE;
		case 6:
			return EnumUF.DF;
		case 7:
			return EnumUF.ES;
		case 8:
			return EnumUF.GO;
		case 9:
			return EnumUF.MA;
		case 10:
			return EnumUF.MT;
		case 11:
			return EnumUF.MS;
		case 12:
			return EnumUF.MG;
		case 13:
			return EnumUF.PA;
		case 14:
			return EnumUF.PB;
		case 15:
			return EnumUF.PR;
		case 16:
			return EnumUF.PE;
		case 17:
			return EnumUF.PI;
		case 18:
			return EnumUF.RN;
		case 19:
			return EnumUF.RS;
		case 20:
			return EnumUF.RJ;
		case 21:
			return EnumUF.RO;
		case 22:
			return EnumUF.RR;
		case 23:
			return EnumUF.SC;
		case 24:
			return EnumUF.SP;
		case 25:
			return EnumUF.SE;
		case 26:
			return EnumUF.TO;	
		default:
			return EnumUF.CE;
		}
	}
	
	/**
	 * Deleta todas as regras da tabela REGRA_TRIBUTARIA
	 * @return numero de registros atualizados ou excluidos
	 */
	public int deleteAll() {
		return daoRegraTributacao.deleteAll();
	}

	@Override
	public List<RegraTributaria> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegraTributaria> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}

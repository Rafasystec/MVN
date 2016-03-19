package br.com.systeconline.tables.frontend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.systeconline.core.enums.EnumTipoMeioPgto;
import br.com.systeconline.core.enums.EnumUsaTEF;
import br.com.systeconline.tables.basicos.Empresa;
import br.com.systeconline.tables.basicos.EntidadeEmpresa;
import br.com.systeconline.tables.basicos.Usuario;

@NamedQueries({
		@NamedQuery(name=MeiosPagamento.FIND_BY_CODE,query="FROM MeiosPagamento WHERE codigo = :codigo"),
		@NamedQuery(name=MeiosPagamento.FIND_ALL, query="FROM MeiosPagamento")
})

@Entity
@Table(name="MEIOS_PAGAMENTO")
public class MeiosPagamento extends EntidadeEmpresa {
	private static final long serialVersionUID = -4387786115080387276L;

	public MeiosPagamento() {
		// TODO Auto-generated constructor stub
	}
	public MeiosPagamento(Empresa empresa, Usuario usuario) {
		super(empresa, usuario);
		// TODO Auto-generated constructor stub
	}
	public static final String FIND_BY_CODE = "MeiosPagamento.findByCode";
	public static final String FIND_ALL 	= "MeiosPagamento.findAll"; 
	@Column(nullable=false)
	private String descricao;
	@Column(nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumUsaTEF flUsaTef;
	@Column(nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTipoMeioPgto tpMeio;
	@Transient
	private String imgSrc;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		descricao = descricao.toUpperCase();
		this.descricao = descricao;
	}
	public EnumUsaTEF getFlUsaTef() {
		return flUsaTef;
	}
	public void setFlUsaTef(EnumUsaTEF flUsaTef) {
		this.flUsaTef = flUsaTef;
	}
	public EnumTipoMeioPgto getTpMeio() {
		return tpMeio;
	}
	public void setTpMeio(EnumTipoMeioPgto tpMeio) {
		this.tpMeio = tpMeio;
	}
	public String getImgSrc() {
		if(getTpMeio() == EnumTipoMeioPgto.TEF){
			imgSrc = "../resources/Imagens/tefIcon16.png";
		}else if(getTpMeio() == EnumTipoMeioPgto.DINHEIRO){
			imgSrc = "../resources/Imagens/table_money.png";
		}else if(getTpMeio() == EnumTipoMeioPgto.CREDIARIO){
			imgSrc = "../resources/Imagens/barcode16.png";
		}else if(getTpMeio() == EnumTipoMeioPgto.CHEQUE){
			imgSrc = "../resources/Imagens/chequeIcon16.png";
		}else if(getTpMeio() == EnumTipoMeioPgto.FINANCIADO){
			imgSrc = "../resources/Imagens/finacIcon16.png";
		}
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
}

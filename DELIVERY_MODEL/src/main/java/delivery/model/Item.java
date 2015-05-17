package delivery.model;

import java.util.List;

public class Item {
	
	private int id;
	private String descricao;
	private List<ItensProduto> itensProduto;
	private List<AdicionalProduto> adicionaisProduto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<ItensProduto> getItensProduto() {
		return itensProduto;
	}
	public void setItensProduto(List<ItensProduto> itensProduto) {
		this.itensProduto = itensProduto;
	}
	public List<AdicionalProduto> getAdicionaisProduto() {
		return adicionaisProduto;
	}
	public void setAdicionaisProduto(List<AdicionalProduto> adicionaisProduto) {
		this.adicionaisProduto = adicionaisProduto;
	}

	
	
	
	
}

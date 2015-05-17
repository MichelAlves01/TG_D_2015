package delivery.model;

import java.util.List;

public class Cidade {
	
	private int id;
	private String nome;
	private int idEstado;
	private List<Empresa> empresa;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	
	public List<Empresa> getEmpresa() {
		return empresa;
	}
	public void setEmpresa(List<Empresa> empresa) {
		this.empresa = empresa;
	}
	
}

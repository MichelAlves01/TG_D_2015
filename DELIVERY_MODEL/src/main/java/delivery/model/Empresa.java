package delivery.model;

import java.util.List;

public class Empresa {
	
	private String cpfCnpj;
	private String nome;
	private String endereco;
	private int    idCidade;
	private String telefoneFixo;
	private String telefoneMovel;
	private String cep;
	private String email;
	private double raio;
	private int usaAgenda;
	private String tipo;
	private double latitude;
	private double longitude;
	private double avaliacao;
	private int status;
	private List<Produto> produto;
	private List<Users> users;
	
	
	public Empresa(){
		
	}
	public Empresa(String cpfCnpj, String nome, String endereco, int idCidade,
			String telefoneFixo, String telefoneMovel, String cep,
			String email, double raio, int usaAgenda, String tipo,
			double latitude, double longitude, double avaliacao, int status,
			List<Produto> produto, List<Users> users) {
		super();
		this.cpfCnpj = cpfCnpj;
		this.nome = nome;
		this.endereco = endereco;
		this.idCidade = idCidade;
		this.telefoneFixo = telefoneFixo;
		this.telefoneMovel = telefoneMovel;
		this.cep = cep;
		this.email = email;
		this.raio = raio;
		this.usaAgenda = usaAgenda;
		this.tipo = tipo;
		this.latitude = latitude;
		this.longitude = longitude;
		this.avaliacao = avaliacao;
		this.status = status;
		this.produto = produto;
		this.users = users;
	}
	
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public int getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}
	public String getTelefoneFixo() {
		return telefoneFixo;
	}
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	public String getTelefoneMovel() {
		return telefoneMovel;
	}
	public void setTelefoneMovel(String telefoneMovel) {
		this.telefoneMovel = telefoneMovel;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getRaio() {
		return raio;
	}
	public void setRaio(double raio) {
		this.raio = raio;
	}
	public int getUsaAgenda() {
		return usaAgenda;
	}
	public void setUsaAgenda(int usaAgenda) {
		this.usaAgenda = usaAgenda;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}
	public List<Produto> getProduto() {
		return produto;
	}
	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	public List<Users> getUsers() {
		return users;
	}
	public void setUsers(List<Users> users) {
		this.users = users;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}

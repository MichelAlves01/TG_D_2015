package hello;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import delivery.api.mapper.CidadeImpl;
import delivery.api.mapper.EmpresaImpl;
import delivery.model.Cidade;
import delivery.model.Empresa;
import delivery.service.DELIVERY_SERVICE.EmpresaService;

@RestController
public class EmpresaController {
	private Empresa empresa;
	EmpresaImpl empresaImpl = null;
	private EmpresaService empresaService;
	
	@RequestMapping(value="/iniciaCadastroEmpresa", method=RequestMethod.POST)
	public Empresa iniciaCadastro( 	@RequestParam(value="nome") String nome,
									@RequestParam(value="cpfCnpj") String cpfCnpj){
		
		empresa = new Empresa();
		empresa.setNome(nome);
		empresa.setCpfCnpj(cpfCnpj);
		System.out.println("nome = " + empresa.getNome() + " e " + empresa.getCpfCnpj());
		empresaService = new EmpresaService();
		empresaService.verificaCpf(empresa);
		System.out.println("status" + empresa.getStatus());
		return empresa;
	}
	
	@RequestMapping(value="/getEmpresaCadastro", method=RequestMethod.GET)
	public Empresa getEmpresaCadastro(){
		return empresa;
	}
	
	@RequestMapping(value="/cadastrarEmpresaController", method=RequestMethod.POST)
	public Empresa cadastrarEmpresa(	@RequestParam(value="tipo") String tipo,
									@RequestParam(value="idCidade") int idCidade,
									@RequestParam(value="endereco") String endereco,
									@RequestParam(value="email") String email,
									@RequestParam(value="telefoneFixo") String telefoneFixo,
									@RequestParam(value="telefoneMovel") String telefoneMovel,
									@RequestParam(value="cep") String cep,
									@RequestParam(value="latitude")String latitude,
									@RequestParam(value="longitude")String longitude,
									@RequestParam(value="senha") String senha){
		
		double lat = Double.parseDouble(latitude);
		double lon = Double.parseDouble(longitude);
		
		empresa.setTipo(tipo);
		empresa.setEmail(email);
		empresa.setEndereco(endereco);
		empresa.setIdCidade(idCidade);
		empresa.setTelefoneFixo(telefoneFixo);
		empresa.setTelefoneMovel(telefoneMovel);
		empresa.setCep(cep);
		empresa.setRaio(5);
		empresa.setStatus(0);
		empresa.setUsaAgenda(0);
		empresa.setAvaliacao(3);
		empresa.setLatitude(lat);
		empresa.setLongitude(lon);
		
		empresaImpl = new EmpresaImpl();
		empresaImpl.cadastrarEmpresaDAO(empresa);
		
		return empresa;
	}
	
	@RequestMapping(value="/atualizarEmpresaController", method=RequestMethod.POST)
	public Empresa atualizarEmpresa(@RequestParam(value="nome") String nome,
									@RequestParam(value="cpfCnpj") String cpfCnpj,
									@RequestParam(value="tipo") String tipo,
									@RequestParam(value="idCidade") int idCidade,
									@RequestParam(value="endereco") String endereco,
									@RequestParam(value="email") String email,
									@RequestParam(value="telefoneFixo") String telefoneFixo,
									@RequestParam(value="telefoneMovel") String telefoneMovel,
									@RequestParam(value="cep") String cep,
									@RequestParam(value="latitude")String latitude,
									@RequestParam(value="longitude")String longitude,
									@RequestParam(value="senha") String senha){
		
		double lat = Double.parseDouble(latitude);
		double lon = Double.parseDouble(longitude);
		
		empresa.setNome(nome);
		empresa.setCpfCnpj(cpfCnpj);
		empresa.setTipo(tipo);
		empresa.setEmail(email);
		empresa.setEndereco(endereco);
		empresa.setIdCidade(idCidade);
		empresa.setTelefoneFixo(telefoneFixo);
		empresa.setTelefoneMovel(telefoneMovel);
		empresa.setCep(cep);
		empresa.setRaio(5);
		empresa.setStatus(0);
		empresa.setUsaAgenda(0);
		empresa.setAvaliacao(3);
		empresa.setLatitude(lat);
		empresa.setLongitude(lon);
		
		empresaImpl = new EmpresaImpl();
		empresaImpl.atualizarEmpresaDAO(empresa);
		
		return empresa;
	}
}

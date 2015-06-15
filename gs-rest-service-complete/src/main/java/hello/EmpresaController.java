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

@RestController
public class EmpresaController {
	Empresa empresa = new Empresa();
	EmpresaImpl empresaImpl = null;
	
	@RequestMapping(value="/iniciaCadastroEmpresa", method=RequestMethod.POST)
	public void iniciaCadastro( 	@RequestParam(value="nome") String nome,
									@RequestParam(value="cpfCnpj") String cpfCnpj){
		
		empresa.setNome(nome);
		empresa.setCpfCnpj(cpfCnpj);
		System.out.println("nome = " + nome + " e " + cpfCnpj);
	}
	
	@RequestMapping(value="/getEmpresaCadastro", method=RequestMethod.GET)
	public Empresa getEmpresaCadastro(){
		
		return empresa;
	}
	
	@RequestMapping(value="/cadastrarEmpresaController", method=RequestMethod.POST)
	public void cadastrarEmpresa(	@RequestParam(value="tipo") String tipo,
									@RequestParam(value="email") String email,
									@RequestParam(value="endereco") String endereco,
									@RequestParam(value="idCidade") int idCidade,
									@RequestParam(value="telefoneFixo") String telefoneFixo,
									@RequestParam(value="telefoneMovel") String telefoneMovel,
									@RequestParam(value="Cep") String cep,
									@RequestParam(value="latitude")double latitude,
									@RequestParam(value="longitude")double longitude){
		
		CidadeImpl cidadeImpl = new CidadeImpl();
		Cidade cidade = cidadeImpl.geCidadeDAO(idCidade);
		
		empresa.setTipo(tipo);
		empresa.setEmail(email);
		empresa.setEndereco(endereco);
		empresa.setCidade(cidade);
		empresa.setTelefoneFixo(telefoneFixo);
		empresa.setTelefoneMovel(telefoneMovel);
		empresa.setCep(cep);
		empresa.setRaio(5);
		empresa.setStatus(0);
		empresa.setUsaAgenda(0);
		empresa.setAvaliacao(3);
		
		empresaImpl = new EmpresaImpl();
		empresaImpl.cadastrarEmpresaDAO(empresa);
		
	}
}

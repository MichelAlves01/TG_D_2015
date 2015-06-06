package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import delivery.model.Empresa;

@RestController
public class EmpresaController {
	Empresa empresa = new Empresa();
	
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
}

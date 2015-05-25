package hello;

import io.undertow.attribute.RequestMethodAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import delivery.model.Empresa;

@RestController
public class EmpresaController {
	
	@RequestMapping(value="/cadastrarEmpresaInicio" , method=RequestMethod.GET)
	public Empresa cadastrarEmpresaController(	@RequestParam(value="nome")String nome,
												@RequestParam(value="cpfCnpj")int cpfCnpj){
		Empresa empresa = new Empresa();
		empresa.setNome(nome);
		empresa.setCpfCnpj(cpfCnpj);
		return empresa;
	}
}

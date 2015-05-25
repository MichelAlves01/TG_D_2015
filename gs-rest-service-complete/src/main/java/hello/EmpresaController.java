package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import delivery.model.Empresa;

@RestController
public class EmpresaController {
	
	@RequestMapping("/cadastrarEmpresa")
	public Empresa cadastrarEmpresaController(){
		Empresa empresa = new Empresa();
		empresa.setNome("Habibs");
		return empresa;
	}
}

package delivery.service.DELIVERY_SERVICE;

import java.util.ArrayList;
import java.util.List;

import delivery.DELIVERY_MODELO.Empresa;

public class EmpresaService {
	private Empresa empresa;
	
	public void cadastrarEmpresaService(Empresa empresa){
		
	}
	
	public void atualizarEmpresaService(Empresa empresa){
		
	}
	
	public Empresa getEmpresaService( int cpfCnpj ){
		empresa = new Empresa();
		return empresa;
	}
	
	public List<Empresa> getEmpresasService(){
		List<Empresa> empresas = new ArrayList<Empresa>();
		return empresas;
	}
}

package delivery.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;

import delivery.api.connection.ConnectionFactory;
import delivery.api.dao.EmpresaDAO;
import delivery.model.Cidade;
import delivery.model.Empresa;

public class EmpresaImpl {
	
	private static CidadeImpl cidadeImpl;
	
	private Cidade cidade;
	
	public void cadastrarEmpresaDAO(Empresa empresa){
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		EmpresaDAO empresaDao = session.getMapper(EmpresaDAO.class);
		empresaDao.cadastrarEmpresaDAO(empresa);
		session.commit();
		session.close();
	}
	
	public void atualizarEmpresaDAO(Empresa empresa){
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		EmpresaDAO empresaDao = session.getMapper(EmpresaDAO.class);
		empresaDao.atualizarEmpresaDAO(empresa);
		session.commit();
		session.close();
	}
	
	public void excluirEmpresaDAO(String cpfCnpj){
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		EmpresaDAO empresaDao = session.getMapper(EmpresaDAO.class);
		empresaDao.excluirEmpresaDAO(cpfCnpj);
		session.commit();
		session.close();
	}
	
	public Empresa getEmpresaDAO(String cpfCnpj){
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		EmpresaDAO empresaDao = session.getMapper(EmpresaDAO.class);
		Empresa empresa = empresaDao.getEmpresaDAO(cpfCnpj);
		
		//busca informações da cidade no banco de dados e preenche campos nulo
		cidadeImpl = new CidadeImpl();
		cidade = cidadeImpl.geCidadeDAO(empresa.getCidade().getId());
		empresa.setCidade(cidade);
		
		session.close();
		return empresa;
	}
	
	public List<Empresa> getEmpresasDAO(){
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		EmpresaDAO empresaDao = session.getMapper(EmpresaDAO.class);
		List<Empresa> empresas = empresaDao.getEmpresasDAO();
		session.close();
		return empresas;
	}
	
	public List<Empresa> getEmpresasPorTipoDAO(String tipo){
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		EmpresaDAO empresaDao = session.getMapper(EmpresaDAO.class);
		List<Empresa> empresas = empresaDao.getEmpresasPorTipoDAO(tipo);
		session.close();
		return empresas;
	}
}

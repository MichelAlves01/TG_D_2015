package delivery.api.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import delivery.api.connection.ConnectionFactory;
import delivery.api.dao.CidadeDAO;
import delivery.model.Cidade;

public class CidadeImpl {

	public List<Cidade> getCidadesDAO(int idEstado){
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		CidadeDAO cidadeDao = session.getMapper(CidadeDAO.class);
		List<Cidade> cidades = cidadeDao.getCidadesDAO(idEstado);
		session.close();
		return cidades;
	}
	
}

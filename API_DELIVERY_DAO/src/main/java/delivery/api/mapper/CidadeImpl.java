package delivery.api.mapper;

import org.apache.ibatis.session.SqlSession;

import delivery.api.connection.ConnectionFactory;
import delivery.api.dao.CidadeDAO;
import delivery.model.Cidade;

public class CidadeImpl {

	public Cidade getCidadesDAO(int idCidade){
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		CidadeDAO cidadeDao = session.getMapper(CidadeDAO.class);
		Cidade cidade = cidadeDao.getCidadesDAO(idCidade);
		session.close();
		return cidade;
	}
	
}

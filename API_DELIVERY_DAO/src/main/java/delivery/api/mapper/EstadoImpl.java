package delivery.api.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import delivery.api.connection.ConnectionFactory;
import delivery.api.dao.EstadoDAO;
import delivery.model.Estado;

public class EstadoImpl {

	public List<Estado> getEstadosDAO(){
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		EstadoDAO estadoDao = session.getMapper(EstadoDAO.class);
		List<Estado> estados = estadoDao.getEstadosDAO();
		session.close();
		return estados;
	}
	
}

package delivery.api.mapper;

import org.apache.ibatis.session.SqlSession;

import delivery.api.connection.ConnectionFactory;
import delivery.api.dao.UsuarioMobDAO;
import delivery.model.UsuarioMob;



public class UsuariosMobImpl {
	
		
	
	private UsuarioMob usuarioMob =  new UsuarioMob();
	
	public void cadastrarUsuarioMobDAO(UsuarioMob usuarioMob){
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		UsuarioMobDAO usuarioMobDao = session.getMapper(UsuarioMobDAO.class);
			usuarioMobDao.cadastrarUsuarioMobDAO(usuarioMob);
		session.commit();
		session.close();
	}
	
	public UsuarioMob selectUsuarioMobDAO(String email) {
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		UsuarioMobDAO usuarioMobDao = session.getMapper(UsuarioMobDAO.class);
			return usuarioMobDao.getUsuarioMobDAO(email);
	}
	
	public void atualizarUsuarioMobDAO(UsuarioMob usuarioMob){
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		UsuarioMobDAO usuarioMobDao = session.getMapper(UsuarioMobDAO.class);
			usuarioMobDao.atualizarUsuarioMobDAO(usuarioMob);
		session.commit();
		session.close();
	}
	
	public void inativarUsuarioMobDAO(String email){
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		UsuarioMobDAO usuarioMobDao = session.getMapper(UsuarioMobDAO.class);
			usuarioMobDao.inativarUsuarioMobDAO(email);
		session.commit();
		session.close();
	}
	
	

}
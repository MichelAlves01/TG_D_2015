package delivery.dao.api;

import delivery.api.mapper.UsuariosMobImpl;
import delivery.model.UsuarioMob;

public class Teste {

	public static void main(String[] args) {
		UsuarioMob usuarioMob = new UsuarioMob();
		String email = "talitatabata28@gmail.com";
		UsuariosMobImpl usuariomobimpl = new UsuariosMobImpl();
		//usuariomobimpl.cadastrarUsuarioMobDAO();
		//usuarioMob = usuariomobimpl.selectUsuarioMobDAO(email);
		//System.out.println("teste : " + usuarioMob.getNome());
		
		usuarioMob.setEmail(email);
		usuarioMob.setNome("Talita");
		usuarioMob.setSobrenome("Oliveira");
		usuariomobimpl.cadastrarUsuarioMobDAO(usuarioMob);
		
		//usuariomobimpl.inativarUsuarioMobDAO(email);
		
	}
}

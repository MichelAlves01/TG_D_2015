package delivery.api.mapper;

import org.apache.ibatis.session.SqlSession;

import delivery.api.connection.ConnectionFactory;
import delivery.api.dao.ProdutoDAO;
import delivery.model.Produto;


public class ProdutoImpl {
	public void cadastrarProdutoDAO(){
		
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
		ProdutoDAO produtodao = session.getMapper(ProdutoDAO.class);
		Produto produto = new Produto();
//		Empresa empresa = new Empresa();
//		empresa.setCpfCnpj(1231231232);
		produto.setId(1);
		produto.setDescricao("Pizza de mussarela");
		produto.setPreco(29.90);
//		produto.setEmpresa(empresa);
		produtodao.cadastrarProdutoDAO(produto);
		
	}
}

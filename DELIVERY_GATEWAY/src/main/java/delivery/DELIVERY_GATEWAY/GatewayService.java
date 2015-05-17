package delivery.DELIVERY_GATEWAY;


import delivery.DELIVERY_MODELO.Produto;
import delivery.service.DELIVERY_SERVICE.ProdutoService;

public class GatewayService {
	
	protected ProdutoService getProdutoService(){
		ProdutoService produtoService = new ProdutoService();
		return produtoService;
	}
	
	public void cadastrarProdutoService(Produto produto){
		getProdutoService().cadastrarProdutoService(produto);
	}
}

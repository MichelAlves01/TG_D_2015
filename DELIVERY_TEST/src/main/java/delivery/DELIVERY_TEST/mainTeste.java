package delivery.DELIVERY_TEST;

import delivery.DELIVERY_GATEWAY.GatewayService;
import delivery.DELIVERY_MODELO.Produto;

public class mainTeste {

	
	public static void main(String[] args) {
	GatewayService gatewayservice = new GatewayService();
	Produto produto = new Produto();	
	gatewayservice.cadastrarProdutoService(produto);

	}

}

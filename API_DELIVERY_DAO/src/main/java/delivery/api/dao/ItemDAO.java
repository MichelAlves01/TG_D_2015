package delivery.api.dao;

import java.util.List;

import delivery.model.Item;

public interface ItemDAO {
	
	public void cadastrarItemDAO(Item item);
	
	public void atualizarItemDAO(Item item);
	
	public void excluirProdutoDAO(int idItem);
	
	public Item getItemDAO(int idItem);
	
	public List<Item> getItensDAO();
	
}

package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		//cadastrarProduto();
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
		
//		Produto p = produtoDAO.buscarPorId(1l);
//		
//		System.out.println(p.getNome() + " " + p.getPreco());
//		
//		List<Produto> busca = produtoDAO.buscarPorNomeDaCategoria("CELULARES");
//		busca.forEach(prod -> System.out.println(prod.getNome()));
		
		BigDecimal precoDoProduto = produtoDAO.buscarPrecoDoProdutoPorNome("Xiaomi");
		System.out.println("Preco: " + precoDoProduto);
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto p1 = new Produto("Xiaomi", "Celular chinês", new BigDecimal("800"), celulares);
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
		CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
		
		entityManager.getTransaction().begin(); // Inicia a operação
		
		categoriaDAO.cadastrar(celulares);
		produtoDAO.cadastrar(p1);
		
		entityManager.getTransaction().commit(); // Faz commit no BD
		entityManager.close();
	}
	
}

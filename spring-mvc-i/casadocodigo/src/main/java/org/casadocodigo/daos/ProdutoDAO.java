package org.casadocodigo.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.casadocodigo.models.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager manager;

	public void gravar(Produto produto) {
		 manager.persist(produto);
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listar(){
    return manager.createQuery("select p from Produto p").getResultList();
}

	public Produto find(Integer id) {
		return manager.createQuery("select distinct(p) from Produto p join fetch p.precos precos where p.id = :id", Produto.class).setParameter("id", id).getSingleResult();
	}
	
}

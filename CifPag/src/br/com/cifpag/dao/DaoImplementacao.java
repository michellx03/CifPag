package br.com.cifpag.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.cifpag.dao.Dao;
import br.com.cifpag.uteis.ConexaoEntityFactory;

public abstract class DaoImplementacao<T, I extends Serializable> implements Dao<T, I> {

	private ConexaoEntityFactory conexao;

	@Override
	public T save(T entity) {

		T saved = null;

		getEntityManager().getTransaction().begin();
		saved = getEntityManager().merge(entity);
		getEntityManager().getTransaction().commit();

		return saved;
	}

	@Override
	public void remove(T entity) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(entity);
		getEntityManager().getTransaction().commit();

	}

	@Override
	public T getById(Class<T> classe, I pk) {

		try {
			return getEntityManager().find(classe, pk);
		} catch (NoResultException e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> classe) {

		return getEntityManager().createQuery("select o from " + classe.getSimpleName() + " o").getResultList();
	}

	@Override
	public EntityManager getEntityManager() {

		if (conexao == null) {
			conexao = new ConexaoEntityFactory();
		}
		return conexao.getEntityManager();
	}
}

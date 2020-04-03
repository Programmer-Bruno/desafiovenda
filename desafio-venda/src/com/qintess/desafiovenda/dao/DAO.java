package com.qintess.desafiovenda.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qintess.desafiovenda.config.HibernateConfig;

public class DAO<T> {

	public void insere(T classe) {

		Transaction transacao = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {

			transacao = session.beginTransaction();
			session.save(classe);

			transacao.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualiza(T classe) {

		Transaction transacao = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {

			transacao = session.beginTransaction();
			session.merge(classe);

			transacao.commit();

		} catch (Exception e) {
			if (transacao != null) {
				transacao.rollback();
			}
			e.printStackTrace();
		}
	}
	public void remove(T classe) {

		Transaction transacao = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {

			transacao = session.beginTransaction();
			session.remove(classe);

			transacao.commit();

		} catch (Exception e) {
			if (transacao != null) {
				transacao.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public Object buscaPorID(T classe, int id) {
		try(Session session = HibernateConfig.getSessionFactory().openSession()) {
			
			return session.find(classe.getClass(), id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> buscaTodos(T classe) {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {

			return session.createQuery("from " + classe.getClass().getName() + " t").list();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

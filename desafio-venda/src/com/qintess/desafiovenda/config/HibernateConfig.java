package com.qintess.desafiovenda.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.qintess.desafiovenda.model.Fornecedor;
import com.qintess.desafiovenda.model.FornecedorProdutoID;
import com.qintess.desafiovenda.model.Fornecedor_Produto;
import com.qintess.desafiovenda.model.Produto;
import com.qintess.desafiovenda.model.Venda;
import com.qintess.desafiovenda.model.VendaItens;

public class HibernateConfig {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if (sessionFactory == null) {
			
			try {
				
				Configuration configuration = new Configuration();
				
				Properties prop = new Properties();
				//CONFIG DE CONEXAO AO BANCO DE DADOS
				prop.put(Environment.DRIVER, "org.h2.Driver");
				prop.put(Environment.URL, "jdbc:h2:~/db_desafio_venda");
				prop.put(Environment.USER, "sa");
				prop.put(Environment.PASS, "");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
				
				prop.put(Environment.SHOW_SQL, "true");
				prop.put(Environment.HBM2DDL_AUTO, "create-drop");
				
				configuration.setProperties(prop);
				
				configuration.addAnnotatedClass(Produto.class);
				configuration.addAnnotatedClass(Venda.class);
				configuration.addAnnotatedClass(Fornecedor.class);
				configuration.addAnnotatedClass(Fornecedor_Produto.class);
				configuration.addAnnotatedClass(FornecedorProdutoID.class);
				configuration.addAnnotatedClass(VendaItens.class);
				
				StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        						.applySettings(configuration.getProperties())
                        						.build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
						
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return sessionFactory;
	}
}

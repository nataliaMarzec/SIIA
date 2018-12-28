package ar.sarm.siia.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.siia.dao.ClienteHome;
import ar.sarm.siia.modelo.Cliente;

@Component
@Transactional
public class DataGenerator {
	@Autowired
	private ClienteHome clienteHome;
	@Autowired
	private SessionFactory sessionFactory;
	
	protected void generate() {
		Cliente cliente=new Cliente();
		cliente.setFullName("John");
		
		Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
		clienteHome.saveOrUpdate(cliente);
		ts.commit();
	}
	
	public static void main(String[] args) {
		HibernateConfiguration.crearDB = true;
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("ar.sarm.sia","ar.sarm.siia.hibernate");
		ctx.refresh();
		DataGenerator dg = (DataGenerator) ctx.getBean("dataGenerator");
		dg.generate();
		
		ctx.close();
	}
}

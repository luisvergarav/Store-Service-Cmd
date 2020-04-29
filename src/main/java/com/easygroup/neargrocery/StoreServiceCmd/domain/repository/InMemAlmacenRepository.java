package com.easygroup.neargrocery.StoreServiceCmd.domain.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.easygroup.neargrocery.StoreServiceCmd.domain.entities.Almacen;

/**
 *
 * @author Vass Chile
 */
@Repository("almacenRepository")
public class InMemAlmacenRepository implements AlmacenRepository<Almacen, String> {

	private static final Logger log = Logger.getLogger(InMemAlmacenRepository.class);

	private SessionFactory sessionFactory;

	/**
	 * Initializep
	 * 
	 * @throws Exception
	 */
	public InMemAlmacenRepository(SessionFactory sessionFactory) throws Exception {
		this.sessionFactory = sessionFactory;
	}

	// Injected database connection:
	// @PersistenceContext private EntityManager em;

	// Stores a new guest:
	@Transactional
	@Override
	public boolean add(Almacen entity) {
		Session session = this.sessionFactory.getCurrentSession();

		// EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(
		// "mysql-eclipselink" );
		// EntityManager entitymanager = emfactory.createEntityManager( );
		//session.getTransaction( ).begin( );

		session.persist(entity);
		//session.getTransaction().commit();
		// entitymanager.refresh(entity);


		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.falabella.login.domain.repository.Repository#remove(java.lang.Object)
	 */
	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Almacen entity) {
		Session session = this.sessionFactory.getCurrentSession();

//		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mysql-eclipselink");
//		EntityManager entitymanager = emfactory.createEntityManager();

		session.getTransaction().begin();

		session.merge(entity);
		session.getTransaction().commit();

	}

	@Override
	public boolean contains(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	@Override
	public Almacen get(String id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
//
//		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mysql-eclipselink");
//		EntityManager entitymanager = emfactory.createEntityManager();
		Query q = session.createNativeQuery("Select * From Almacen a inner join Usuario u on a.idUsuario = u.idUsuario where u.idUsuario = ? ", Almacen.class);

		q.setParameter(1, id);
		return (Almacen) q.getSingleResult();
	}

	@Override
	public Collection<Almacen> getAll(String id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();

//		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mysql-eclipselink");
//		EntityManager entitymanager = emfactory.createEntityManager();

		
		return session.createQuery("Select a From Almacen a", Almacen.class).getResultList();

	}

	@Override
	public Almacen get(Integer id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();

		
//		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mysql-eclipselink");
//		EntityManager entitymanager = emfactory.createEntityManager();
		return session.find(Almacen.class, id);
	}
	@Transactional
	@Override
	public List<Almacen> getAll(String region, String comuna, String articulo) throws Exception {
		
		Session session = this.sessionFactory.getCurrentSession();

//		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mysql-eclipselink");
//		EntityManager entitymanager = emfactory.createEntityManager();

		Query q = session.createNativeQuery(
				"select * from Almacen al inner join Ubicacion u on al.idAlmacen = u.idAlmacen where u.region like ? and u.comuna like ? and ? in (select a.nombreArticulo from Articulo  a where a.idAlmacen = al.idAlmacen)",
				Almacen.class);
		// + "Select a From Almacen a inner join a.articulos b where a.Region = ?1 and
		// a.Comuna =?2 and b.nombreArticulo like ?3",Almacen.class);

		q.setParameter(1, "%" + region + "%");
		q.setParameter(2, "%" + comuna + "%");
		q.setParameter(3, articulo);

		return (List<Almacen>) q.getResultList();
	}

}

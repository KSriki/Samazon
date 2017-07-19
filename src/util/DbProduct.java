package util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Product;


public class DbProduct {
	
	public static void insert(Product prod) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(prod);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Product prod) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(prod);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Product prod) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(prod));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	/*
	public static List<Product> samPost (){
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "select p from Products p";
		
		List<Product> posts = null;
		try{
			TypedQuery<Product> query = em.createQuery(qString,Product.class);
			posts = query.getResultList();

		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
				em.close();
			}
		return posts;
	}
	
	public static List<Product> postsofUser(long userid)
	{
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		List<Bhpost> userposts = null;
		String qString = "select b from Bhpost b where b.bhuser.bhuserid = :userid";
		
		try{
			TypedQuery<Bhpost> query = em.createQuery(qString,Bhpost.class);
			query.setParameter("userid", userid);
			userposts = query.getResultList();
		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
				em.close();
			}
		return userposts;	
	}
	public static List<Bhpost> postsofUser(String useremail)
	{
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		List<Bhpost> userposts = null;
		String qString = "select b from Bhpost b "
				+ "where b.bhuser.useremail = :useremail";
		
		try{
			TypedQuery<Bhpost> query = em.createQuery(qString,Bhpost.class);
			query.setParameter("useremail", useremail);
			userposts = query.getResultList();
		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
				em.close();
			}
		return userposts;	
	}
	
	public static List<Bhpost> searchPosts (String search)
	{
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		List<Bhpost> searchposts = null;
		String qString = "select b from Bhpost b "
				+ "where b.posttext like :search";
		
		try{
			TypedQuery<Bhpost> query = em.createQuery(qString,Bhpost.class);
			query.setParameter("search", "%" + search + "%");
			searchposts = query.getResultList();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}return searchposts;
	}
	*/
	
}

package util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Product;
import model.Samitem;
import model.Samuser;

public class DbItems {


	public static void insert(Samitem cartitem) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(cartitem);
			em.flush();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Samitem cartitem) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(cartitem);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Samitem cartitem) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(cartitem));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}


	public static List<Samitem> getCartitem (int id){
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "select p from Samitem p where p.samuser.samid = " + id + " and p.list='CART'";
		
		
		List<Samitem>cartitem = null;
		try{
			TypedQuery<Samitem> query = em.createQuery(qString,Samitem.class);
			
			cartitem = query.getResultList();

		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
			em.close();
		}
		return cartitem;
	}

/*	public static Samitem getCartitem(int pID)
	{
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		Samitem cartitem = em.find(Samitem.class, pID);
		return cartitem;		
	}
*/
	/*
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



package country.dao;

import country.model.Country;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;


@Repository("countryDao")
public class CountryDAOImpl extends Dao implements CountryDAO {

	
	@SuppressWarnings("unused")
	private Transaction trans;
	@Override
	public boolean saveCountry(Country country) {
		// TODO Auto-generated method stub
		Session session=getSession();
		   Transaction trans=session.beginTransaction();
		   try {
			   session.save(country);
			   trans.commit();
			   session.close();
			   return true;
		   }catch(Exception e){
			   System.out.print(e.getMessage());

		   }
		   return false;
	}

	@Override
	public Country findByCode(String code) {
		// TODO Auto-generated method stub
		Session session=getSession();
		   trans = session.beginTransaction();
		   Country countries=new Country();
		  try {
			   countries = (Country) session.createQuery("FROM Country where code=:countrycode").setParameter("countrycode", code).uniqueResult();
		  }
		  catch(Exception e)
		  {
			  System.out.print(e.getMessage());
		  }
		   trans.commit();
		   session.close();
		   return countries;
    }
	
	@Override
	public List<Country> listCountry() {
		// TODO Auto-generated method stub
		Session session=getSession();
		   trans = session.beginTransaction();
		  @SuppressWarnings("unchecked")
		   List<Country> countries =  session.createQuery("FROM Country").list();
		   trans.commit();
		   session.close();
		   return countries;
	}

	
}
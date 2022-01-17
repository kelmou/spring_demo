package country.dao;

import country.model.Country;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;


@Repository("countryDao")
public class CountryDAOImpl extends Dao implements CountryDAO {

	
	@SuppressWarnings("unused")
	private Transaction trans;
	private Session session=getSession();
	@Override
	public void saveCountry(Country country) {
		// TODO Auto-generated method stub
		Session session=getSession();
		   Transaction trans=session.beginTransaction();
		   session.save(country);
		   trans.commit();
		   session.close();
	}
	@Override
	public void listCountry() {
		// TODO Auto-generated method stub
		   trans = session.beginTransaction();
		   @SuppressWarnings("unchecked")
		List<Country> countries = session.createQuery("FROM Country").list();
		   for (Iterator iterator =countries.iterator(); iterator.hasNext();){
			Country country = (Country) iterator.next();
			System.out.print(" Name: " + country.getName());
			System.out.print(" ,Devise: " + country.getDevise());
			System.out.print(" ,Greetings: " + country.getGreetings());
			System.out.println(",Code: " + country.getCode());
			}
		   trans.commit();
		   session.close();
	}
	
	
}

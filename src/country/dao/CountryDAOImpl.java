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

			Session session=getSession();
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
	
	@Override
	public void findByCode(String code) {
		// TODO Auto-generated method stub
		Session session=getSession();
		   trans = session.beginTransaction();
		   @SuppressWarnings("unchecked")
		   List countries = session.createQuery("FROM Country where code=:countrycode").setParameter("countrycode", code).list();
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
	@Override
	public void deleteByCode(String code)
	{
		Session session = getSession();
		trans = session.beginTransaction();
		int query = session.createSQLQuery("delete from Country where code = :code").setParameter("code", code).executeUpdate();
		if(query>0)
			System.out.println("Pays avec le code  :"+code+" est supprimé");
		else
			System.out.println("Pays avec le code  :"+code+" non existe");
		trans.commit();
		session.close();
	}
	@Override
	public void updateByCode(String code, Country c) {
		// TODO Auto-generated method stub
		Session session = getSession();
		trans = session.beginTransaction();
		int query = session.createSQLQuery(
				"UPDATE Country SET name = :name ,devise =:devise ,greetings=:greetings  WHERE code = :code").setParameter("code", code).setParameter("name", c.getName()).setParameter("devise", c.getDevise()).setParameter("greetings", c.getGreetings()).executeUpdate();
		trans.commit();
		session.close();
		if(query>0)
		{
			System.out.println("Pays avec le code  :"+code+" est modifié");
			System.out.println("Nouvelle Modification");
			findByCode(code);
		}
		else
			System.out.println("Pays avec le code  :"+code+" non existe");
	
	}
	
}
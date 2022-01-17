package country.dao;

import country.model.Country;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class CountryDAOImpl implements CountryDAO {
	private static final Logger LOGGER = Logger.getLogger(CountryDAOImpl.class.getName());
	@Autowired
	private DataSource dataSource;
	
	@Override
	public Country getByCode(String countryCode) {
		Country country = null;
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM country where code = ?;");
			preparedStatement.setString(1, countryCode);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				country = new Country();
				Integer id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String code = resultSet.getString(3);
				String devise = resultSet.getString(4);
				String greetings = resultSet.getString(5);
				
				country.setId(id);
				country.setName(name);
				country.setCode(code);
				country.setDevise(devise);
				country.setGreetings(greetings);
				
			}
		} catch (SQLException exception) {
			LOGGER.log(Level.SEVERE, "Exception while accessing the database", exception);
		}
		return country;
	}
=======

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
	
	
>>>>>>> origin/aspect-fonctionnel-01
}

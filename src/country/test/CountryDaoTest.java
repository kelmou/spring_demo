package country.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import configuration.AppConfig;
import continent.model.Continent;
import country.dao.CountryDAO;
import country.model.Country;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})

public class CountryDaoTest   {
	@Autowired
	CountryDAO countryDao;
	List<Country>countries=new ArrayList<Country>();

	static boolean initialised= false;
	
	@Before
	public void setup() {
		if(!initialised) {
			countries=countryDao.listCountry();
			initialised = true;
		}
	}
	
    @Test
    public void saveCountryTest()
	 { 
		 Country country=new Country();
		 country.setCode("ma");
		 country.setDevise("Dirham");
		 country.setGreetings("Salam");
		 country.setName("Maroc");
		 assertEquals(countryDao.saveCountry(country),true);
	 }
	 @Test
	 public void findByCodeTest()
	 { 
		 Country country=new Country();
		 country.setCode("fr");
		 country.setDevise("EURO");
		 country.setGreetings("Bonjour");
		 country.setName("France");
		 assertEquals(countryDao.findByCode("fr").getCode(),country.getCode());
		 assertEquals(countryDao.findByCode("fr").getDevise(),country.getDevise());
		 assertEquals(countryDao.findByCode("fr").getName(),country.getName());
		 assertEquals(countryDao.findByCode("fr").getGreetings(),country.getGreetings());
	 } 
	 @Test
	 public void deleteCodeTest()
	 {
		 assertEquals(countryDao.deleteByCode("ma"),true);
	 }
	 @Test
	 public void updateByCodeTest()
	 {
	 }
	 @Test
	  public void getCountriesofContinentTest()
	  {
		List<Country>contriesOfEurope=new ArrayList<Country>();
		contriesOfEurope.add(countryDao.findByCode("fr"));
	    contriesOfEurope.add(countryDao.findByCode("es"));
	    contriesOfEurope.add(countryDao.findByCode("en"));
		contriesOfEurope.add(countryDao.findByCode("de"));
		assertEquals(contriesOfEurope,countryDao.getCountriesofContinent("EU"));
	  }
}
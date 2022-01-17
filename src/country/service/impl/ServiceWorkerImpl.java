package country.service.impl;

import country.dao.CountryDAO;
import country.model.Country;
import country.service.ICountryService;
import country.service.IServiceWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ServiceWorkerImpl implements IServiceWorker {
	@Autowired
	private CountryDAO countryDAO;
<<<<<<< HEAD
	@Autowired
	private ApplicationContext applicationContext;
	
	@Override
	public void dealWithCountryByCode(String language) {
		Country pays = countryDAO.getByCode(language);
		// car c'est prototype
		ICountryService countryService = applicationContext.getBean(ICountryService.class, pays);
		
		System.out.println("WELCOME : " + countryService.welcome());
		System.out.println("Devise is :" + countryService.devise());
=======

	@Override
	public void InsertCountry(String country) {
		// TODO Auto-generated method stub
		String[] l=country.split(",");
		Country country2=new Country();
		country2.setCode(l[0]);
		country2.setDevise(l[2]);
		country2.setGreetings(l[3]);
		country2.setName(l[1]);
		countryDAO.saveCountry(country2);
	}

	@Override
	public void listCountry() {
		// TODO Auto-generated method stub
		countryDAO.listCountry();
		
>>>>>>> origin/aspect-fonctionnel-01
	}
}

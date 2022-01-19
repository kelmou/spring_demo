package country.service.impl;

import country.dao.CountryDAO;
import country.model.Country;
import country.service.IServiceWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceWorkerImpl implements IServiceWorker {
	@Autowired
	private CountryDAO countryDAO;
	
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
	}

	@Override
	public void findByCode(String code) {
		// TODO Auto-generated method stub
		countryDAO.findByCode(code);
	}

	@Override
	public void deleteByCode(String code) {
		// TODO Auto-generated method stub
		countryDAO.deleteByCode(code);
	}
	@Override
	public void updateByCode(String code, Country c) {
		// TODO Auto-generated method stub
		countryDAO.updateByCode(code,c);
	}

	@Override
	public void getCountriesofContinent(String continentcode) {
		// TODO Auto-generated method stub
		countryDAO.getCountriesofContinent(continentcode);
	}
}

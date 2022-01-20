package country.service.impl;

import country.dao.CountryDAO;
import country.model.Country;
import country.service.IServiceWorker;

import java.util.List;

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
		if(countryDAO.saveCountry(country2)==true)
			System.out.println("Insertion valide");
		else
			System.out.println("Insertion non valide");
		
	}
	@Override
	public List<Country> listCountry() {
		// TODO Auto-generated method stub
			return countryDAO.listCountry();	
	}

	@Override
	public Country findByCode(String code) {
		// TODO Auto-generated method stub
			return countryDAO.findByCode(code);
	}

	@Override
	public void deleteByCode(String code) {
		// TODO Auto-generated method stub
		if(countryDAO.deleteByCode(code)==true)
			System.out.println("Pays avec le code  :"+code+" est supprimé");
		else
			System.out.println("Pays avec le code  :"+code+" non existe");	
	}
}

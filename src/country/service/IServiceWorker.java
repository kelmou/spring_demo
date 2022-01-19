package country.service;

import country.model.Country;

public interface IServiceWorker {
	void listCountry();
	void InsertCountry(String country);
	void findByCode(String code);
	 void deleteByCode(String code);
	 void updateByCode(String code,Country c);
	 void getCountriesofContinent(String continentcode);
}

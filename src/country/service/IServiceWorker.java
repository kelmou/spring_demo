package country.service;

import java.util.List;

import country.model.Country;

public interface IServiceWorker {
	List<Country>listCountry();
	void InsertCountry(String country);
}

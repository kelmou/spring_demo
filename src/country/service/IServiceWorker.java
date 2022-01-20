package country.service;
import java.util.*;

import country.model.Country;
public interface IServiceWorker {

	List<Country>listCountry();
	void InsertCountry(String country);
	Country findByCode(String code);
    void deleteByCode(String code);
}

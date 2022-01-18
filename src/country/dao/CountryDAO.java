package country.dao;

import country.model.Country;

public interface CountryDAO {
   void saveCountry(Country country);
   void listCountry();
   void findByCode(String code);
   void deleteByCode(String code);
}
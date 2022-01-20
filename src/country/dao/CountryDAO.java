package country.dao;

import java.util.List;

public interface CountryDAO {
   boolean saveCountry(Country country);
   List<Country> listCountry();
   Country findByCode(String code);
}
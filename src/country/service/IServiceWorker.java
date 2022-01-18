package country.service;

public interface IServiceWorker {
	void listCountry();
	void InsertCountry(String country);
	void findByCode(String code);
}

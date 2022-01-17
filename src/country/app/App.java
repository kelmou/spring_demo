package country.app;

import country.service.IServiceWorker;
import org.springframework.context.ApplicationContext;
<<<<<<< HEAD
import org.springframework.context.support.ClassPathXmlApplicationContext;

=======
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import configuration.HibernateConfiguration;

>>>>>>> origin/aspect-fonctionnel-01
import java.util.Scanner;

@SuppressWarnings("all")
public class App {
	public static void main(String[] args) {
<<<<<<< HEAD
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("beans/*.xml");
		IServiceWorker serviceWorker = applicationContext.getBean(IServiceWorker.class);
		while (true) {
			System.out.print("Choisir une langue : ");
			Scanner inputFromConsole = new Scanner(System.in);
			String language = inputFromConsole.next();
			serviceWorker.dealWithCountryByCode(language);
=======
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
		IServiceWorker serviceWorker = applicationContext.getBean(IServiceWorker.class);
		int choix=0;
		while (true) {
			System.out.println("\nLe menu devra etre interactif : \r\n" + 
					"1- Pour l'ajout d'un nouveau pays tapper 1,r\n" + 
					"2- Pour lister les informations d'un pays, tapper 2, (le code pays sera saisi par l'utilisateur).\r\n" + 
					"3- Pour supprimer un pays, tapper 3, (le code pays sera saisi par l'utilisateur).\r\n" + 
					"4- Pour modifier des informations d'un pays, tapper 4, (le code pays sera saisi par l'utilisateur).\r\n" + 
					"5- Pour lister tous les pays d'un continent, tapper 5, (le code du continent sera saisi par l'utilisateur).\r\n" + 
					"6- Pour sortir de l'application tapper 0;");
			System.out.println("S'il vous plait entrer un nombre");
			
			Scanner inputFromConsole = new Scanner(System.in);
			choix= inputFromConsole.nextInt();
			if(choix==0)
			{

				System.out.print("Vous étes sorti de l'application");
				System.exit(0);
			}
			else if(choix==1)
			{

				System.out.println("Ajouter un pays comme cet exemple (FR,france,EURO,Bonjour!) : ");
				Scanner inputFromConsole1 = new Scanner(System.in);
				String pays = inputFromConsole1.next();
				serviceWorker.InsertCountry(pays);
				serviceWorker.listCountry();
			}
			else
			{
				System.out.print("ce choix n'existe pas maintenant ");
			}
>>>>>>> origin/aspect-fonctionnel-01
			
		}
	}
	
}

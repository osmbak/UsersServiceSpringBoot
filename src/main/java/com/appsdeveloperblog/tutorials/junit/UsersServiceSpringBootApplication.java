package com.appsdeveloperblog.tutorials.junit;

import com.appsdeveloperblog.tutorials.junit.shared.SpringApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;

@SpringBootApplication
public class UsersServiceSpringBootApplication {

	public static void main(String[] args) {
		List<String> chaine = new ArrayList(asList("chat", "chien", "poule", "poisson", "cheval", "vache"));

/*		numbers.stream().filter(nomber -> nomber % 2 != 0 )
						.map(nomber-> nomber*10)
								.forEach(System.out::println);*/
//		chaine.stream().filter(a-> a.startsWith("c"))
//				.map(a-> a.toUpperCase())
//				.forEach(System.out::println);
//trier objet par prix ( sort)
		/*List<Produit> produits = Arrays.asList(
				new Produit("Ordinateur", 1200.50, 10),
				new Produit("Téléphone", 750.99, 50),
				new Produit("Tablette", 300.00, 5),
				new Produit("Montre connectée", 150.75, 30));

		produits.stream().sorted(Comparator.comparingDouble(Produit::prix).reversed())
				.forEach(System.out::println);

		double sommeTotale = produits.stream()
				.mapT(p -> p.prix() * p.quantite())  // Calcul du total en multipliant le prix par la quantité
				.sum();*/




		SpringApplication.run(UsersServiceSpringBootApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}


	@Bean
	public Executor taskExecutor() {
		return Executors.newVirtualThreadPerTaskExecutor();
	}
}



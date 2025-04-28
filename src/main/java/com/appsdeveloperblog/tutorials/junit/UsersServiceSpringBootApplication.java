package com.appsdeveloperblog.tutorials.junit;

import com.appsdeveloperblog.tutorials.junit.shared.SpringApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;

@SpringBootApplication
public class UsersServiceSpringBootApplication {

	public static void main(String[] args) {
		List<String> chaine = new ArrayList(asList("chat", "chien", "poule", "poisson", "cheval", "vache"));

/*		numbers.stream().filter(nomber -> nomber % 2 != 0 )
						.map(nomber-> nomber*10)
								.forEach(System.out::println);*/
		chaine.stream().filter(a-> a.startsWith("c"))
				.map(a-> a.toUpperCase())
				.forEach(System.out::println);


		// 1. Créer un ExecutorService avec un pool de 3 threads
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		// 2. Soumettre des tâches (Runnable)
		for (int i = 1; i <= 5; i++) {
			int taskId = i;
			executorService.submit(() -> {
				System.out.println("Tâche " + taskId + " exécutée dans " + Thread.currentThread().getName());
				try {
					Thread.sleep(1000); // Simuler un travail
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			});
		}

		// 3. Dire à l'ExecutorService de ne plus accepter de nouvelles tâches
		executorService.shutdown();

		// 4. Attendre que toutes les tâches soient terminées
		try {
			if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
				executorService.shutdownNow(); // Forcer l'arrêt si ça prend trop de temps
			}
		} catch (InterruptedException e) {
			executorService.shutdownNow();
		}
		//trst
		System.out.println("Toutes les tâches sont terminées !");

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
}

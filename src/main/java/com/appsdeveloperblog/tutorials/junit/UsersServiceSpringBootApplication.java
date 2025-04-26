package com.appsdeveloperblog.tutorials.junit;

import com.appsdeveloperblog.tutorials.junit.shared.SpringApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

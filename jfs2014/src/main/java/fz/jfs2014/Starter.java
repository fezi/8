package fz.jfs2014;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@ComponentScan("fz.jfs2014")
@Configuration
public class Starter {
	private static final Logger log = LoggerFactory.getLogger(Starter.class);

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(Starter.class, args);
		makeUsers(ctx.getBean(UserRepo.class));
		debugOutputSpringBeans(ctx);
	}

	private static void makeUsers(UserRepo userRepo) {
		userRepo.save(new User("Jack"));
		userRepo.save(new User("Chloe"));
		userRepo.save(new User("Jack"));
		userRepo.save(new User("David"));
		userRepo.save(new User("Michelle"));

		// fetch all Users
		Iterable<User> Users = userRepo.findAll();
		log.info("Users found with findAll():");
		log.info("-------------------------------");
		for (User User : Users) {
			log.info(User.toString());
		}

		// fetch an individual User by ID
		User User = userRepo.findOne(1L);
		log.info("User found with findOne(1L):");
		log.info("--------------------------------");
		log.info(User.toString());

	}

	private static void debugOutputSpringBeans(ApplicationContext ctx) {
		log.debug("Let's inspect the beans provided by Spring Boot:");
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			log.debug(beanName);
		}
	}

}
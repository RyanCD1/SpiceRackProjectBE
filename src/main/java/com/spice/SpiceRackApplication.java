package com.spice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spice.rest.SpiceController;

@SpringBootApplication
public class SpiceRackApplication {

	public static void main(String[] args) {
		ApplicationContext beanBag = SpringApplication.run(SpiceRackApplication.class, args);
		SpiceController controller = beanBag.getBean(SpiceController.class);
		System.out.println(controller);

		SpringApplication.run(SpiceRackApplication.class, args);
	}

}

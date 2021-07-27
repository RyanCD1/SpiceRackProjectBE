package com.spice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spice.rest.SpiceController;
import com.spice.service.SpiceServiceList;

@SpringBootApplication
public class SpiceRackApplication {

	public static void main(String[] args) {
		ApplicationContext beanBag = SpringApplication.run(SpiceRackApplication.class, args);
		SpiceController controller = beanBag.getBean(SpiceController.class);
		System.out.println(controller);

		SpiceServiceList service = beanBag.getBean(SpiceServiceList.class);
		System.out.println(service);
	}

}

package com.example.rabbitserver;


import com.example.rabbitserver.dto.Bar;
import com.example.rabbitserver.dto.Foo;
import com.example.rabbitserver.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class RabbitmqdemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqdemoApplication.class, args);
	}

	@Autowired
	SenderService senderService;

	@Override
	public void run(String... strings) throws Exception {
		Random random = new Random();
		while (true){
			System.out.println(String.valueOf("Bar111111111111111111111"));
			Thread.sleep(3000);
			senderService.sendBar2Rabbitmq(new Bar(random.nextInt()));
			senderService.sendFoo2Rabbitmq(new Foo("Bar111111111111111111111"));
		}
	}
}

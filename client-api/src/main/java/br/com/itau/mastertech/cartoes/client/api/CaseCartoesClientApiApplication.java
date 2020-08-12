package br.com.itau.mastertech.cartoes.client.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CaseCartoesClientApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseCartoesClientApiApplication.class, args);
	}

}

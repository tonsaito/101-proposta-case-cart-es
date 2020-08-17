package br.com.itau.mastertech.cartoes.card.api;

import br.com.itau.mastertech.cartoes.card.api.config.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
public class CaseCartoesCardApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseCartoesCardApiApplication.class, args);
	}

}

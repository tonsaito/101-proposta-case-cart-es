package br.com.itau.mastertech.cartoes.invoice.api.config;

import br.com.itau.mastertech.cartoes.invoice.api.service.fallback.ClientServiceFallback;
import feign.Feign;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientFeignConfiguration {

    @Bean
    public Feign.Builder builderClient(){
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(new ClientServiceFallback())
                .build();

        return Resilience4jFeign.builder(decorators);
    }
}

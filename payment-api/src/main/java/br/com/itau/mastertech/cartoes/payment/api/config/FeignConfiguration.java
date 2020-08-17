package br.com.itau.mastertech.cartoes.payment.api.config;

import br.com.itau.mastertech.cartoes.payment.api.service.fallback.CardServiceFallback;
import feign.Feign;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public Feign.Builder builder(){
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(new CardServiceFallback())
                .build();

        return Resilience4jFeign.builder(decorators);
    }
}

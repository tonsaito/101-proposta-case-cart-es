package br.com.itau.mastertech.cartoes.invoice.api.config;

import br.com.itau.mastertech.cartoes.invoice.api.service.fallback.CardServiceFallback;
import br.com.itau.mastertech.cartoes.invoice.api.service.fallback.ClientServiceFallback;
import br.com.itau.mastertech.cartoes.invoice.api.service.fallback.PaymentServiceFallback;
import feign.Feign;
import feign.RetryableException;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Feign.Builder feignBuilder(){
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallbackFactory(ClientServiceFallback::new, RetryableException.class)
                .withFallbackFactory(ClientServiceFallback::new, RuntimeException.class)
                .withFallbackFactory(CardServiceFallback::new, RetryableException.class)
                .withFallbackFactory(CardServiceFallback::new, RuntimeException.class)
                .withFallbackFactory(PaymentServiceFallback::new, RetryableException.class)
                .withFallbackFactory(PaymentServiceFallback::new, RuntimeException.class)
                .build();

        return Resilience4jFeign.builder(decorators);
    }

}

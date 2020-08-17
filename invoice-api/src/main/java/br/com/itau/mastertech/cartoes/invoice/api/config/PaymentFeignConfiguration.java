package br.com.itau.mastertech.cartoes.invoice.api.config;

import br.com.itau.mastertech.cartoes.invoice.api.service.fallback.PaymentServiceFallback;
import feign.Feign;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentFeignConfiguration {

    @Bean
    public Feign.Builder builderPayment(){
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(new PaymentServiceFallback())
                .build();

        return Resilience4jFeign.builder(decorators);
    }
}

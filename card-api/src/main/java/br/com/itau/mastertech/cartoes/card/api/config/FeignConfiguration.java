package br.com.itau.mastertech.cartoes.card.api.config;

import br.com.itau.mastertech.cartoes.card.api.service.fallback.ClientServiceFallback;
import com.netflix.client.ClientException;
import feign.Feign;
import feign.FeignException;
import feign.RetryableException;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public Feign.Builder builder(){
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(new ClientServiceFallback())
                .build();

        return Resilience4jFeign.builder(decorators);
    }
}

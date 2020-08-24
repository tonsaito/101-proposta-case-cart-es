package br.com.itau.mastertech.cartoes.invoice.api.config;

public class OauthInterceptorConfig {
    
    @Autowired
    private OAuth2ClientContext clientContext;

    @Autowired
    private ClientCredentialsResourceDetails clientCredentialsResourceDetails;

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor(){
        return new OAuth2FeignRequestInterceptor(clientContext, clientCredentialsResourceDetails);
    }
}

package com.dm.onerosterapi.apiconfig;


import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import java.nio.charset.Charset;
import java.util.Map;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {


    @Value("${spring.security.client.id}")
    private String CLIENT_ID;

    @Value("${spring.security.client.secret}")
    private String CLIENT_SECRET;

    @Value("${server.port}")
    private int sslPort;

    @Value("${spring.security.expiration.days}")
    private int token_valid_days;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private UserApprovalHandler userApprovalHandler;

    @Autowired
    private AuthenticationManager authenticationManager;

    private HostnameVerifier defaultVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
    private HostnameVerifier bypassVerifier = (hostname, sslSession) -> true;

    void disableSSLCheck() { HttpsURLConnection.setDefaultHostnameVerifier(this.bypassVerifier); }
    void enableSSLCheck(){
        HttpsURLConnection.setDefaultHostnameVerifier(this.defaultVerifier);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
        configurer
                .inMemory()
                .withClient(CLIENT_ID)
                .secret(new BCryptPasswordEncoder().encode(CLIENT_SECRET))
                .authorizedGrantTypes("client_credentials")
                .scopes("all")
                .accessTokenValiditySeconds(86400*token_valid_days);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
                .authenticationManager(authenticationManager);
    }

    public Map<String, String> getToken() {

        String auth = CLIENT_ID + ":" + CLIENT_SECRET;
        String encodedAuth = new String (Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII"))));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/x-www-form-urlencoded");
        headers.add("Authorization","Basic " + encodedAuth);

        HttpEntity<Object> request = new HttpEntity<>("grant_type=client_credentials",headers);
        disableSSLCheck();

        try {
            return new RestTemplate().postForObject
                    ("https://localhost:" + sslPort + "/oauth/token", request, Map.class);
        } finally {
            enableSSLCheck();
        }
    }

}


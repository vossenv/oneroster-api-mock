package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.utility.SSLUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.NoHandlerFoundException;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;


@ApiIgnore
@Controller
public class AuthController {

    @Value("${secure.endpoint.uri}")
    private String secureURI;

    @Value("${spring.security.client.id}")
    private String CLIENT_ID;

    @Value("${spring.security.client.secret}")
    private String CLIENT_SECRET;

    @Value("${server.port}")
    private int sslPort;

    @Autowired
    private SSLUtil sslUtil;

    @RequestMapping(value ="${secure.endpoint.uri}/**", method = RequestMethod.GET)
    public void testAPI(HttpServletResponse response, HttpServletRequest request,
                        @RequestHeader HttpHeaders headers) throws ServletException, IOException {

        try {
            String redirect = request.getRequestURL().toString().split(secureURI)[1];
            if (redirect.length() > 1) {
                request.setAttribute("Auth-URL",secureURI);
                request.getRequestDispatcher(redirect).forward(request,response);
            }
        } catch (ArrayIndexOutOfBoundsException e) { /* do nothing */ }
        throw new NoHandlerFoundException(request.getMethod(), request.getRequestURL().toString(), headers);
    }

    @RequestMapping(value="/openauth", method = RequestMethod.GET)
    @ResponseBody
    public Object getToken() {

        String auth = CLIENT_ID + ":" + CLIENT_SECRET;
        String encodedAuth = new String (Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII"))));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/x-www-form-urlencoded");
        headers.add("Authorization","Basic " + encodedAuth);

        HttpEntity<Object> request = new HttpEntity<>("grant_type=client_credentials",headers);

        sslUtil.disableSSLCheck();

        try {

            Object authData = new RestTemplate()
                    .postForEntity("https://localhost:" + sslPort + "/oauth/token", request, Object.class);
            sslUtil.enableSSLCheck();
            return authData;

        } catch (Exception e) {
            sslUtil.enableSSLCheck();
            throw e;
        }

    }


}

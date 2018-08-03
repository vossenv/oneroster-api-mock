package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.apiconfig.AuthorizationServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;
import springfox.documentation.annotations.ApiIgnore;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@ApiIgnore
@Controller
public class AuthController {

    @Value("${secure.endpoint.uri}")
    private String secureURI;

    final private AuthorizationServerConfig authConfig;

    @Inject
    public AuthController(AuthorizationServerConfig authConfig) {
        this.authConfig = authConfig;
    }

    @RequestMapping(value ="${secure.endpoint.uri}/**", method = RequestMethod.GET)
    public void handleSecureEntry(HttpServletResponse response, HttpServletRequest request,
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

    @RequestMapping(value="/token", method = RequestMethod.GET)
    @ResponseBody
    public Object getToken() {
        return authConfig.getToken();
    }

}

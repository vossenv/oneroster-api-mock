package com.dm.onerosterapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ApiIgnore
@Controller
public class AuthController {

    @Value("${secure.endpoint.uri}")
    private String secureURI;

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


    @RequestMapping(value="/info", method = RequestMethod.GET)
    @ResponseBody
    public Object getInfo(HttpServletRequest request){

        List<String> info = new ArrayList<>();

        info.add(request.getRequestURI());
        info.add(request.getRequestURL().toString());
        info.add(request.getHeader("host"));
        info.add(request.getScheme());

        return info;

    }


}

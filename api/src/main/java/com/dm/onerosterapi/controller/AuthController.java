package com.dm.onerosterapi.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.NoHandlerFoundException;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ApiIgnore
@Controller
public class AuthController {

    @RequestMapping(value = "/oa/**", method = {RequestMethod.GET, RequestMethod.POST})
    public void testAPI(HttpServletResponse response, HttpServletRequest request,
                        @RequestHeader HttpHeaders headers) throws NoHandlerFoundException, IOException {
        try {
            String redirect = request.getRequestURL().toString().split("/oa")[1];
            if (redirect.length() > 1) {
                response.sendRedirect(redirect);
            }
        } catch (ArrayIndexOutOfBoundsException e) { /* do nothing */ }
        throw new NoHandlerFoundException(request.getMethod(), request.getRequestURL().toString(), headers);
    }

}

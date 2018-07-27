package com.dm.onerosterapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {

    @Autowired

    private AuthController au;

    @RequestMapping(value = {"","/"}, method = RequestMethod.GET)
    public Object indexPage()  {

        Object o = au.getToken();


        return "index.html";
    }

    @RequestMapping(value="/info", method = RequestMethod.GET)
    @ResponseBody
    public Object getInfo(HttpServletRequest request){

        List<String> info = new ArrayList<>();

        info.add(request.getRequestURI());
        info.add(request.getRequestURL().toString());
        info.add(request.getHeader("host"));
        info.add(request.getScheme());
        info.add(au.getToken().toString());



        return info;
    }


    @RequestMapping(value = {"/docs"})
    void handleSwagger(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

}

package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.apiconfig.AuthorizationServerConfig;
import com.dm.onerosterapi.utility.PropertyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@ApiIgnore
@Controller
public class ViewController {

    @Autowired
    AuthorizationServerConfig authConfig;

    @RequestMapping(value = {"","/"}, method = RequestMethod.GET)
    public Object indexPage(Model model)  {

        PropertyGenerator pg = new PropertyGenerator();
        model.addAllAttributes(pg.generateProperties());

        return "index.html";
    }

    @RequestMapping(value="/info", method = RequestMethod.GET)
    @ResponseBody
    public Object getInfo(HttpServletRequest request) {

        PropertyGenerator pg = new PropertyGenerator();

        Map<String, String> info = new LinkedHashMap<>(pg.generateProperties());
        info.put("full URL", request.getRequestURL().toString());
        info.putAll(authConfig.getToken());

        return info;
    }

    @RequestMapping(value = {"/docs"})
    void handleSwagger(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @RequestMapping(value = {"/static/**"}, method = RequestMethod.GET)
    public Object fetchStaticResource(HttpServletRequest request) {
        String path = request.getRequestURL().toString().split("/static/")[1];

        if (path.endsWith(".map")) { return "../static/js/empty.js" ; }
        return "../static/" + path;

    }

}

package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.apiconfig.AuthorizationServerConfig;
import com.dm.onerosterapi.utility.PropertyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public Object indexPage()  {
        return "index.html";
    }

    @RequestMapping(value = {"/js/homepage.js"}, method = RequestMethod.GET)
    public Object thingsJavascript() { return "../static/js/homepage.js"; }

    @RequestMapping(value = {"/js/jquery-3.3.1.min.js"}, method = RequestMethod.GET)
    public Object jQueryJavascript() { return "../static/js/jquery-3.3.1.min.js"; }

    @RequestMapping(value = {"/js/bootstrap.min.js"}, method = RequestMethod.GET)
    public Object bootstrapJavascript() { return "../static/js/bootstrap.min.js"; }

    @RequestMapping(value = {"/js/showdown.min.js"}, method = RequestMethod.GET)
    public Object showdownJavascript() { return "../static/js/showdown.min.js"; }

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

}

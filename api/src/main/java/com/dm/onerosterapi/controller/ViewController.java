package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.apiconfig.AuthorizationServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${version}")
    private String version;

    @Value("${build_date}")
    private String date;

    @Value("${commit_message}")
    private String message;

    @Autowired
    AuthorizationServerConfig authConfig;

    @RequestMapping(value = {"","/"}, method = RequestMethod.GET)
    public Object indexPage()  {
        return "index.html";
    }

    @RequestMapping(value="/info", method = RequestMethod.GET)
    @ResponseBody
    public Object getInfo(HttpServletRequest request) {

        Map<String, String> info = new LinkedHashMap<>();

        info.put("version",this.version);
        info.put("build_date",this.date);
        info.put("commit_message",this.message);

        info.put("full URL", request.getRequestURL().toString());
        info.putAll(authConfig.getToken());

        return info;
    }

    @RequestMapping(value = {"/docs"})
    void handleSwagger(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

}

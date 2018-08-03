package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.apiconfig.AuthorizationServerConfig;
import com.dm.onerosterapi.utility.PropertyGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@ApiIgnore
@Controller
@SuppressWarnings({"OptionalUsedAsFieldOrParameterType", "DefaultAnnotationParam"})
public class ViewController {

    final private AuthorizationServerConfig authConfig;
    final private PropertyGenerator propertyGenerator;

    @Inject
    public ViewController(AuthorizationServerConfig authConfig, PropertyGenerator propertyGenerator) {
        this.authConfig = authConfig;
        this.propertyGenerator = propertyGenerator;
    }

    @RequestMapping(value = {"","/"}, method = RequestMethod.GET)
    public Object indexPage(Model model, HttpServletRequest request)  {
        model.addAttribute("info", getInfo(request));
        return "index.html";
    }

    @RequestMapping(value="/info", method = RequestMethod.GET)
    @ResponseBody
    public Object getInfo(HttpServletRequest request) {

        Map<String, String> info =
                new LinkedHashMap<>(propertyGenerator.generateProperties());

        info.put("full URL", request.getRequestURL().toString());
        info.putAll(authConfig.getToken());
        return info;
    }

    @RequestMapping(value = {"/docs"})
    void handleSwagger(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }


}

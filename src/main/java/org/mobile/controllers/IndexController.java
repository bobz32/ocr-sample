package org.mobile.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Simple Index Controller, just returns the index.html for testins
 */
@Controller
public class IndexController {


    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

}

package com.lvmama.order.controller;


import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class HelloSpringBoot {

    final Logger logger = Logger.getLogger(HelloSpringBoot.class);

    @RequestMapping("/request")
    public String request(HttpServletRequest request){
        request.setAttribute("name", "Penns");
        return "index";
    }

    @RequestMapping("/model/{orderId}")
    public ModelAndView model(@PathVariable("orderId") Long orderId){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "Penn");
        mav.setViewName("index");
        return mav;
    }


    @RequestMapping(value= "/param", method= RequestMethod.GET)
    public ModelAndView param(@RequestParam("orderId") Long orderId){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "Test");
        mav.setViewName("index");
        String logSuffix = String.format("orderId=%d performed successfully.", orderId);
        logger.info(logSuffix);
        return mav;
    }

    @RequestMapping("/map")
    public String map(Map<String, Object> map){
        map.put("name", "Penny");
        return "index";
    }


}

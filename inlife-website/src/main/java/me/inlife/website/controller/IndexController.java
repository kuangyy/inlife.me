package me.inlife.website.controller;

import me.inlife.website.ibusiness.IPosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kuangye on 2016/12/8.
 */
@Controller
public class IndexController extends BaseController {


    @Autowired
    IPosts iPosts;

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        ModelAndView mav = new ModelAndView("index");






        return mav;
    }


}

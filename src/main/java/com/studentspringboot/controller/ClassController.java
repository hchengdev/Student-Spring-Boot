package com.studentspringboot.controller;

import com.studentspringboot.service.ClassService;
import com.studentspringboot.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.studentspringboot.model.Class;



@Controller
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    private IClassService classService;

    @RequestMapping("")
    public ModelAndView index(@PageableDefault(value = 5) Pageable pageable) {
        Page<Class> classes = classService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/classList");
        modelAndView.addObject("class", classes);
        return modelAndView;
    }
}

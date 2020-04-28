package com.javaweb.myblog.controller.web;

import com.javaweb.myblog.model.PostModel;
import com.javaweb.myblog.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller(value = "controllerOfWeb")
public class HomeController {

    @Autowired
    private IPostService postService;

    @GetMapping(value = {"/home", "/"})
    public String homePage(Model model) {
        List<PostModel> postModels = postService.findAll();
        model.addAttribute("posts", postModels);
        return "home";
    }


}

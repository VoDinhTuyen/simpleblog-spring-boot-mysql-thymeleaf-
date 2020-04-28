package com.javaweb.myblog.controller.admin;

import com.javaweb.myblog.model.PostModel;
import com.javaweb.myblog.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller(value = "controllerOfAdmin")
public class HomeController {

    @Autowired
    private IPostService postService;

    @GetMapping(value = {"/admin/home", "/admin"})
    public String homePage(Model model, @RequestParam(value = "message", required = false) String message) {
        List<PostModel> posts = postService.findAll();
        model.addAttribute("message", message);
        model.addAttribute("posts", posts);
        return "admin_home";
    }

}

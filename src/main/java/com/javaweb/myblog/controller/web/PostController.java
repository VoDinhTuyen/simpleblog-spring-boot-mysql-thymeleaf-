package com.javaweb.myblog.controller.web;

import com.javaweb.myblog.model.PostModel;
import com.javaweb.myblog.service.IPostService;
import com.javaweb.myblog.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller(value = "postControllerOfWeb")
public class PostController {

    @Autowired
    private IPostService postService;

    @GetMapping(value = {"/detail/{id}"})
    public String detailPage(@PathVariable("id") Long id, Model model) {
        PostModel postModel = postService.findById(id).get();
        model.addAttribute("post", postModel);
        return "post_detail";
    }
}

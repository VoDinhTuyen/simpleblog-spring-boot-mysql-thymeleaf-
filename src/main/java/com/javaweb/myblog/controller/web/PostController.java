package com.javaweb.myblog.controller.web;

import com.javaweb.myblog.model.CommentModel;
import com.javaweb.myblog.model.PostModel;
import com.javaweb.myblog.service.ICommentService;
import com.javaweb.myblog.service.IPostService;
import com.javaweb.myblog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller(value = "postControllerOfWeb")
public class PostController {

    @Autowired
    private IPostService postService;

    @Autowired
    private ICommentService commentService;

    @GetMapping(value = {"/detail/{id}"})
    public String detailPage(@PathVariable("id") Long id, Model model) {
        PostModel postModel = postService.findById(id).get();
        model.addAttribute("post", postModel);
        // comment
        model.addAttribute("comment", new CommentModel());
        // list comment
        List<CommentModel> commentModels = commentService.findAllByPostId(id);
        model.addAttribute("comments", commentModels);
        return "post_detail";
    }
}

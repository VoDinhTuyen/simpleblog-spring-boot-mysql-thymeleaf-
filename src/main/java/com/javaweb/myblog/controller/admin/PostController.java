package com.javaweb.myblog.controller.admin;

import com.javaweb.myblog.model.PostModel;
import com.javaweb.myblog.service.IPostService;
import com.javaweb.myblog.service.impl.PostService;
import com.javaweb.myblog.validator.PostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostValidator postValidator;

    @Autowired
    private IPostService postService;

    @GetMapping(value = {"/admin/add"})
    public String addPage(Model model) {
        model.addAttribute("post", new PostModel());
        return "add_post";
    }

    @PostMapping(value = {"/admin/add"})
    public String addPage(@ModelAttribute("post") PostModel postModel, BindingResult bindingResult, Model model) {
        postValidator.validate(postModel, bindingResult);
        if(bindingResult.hasErrors()) {
            return "add_post";
        }
        postService.save(postModel);
        return "redirect:/admin/home?message=Add success!";
    }

    @GetMapping(value = {"/admin/edit/{id}"})
    public String editPage(@PathVariable("id") Long id, Model model) {
        Optional<PostModel> postModel = postService.findById(id);
        PostModel post = postModel.get();
        model.addAttribute("post", post);
        return "edit_post";
    }

    @PostMapping(value = {"/admin/edit/{id}"})
    public String editPage(@PathVariable("id") Long id, @ModelAttribute("post") PostModel postModel, BindingResult bindingResult, Model model) {
        postValidator.validate(postModel, bindingResult);
        if(bindingResult.hasErrors()) {
            postModel.setId(id);
            return "edit_post";
        }
        postService.save(postModel);
        return "redirect:/admin/home?message=Update success!";
    }

    @GetMapping(value = {"/admin/delete/{id}"})
    public String delete(@PathVariable("id") Long id) {
        postService.delete(id);
        return "redirect:/admin/home?message=Delete success!";
    }
}

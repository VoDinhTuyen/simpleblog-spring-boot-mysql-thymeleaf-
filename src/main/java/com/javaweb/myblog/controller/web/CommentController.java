package com.javaweb.myblog.controller.web;

import com.javaweb.myblog.model.CommentModel;
import com.javaweb.myblog.model.UserModel;
import com.javaweb.myblog.service.ICommentService;
import com.javaweb.myblog.service.IPostService;
import com.javaweb.myblog.service.IUserService;
import com.javaweb.myblog.validator.CommentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IPostService postService;

    @Autowired
    private CommentValidator commentValidator;

    @PostMapping(value = {"/add_comment/{id}"})
    public String comment(@ModelAttribute("comment") CommentModel commentModel, @PathVariable("id") Long id, Principal principal, BindingResult bindingResult) {
        if(principal == null) {
            return "redirect:/login";
        }
        commentValidator.validate(commentModel, bindingResult);
        if(bindingResult.hasErrors()) {
            return "redirect:/detail/"+id;
        }
        UserModel userModel = userService.findByUserName(principal.getName());
        commentModel.setUser(userModel);
        commentModel.setPost(postService.findById(id).get());
        commentService.save(commentModel);
        return "redirect:/detail/"+id;
    }
}

package com.blog.Blogging.Project.controller;

import com.blog.Blogging.Project.model.Post;
import com.blog.Blogging.Project.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @Autowired
    PostRepo postRepo;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listPosts", postRepo.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String newPost(Model model) {
        model.addAttribute("post", new Post());
        return "new_post";
    }

    @PostMapping("/save")
    public String savePost(@ModelAttribute("post") Post post) {
        System.out.println("Saving post: " + post);
        postRepo.save(post);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable int id) {
        postRepo.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable int id, Model model) {
        model.addAttribute("post", postRepo.findById(id));
        return "edit_post";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute("post") Post post) {
        postRepo.save(post);
        return "redirect:/";
    }
}


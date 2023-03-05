package com.kh.Jdbc.controller;

import com.kh.Jdbc.dao.WriteDAO;
import com.kh.Jdbc.vo.WriteVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class WritePost {
    @GetMapping("/write")
    public String write(Model model) {
        model.addAttribute("post", new WriteVO());
        return "thymeleafEx/postWrite";
    }
    @PostMapping("/write")
    public String savePost(@ModelAttribute("post") WriteVO wvo) {
        WriteDAO wdao = new WriteDAO();
        wdao.writePost(wvo);
        return "thymeleafEx/postWriteRst";
    }
}

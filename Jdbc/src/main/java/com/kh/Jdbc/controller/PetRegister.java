package com.kh.Jdbc.controller;

import com.kh.Jdbc.dao.PetDAO;
import com.kh.Jdbc.vo.PetVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class PetRegister {
    @GetMapping("/pet")
    public String register(Model model) {
        model.addAttribute("pets", new PetVO());
        return "thymeleafEx/registerPet";
    }
    @PostMapping("/pet")
    public String savePet(@ModelAttribute("pets") PetVO pvo) {
        PetDAO pdao = new PetDAO();
        pdao.registerPet(pvo);
        return "thymeleafEx/registerPetRst";
    }
}

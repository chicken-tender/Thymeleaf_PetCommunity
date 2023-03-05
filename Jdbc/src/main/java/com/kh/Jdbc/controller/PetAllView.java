package com.kh.Jdbc.controller;
import com.kh.Jdbc.dao.PetDAO;
import com.kh.Jdbc.vo.PetVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/allView")
public class PetAllView {
    private PetDAO pdao;

    @GetMapping("/pet")
    public String index(Model model) {
        pdao = new PetDAO();
        List<PetVO> pets = pdao.petAll();
        model.addAttribute("pets", pets);
        return "thymeleafEx/petAllView";
    }
}

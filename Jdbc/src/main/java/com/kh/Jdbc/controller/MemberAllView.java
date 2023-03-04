package com.kh.Jdbc.controller;
import com.kh.Jdbc.dao.MemberDAO;
import com.kh.Jdbc.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/allView")
public class MemberAllView {
    private MemberDAO mdao;

    @GetMapping("/member")
    public String index(Model model) {
        mdao = new MemberDAO();
        List<MemberVO> members = mdao.memAll();
        model.addAttribute("members", members);
        return "thymeleafEx/memberAllView";
    }


}

package com.kh.Jdbc.controller;
import com.kh.Jdbc.dao.MemberDAO;
import com.kh.Jdbc.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.lang.reflect.Member;

@Controller
@RequestMapping("/join")
public class MemberJoin {
    @GetMapping("/member")
    public String join(Model model) {
        model.addAttribute("members", new MemberVO());
        return "thymeleafEx/joinMember";
    }
    @PostMapping("/member")
    public String saveMember(@ModelAttribute("members") MemberVO mvo) {
        MemberDAO mdao = new MemberDAO();
        mdao.signUp(mvo);
        return "thymeleafEx/joinMemberRst";
    }
}

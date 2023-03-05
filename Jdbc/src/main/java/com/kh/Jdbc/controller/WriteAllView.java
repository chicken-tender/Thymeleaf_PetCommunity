package com.kh.Jdbc.controller;
import com.kh.Jdbc.dao.WriteDAO;
import com.kh.Jdbc.vo.WriteVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/allView")
public class WriteAllView {
    private WriteDAO wdao;

    @GetMapping("/write")
    public String index(Model model) {
        wdao = new WriteDAO();
        List<WriteVO> lists = wdao.getEntireList();
        model.addAttribute("lists", lists);
        return "thymeleafEx/writeAllView";
    }
}

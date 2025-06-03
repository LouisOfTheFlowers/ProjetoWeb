package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/agricultor/home")
    public String homeAgricultor() {
        return "home_page";
    }

    @GetMapping("/agricultor/cronograma")
    public String verCronogramas() {
        return "cronograma";
    }

    @GetMapping("/agricultor/propostas")
    public String verPropostas() {
        return "propostas-plantio";
    }

    @GetMapping("/agricultor/terrenos")
    public String verTerrenos() {
        return "terrenos";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}

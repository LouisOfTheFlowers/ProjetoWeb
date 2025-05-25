package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/agricultor/home")
    public String homeAgricultor() {
        return "home_page"; // corresponde ao ficheiro home-agricultor.html em /templates
    }

    @GetMapping("/agricultor/cronogramas")
    public String verCronogramas() {
        return "cronogramas"; // criar cronogramas.html em /templates
    }

    @GetMapping("/agricultor/propostas")
    public String verPropostas() {
        return "propostas-plantio"; // criar propostas-plantio.html
    }

    @GetMapping("/agricultor/terrenos")
    public String verTerrenos() {
        return "terrenos"; // criar terrenos.html
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login"; // redireciona para página de login
    }
}

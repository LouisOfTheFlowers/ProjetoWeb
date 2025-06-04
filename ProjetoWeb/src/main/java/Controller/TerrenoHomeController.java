package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agricultor/gestao-terrenos")
public class TerrenoHomeController {

    @GetMapping
    public String mostrarPaginaTerrenos() {
        return "terrenos"; // Nome do HTML que vamos criar já a seguir
    }
}

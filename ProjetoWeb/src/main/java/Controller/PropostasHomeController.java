package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agricultor/gestao-propostas") // <- NOVO caminho que NINGUÉM usa
public class PropostasHomeController {

    @GetMapping
    public String mostrarPaginaDeBotoes() {
        return "propostas_plantio"; // página dos 2 botões
    }
}

package Controller;

import Models.trabalhoprojeto.Cronograma;
import Repositorio.CronogramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ListaCronogramaController {

    @Autowired
    private CronogramaRepository cronogramaRepository;

    @GetMapping("/lista_cronogramas")
    public String listarCronogramas(Model model) {
        List<Cronograma> cronogramas = cronogramaRepository.findAll();
        model.addAttribute("cronogramas", cronogramas);
        return "lista_cronogramas";
    }

    @GetMapping("/cronogramas/{id}")
    public String detalhesCronograma(@PathVariable("id") int id, Model model) {
        Cronograma cronograma = cronogramaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de Cronograma inválido: " + id));

        model.addAttribute("cronograma", cronograma);
        return "ler_cronograma";
    }
}

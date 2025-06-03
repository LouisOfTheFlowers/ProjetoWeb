package Controller;

import Models.trabalhoprojeto.Cronograma;
import Repositorio.CronogramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LerCronogramaController {

    @Autowired
    private CronogramaRepository cronogramaRepository;

    @GetMapping("/cronograma/{id}")
    public String mostrarDetalhesCronograma(@PathVariable("id") Integer id, Model model) {

        Cronograma cronograma = cronogramaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cronograma não encontrado com ID: " + id));
        model.addAttribute("cronograma", cronograma);

        return "ler_cronograma";
    }
}

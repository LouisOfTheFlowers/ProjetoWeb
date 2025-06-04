package Controller;

import Models.trabalhoprojeto.PropostaPlantio;
import Services.PropostaPlantioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/agricultor/propostas/listar")
public class ListarPropostaPlantioController {

    @Autowired
    private PropostaPlantioService propostaPlantioService;

    @GetMapping
    public String listarPropostas(Model model) {
        List<PropostaPlantio> propostas = propostaPlantioService.findAll();
        model.addAttribute("propostas", propostas);
        return "consultar_propostas"; // <-- Nome EXATO do HTML (sem .html)
    }
}

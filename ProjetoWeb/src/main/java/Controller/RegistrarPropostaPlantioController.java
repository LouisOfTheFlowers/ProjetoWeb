package Controller;

import Models.trabalhoprojeto.Agricultor;
import Models.trabalhoprojeto.GestorProducao;
import Models.trabalhoprojeto.PropostaPlantio;
import Models.trabalhoprojeto.Terreno;
import Services.AgricultorService;
import Services.GestorProducaoService;
import Services.PropostaPlantioService;
import Services.TerrenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/agricultor/propostas")
public class RegistrarPropostaPlantioController {

    @Autowired
    private TerrenoService terrenoService;

    @Autowired
    private AgricultorService agricultorService;

    @Autowired
    private GestorProducaoService gestorProducaoService;

    @Autowired
    private PropostaPlantioService propostaPlantioService;

    @GetMapping("/novo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("proposta", new PropostaPlantio());
        model.addAttribute("terrenos", terrenoService.findAll());
        model.addAttribute("agricultores", agricultorService.findAll());
        model.addAttribute("gestores", gestorProducaoService.findAll());
        return "registrar_proposta"; // Nome do ficheiro .html sem extensão
    }

    @PostMapping("/novo")
    public String submeterFormulario(@ModelAttribute("proposta") PropostaPlantio proposta, Model model) {
        if (proposta.getHorticolas() == null || proposta.getHorticolas().trim().isEmpty() ||
                proposta.getAlturaDoAno() == null || proposta.getAlturaDoAno().trim().isEmpty() ||
                proposta.getIdTerreno() == null || proposta.getIdTerreno().getId() == null ||
                proposta.getIdAgricultor() == null || proposta.getIdAgricultor().getId() == null ||
                proposta.getIdGestor() == null || proposta.getIdGestor().getId() == null) {

            model.addAttribute("erroPopup", "Todos os campos devem ser preenchidos.");
            model.addAttribute("terrenos", terrenoService.findAll());
            model.addAttribute("agricultores", agricultorService.findAll());
            model.addAttribute("gestores", gestorProducaoService.findAll());
            return "registrar_proposta";
        }

        proposta.setId(null);

        Terreno terreno = terrenoService.findById(proposta.getIdTerreno().getId()).orElse(null);
        Agricultor agricultor = agricultorService.findById(proposta.getIdAgricultor().getId()).orElse(null);
        GestorProducao gestor = gestorProducaoService.findById(proposta.getIdGestor().getId()).orElse(null);

        proposta.setIdTerreno(terreno);
        proposta.setIdAgricultor(agricultor);
        proposta.setIdGestor(gestor);

        proposta.setEstado(null);
        propostaPlantioService.save(proposta);

        return "redirect:/agricultor/propostas/listar";
    }


}

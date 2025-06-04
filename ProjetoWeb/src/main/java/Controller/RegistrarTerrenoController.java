package Controller;

import Models.trabalhoprojeto.Agricultor;
import Models.trabalhoprojeto.Terreno;
import Services.AgricultorService;
import Services.TerrenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/agricultor/terrenos")
public class RegistrarTerrenoController {

    @Autowired
    private TerrenoService terrenoService;

    @Autowired
    private AgricultorService agricultorService;

    @GetMapping("/novo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("terreno", new Terreno());
        model.addAttribute("agricultores", agricultorService.findAll());
        return "registrar_terreno"; // Nome do ficheiro .html sem extensão
    }

    @PostMapping("/novo")
    public String submeterFormulario(@ModelAttribute("terreno") Terreno terreno, Model model) {
        if (terreno.getArea() == null || terreno.getArea().trim().isEmpty() ||
                terreno.getCoordenadas() == null || terreno.getCoordenadas().trim().isEmpty() ||
                terreno.getIdAgricultor() == null || terreno.getIdAgricultor().getId() == null) {

            model.addAttribute("erroPopup", "Todos os campos devem ser preenchidos.");
            model.addAttribute("agricultores", agricultorService.findAll());
            return "registrar_terreno";
        }

        terreno.setId(null);

        Agricultor agricultor = agricultorService.findById(terreno.getIdAgricultor().getId()).orElse(null);
        terreno.setIdAgricultor(agricultor);

        terrenoService.save(terreno);

        return "redirect:/agricultor/gestao-terrenos";
    }
}

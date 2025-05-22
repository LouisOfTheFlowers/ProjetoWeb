package Controller;

import Models.trabalhoprojeto.*;
import Repositorio.*;
import Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistoWebController {

    @Autowired
    private UserService userService;

    @Autowired
    private TrabalhadorRepository trabalhadorRepository;

    @Autowired
    private LocalidadeRepository localidadeRepository;

    @Autowired
    private AgricultorRepository agricultorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @GetMapping("/registar")
    public String mostrarFormularioDeRegisto(Model model) {
        model.addAttribute("erro", null);
        return "registar";
    }

    @PostMapping("/registar")
    public String processarRegisto(@RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String email,
                                   @RequestParam String nome,
                                   @RequestParam String rua,
                                   @RequestParam Integer numeroPorta,
                                   @RequestParam String codigoPostal,
                                   @RequestParam String telefone,
                                   Model model) {

        // 1. Buscar ou criar localidade
        Localidade localidade = localidadeRepository.findById(codigoPostal)
                .orElseGet(() -> {
                    Localidade nova = new Localidade();
                    nova.setCodigoPostal(codigoPostal);
                    nova.setLocalidade("Por definir");
                    return localidadeRepository.save(nova);
                });

        // 2. Criar trabalhador
        Trabalhador trabalhador = new Trabalhador();
        trabalhador.setNome(nome);
        trabalhador.setRua(rua);
        trabalhador.setNumeroPorta(numeroPorta);
        trabalhador.setCodigoPostal(localidade);
        trabalhador = trabalhadorRepository.save(trabalhador);

        // 3. Criar user
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setTrabalhador(trabalhador);
        userRepository.save(user);

        // 4. Criar agricultor
        Agricultor agricultor = new Agricultor();
        agricultor.setNome(nome);
        agricultor.setRua(rua);
        agricultor.setNumeroPorta(numeroPorta);
        agricultor.setCodigoPostal(codigoPostal); // <- String no modelo Agricultor
        agricultor.setIdTrabalhador(trabalhador);
        agricultorRepository.save(agricultor);

        // 5. Criar email (opcional)
        Email emailObj = new Email();
        emailObj.setEndereço(email);
        emailObj.setIdTrabalhador(trabalhador);
        emailRepository.save(emailObj);

        // 6. Criar telefone (opcional)
        Telefone telefoneObj = new Telefone();
        telefoneObj.setNum(telefone);
        telefoneObj.setIdTrabalhador(trabalhador);
        telefoneRepository.save(telefoneObj);

        return "redirect:/login";
    }
}

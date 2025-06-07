package Controller;

import Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginWebController {

    @Autowired
    private UserService userService;

    // Mostra o formulário de login
    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("erro", null);
        return "login";
    }

    @PostMapping("/login")
    public String processarLogin(@RequestParam String username,
                                 @RequestParam String password,
                                 Model model,
                                 HttpSession session) {

        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            model.addAttribute("erro", "Por favor, preencha os campos.");
            return "login";
        }

        String role = userService.autenticarComRole(username.trim(), password);

        if ("agricultor".equalsIgnoreCase(role)) {
            session.setAttribute("utilizador", username);
            session.setAttribute("role", role);
            return "redirect:/agricultor/home";
        }

        // Se não for agricultor ou se for inválido
        model.addAttribute("erro", "Acesso permitido apenas a Agricultores.");
        return "login";
    }
}
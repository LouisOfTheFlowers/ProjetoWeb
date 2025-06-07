package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EsqueceuPassController {

    @GetMapping("/esqueceu-password")
    public String showForgotPasswordForm(Model model) {
        model.addAttribute("forgotPasswordForm", new ForgotPasswordForm());
        return "esqueceu_pass";
    }

    @PostMapping("/esqueceu-password")
    public String processForgotPassword(@ModelAttribute ForgotPasswordForm forgotPasswordForm, Model model) {
        String input = forgotPasswordForm.getEmailOrUsername().trim();

        if (input.isEmpty()) {
            model.addAttribute("alertMessage", "Por favor, insira o seu e-mail ou nome de utilizador.");
        } else {
            model.addAttribute("alertMessage", "Se o e-mail ou nome estiver correto, irá receber instruções em breve.");
        }

        // Adiciona um novo formulário vazio para limpar o campo
        model.addAttribute("forgotPasswordForm", new ForgotPasswordForm());

        return "esqueceu_pass";
    }

    @GetMapping("/back-to-login")
    public String showLoginPage() {
        return "redirect:/login";
    }

    public static class ForgotPasswordForm {
        private String emailOrUsername;

        public String getEmailOrUsername() {
            return emailOrUsername;
        }

        public void setEmailOrUsername(String emailOrUsername) {
            this.emailOrUsername = emailOrUsername;
        }
    }
}

package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CronogramaController {

    @GetMapping("/cronograma")
    public String mostrarCronogramas() {
        return "cronograma";
    }
}

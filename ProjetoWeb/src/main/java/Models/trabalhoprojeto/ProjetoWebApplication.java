package Models.trabalhoprojeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
        "Models.trabalhoprojeto", // entidades e aplicação
        "Controller",             // <-- para encontrar HomeController, LoginWebController
        "Services",               // caso tenhas os teus @Service aqui
        "Repositorio"// onde estão os teus @Repository

})
@EnableJpaRepositories(basePackages = "Repositorio")
public class ProjetoWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjetoWebApplication.class, args);
    }
}

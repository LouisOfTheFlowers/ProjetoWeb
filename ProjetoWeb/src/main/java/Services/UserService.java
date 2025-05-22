package Services;

import Models.trabalhoprojeto.*;
import Repositorio.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserRepository userRepository;

    public boolean registarNovoUtilizador(String username, String password, String email) {
        if (userRepository.existsByUsername(username)) {
            return false;
        }

        User novo = new User();
        novo.setUsername(username);
        novo.setPassword(password);
        novo.setEmail(email);

        userRepository.save(novo);
        return true;
    }

    public User findByUsername(String username) {
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Transactional
    public String autenticarComRole(String username, String password) {
        User user = findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            Trabalhador trabalhador = user.getTrabalhador();
            if (trabalhador != null) {
                if (trabalhador.getAgricultores() != null && !trabalhador.getAgricultores().isEmpty()) return "agricultor";
                if (trabalhador.getGestoresProducao() != null && !trabalhador.getGestoresProducao().isEmpty()) return "gestor";
                if (trabalhador.getAnalistaDados() != null && !trabalhador.getAnalistaDados().isEmpty()) return "analista";
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<Agricultor> findAllAgricultores() {
        return em.createQuery("SELECT a FROM Agricultor a").getResultList();
    }
}

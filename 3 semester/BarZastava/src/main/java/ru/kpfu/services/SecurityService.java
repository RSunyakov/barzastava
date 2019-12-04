package ru.kpfu.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kpfu.db.DbConnection;
import ru.kpfu.models.Role;
import ru.kpfu.models.User;
import ru.kpfu.repositories.CrudRoleRepositoryImpl;
import ru.kpfu.repositories.CrudUserRepositoryImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class SecurityService {
    private DbConnection dbConnection;
    private CrudUserRepositoryImpl crudUserRepository;
    private PasswordEncoder passwordEncoder;
    private CrudRoleRepositoryImpl crudRoleRepository;

    public SecurityService() {
        this.dbConnection = new DbConnection();
        dbConnection.setConnection();
        crudUserRepository = dbConnection.getUserRepository();
        crudRoleRepository = dbConnection.getCrudRoleRepository();
        passwordEncoder = new BCryptPasswordEncoder();
    }

    public boolean isSigned(HttpServletRequest req) {
        return req.getSession().getAttribute("email") != null;
    }

    public User getUser(HttpServletRequest req) {
        if (isSigned(req)) {
            Optional<User> optionalUser = crudUserRepository.find(req.getSession().getAttribute("email").toString());
            if (optionalUser.isPresent()) {
               return optionalUser.get();
            }
        }
        return null;
    }

    public boolean signIn(HttpServletRequest req, String email, String password) {
        Optional<User> optionalUser = crudUserRepository.find(email);
        if (optionalUser.isPresent()) {
            User u = optionalUser.get();
            u.setRole(dbConnection.getCrudRoleRepository().findByUserId(u.getId()));
            if (passwordEncoder.matches(password, u.getPassword())) {
                req.getSession().setAttribute("roles", u.getRole());
                req.getSession().setAttribute("email", email);
                return true;
            }
        }
        return false;
    }
    public static void signOut(HttpServletRequest req) {
        req.getSession().removeAttribute("email");
    }
}

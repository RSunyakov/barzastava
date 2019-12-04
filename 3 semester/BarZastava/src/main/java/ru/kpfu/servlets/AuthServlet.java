package ru.kpfu.servlets;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kpfu.db.DbConnection;
import ru.kpfu.models.User;
import ru.kpfu.repositories.CrudUserRepositoryImpl;
import ru.kpfu.services.SecurityService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class AuthServlet extends HttpServlet {
    private DbConnection dbConnection;
    private CrudUserRepositoryImpl crudUserRepository;
    private PasswordEncoder passwordEncoder;
    private SecurityService securityService;


    @Override
    public void init() throws ServletException {
        dbConnection = new DbConnection();
        dbConnection.setConnection();
        crudUserRepository = dbConnection.getUserRepository();
        passwordEncoder = new BCryptPasswordEncoder();
        securityService = new SecurityService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("WEB-INF/jsp/signin.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("fail", "");
        String email = req.getParameter("inputEmail");
        String password = req.getParameter("inputPassword");
        if (email != null && password != null) {
            if (securityService.signIn(req, email, password)) {
                resp.sendRedirect(getServletContext().getContextPath() + "/profile");
            } else {
                req.setAttribute("fail", "Неверная почта или пароль");
                req.getRequestDispatcher("WEB-INF/jsp/signin.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("fail", "Почта или пароль не могут быть пустыми");
            req.getRequestDispatcher("WEB-INF/jsp/signin.jsp").forward(req, resp);
        }
    }
}

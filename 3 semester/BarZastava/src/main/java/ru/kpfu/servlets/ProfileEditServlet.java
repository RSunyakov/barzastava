package ru.kpfu.servlets;

import ru.kpfu.db.DbConnection;
import ru.kpfu.models.User;
import ru.kpfu.repositories.CrudRoleRepositoryImpl;
import ru.kpfu.repositories.CrudUserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/edit")
public class ProfileEditServlet extends HttpServlet {
    private DbConnection dbConnection;
    private CrudRoleRepositoryImpl crudRoleRepository;
    private CrudUserRepositoryImpl crudUserRepository;
    @Override
    public void init() throws ServletException {
        dbConnection = new DbConnection();
        dbConnection.setConnection();
        crudRoleRepository = dbConnection.getCrudRoleRepository();
        crudUserRepository = dbConnection.getUserRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/profileedit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("inputName");
        String gender = req.getParameter("genderRadios");
        String[] roles = req.getParameterValues("inputAddress");
        String password = req.getParameter("inputPassword");
        if (username != null && gender != null && roles != null && password != null) {
            User u = (User) req.getAttribute("user");
            u.setUsername(username);
            u.setPassword(password);
            u.setGender(gender);
            crudRoleRepository.update(u.getId(), roles);
            crudUserRepository.update(u);
            u.setRole(crudRoleRepository.findByUserId(u.getId()));
            req.setAttribute("editCheck", "Success");
            req.setAttribute("roles", u.getRole());
            req.setAttribute("user", u);
            req.getSession().setAttribute("roles", u.getRole());
            req.getSession().setAttribute("user", u);
            resp.sendRedirect(getServletContext().getContextPath() + "/profile");
        } else {
            req.setAttribute("editCheck", "false");
        }
    }
}

package ru.kpfu.servlets;

import ru.kpfu.db.DbConnection;
import ru.kpfu.models.Role;
import ru.kpfu.models.User;
import ru.kpfu.repositories.CrudRoleRepositoryImpl;
import ru.kpfu.repositories.CrudUserRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterServlet extends HttpServlet {
    private DbConnection dbConnection;
    private CrudUserRepositoryImpl crudUserRepository;
    private CrudRoleRepositoryImpl crudRoleRepository;
    private List<String> parameters;

    @Override
    public void init() throws ServletException {
        dbConnection = new DbConnection();
        dbConnection.setConnection();
        crudUserRepository = dbConnection.getUserRepository();
        crudRoleRepository = dbConnection.getCrudRoleRepository();
        parameters = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher view=req.getRequestDispatcher("WEB-INF/jsp/registration.jsp");
        view.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("emailCheck", "");
        req.setAttribute("userFind", "");
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("inputEmail");
        String password = req.getParameter("inputPassword");
        String username = req.getParameter("inputName");
        String gender = req.getParameter("genderRadios");
        String accepted = req.getParameter("checkAccepted");
        String[] role = req.getParameterValues("inputAddress");
        parameters.add(email);
        parameters.add(password);
        parameters.add(username);
        parameters.add(gender);
        parameters.add(accepted);
        if (!parameters.contains(null)) {
            User user = new User(null, email, username, password, gender);
            if (checkEmail(email) && accepted.equals("accepted") && checkUser(email)) {
                crudUserRepository.save(user);
                if (role != null) {
                    for (int i = 0; i < role.length; i++) {
                        System.out.println(role[i]);
                        crudRoleRepository.save(new Role(null, user.getId(), role[i]));
                    }
                }
                String localRole = req.getParameter("inputRole");
                if (localRole != null) {
                    crudRoleRepository.save(new Role(null, user.getId(), localRole));
                }
                List<Role> roleList = crudRoleRepository.findByUserId(user.getId());
                req.setAttribute("email", user.getEmail());
                req.getSession().setAttribute("email", user.getEmail());
                req.setAttribute("user" , user);
                req.getSession().setAttribute("roles", roleList);
                req.setAttribute("roles", roleList);
                resp.sendRedirect(getServletContext().getContextPath() + "/profile");
            } else {
                if (!checkUser(email)) req.setAttribute("userFind", "Пользователь с такой почтой уже существует!");
                if (!checkEmail(email)) req.setAttribute("emailCheck", "Неверный ");
                req.getRequestDispatcher("WEB-INF/jsp/registration.jsp").forward(req, resp);
            }
        }
    }

    private boolean checkEmail(String email) {
        boolean checker = false;
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) checker = true;
        return checker;
    }

    private boolean checkUser(String email) {
        boolean checker = false;
        if (!crudUserRepository.find(email).isPresent()) {
            checker = true;
        }
        return checker;
    }
}

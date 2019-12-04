package ru.kpfu.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterFileServlet extends HttpServlet {
    private File csvFile;
    private FileWriter fw;


    @Override
    public void init() throws ServletException {
        this.csvFile = new File("data.csv");
        try {
            fw = new FileWriter(csvFile);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view=req.getRequestDispatcher("WEB-INF/jsp/registration.jsp");
        view.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("emailCheck", "");

        String email = req.getParameter("inputEmail");
        String password = req.getParameter("inputPassword");
        String name = req.getParameter("inputName");
        String country = req.getParameter("inputCountry");
        String about = req.getParameter("inputAbout");
        String gender = req.getParameter("genderRadios");
        String accepted = req.getParameter("checkAccepted");
        if (checkEmail(email)) {
            fw.write(email + "," + password + "," + name + "," + country + "," + about + "," + gender + "," + accepted);
            fw.write("\n");
            fw.flush();
        }
        if (!checkEmail(email)) req.setAttribute("emailCheck", "Неверный ");
        req.getRequestDispatcher("WEB-INF/jsp/registration.jsp").forward(req, resp);
    }

    private boolean checkEmail(String email) {
        boolean checker = false;
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) checker = true;
        return checker;
    }
}

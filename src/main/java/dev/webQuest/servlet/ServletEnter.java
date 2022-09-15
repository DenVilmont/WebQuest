package dev.webQuest.servlet;

import dev.webQuest.SQLiteHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

@WebServlet(name = "ServletEnter", value = "/enter")
public class ServletEnter extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(ServletEnter.class);
    private static final SQLiteHandler sqLiteHandler = SQLiteHandler.getInstance();

    @Override
    public void init() throws ServletException {
        LOGGER.info("ServletEnter was inited!");
        super.init();
    }

    @Override
    public void destroy() {
        LOGGER.info("ServletEnter was destroyed");
        super.destroy();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("ServletEnter do Post!");
        HttpSession session = req.getSession();

        LOGGER.info(".........................");
        Enumeration<String> attributeNames = session.getAttributeNames();
        ArrayList<String> list = Collections.list(attributeNames);
        list.forEach(x -> LOGGER.info("session attribute {} -> {}", x, session.getAttribute(x)));

        Enumeration<String> attributeNames1 = req.getAttributeNames();
        list = Collections.list(attributeNames1);
        list.forEach(x -> LOGGER.info("request attribute {} -> {}", x, req.getAttribute(x)));

        Enumeration<String> parameterNames = req.getParameterNames();
        list = Collections.list(parameterNames);
        list.forEach(x -> LOGGER.info("request parameter {} -> {}", x, req.getParameter(x)));
        LOGGER.info(".........................");


        LOGGER.info("User name in session: {}", session.getAttribute("Login"));

        if (validateUserName(session.getAttribute("Login"))){
            if (session.getAttribute("currentQuestion") == null){
                session.setAttribute("currentQuestion", sqLiteHandler.getStartQuestionID());
            }
            getServletContext().getRequestDispatcher("/quest.jsp").forward(req, resp);

        }else {
            String userName = req.getParameter("Login");
            LOGGER.info("User name in parameters: {}", userName);
            if (validateUserName(userName)){
                session.setAttribute("Login", userName);
                LOGGER.info("Inserted user name in session");
                LOGGER.info("User name in session: {}", userName);
                if (session.getAttribute("currentQuestion") == null){
                    session.setAttribute("currentQuestion", sqLiteHandler.getStartQuestionID());
                }
                getServletContext().getRequestDispatcher("/quest.jsp").forward(req, resp);

            }else {
                resp.sendRedirect("index.jsp");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("ServletEnter do Get!");
        HttpSession session = req.getSession();
        req.setAttribute("currentQuestion", sqLiteHandler.getStartQuestionID());

        LOGGER.info(".........................");
        Enumeration<String> attributeNames = session.getAttributeNames();
        ArrayList<String> list = Collections.list(attributeNames);
        list.forEach(x -> LOGGER.info("session attribute {} -> {}", x, session.getAttribute(x)));

        Enumeration<String> attributeNames1 = req.getAttributeNames();
        list = Collections.list(attributeNames1);
        list.forEach(x -> LOGGER.info("request attribute {} -> {}", x, req.getAttribute(x)));

        Enumeration<String> parameterNames = req.getParameterNames();
        list = Collections.list(parameterNames);
        list.forEach(x -> LOGGER.info("request parameter {} -> {}", x, req.getParameter(x)));
        LOGGER.info(".........................");


        LOGGER.info("User name in session: {}", session.getAttribute("Login"));

        if (validateUserName(session.getAttribute("Login"))){
            if (session.getAttribute("currentQuestion") == null){
                session.setAttribute("currentQuestion", sqLiteHandler.getStartQuestionID());
            }
            getServletContext().getRequestDispatcher("/quest.jsp").forward(req, resp);

        }else {
            String userName = req.getParameter("Login");
            LOGGER.info("User name in parameters: {}", userName);
            if (validateUserName(userName)){
                session.setAttribute("Login", userName);
                LOGGER.info("Inserted user name in session");
                LOGGER.info("User name in session: {}", userName);
                if (session.getAttribute("currentQuestion") == null){
                    session.setAttribute("currentQuestion", sqLiteHandler.getStartQuestionID());
                }
                getServletContext().getRequestDispatcher("/quest.jsp").forward(req, resp);

            }else {
                resp.sendRedirect("index.jsp");
            }
        }
    }


    private boolean validateUserName(Object obj){
        String name;
        if (obj instanceof String){
            name = String.valueOf(obj);
            if (name != null
                    && !name.isBlank()
                    && !name.isEmpty()){
                return true;
            }
        }
        return false;
    }
}

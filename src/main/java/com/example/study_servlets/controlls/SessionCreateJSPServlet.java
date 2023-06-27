package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// /session/CreateServlet?username=yojulab&password=1234
@WebServlet(urlPatterns = "/session/CreateJSPServlet")
public class SessionCreateJSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // get params from query
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // display
            // login
            HttpSession httpSession = request.getSession(false);
            String usernameSession = (String)httpSession.getAttribute("username");
            if (httpSession != null && usernameSession != null) { // JSESSION 있음.    - 로그인 되었다는 표시
                System.out.println(usernameSession);
            } else { // 없음 - 로그인
                if ("yojulab".equals(username) && "1234".equals(password)) {
                    httpSession = request.getSession();
                    httpSession.setAttribute("username", username);
                    httpSession.setAttribute("password", password);
                } else {
                    System.out.println("<div>Faild</div>");
                }
            }

                        // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/hellowordJSP.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

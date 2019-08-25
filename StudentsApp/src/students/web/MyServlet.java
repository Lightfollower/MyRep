package students.web;

import students.entity.Students;
import students.logic.ManagementSystemBean;
import students.logic.ManagementSystemLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {
    @EJB
    private ManagementSystemBean ms;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            System.out.println("started");
            Students d = ms.getStudents(Integer.parseInt(request.getParameter("student_Id")));
            System.out.println("Students geted");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Student:["+d.getFirstName()+","+d.getSurName()+"]</h1>");
            out.println("</body>");
            out.println("</html>");
            System.out.println("printing finished");
        }
        catch (Exception e){
            System.err.println(e);
        }
        finally {
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }
}

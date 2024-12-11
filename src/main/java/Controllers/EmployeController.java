package Controllers;

import Enteties.Employe;
import Services.GestionEmployeV1;
import Services.InterfaceGestion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "employeController", value = "/employe/*")
public class EmployeController extends HttpServlet {
    InterfaceGestion employeeService = new GestionEmployeV1();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = (request.getServletPath()+request.getPathInfo());
        switch (action) {
            case "/employe/addEmploye":{
                System.out.println("l Post");
                //int Id = Integer.parseInt(request.getParameter("Id"));
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String adresse = request.getParameter("adresse");
                String numTel = request.getParameter("numTel");

                Employe employee = new Employe(nom, prenom, adresse, numTel);

                employeeService.aouterEmployee(employee);
                try {
                    response.sendRedirect("employeeList.jsp");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }

            case "/employe/updateEmploye": {
                String idParam = request.getParameter("id");
                if (idParam != null) {
                    int Id = Integer.parseInt(idParam);
                    String nom = request.getParameter("nom");
                    String prenom = request.getParameter("prenom");
                    String adresse = request.getParameter("adresse");
                    String numTel = request.getParameter("numTel");

                    Employe employee = new Employe(Id, nom, prenom, adresse, numTel);

                    employeeService.modifierEmployee(employee);
                    response.sendRedirect("/employe");
                } else {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Id parameter is missing");
                }
                break;
            }

            case "/deleteEmploye":{
                int Id = Integer.parseInt(request.getParameter("Id"));

                employeeService.supprimerEmployee(employeeService.chercherEmployee(Id));
                try {
                    response.sendRedirect("employeeList.jsp");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }

            default:
                // Code here
                break;
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = (request.getServletPath()+request.getPathInfo());
        System.out.println(action+"  HAMID");
        switch (action) {
            case "/employe/updateEmploye": {
                System.out.println("HAMIIIID");
                int Id = Integer.parseInt(request.getParameter("id"));
                Employe employee = employeeService.chercherEmployee(Id);
                request.setAttribute("employee", employee);
                request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request, response);
                break;
            }
            case "/employe/getEmploye": {
                String idParam = request.getParameter("Id");
                if (idParam != null) {
                    int Id = Integer.parseInt(idParam);
                    Employe employee = employeeService.chercherEmployee(Id);
                    request.setAttribute("employee", employee);
                    request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Id parameter is missing");
                }
                break;
            }
            case "/employe/getAllEmployes": {
                request.setAttribute("employees", employeeService.findAllEmployes());
                request.getRequestDispatcher("employeeList.jsp").forward(request, response);
            }
            case "/employe/addEmploye": {
                request.getRequestDispatcher("/AddEmployee.jsp").forward(request, response);
                break;
            }
            default:
                request.setAttribute("employees", employeeService.findAllEmployes());
                request.getRequestDispatcher("/EmployeManagement.jsp").forward(request, response);
                break;
        }
    }
}

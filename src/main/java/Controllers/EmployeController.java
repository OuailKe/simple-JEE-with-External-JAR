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


@WebServlet(name = "employeController", value = "/employe")
public class EmployeController extends HttpServlet {
    InterfaceGestion employeeService = new GestionEmployeV1();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();
        switch (action) {
            case "/addEmploye":{
                int Id = Integer.parseInt(request.getParameter("Id"));
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String adresse = request.getParameter("adresse");
                String numTel = request.getParameter("numTel");

                Employe employee = new Employe(Id, nom, prenom, adresse, numTel);

                employeeService.aouterEmployee(employee);
                try {
                    response.sendRedirect("employeeList.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }

            case "/updateEmploye":{
                int Id = Integer.parseInt(request.getParameter("Id"));
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String adresse = request.getParameter("adresse");
                String numTel = request.getParameter("numTel");

                Employe employee = new Employe(Id, nom, prenom, adresse, numTel);

                employeeService.modifierEmployee(employee);
                try {
                    response.sendRedirect("employeeList.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }

            case "/deleteEmploye":{
                int Id = Integer.parseInt(request.getParameter("Id"));

                employeeService.supprimerEmployee(employeeService.chercherEmployee(Id));
                try {
                    response.sendRedirect("employeeList.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
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
        String action = request.getServletPath();
        switch (action) {
            case "/getEmploye": {
                int Id = Integer.parseInt(request.getParameter("Id"));

                Employe employee = employeeService.chercherEmployee(Id);
                request.setAttribute("employee", employee);
                request.getRequestDispatcher("employeeDetails.jsp").forward(request, response);
                break;
            }
            case "/getAllEmployes": {
                request.setAttribute("employees", employeeService.findAllEmployes());
                request.getRequestDispatcher("employeeList.jsp").forward(request, response);
            }
                break;
            default:
                request.getRequestDispatcher("/EmployeManagement.jsp").forward(request, response);
                break;
        }
    }
}

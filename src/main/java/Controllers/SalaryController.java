package Controllers;

import Enteties.*;
import Services.InterfaceGestion;

import lombok.RequiredArgsConstructor;
import Enteties.Employe;
import Services.GestionSalaireV1;
import Services.InterfaceGestion;
import Services.InterfaceSalaire;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "salaryController", value = "/salary")
public class SalaryController extends HttpServlet {
    InterfaceSalaire salaryService = new GestionSalaireV1();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();
        switch (action) {
            case "/addSalary":{
                int fId = Integer.parseInt(request.getParameter("fId"));
                int nbHeure = Integer.parseInt(request.getParameter("nbHeure"));
                Double tauxHeure = Double.parseDouble(request.getParameter("tauxHeure"));

                FicheSalaire salary = new FicheSalaire(fId, nbHeure, tauxHeure);
                salaryService.ajouterFicheSalaire(salary);
                try {
                    response.sendRedirect("salaryList.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }

            case "/updateSalary":{
                int fId = Integer.parseInt(request.getParameter("fId"));
                int nbHeure = Integer.parseInt(request.getParameter("nbHeure"));
                Double tauxHeure = Double.parseDouble(request.getParameter("tauxHeure"));

                FicheSalaire salary = new FicheSalaire(fId, nbHeure, tauxHeure);
                salaryService.modifierFicheSalaire(salary);
                try {
                    response.sendRedirect("salaryList.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }

            case "/deleteSalary":{
                int fId = Integer.parseInt(request.getParameter("fId"));

                salaryService.supprimerFicheSalaire(salaryService.chercherFicheSalaire(fId));
                try {
                    response.sendRedirect("salaryList.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}

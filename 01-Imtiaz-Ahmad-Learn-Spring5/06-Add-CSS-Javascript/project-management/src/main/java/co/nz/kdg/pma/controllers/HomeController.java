package co.nz.kdg.pma.controllers;

import co.nz.kdg.pma.dao.EmployeeRepository;
import co.nz.kdg.pma.dao.ProjectRepository;
import co.nz.kdg.pma.dto.ChartData;
import co.nz.kdg.pma.dto.EmployeeProject;
import co.nz.kdg.pma.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);

        List<EmployeeProject> employeeProjectsCntList = employeeRepository.employeeProjects();
        model.addAttribute("employeeProjectsCntList", employeeProjectsCntList);

        List<ChartData> projectData = projectRepository.getProjectStatus();
        String jsonString = new ObjectMapper().writeValueAsString(projectData);
        model.addAttribute("projectStatusCount", jsonString);

        return "/main/home";
    }
}

package co.nz.kdg.pma.controllers;

import co.nz.kdg.pma.dao.EmployeeRepository;
import co.nz.kdg.pma.dao.ProjectRepository;
import co.nz.kdg.pma.entities.Employee;
import co.nz.kdg.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Null;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);
        return "/projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("employeeList", employeeRepository.findAll());
        return "/projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Model model, Project project) {
        projectRepository.save(project);
        return "redirect:/projects";
    }
}

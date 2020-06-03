package co.nz.kdg.pma;

import co.nz.kdg.pma.dao.EmployeeRepository;
import co.nz.kdg.pma.dao.ProjectRepository;
import co.nz.kdg.pma.entities.Employee;
import co.nz.kdg.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ProjectManagementApplication {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProjectRepository projectRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            Employee employee1 = new Employee("Dhanushka", "Gayashan", "dhanu@text.com");
            Employee employee2 = new Employee("Chamari", "Nimalka", "chamari@text.com");
            Employee employee3 = new Employee("Jack", "Jil", "jack@text.com");

            Project project1 = new Project("Coding", "COMPLETED", "Coding phrase is completed");
            Project project2 = new Project("DevOps", "INPRPGRESS", "Environment has been setup and working on code deployment");
            Project project3 = new Project("Testing", "NOTSTARTED", "Testing will need to start after deployment");

            project1.setEmployees(Arrays.asList(employee1, employee2));
            project2.setEmployees(Arrays.asList(employee2, employee3));
            project3.setEmployees(Arrays.asList(employee3, employee1));

            employee1.setProjects(Arrays.asList(project1, project3));
            employee2.setProjects(Arrays.asList(project1, project2));
            employee3.setProjects(Arrays.asList(project2, project3));

            employeeRepository.save(employee1);
            employeeRepository.save(employee2);
            employeeRepository.save(employee3);

            projectRepository.save(project1);
            projectRepository.save(project2);
            projectRepository.save(project3);
        };
    }
}

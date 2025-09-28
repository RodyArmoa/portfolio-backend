package porfolioProyecto.porfolio.controller;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import porfolioProyecto.porfolio.model.Project;
import porfolioProyecto.porfolio.repository.ProjectRepository; // <-- IMPORTANTE

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        // ¡Ahora leemos los proyectos directamente de la base de datos!
        return projectRepository.findAll();
    }
}
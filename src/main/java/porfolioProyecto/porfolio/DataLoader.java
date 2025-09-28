package porfolioProyecto.porfolio;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import porfolioProyecto.porfolio.model.Project;
import porfolioProyecto.porfolio.repository.ProjectRepository;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProjectRepository projectRepository;

    public DataLoader(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Limpiamos la base de datos por si acaso para no duplicar datos en cada reinicio
        projectRepository.deleteAll();

        // Creamos el objeto de tu proyecto
        Project budgetManager = new Project();
        budgetManager.setName("Gestor de Presupuestos (Aplicación de Escritorio)");
        budgetManager.setDescription("Aplicación de escritorio multiplataforma para la gestión de presupuestos, diseñada para profesionales autónomos. Permite generar presupuestos en PDF y funcionar 100% local.");
        budgetManager.setTechnologies(List.of("Java", "Spring Boot", "Svelte", "Electron", "SQLite", "OpenPDF"));
        budgetManager.setGithubUrl("https://github.com/RodyArmoa/app-gestor-presupuestos.git");


        // --- PROYECTO 2: Tu Nuevo Proyecto (Este Porfolio) ---
        Project webPortfolio = new Project();
        webPortfolio.setName("Portfolio Personal Full-Stack");
        webPortfolio.setDescription("Aplicación web completa para servir como porfolio personal, con un backend en Java/Spring Boot que expone una API REST y un frontend en SvelteKit que la consume. Desplegado en un ecosistema multi-nube (Render, Vercel, Railway).");
        webPortfolio.setTechnologies(List.of("Java", "Spring Boot", "SvelteKit", "Docker", "MySQL", "CI/CD"));
        webPortfolio.setGithubUrl("https://github.com/RodyArmoa/portfolio-backend");
        // Guardamos el proyecto en la base de datos
        projectRepository.save(budgetManager);

        System.out.println(">>> Datos de prueba cargados en la base de datos! <<<");
    }
}
package porfolioProyecto.porfolio.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import porfolioProyecto.porfolio.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Métodos como findAll(), findById(), save() ya están disponibles.
}
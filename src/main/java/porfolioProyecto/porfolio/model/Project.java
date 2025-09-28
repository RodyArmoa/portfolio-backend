package porfolioProyecto.porfolio.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data // Anotación de Lombok para generar getters, setters, toString, etc.
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 500) // Aumentamos la longitud para la descripción
    private String description;

    @ElementCollection // Ideal para una lista de strings simples como las tecnologías
    private List<String> technologies;

    private String githubUrl;
}

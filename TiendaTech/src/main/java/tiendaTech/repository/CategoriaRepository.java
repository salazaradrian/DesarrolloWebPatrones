package tiendaTech.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tiendaTech.com.domain.Categoria;
import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    List<Categoria> findByActivoTrue();
}

package tiendaTech.com.repository;

import tiendaTech.com.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByActivoTrue();
    List<Producto> findByCategoriaIdCategoria(Integer idCategoria);

}



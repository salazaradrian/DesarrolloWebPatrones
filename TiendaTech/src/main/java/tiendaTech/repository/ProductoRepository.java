package tiendaTech.com.repository;

import tiendaTech.com.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findByActivoTrue();

    List<Producto> findByPrecioBetweenOrderByPrecioAsc(double precioInf, double precioSup);

    @Query("SELECT p FROM Producto p WHERE p.precio BETWEEN :precioInf AND :precioSup ORDER BY p.precio ASC")
    List<Producto> consultaJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    @Query(value = "SELECT * FROM producto p WHERE p.precio BETWEEN :precioInf AND :precioSup ORDER BY p.precio ASC", nativeQuery = true)
    List<Producto> consultaSQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    List<Producto> findByCategoriaIdCategoria(Integer idCategoria);

}



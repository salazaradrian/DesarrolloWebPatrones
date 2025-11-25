package tiendaTech.controller;

import tiendaTech.services.ProductoService;
import tiendaTech.services.CategoriaServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    private final ProductoService productoService;
    private final CategoriaServices categoriaService;

    public ConsultaController(ProductoService productoService, CategoriaServices categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        var productos = productoService.getProductos(false);
        var categorias = categoriaService.getCategorias(true);

        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);

        return "/consultas/listado";
    }

    @PostMapping("/consultaCategoria")
    public String consultaCategoria(@RequestParam Integer idCategoria, Model model) {
        var productos = productoService.getProductosPorCategoria(idCategoria);
        var categorias = categoriaService.getCategorias(true);

        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);
        model.addAttribute("idCategoria", idCategoria);

        return "/consultas/listado";
    }

    @PostMapping("/consultaDerivada")
    public String consultaDerivada(@RequestParam double precioInf,
                                   @RequestParam double precioSup,
                                   Model model) {
        var productos = productoService.consultaDerivada(precioInf, precioSup);
        var categorias = categoriaService.getCategorias(true);

        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);

        return "/consultas/listado";
    }

    @PostMapping("/consultaJPQL")
    public String consultaJPQL(@RequestParam double precioInf,
                               @RequestParam double precioSup,
                               Model model) {
        var productos = productoService.consultaJPQL(precioInf, precioSup);
        var categorias = categoriaService.getCategorias(true);

        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);

        return "/consultas/listado";
    }

    @PostMapping("/consultaSQL")
    public String consultaSQL(@RequestParam double precioInf,
                               @RequestParam double precioSup,
                               Model model) {
        var productos = productoService.consultaSQL(precioInf, precioSup);
        var categorias = categoriaService.getCategorias(true);

        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);

        return "/consultas/listado";
    }
}

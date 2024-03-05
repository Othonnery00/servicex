package br.com.othonnery.servicex.categoria.ressources;

import br.com.othonnery.servicex.categoria.domain.Categoria;
import br.com.othonnery.servicex.categoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    private ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria novaCategoria){
        Categoria novaCategoria = categoriaService.criarCategoria(Categoria)
    }
}

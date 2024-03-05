package br.com.othonnery.servicex.categoria;

import br.com.othonnery.servicex.categoria.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class CategoriaRepository {
    @Autowired
    private CategoriaRepository CategoriaRepository;

    public Categoria criarCategoria(Categoria categoria){
        return CategoriaRepository.save(categoria);
    }
    public List<Categoria> listaCategoria{
        return categoriaRepository.findAll();
    }

    public Categoria atualizarCategoria(Categoria categoria){
        return CategoriaRepository.save(categoria);

    }

    public Categoria save(Categoria categoria) {
    }

    public void
}

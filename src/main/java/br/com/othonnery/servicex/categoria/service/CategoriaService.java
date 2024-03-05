package br.com.othonnery.servicex.categoria.service;

import br.com.othonnery.servicex.categoria.CategoriaRepository;
import br.com.othonnery.servicex.categoria.domain.Categoria;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository CategoriaRepository;

    public Categoria criarCategoria(Categoria categoria){
        return CategoriaRepository.save(categoria);
    }

}

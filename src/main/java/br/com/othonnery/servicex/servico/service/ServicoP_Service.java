package br.com.othonnery.servicex.servico.service;

import br.com.othonnery.servicex.servico.domain.ServicoPre;
import br.com.othonnery.servicex.servico.repositories.ServicoP_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoP_Service {
    @Autowired
    private ServicoP_Repository servicoP_repository;

    public ServicoPre cadastrarServicoP(ServicoPre servicop) {
        return servicoP_repository.save(servicop);
    }

    public List<ServicoPre> listarServicoP() {
        return servicoP_repository.findAll();
    }

    public Optional<ServicoPre> buscarServicoP(Integer idServicoP) {
        return servicoP_repository.findById(idServicoP);
    }

    public ServicoPre atualizarServicoP(ServicoPre servicop) {
        return servicoP_repository.save(servicop);
    }

    public void deletarServicoP(Integer idServicoP) {
        servicoP_repository.deleteById(idServicoP);
    }
}

package br.com.othonnery.servicex.servico.repositories;

import br.com.othonnery.servicex.servico.domain.ServicoPre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoP_Repository extends JpaRepository<ServicoPre,Integer> {

}
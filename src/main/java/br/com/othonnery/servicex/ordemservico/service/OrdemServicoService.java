package br.com.othonnery.servicex.ordemservico.service;

import br.com.othonnery.servicex.ordemservico.domain.OrdemServico;
import br.com.othonnery.servicex.ordemservico.repositories.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    public OrdemServico criarOS(OrdemServico novaOS) {
        return ordemServicoRepository.save(novaOS);
    }

    public List<OrdemServico> listarOS() {
        return ordemServicoRepository.findAll();
    }

    public Optional<OrdemServico> buscarOS(Integer IdOS) {
        return ordemServicoRepository.findById(IdOS);
    }

    public void deletarOS(Integer IdOS) {
        ordemServicoRepository.deleteById(IdOS);
    }

    public OrdemServico atualizarOS(Integer IdOS,OrdemServico ordemServico) {
        Optional<OrdemServico> ordemServicoEncontrada = buscarOS(IdOS);
        if (ordemServicoEncontrada.isPresent()) {

            OrdemServico ordemServicoAtualizada = ordemServicoEncontrada.get();
            ordemServicoAtualizada.setDataSolicitacao(ordemServico.getDataSolicitacao());
            ordemServicoAtualizada.setValorOS(ordemServico.getValorOS());

            return ordemServicoRepository.save(ordemServicoAtualizada);
        } else {
            return null;
        }
    }

    public void setIdOS(Integer idOS) {
    }
}

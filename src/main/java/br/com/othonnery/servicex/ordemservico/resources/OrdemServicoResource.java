package br.com.othonnery.servicex.ordemservico.resources;

import br.com.othonnery.servicex.ordemservico.domain.OrdemServico;
import br.com.othonnery.servicex.ordemservico.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordemservico")
public class OrdemServicoResource {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @PostMapping
    public ResponseEntity<OrdemServico> cadastrarOS(@RequestBody OrdemServico novaOS) {
        OrdemServico ordemServicoCriada = ordemServicoService.criarOS(novaOS);
        return new ResponseEntity<>(ordemServicoCriada, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrdemServico>> listarOS() {
        List<OrdemServico> ordensServico = ordemServicoService.listarOS();
        return ResponseEntity.ok(ordensServico);
    }

    @GetMapping("/{IdOS}")
    public ResponseEntity<OrdemServico> buscarOS(@PathVariable Integer IdOS) {
        Optional<OrdemServico> ordemServicoEncontrada = ordemServicoService.buscarOS(IdOS);
        return ordemServicoEncontrada
                .map(ordemServico -> new ResponseEntity<>(ordemServico, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{IdOS}")
    public ResponseEntity<Void> deletarOS(@PathVariable Integer IdOS) {
        ordemServicoService.deletarOS(IdOS);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{IdOS}")
    public ResponseEntity<OrdemServico> atualizarOS(@PathVariable Integer IdOS, @RequestBody OrdemServico ordemServico) {
        Optional<OrdemServico> ordemServicoEncontrada = ordemServicoService.buscarOS(IdOS);
        if (!ordemServicoEncontrada.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        OrdemServico ordemServicoAtualizada = ordemServicoEncontrada.get();
        ordemServicoAtualizada.setDataSolicitacao(ordemServico.getDataSolicitacao());
        ordemServicoAtualizada.setValorOS(ordemServico.getValorOS());

        OrdemServico novaOS = ordemServicoService.atualizarOS(IdOS, ordemServicoAtualizada);
        return new ResponseEntity<>(novaOS, HttpStatus.OK);
    }
}


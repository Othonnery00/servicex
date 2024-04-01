package br.com.othonnery.servicex.servico.resources;

import br.com.othonnery.servicex.servico.domain.ServicoPre;
import br.com.othonnery.servicex.servico.service.ServicoP_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Service")

public class ServicoP_Resource {
        @Autowired
        private ServicoP_Service servicoP_Service;

        @PostMapping
        public ResponseEntity<ServicoPre> cadastrarServicoP(@RequestBody ServicoPre novoServicoP) {
            ServicoPre servicoPCriado = servicoP_Service.cadastrarServicoP(novoServicoP);
            return new ResponseEntity<>(servicoPCriado, HttpStatus.CREATED);
        }

        @GetMapping
        public ResponseEntity<List<ServicoPre>> listarServicoP() {
            List<ServicoPre> servicos = servicoP_Service.listarServicoP();
            return ResponseEntity.ok(servicos);
        }

        @GetMapping("/{idServicoP}")
        public ResponseEntity<ServicoPre> buscarServicoP(@PathVariable Integer idServicoP) {
            return servicoP_Service.buscarServicoP(idServicoP)
                    .map(servicoP -> new ResponseEntity<>(servicoP, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        @DeleteMapping("/{idServicoP}")
        public ResponseEntity<Void> deletarServico(@PathVariable Integer idServicoP) {
            servicoP_Service.deletarServicoP(idServicoP);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @PutMapping("/{idServicoP}")
        public ResponseEntity<ServicoPre> atualizarServico(@PathVariable Integer idServicoP, @RequestBody ServicoPre servico) {
            if (!servicoP_Service.buscarServicoP(idServicoP).isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            servico.setIdServicoPre(idServicoP);
            ServicoPre novoServicoP = servicoP_Service.atualizarServicoP(servico);
            return new ResponseEntity<>(novoServicoP, HttpStatus.OK);
        }
    }

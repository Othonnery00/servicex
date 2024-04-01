package br.com.othonnery.servicex.pagamento.domain;

import br.com.othonnery.servicex.ordemservico.domain.OrdemServico;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "PAGAMENTO")
@NoArgsConstructor
public class Pagamento {

    @Id
    private Integer idPagamento;

    @Column(name = "STATUS_PAGAMENTO")
    private StatusPagamento statusPagamento;

    @OneToOne
    @JoinColumn(name = "ID_OS")
    private OrdemServico ordemServico;

    public Pagamento(Integer idPagamento, StatusPagamento statusPagamento, OrdemServico ordemServico) {
        this.idPagamento = idPagamento;
        this.statusPagamento = statusPagamento;
        this.ordemServico = ordemServico;
    }

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }
}

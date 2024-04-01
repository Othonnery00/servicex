package br.com.othonnery.servicex.ordemservico.domain;

import br.com.othonnery.servicex.pagamento.domain.Pagamento;
import br.com.othonnery.servicex.servico.domain.ServicoPre;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ORDEMSERVICOS")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdOS;

    @Column(name = "DATA_SOLICITACAO")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataSolicitacao;

    @Column(name = "VALOR_OS")
    private Double valorOS;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ordemServico")
    private Pagamento pagamento;

    @ManyToMany
    @JoinTable(name = "SERVICO_OS",
            joinColumns = @JoinColumn(name = "ID_OS"),
            inverseJoinColumns = @JoinColumn(name = "ID_SERVICO"))
    private Set<ServicoPre> servicos;

    public Integer getIdOS() {
        return IdOS;
    }

    public void setIdOS(Integer idOS) {
        IdOS = idOS;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Double getValorOS() {
        return valorOS;
    }

    public void setValorOS(Double valorOS) {
        this.valorOS = valorOS;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Set<ServicoPre> getServicos() {
        return servicos;
    }

    public void setServicos(Set<ServicoPre> servicos) {
        this.servicos = servicos;
 }
}

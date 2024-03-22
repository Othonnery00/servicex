package br.com.othonnery.servicex.servico.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Generated;

@Entity
@Data
@Table(name = "SERVICOS_PRESTADOS")
public class ServicoPre {

    @Id
    @Generated
    @Column(name = "ID_ServicoPre")
    private Integer IdServicoPre;

    @Column(name = "NOME_SERVICO_PRE")
    private String name;

    @Column(name = "VALOR_SERVICE_PRE")
    private Double valorServicoPre;
    
}

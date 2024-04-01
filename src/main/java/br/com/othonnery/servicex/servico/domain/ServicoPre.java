package br.com.othonnery.servicex.servico.domain;


import br.com.othonnery.servicex.categoria.domain.Categoria;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Data
@Table(name = "SERVICOS_PRESTADOS")
public class ServicoPre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SERVICO_PRE")
    private Integer IdServicoPre;

    @Column(name = "NOME_SERVICO_PRE")
    private String name;

    @Column(name = "VALOR_SERVICE_PRE")
    private Double valorServicoPre;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categorias;
    
}

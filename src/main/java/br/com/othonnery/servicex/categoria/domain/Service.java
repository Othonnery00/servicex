package br.com.othonnery.servicex.categoria.domain;

import br.com.othonnery.servicex.categoria.CategoriaRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SERVIÇOS")
public class Service {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "ID_CATEGORIA" )
 private Integer Idcategoria;

 @Column(name = "NOME_CATEGORIA")
 private String nomeCategoria;

 @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
 private List<Service> serviços;

 @ManyToOne
 @JoinColumn(name = "IdCategoria")


 public Integer getIdcategoria() {
  return Idcategoria;
 }

 public void setIdcategoria(Integer idcategoria) {
  Idcategoria = idcategoria;
 }

 public String getNomeCategoria() {
  return nomeCategoria;
 }

 public void setNomeCategoria(String nomeCategoria) {
  this.nomeCategoria = nomeCategoria;
 }

 public List<Service> getServiços() {
  return serviços;
 }

 public void setServiços(List<Service> serviços) {
  this.serviços = serviços;
 }
}

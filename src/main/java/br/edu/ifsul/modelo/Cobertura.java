package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "cobertura")
public class Cobertura implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_cob", sequenceName = "seq_cob_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_cob", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "A descrição deve ser informada!")
    @Length(max = 50, message = "A descrição não pode ter mais que {max} caracteres!")
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;
    
    @NotBlank(message = "O valor  deve ser informado!")
    @Column(name = "valor", precision = 2, nullable = false)
    private Double valor;
    
    @NotNull(message = "O seguro deve ser informado")
    @ManyToOne
    @JoinColumn(name = "seguro_id", referencedColumnName = "id", nullable = false)        
    private Seguro seguro;
    
    public Cobertura(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }   

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cobertura other = (Cobertura) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "acessorios")
public class Acessorios implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_acess", sequenceName = "seq_acess_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_acess", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "A descrição deve ser informada!")
    @Length(max = 30, message = "A descrição não pode ter mais que {max} caracteres!")
    @Column(name = "descricao", length = 30, nullable = false)
    private String descricao;
    
    public Acessorios(){
        
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
    
    @Override
    public int hashCode() {
        int hash = 5;
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
        final Acessorios other = (Acessorios) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
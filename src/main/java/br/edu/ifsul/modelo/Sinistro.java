package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "sinistro")
public class Sinistro implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_sin", sequenceName = "seq_sin_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_sin", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "A descrição deve ser informada!")
    @Column(name = "descr", nullable = false)
    private String descricao;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data do sinistro deve ser informada!")
    @Column(name = "dta_sin", nullable = false)
    private Calendar dataSin;
    
    @NotBlank(message = "A cidade deve ser informada!")
    @Length(max = 20, message = "A cidade não pode ter mais que {max} caracteres!")
    @Column(name = "cidade", length = 20, nullable = false)
    private String cidade;
    
    @NotBlank(message = "O estado deve ser informado!")
    @Length(max = 20, message = "O estado não pode ter mais que {max} caracteres!")
    @Column(name = "estado", length = 20, nullable = false)
    private String estado;
    
    @NotNull(message = "O seguro deve ser informado")
    @ManyToOne
    @JoinColumn(name = "seguro_id", referencedColumnName = "id", nullable = false)        
    private Seguro seguro;
    
    public Sinistro(){
        this.dataSin = Calendar.getInstance();
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

    public Calendar getDataSin() {
        return dataSin;
    }

    public void setDataSin(Calendar dataSin) {
        this.dataSin = dataSin;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        final Sinistro other = (Sinistro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
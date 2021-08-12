package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "carro")
public class Carro implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_carro", sequenceName = "seq_carro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_carro", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "A placa deve ser informada!")
    @Length(max = 7, message = "A placa não pode ter mais que {max} caracteres!")
    @Column(name = "placa", length = 7, nullable = false)
    private String placa;
    
    @NotBlank(message = "O renavam deve ser informado!")
    @Length(max = 11, message = "O Renavam não pode ter mais que {max} caracteres!")
    @Column(name = "renavam", length = 11, nullable = false)
    private String renavam;
    
    @NotBlank(message = "O modelo deve ser informado!")
    @Length(max = 20, message = "O modelo não pode ter mais que {max} caracteres!")
    @Column(name = "modelo", length = 20, nullable = false)
    private String modelo;
    
    @NotBlank(message = "O fabricante deve ser informado!")
    @Length(max = 15, message = "O fabricante não pode ter mais que {max} caracteres!")
    @Column(name = "fabr", length = 15, nullable = false)
    private String fabricante;
    
    @NotBlank(message = "O ano de fabricação deve ser informado!")
    @Column(name = "ano_fabr", nullable = false)
    private Integer anoFabricacao;
    
    @NotBlank(message = "O ano modelo deve ser informado!")
    @Column(name = "ano_mod", nullable = false)
    private Integer anoModelo;
    
    @NotNull(message = "A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "acessorios_carro",
            joinColumns = 
                    @JoinColumn(name = "id_carro", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name = "acessorios", referencedColumnName = "id", nullable = false))
    private Set<Acessorios> acessorios = new HashSet<>();
    
    public Carro(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    } 

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Set<Acessorios> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(Set<Acessorios> acessorios) {
        this.acessorios = acessorios;
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
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
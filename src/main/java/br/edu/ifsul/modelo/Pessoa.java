package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public class Pessoa implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado!")
    @Length(max = 30, message = "O nome não pode ter mais que {max} caracteres!")
    @Column(name = "nome", length = 30, nullable = false)
    private String nome;
    
    @NotBlank(message = "O CPF deve ser informado!")
    @Length(max = 11, message = "O CPF não pode ter mais que {max} caracteres!")
    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;
    
    @NotBlank(message = "O RG deve ser informado!")
    @Length(max = 10, message = "O RG não pode ter mais que {max} caracteres!")
    @Column(name = "rg", length = 10, nullable = false)
    private String rg;
    
    @NotBlank(message = "O e-mail deve ser informado!")
    @Length(max = 30, message = "O e-mail não pode ter mais que {max} caracteres!")
    @Column(name = "email", length = 30, nullable = false)
    private String email;
    
    @NotBlank(message = "O telefone deve ser informado!")
    @Length(max = 11, message = "O telefone não pode ter mais que {max} caracteres!")
    @Column(name = "telefone", length = 11, nullable = false)
    private String telefone;
    
    public Pessoa(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }   

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
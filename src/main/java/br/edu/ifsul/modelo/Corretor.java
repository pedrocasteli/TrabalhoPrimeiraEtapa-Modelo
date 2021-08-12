package br.edu.ifsul.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "corretor")
public class Corretor extends Pessoa{
    
    @NotBlank(message = "O percentual da comissão deve ser informado!")
    @Column(name = "percentual", precision = 2, nullable = false)
    private Double percentualComissao;
    
    @NotBlank(message = "O usuário deve ser informado!")
    @Length(max = 20, message = "O usuário não pode ter mais que {max} caracteres!")
    @Column(name = "nomeUsuario", length = 20, nullable = false)
    private String nomeUsuario;
    
    @NotBlank(message = "A senha deve ser informada!")
    @Length(max = 15, message = "A senha não pode ter mais que {max} caracteres!")
    @Column(name = "senha", length = 15, nullable = false)
    private String senha;
    
    public Corretor(){
        
    }

    public Double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(Double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }   
}
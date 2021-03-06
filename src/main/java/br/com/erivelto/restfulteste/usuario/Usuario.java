package br.com.erivelto.restfulteste.usuario;

import br.com.erivelto.restfulteste.pessoa.Pessoa;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Create by erivelto on 05/02/19
 */
@Entity
@Data
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "pessoaId", referencedColumnName = "id")
public class Usuario extends Pessoa {

    @Embedded
    private Credenciais credenciais;

    public Usuario(String nomeUsuario, String nome, String senha, TipoUsuario tipoUsuario){
        this.credenciais = new Credenciais(nomeUsuario, senha, tipoUsuario);
        this.setNome(nome);
    }

    public Usuario(String nomeUsuario, String nome, String senha){
        this.credenciais = new Credenciais(nomeUsuario, senha);
        this.setNome(nome);
    }

    public String getUsername() {
        return this.credenciais != null ? this.credenciais.getNomeUsuario() : null;
    }

    public String getSenha() {
        return this.credenciais != null ? this.credenciais.getSenha() : null;
    }

    public void setSenha(String senha){
        this.credenciais.setSenha(senha);
    }

}

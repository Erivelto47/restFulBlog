package br.com.erivelto.restfulteste.usuario.validation;

import br.com.erivelto.restfulteste.core.validation.Validator;
import br.com.erivelto.restfulteste.exception.ValidationException;
import br.com.erivelto.restfulteste.usuario.UsuarioRepository;

/**
 * Create by erivelto on 07/02/19
 */
public class NomeUsuarioValidator implements Validator<String> {

    private final UsuarioRepository usuarioRepository;

    public NomeUsuarioValidator(UsuarioRepository usuarioRepository) {
        this.usuarioRepository =  usuarioRepository;
    }

    @Override
    public void valida(String nomeUsuario) throws ValidationException {

        if(nomeUsuario.equals("")){
            throw new ValidationException("O nome de usuário não pode ser VAZIO.");
        }
        else{

            boolean present = usuarioRepository.findByCredenciais_NomeUsuario(nomeUsuario).isPresent();

            if (present) throw new ValidationException("O nome de usuário já existe.");

        }


    }
}

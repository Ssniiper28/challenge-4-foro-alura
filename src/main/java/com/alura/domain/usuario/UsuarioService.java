package com.alura.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    public UsuarioService(){
//        this.passwordEncoder = new BCryptPasswordEncoder();
//    }

    public Usuario guardar(Usuario usuario){
        String bcryptPass = passwordEncoder.encode(usuario.getPass());
        usuario.setPass(bcryptPass);
        return usuarioRepository.save(usuario);
    }

    public Page<Usuario> listaUsuarios(Pageable paginacion) {
        return usuarioRepository.findAll(paginacion);
    }
}

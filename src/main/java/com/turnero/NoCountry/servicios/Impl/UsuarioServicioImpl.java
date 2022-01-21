
package com.turnero.NoCountry.servicios.Impl;

import com.turnero.NoCountry.Mapper.UsuarioMapper;
import com.turnero.NoCountry.dto.UsuarioDTO;
import com.turnero.NoCountry.entidades.Usuario;
import com.turnero.NoCountry.enums.Role;
import com.turnero.NoCountry.excepciones.WebException;
import com.turnero.NoCountry.repositorios.UsuarioRepositorio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImpl implements UserDetailsService {

      @Autowired
    private UsuarioRepositorio usuarioRepositorio;
      
     @Autowired
     private UsuarioMapper usuarioMapper;
     
     public UsuarioDTO save(UsuarioDTO dto){
        Usuario entidad = usuarioMapper.UsuarioDTO2Entity(dto);
        Usuario entitySaved = usuarioRepositorio.save(entidad);
        UsuarioDTO result = usuarioMapper.UsuarioDTO2Entity(entitySaved);
        return result;
     }

    
    public List<UsuarioDTO> getAllUsuarios() {
    
        List <Usuario> entities = usuarioRepositorio.findAll();
        List <UsuarioDTO> result = usuarioMapper.UsuarioList2DTOList(entities);
        return result;
    }

   @Transactional
    public void save(Usuario usuario) throws WebException, IOException {
        
        String[] symbols = {"+", "=", "-", "*", "'"};
        
        if (usuario.getUsername().isEmpty() || usuario.getUsername() == null) {

            throw new WebException("El email no puede estar vacio");
        }
        
        Usuario user = findByUserName(usuario.getUsername());
        if (user != null) {
            throw new WebException("El email ya está registrado");
        }

        if (usuario.getPassword().isEmpty() || usuario.getPassword() == null) {

            throw new WebException("El password no puede estar vacio");
        }
        if (usuario.getPassword().length() < 6) {
            throw new WebException("La contraseña debe tener al menos 6 caracteres");
        }

        for (int i = 0; i < symbols.length; i++) {
            if (usuario.getPassword().contains(symbols[i])) {
                throw new WebException("La contraseña no debe contener símbolos");
            }
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setId_usuario(usuario.getId_usuario());
        usuario.setUsername(usuario.getUsername());
        usuario.setPassword(encoder.encode(usuario.getPassword()));

        usuario.setRol(Role.USER);
          
    }
    
   public List<Usuario> listAll(String q) {
        // return usuarioRepositorio.findAll("%" + q + "%");
        return usuarioRepositorio.findAll();
    }

    public Usuario findByUserName(String username) {
        return usuarioRepositorio.findByUserName(username);
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepositorio.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Usuario usuario = usuarioRepositorio.findByUserName(username);
            org.springframework.security.core.userdetails.User user;
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_"+usuario.getRol()));
            if (usuario.getRol().equals(Role.ADMIN)) {
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            }
            return new org.springframework.security.core.userdetails.User(username, usuario.getPassword(), authorities);
        } catch (Exception e) {
            throw new UsernameNotFoundException("El usuario no existe");
        }
    }
    
}



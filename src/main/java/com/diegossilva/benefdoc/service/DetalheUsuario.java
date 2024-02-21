package com.diegossilva.benefdoc.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.diegossilva.benefdoc.entity.Usuario;
import com.diegossilva.benefdoc.repository.UsuarioRepository;

@Service
public class DetalheUsuario implements UserDetailsService {

	private final UsuarioRepository repo;

	public DetalheUsuario(UsuarioRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) {
		Usuario u = repo.findById(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuaário não encontrado: "+ email));
		
		return org.springframework.security.core.userdetails.User.builder()
			.username(u.getEmail())
			.password(u.getSenha())
			.build();
	}
	
}

package com.diegossilva.benefdoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.diegossilva.benefdoc.entity.Usuario;
import com.diegossilva.benefdoc.repository.UsuarioRepository;
import com.diegossilva.benefdoc.security.JWTHelper;

@Service
@Lazy
public class UsuarioService { //implements UserDetailsService
	
	@Autowired
    private AuthenticationManager gerenciadorAutenticacao;
	
	private UsuarioRepository repo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }
	
	public String[] fazerLogin(Usuario usuario) {
		
		String[] respostas = new String[2];
		
		Authentication autenticacao = gerenciadorAutenticacao.authenticate(
				new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha()));
		
		String token = JWTHelper.generateToken(usuario.getEmail());
		SecurityContextHolder.getContext().setAuthentication(autenticacao);
		
		usuario = repo.findById(usuario.getEmail()).get();
		
		respostas[0] = "Seja bem-vindo, " + usuario.getNome();
		respostas[1] = token;
		
		return respostas;
		
	}
	
	public String fazerRegistro(Usuario usuario) {
		
		if(repo.existsById(usuario.getEmail())){
            return "Erro: E-mail já existe na base de dados.";
        }
		
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        repo.save(usuario);
		
		return "Você foi registrado com sucesso no sistema, " + usuario.getNome();
		
	}

	/*
	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario u = repo.findById(email)
                 .orElseThrow(() ->
                         new UsernameNotFoundException("Usuaário não encontrado: "+ email));

		SimpleGrantedAuthority a = new SimpleGrantedAuthority(u.getEmail());
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(a);

        return new org.springframework.security.core.userdetails.User(u.getEmail(),
                u.getSenha(),
                authorities);
    }
    */

}

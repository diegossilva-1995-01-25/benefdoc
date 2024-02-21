package com.diegossilva.benefdoc.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegossilva.benefdoc.entity.Usuario;
import com.diegossilva.benefdoc.service.UsuarioService;

@RestController
@RequestMapping("/benefdoc/api/auth")
public class LoginRestController {
	
	@Autowired
	UsuarioService service;
	
	@PostMapping("/login")
	public ResponseEntity<?> autenticar(@RequestBody Usuario usuario) {
		
		String[] msgEToken = service.fazerLogin(usuario);
		
		MultiValueMap<String, String> cabecalho = new LinkedMultiValueMap<>();
		cabecalho.add("Authorization", msgEToken[1]);
		
		return new ResponseEntity<Object>(msgEToken[0], cabecalho, HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
    public ResponseEntity<String> registerUser(@RequestBody Usuario usuario){

        String mensagem = service.fazerRegistro(usuario);
        
        if(mensagem.contains("Erro: ")) {
        	return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
        	return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
        

    }
	

}

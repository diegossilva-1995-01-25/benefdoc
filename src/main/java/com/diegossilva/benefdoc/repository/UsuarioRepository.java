package com.diegossilva.benefdoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diegossilva.benefdoc.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>  {

	boolean existsById(String id);
	
}

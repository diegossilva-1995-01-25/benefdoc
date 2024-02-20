package com.diegossilva.benefdoc.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diegossilva.benefdoc.entity.Beneficiario;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Integer> {
	
	
	
}

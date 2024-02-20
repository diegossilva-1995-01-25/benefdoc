package com.diegossilva.benefdoc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diegossilva.benefdoc.entity.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

	List<Documento> findByBeneficiarioId(Integer id);
	
}

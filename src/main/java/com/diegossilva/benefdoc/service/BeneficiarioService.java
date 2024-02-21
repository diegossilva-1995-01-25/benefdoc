package com.diegossilva.benefdoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegossilva.benefdoc.entity.Beneficiario;
import com.diegossilva.benefdoc.repository.BeneficiarioRepository;

@Service
public class BeneficiarioService {
	
	@Autowired
    private BeneficiarioRepository repo;
	
	public Beneficiario resgateBeneficiarioPorId(Integer id) {
		return repo.findById(id).get();
	}
	
	public List<Beneficiario> resgateTodosBeneficiarios() {
		return repo.findAll();
	}
	
	public Beneficiario cadastrarBeneficiario(Beneficiario beneficiario) {
		return repo.save(beneficiario);
	}
	
	public Beneficiario alterarBeneficiario(Integer id, Beneficiario beneficiario) {
		beneficiario.setId(id);
        return repo.save(beneficiario);
	}
	
	public void excluirBeneficiario(Integer id) {
		repo.deleteById(id);
	}

}

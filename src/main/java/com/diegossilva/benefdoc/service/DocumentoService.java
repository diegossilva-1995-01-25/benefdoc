package com.diegossilva.benefdoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegossilva.benefdoc.entity.Beneficiario;
import com.diegossilva.benefdoc.entity.Documento;
import com.diegossilva.benefdoc.repository.BeneficiarioRepository;
import com.diegossilva.benefdoc.repository.DocumentoRepository;

@Service
public class DocumentoService {

	@Autowired
    private DocumentoRepository docRepo;
	
	@Autowired
	private BeneficiarioRepository benefRepo;
	
    public List<Documento> resgateDocumentosPorBeneficiario(Integer id){
        return docRepo.findByBeneficiarioId(id);
    }
    
    public Documento cadastrarBeneficiario(Documento documento, Integer id) {
    	Beneficiario b = benefRepo.findById(id).get();
    	documento.setBeneficiario(b);
    	return docRepo.save(documento);
    }
	
}

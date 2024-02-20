package com.diegossilva.benefdoc.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diegossilva.benefdoc.entity.Beneficiario;
import com.diegossilva.benefdoc.entity.Documento;
import com.diegossilva.benefdoc.repository.BeneficiarioRepository;
import com.diegossilva.benefdoc.repository.DocumentoRepository;

@Controller
@RequestMapping("/benefdoc/documento")
public class DocumentoRestController {
	
	@Autowired
    private DocumentoRepository docRepo;
	
	@Autowired
	private BeneficiarioRepository benefRepo;
	
	@GetMapping("/{id}/todos") 
    public ResponseEntity<List<Documento>> resgateDocumentosPorBeneficiario(@PathVariable Integer id){
        return ResponseEntity.ok(docRepo.findByBeneficiarioId(id));
    }
    
    @PostMapping("/{id}/cadastrar")
    public ResponseEntity<Documento> cadastrarBeneficiario(@RequestBody Documento documento, @PathVariable Integer id) {
    	Beneficiario b = benefRepo.findById(id).get();
    	documento.setBeneficiario(b);
    	return ResponseEntity.ok(docRepo.save(documento));
    }
	
}

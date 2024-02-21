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

import com.diegossilva.benefdoc.entity.Documento;
import com.diegossilva.benefdoc.service.DocumentoService;

@Controller
@RequestMapping("/benefdoc/documento")
public class DocumentoRestController {
	
	@Autowired
	private DocumentoService service;
	
	@GetMapping("/{id}/todos") 
    public ResponseEntity<List<Documento>> resgateDocumentosPorBeneficiario(@PathVariable Integer id){
        return ResponseEntity.ok(service.resgateDocumentosPorBeneficiario(id));
    }
    
    @PostMapping("/{id}/cadastrar")
    public ResponseEntity<Documento> cadastrarBeneficiario(@RequestBody Documento documento, @PathVariable Integer id) {
    	return ResponseEntity.ok(service.cadastrarBeneficiario(documento, id));
    }
	
}

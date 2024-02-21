package com.diegossilva.benefdoc.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegossilva.benefdoc.entity.Beneficiario;
import com.diegossilva.benefdoc.service.BeneficiarioService;

@RestController
@RequestMapping("/benefdoc/beneficiario")
public class BeneficiarioRestController {
	
	@Autowired
	private BeneficiarioService service;
    
    @GetMapping("/{id}")
    public ResponseEntity<Beneficiario> resgateBeneficiarioPorId(@PathVariable Integer id){
        return ResponseEntity.ok(service.resgateBeneficiarioPorId(id));
    }
    
    @GetMapping("/todos")
    public ResponseEntity<List<Beneficiario>> resgateTodosBeneficiarios(){
        return ResponseEntity.ok(service.resgateTodosBeneficiarios());
    }
    
    @PostMapping("/cadastrar")
    public Beneficiario cadastrarBeneficiario(@RequestBody Beneficiario beneficiario) {
    	return service.cadastrarBeneficiario(beneficiario);
    }
    
    @PostMapping("/alterar/{id}")
    public ResponseEntity<Beneficiario> alterarBeneficiario(@PathVariable Integer id, @RequestBody Beneficiario beneficiario) {
    	return ResponseEntity.ok(service.alterarBeneficiario(id, beneficiario));
    }
	
	@PostMapping("/excluir/{id}")
    public void excluirBeneficiario(@PathVariable Integer id) {
        service.excluirBeneficiario(id);
    }
    
}

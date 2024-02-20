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
import com.diegossilva.benefdoc.repository.BeneficiarioRepository;

@RestController
@RequestMapping("/benefdoc/beneficiario")
public class BeneficiarioRestController {
	
	@Autowired
    private BeneficiarioRepository repo;
    
    @GetMapping("/{id}")
    public ResponseEntity<Beneficiario> resgateBeneficiarioPorId(@PathVariable Integer id){
        return ResponseEntity.ok(repo.findById(id).get());
    }
    
    @GetMapping("/todos")
    public ResponseEntity<List<Beneficiario>> resgateTodosBeneficiarios(){
        return ResponseEntity.ok(repo.findAll());
    }
    
    @PostMapping("/cadastrar")
    public Beneficiario cadastrarBeneficiario(@RequestBody Beneficiario beneficiario) {
    	return repo.save(beneficiario);
    }
    
    @PostMapping("/alterar/{id}")
    public ResponseEntity<Beneficiario> alterarBeneficiario(@PathVariable Integer id, @RequestBody Beneficiario beneficiario) {
    	beneficiario.setId(id);
        return ResponseEntity.ok(repo.save(beneficiario));
    }
	
	@PostMapping("/excluir/{id}")
    public void excluirBeneficiario(@PathVariable Integer id) {
        repo.deleteById(id);
    }
    
}

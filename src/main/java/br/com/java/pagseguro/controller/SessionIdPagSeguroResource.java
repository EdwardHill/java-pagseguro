package br.com.java.pagseguro.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uol.pagseguro.api.PagSeguro;
import br.com.uol.pagseguro.api.session.CreatedSession;

@RestController
@RequestMapping(value = "/session")
public class SessionIdPagSeguroResource {
	
	
	@PostMapping 
	public ResponseEntity<CreatedSession> getSession() {
		CreatedSession createdSessionApplication = null;
		try {

			 PagSeguro pagSeguro = PagSeguro.instance();
			
			if (pagSeguro != null) {
				createdSessionApplication = pagSeguro.sessions().create();
				System.out.println(createdSessionApplication.getId());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(createdSessionApplication);
	}

	

}

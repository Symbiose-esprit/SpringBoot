/*package com.esprit.examen.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class OperateurServiceTest {

	@Autowired
	IOperateurService operateurService;
	 @Autowired
	    OperateurRepository operateurRepository;
	

	@BeforeEach
	void
	setUp() {
		operateurRepository.deleteAll();
	}

	@AfterEach
	void
	setDown() {
		operateurRepository.deleteAll();
	}
	//testing Add method
	@Test
	@Order(2)
	public void testAddOperateur(){
		List<Operateur> operateurs = operateurService.retrieveAllOperateurs();
		int expected = operateurs.size();
		Operateur o = new Operateur();
		o.setNom("yasmine");
		o.setPrenom("baouab");
		o.setPassword("passwd");
		Operateur savedOperateur= operateurService.addOperateur(o);
		assertEquals(expected+1, operateurService.retrieveAllOperateurs().size());
		assertNotNull(savedOperateur.getNom());
		operateurService.deleteOperateur(savedOperateur.getIdOperateur());
		
	}
	
	//Testing retrieveOperateur
	@Test
	@Order(1)
	public void testRetrieveOperateurs() {
		Operateur o = new Operateur();
		o.setNom("yasss");
		o.setPrenom("baouab");
		o.setPassword("pass");
		Operateur savedOperateur= operateurService.addOperateur(o);
		Operateur getOperateur= operateurService.retrieveOperateur(savedOperateur.getIdOperateur());
		assertNotNull(savedOperateur.getNom());
		assertNotNull(savedOperateur.getPrenom());
		assertEquals(savedOperateur.getIdOperateur(),getOperateur.getIdOperateur());
		
		operateurService.deleteOperateur(savedOperateur.getIdOperateur());
		}
	
	
	//Testing updateOperateur
	@Test
	public void testUpdateOperateur() {
		Operateur o = new Operateur();
		o.setNom("syrine");
		o.setPrenom("baouab");
		o.setPassword("pass");
		Operateur savedOperateur= operateurService.addOperateur(o);
		savedOperateur.setNom("daam");
		operateurService.updateOperateur(savedOperateur);
		assertEquals(o.getNom(),savedOperateur.getNom());
		operateurService.deleteOperateur(savedOperateur.getIdOperateur());
		}
	
	//Testing deleteOperateur
	@Test
	@Order(3)
	public void testDeleteOperateur() {
		Operateur o = new Operateur();
		o.setNom("hichem");
		o.setPrenom("baouab");
		o.setPassword("pass");
		Operateur savedOperateur= operateurService.addOperateur(o);
		operateurService.deleteOperateur(savedOperateur.getIdOperateur());
		assertNotNull(savedOperateur.getIdOperateur());
		
	}
}*/

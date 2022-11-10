package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.esprit.examen.entities.*;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.OperateurRepository;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
class OperateurServiceTest {

	@Mock
	OperateurRepository operateurRepository;
	@Mock
    FactureRepository factureRepository;

	@InjectMocks
	OperateurServiceImpl operateurService;

    @AfterEach
    void
    setDown() {
        operateurRepository.deleteAll();
    }
    @BeforeEach
    void
    setUp() {
        operateurRepository.deleteAll();
    }
    @Test
    public void retrieveAllOperateurs(){
        var facture = new Facture();
        facture.setMontantRemise(0.5F);
        facture.setArchivee(true);
        // facture.setArchivee(false);


        facture.setMontantFacture(10F);
        facture.setDateCreationFacture(new Date());

        facture.setDateDerniereModificationFacture(new Date());
        factureRepository.save(facture);
        var listFactures = new HashSet<Facture>();
        listFactures.add(facture);
        // operateur.setFactures(listFactures);

        var operateur = new Operateur();
        operateur.setFactures(listFactures);
        operateur.setNom("hello");
		
        operateur.setPrenom("hello");
        operateur.setPassword("admin");/* 
        var rs = operateurService.retrieveAllOperateurs();
        Assertions.assertEquals(1 , rs.size());
        Assertions.assertEquals("admin",rs.get(0).getNom()); */
        operateurRepository.save(operateur);
        var rs = operateurService.retrieveAllOperateurs();
        Assertions.assertEquals(1 , rs.size());
        Assertions.assertEquals("admin",rs.get(0).getNom());
        Assertions.assertNotNull(operateur.getFactures());
    }
}
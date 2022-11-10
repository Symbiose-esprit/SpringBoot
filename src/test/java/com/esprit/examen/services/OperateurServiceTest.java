package com.esprit.examen.services;


import com.esprit.examen.entities.*;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.OperateurRepository;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import static org.junit.Assert.assertNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OperateurServiceTest {

    @Autowired
    OperateurRepository operateurRepository;

    @Autowired
    FactureRepository factureRepository;
    @Autowired
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

/*     @Test
    public void deleteOperateur(){
        var operateur = new Operateur();
        operateur.setNom("hello");
        operateur.setPrenom("hello");
        operateur.setPassword("admin");
        var rs = operateurRepository.save(operateur);

        operateurService.deleteOperateur(rs.getIdOperateur());
        assertNull(operateurService.retrieveOperateur(rs.getIdOperateur()));
    } */


}
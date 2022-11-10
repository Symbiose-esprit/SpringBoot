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

    @Test
    public void retrieveAllOperateurs(){
        var facture = new Facture();
        facture.setMontantRemise(0.5F);
        facture.setArchivee(true);
        facture.setMontantFacture(10F);
        facture.setDateCreationFacture(new Date());
        facture.setDateDerniereModificationFacture(new Date());
        factureRepository.save(facture);

        var listFactures = new HashSet<Facture>();
        listFactures.add(facture);

        var operateur = new Operateur();
        operateur.setFactures(listFactures);
        operateur.setNom("yasmine");
        operateur.setPrenom("yasmine");
        operateur.setPassword("yas");
        operateurRepository.save(operateur);

        var rs = operateurService.retrieveAllOperateurs();
        Assertions.assertEquals(1 , rs.size());
        Assertions.assertEquals("yasmine",rs.get(0).getNom());
        Assertions.assertNotNull(operateur.getFactures());
    }

    @Test
    public void addOperateur(){
        var operateur = new Operateur(1L,"yasmine","yasmine","yas",new HashSet<Facture>());
        var rs = operateurService.addOperateur(operateur);

        Assertions.assertEquals("yasmine",rs.getNom());
        Assertions.assertEquals("yasmine",rs.getPrenom());
        Assertions.assertEquals("yas",rs.getPassword());

    }
    @Test
    public void deleteOperateur(){
        var operateur = new Operateur();
        operateur.setNom("yasmine");
        operateur.setPrenom("yasmine");
        operateur.setPassword("yas");
        var rs = operateurRepository.save(operateur);

        operateurService.deleteOperateur(rs.getIdOperateur());
        assertNull(operateurService.retrieveOperateur(rs.getIdOperateur()));
    }


    @Test
    public void retrieveOperateur(){
        var operateur = new Operateur();
        operateur.setNom("yasmine");
        operateur.setPrenom("yasmine");
        operateur.setPassword("yas");
        var op = operateurRepository.save(operateur);
        var rs = operateurService.retrieveOperateur(op.getIdOperateur());

        Assertions.assertEquals(op.getIdOperateur(),rs.getIdOperateur());
        Assertions.assertEquals(op.getNom(),rs.getNom());
    }
}

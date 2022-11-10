package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@Slf4j
class ProduitServiceImplTestImpl {
    @Autowired
    IProduitService ps;
    @Autowired
    ProduitRepository pr;
    @Autowired
    StockRepository sr;
    @Autowired
    CategorieProduitRepository catr;

    @BeforeAll
    public void clearDataBase() {
        pr.deleteAll();
        sr.deleteAll();
        catr.deleteAll();
    }

    @Test
    @Order(0)
    void addProduitTest() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("01/09/2022");
        Date date2 = dateFormat.parse("14/12/2022");
        Set<Produit> s = Collections.emptySet();
        Set<DetailFacture> f = Collections.emptySet();
        CategorieProduit cp = new CategorieProduit("cp", "tech", s);
        catr.save(cp);
        log.info("this is the predefined category : " + cp.toString());
        assertNotNull(cp.getIdCategorieProduit());
        Stock st = new Stock("laptops", 50, 10);
        sr.save(st);
        log.info("this is the predefined stock : " + st.toString());
        assertNotNull(st.getIdStock());
        assertTrue(st.getQte() > 0);
        Produit p = new Produit(1L, "ftp", "laptop", 1000, date, date2, st, f, cp);
        p = ps.addProduit(p);
        log.info("this is the added product : " + p.toString());
        assertNotNull(p.getIdProduit());
        assertNotEquals(0, p.getPrix());
        assertTrue(p.getDateDerniereModification().compareTo(p.getDateCreation()) >= 0);
    }

    @Test
    @Order(1)
    void updateStockTest() throws ParseException {
        List<Produit> prods = ps.retrieveAllProduits();
        log.info("this is all the products : " + prods.toString());
        assertNotNull(prods);
        for (Produit produit : prods) {
            Stock stock = sr.findById(produit.getStock().getIdStock()).orElse(null);
            assertNotNull(produit.getStock().getIdStock());
            stock.setQte(stock.getQte() + 1);
            sr.save(stock);
            log.info(stock.toString());
        }
    }

//	@AfterAll
//	public void clearDataBase() {
//		pr.deleteAll();
//		sr.deleteAll();
//	    catr.deleteAll();
//	}

}
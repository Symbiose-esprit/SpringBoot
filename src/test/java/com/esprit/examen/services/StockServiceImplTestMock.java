package com.esprit.examen.services;


import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;
import lombok.var;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.HashSet;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StockServiceImplTestMock {
    @Mock
    StockRepository stockRepository;

    @InjectMocks
    StockServiceImpl stockService;

    @BeforeEach
    void
    setUp() {
        stockRepository.deleteAll();
    }

    @AfterEach
    void
    setDown() {
        stockRepository.deleteAll();
    }
    

    @Test
    public void PRODUCTS_addStock(){
        var prd1 = new Produit();
        prd1.setIdProduit(1L);
        prd1.setPrix(10F);
        var prd2 = new Produit();
        prd2.setIdProduit(2L);
        prd2.setPrix(25F);
        var prods = new HashSet<Produit>();
        prods.add(prd1);
        prods.add(prd2);
        var stock1 = new Stock("stock",8,2);
        stock1.setProduits(prods);
        Mockito.when(stockRepository.save(Mockito.any())).thenReturn(stock1);
        var res = stockService.addStock(stock1);
        Assertions.assertEquals(2,res.getProduits().size());
        Assertions.assertTrue(res.getProduits().contains(prd1));
        Assertions.assertTrue(res.getProduits().contains(prd2));
        Assertions.assertTrue(res.getQte()>res.getQteMin());
    }

}

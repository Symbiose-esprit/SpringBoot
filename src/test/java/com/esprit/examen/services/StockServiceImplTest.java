package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.StockRepository;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.esprit.examen.entities.Stock;


@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class StockServiceImplTest {
	@Autowired
	IStockService stockService;


    @Autowired
    StockRepository stockRepository;

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
	@Order(1)
    public void RetrieveStocks(){
        var stock1 = new Stock("STOCK1",8,2);
        var stock2 = new Stock("STOCK2",12,4);


		stockRepository.save(stock1);
		stockRepository.save(stock2);

		var ls = stockService.retrieveAllStocks();
        Assertions.assertEquals(2,ls.size());
		Assertions.assertEquals(1,ls.get(0).getIdStock());
		Assertions.assertEquals("test",ls.get(0).getLibelleStock());

	}
	@Test
	@Order(2)
	public void AddStockTEST() {
		Stock s = new Stock("test",8,50);
		Stock savedStock= stockService.addStock(s);
		assertNotNull(savedStock.getLibelleStock());
		stockService.deleteStock(savedStock.getIdStock());
	}

	@Test
	@Order(3)
	public void testAddStockOptimized() {

		Stock stock = new Stock();
		stock.setLibelleStock("stockOP");
		stock.setQte(15);
		stock.setQteMin(8);
		Stock savedStock= stockService.addStock(stock);
		assertNotNull(savedStock.getIdStock());
		assertSame(10, savedStock.getQte());
		assertTrue(savedStock.getQteMin()>0);
		stockService.deleteStock(savedStock.getIdStock());

	}

	@Test
	@Order(4)
	public void testDeleteStock() {
		Stock stock = new Stock("stockDelete",20,25);
		Stock savedStock= stockService.addStock(stock);
		stockService.deleteStock(savedStock.getIdStock());
		assertNull(stockService.retrieveStock(savedStock.getIdStock()));
	}

	@Test
	public void retrieveStock_THEN_EXPECT_1(){
		var s1 = new Stock("tst",10,20);
		var s2 = new Stock("tst2",100,20);
		stockRepository.save(s1);
		stockRepository.save(s2);
		var res = stockRepository.retrieveStatusStock();
		Assertions.assertEquals(1,res.size());
		Assertions.assertEquals("tst",res.get(0).getLibelleStock());

	}


	@Test
	public void updateStock(){
		var stock1 = new Stock("tst",10,20);
		var s=stockRepository.save(stock1);
		var s1 = stockService.retrieveStock(s.getIdStock());
		s1.setQteMin(50);
		s1.setQte(100);
		var rs2 = stockService.updateStock(s1);
		Assertions.assertEquals("tst",rs2.getLibelleStock());
		Assertions.assertEquals(100,rs2.getQte());
	}

}
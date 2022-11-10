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

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.repositories.ProduitRepository;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
class ProduitServiceImplWithMockitoTestImpl {

	@Mock
	ProduitRepository pr;
	@Mock
	CategorieProduitRepository catr;

	@InjectMocks
	ProduitServiceImpl ps;

	Set<DetailFacture> f = Collections.emptySet();
	Set<Produit> s = Collections.emptySet();

	@Test
	@Order(3)
	void deleteProductsByCategory() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = dateFormat.parse("01/09/2022");
		Date date2 = dateFormat.parse("14/12/2022");
		CategorieProduit cat = CategorieProduit.builder().codeCategorie("cp").libelleCategorie("tech").produits(s)
				.build();
		List<Produit> products = new ArrayList<Produit>() {
			{
				add(Produit.builder().codeProduit("tp").libelleProduit("iphone").prix(1500).dateCreation(date)
						.dateCreation(date2).detailFacture(f).categorieProduit(cat).build());
				add(Produit.builder().codeProduit("tp").libelleProduit("samsung").prix(950).dateCreation(date)
						.dateCreation(date2).detailFacture(f).categorieProduit(cat).build());
			}
		};
//		Produit p = Produit.builder().codeProduit("tp").libelleProduit("iphone").prix(1500).dateCreation(date)
//				.dateCreation(date2).categorieProduit(cat).build();

		catr.save(cat);
//		assertNotNull(cat.getIdCategorieProduit());
		log.info("this is the predefined category : " + cat.toString());
		Mockito.when(pr.findAll()).thenReturn(Optional.of(products).orElse(null));
		assertNotNull(products);
		ps.deleteProductsByCategory("tech");
		verify(pr).findAll();

	}
}

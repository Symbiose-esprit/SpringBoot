/*package com.esprit.examen.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;





@ExtendWith(MockitoExtension.class)
public class OperateurServiceTestMock {
	@Mock
	OperateurRepository operateurRepository;
	
	@InjectMocks
	OperateurServiceImpl operateurService;
	
	
	@Test
	public void retrieveAllOperateursTest() {
		when(operateurRepository.findAll()).thenReturn(Stream.of(new Operateur((long)1,"yas","yas","pwd", null), new Operateur((long)2,"meriem","meriem","pwd", null), 
				new Operateur((long)3,"ali","ali","pwd", null)).collect(Collectors.toList()));
		assertEquals(3,operateurService.retrieveAllOperateurs().size());
		
	}
	
	@Test
	public void addOperateurTest() {
		Operateur op = new Operateur((long)1,"mhd","med","pwdd", null) ;
		when(operateurRepository.save(op)).thenReturn(op);
		assertEquals(op,operateurService.addOperateur(op));
	}
	
	
	@Test
	public void retreiveOperateurTest() {
		Operateur op = new Operateur((long)2,"adem","med","pwdd", null) ;
		when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(op));
		Operateur op1= operateurService.retrieveOperateur((long)2);
		Assertions.assertNotNull(op1);
		
	}
	
	
	
	@Test
	public void deleteOperateurTest() {
		Operateur op = new Operateur((long)1,"anis","ais","pwdd", null) ;
		operateurService.deleteOperateur((long)1);
		verify(operateurRepository).deleteById((long)1);
		
	}
	
	@Test
	public void updatetOperateurTest() {
		Operateur op = new Operateur((long)1,"yas","yas","pwdd", null) ;
		Mockito.when(operateurRepository.save(Mockito.any(Operateur.class))).thenReturn(op);
		op.setPrenom("eya");;
		Operateur exisitingOp= operateurService.updateOperateur(op) ;
		
		assertNotNull(exisitingOp);
		assertEquals("eya", op.getPrenom());
	}

	
	
		
	
	
	
}*/

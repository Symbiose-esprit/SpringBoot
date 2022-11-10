package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import com.esprit.examen.services.SecteurActiviteServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;




@RunWith(SpringRunner.class)
@SpringBootTest
public class SecteurActivTest {

    @Autowired
    private SecteurActiviteServiceImpl service;

    @MockBean
    private SecteurActiviteRepository repository;

    /*
    @Test
    public void getUsersTest() {
        when(repository.findAll()).thenReturn(Stream
                .of(new SecteurActivite(1, "code", "mahdi", ["mahdi"]), new User(2, "nacef", "nacef", "nacef")).collect(Collectors.toList()));
        assertEquals(2, service.getUsers().size());
    }

    @Test
    public void getUserbyUsernameTest() {
        String username = "tunisie";
        when(repository.findByUsername(username))
                .thenReturn(Stream.of(new User(1, "chedly", "chedly", "chedly")).collect(Collectors.toList()));
        assertEquals(1, service.getUserbyUsername(username).size());
    }

    @Test
    public void saveUserTest() {
        User user = new User(3, "test", "test", "test");
        when(repository.save(user)).thenReturn(user);
        assertEquals(user, service.addUser(user));
    }

    @Test
    public void deleteUserTest() {
        User user = new User(3, "test", "test", "test");
        service.deleteUser(user);
        verify(repository, times(1)).delete(user);
    }
     */

}
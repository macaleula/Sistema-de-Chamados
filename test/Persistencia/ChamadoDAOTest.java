/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import entidade.Chamado;
import entidade.RegistroChamado;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matheus
 */
public class ChamadoDAOTest {
    
    public ChamadoDAOTest() {
    }
    
    @Test
    public void gerarCodigoTest() {
        ChamadoDAO chamadoDAO = new ChamadoDAO();
        assertEquals(1, chamadoDAO.gerarCodigo());
    }
    
    @Test
    public void gerarCodigoRegistroChamadoTest() {
        ChamadoDAO chamadoDAO = new ChamadoDAO();
        assertEquals(1, chamadoDAO.gerarCodigoRegistroChamado());

    }

    @Test
    public void putTest() {
        
    }

    @Test
    public void putRegistroTest() {

    }

    @Test
    public void getTest() {
    }

    @Test
    public void loadTest() {
     
    }
    
    @Test
    public void persitTest() {      
    }
}

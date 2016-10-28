/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matheus
 */
public class EmpresaTest {
    
    public EmpresaTest() {
    }
    
    @Test
    public void construtorTest() {
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        
        assertEquals(1,empresa.getNumeroContrato());
        assertEquals("Jambo Lanches",empresa.getNomeEmpresa());

    }
    
    @Test
    public void toStringTest() {
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        
        String expected = "1 - Jambo Lanches";
        
        assertEquals(expected ,empresa.toString());
    }
}

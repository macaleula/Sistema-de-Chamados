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
public class TecnicoTest {
    
    public TecnicoTest() {
    }
    
    @Test
    public void construtorTest() {
        Tecnico tecnico = new Tecnico("Jorge",41148822);
        
        assertEquals("Jorge",tecnico.getNome());
        assertEquals(41148822,tecnico.getTelefone());
    }
    
    @Test
    public void toStringTest() {
        Tecnico tecnico = new Tecnico("Jorge",41148822);
        
        String expected = "Jorge";
        
        assertEquals(expected ,tecnico.toString());
    }
}

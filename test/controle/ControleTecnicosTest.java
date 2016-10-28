/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.Tecnico;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matheus
 */
public class ControleTecnicosTest {
    
    public ControleTecnicosTest() {
    }
    
    public void inserirTest() {
        ControleTecnicos controle = new ControleTecnicos();
        Tecnico t = controle.inserir(33240989, "Geraldo");
        
        assertEquals("Geraldo",t.getNome());
        assertEquals(33240989,t.getTelefone());
    }
}

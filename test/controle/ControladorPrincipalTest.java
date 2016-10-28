package controle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matheus
 */
public class ControladorPrincipalTest {
    
    public ControladorPrincipalTest() {
    }
    
    @Test
    public void inicializationTest() {
        ControladorPrincipal crtP = new ControladorPrincipal();
        
        assertTrue(crtP.getCtrChamados() != null);
        assertTrue(crtP.getCtrClientes()!= null);
        assertTrue(crtP.getCtrEmpresa()!= null);
        assertTrue(crtP.getCtrTecnicos()!= null);
    }
}

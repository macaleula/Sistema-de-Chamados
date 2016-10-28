/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.Empresa;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matheus
 */
public class ControleEmpresasTest {
    
    public ControleEmpresasTest() {
    }
    
    @Test
    public void retornaTest() {
        ControleEmpresas controle = new ControleEmpresas();
        controle.inserir(2,"Banespa");
        Empresa resultado = controle.retorna(2, "Banespa");
        
        assertEquals(2,resultado.getNumeroContrato());
        assertEquals("Banespa",resultado.getNomeEmpresa());       
    }
    
    @Test
    public void validarTest() {
        ControleEmpresas controle = new ControleEmpresas();
        controle.inserir(3,"Nestle");
        
        assertEquals(1,controle.validar(3, "Nestle"));
        assertEquals(2,controle.validar(4, "Nestle"));
        assertEquals(3,controle.validar(3, "Garoto"));
        assertEquals(4,controle.validar(4, "Garoto"));
    }
    
    @Test
    public void inserirTest() {
        ControleEmpresas controle = new ControleEmpresas();      
        
        assertEquals(null,controle.inserir(3,"Nestle"));
        assertEquals("Ecil",controle.inserir(5,"Ecil").getNomeEmpresa());
    }
    
    @Test
    public void checarTest() {
        ControleEmpresas controle = new ControleEmpresas();
        controle.inserir(3,"Nestle");
        
        assertTrue(controle.checar(new Long(3), "Nestle"));
    }
}

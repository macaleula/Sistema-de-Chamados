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
public class PessoaTest {
    
    public PessoaTest() {
    }
    
    @Test
    public void construtorTest() {
        Pessoa pessoa = new Pessoa("Anderson",41148822);
        
        assertEquals("Anderson",pessoa.getNome());
        assertEquals(41148822,pessoa.getTelefone());
    }
}

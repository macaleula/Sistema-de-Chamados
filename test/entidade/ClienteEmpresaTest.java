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
public class ClienteEmpresaTest {
    
    public ClienteEmpresaTest() {
    }
    
    // O sistema nao suporta um cpf de tamanho normal
    @Test
    public void construtorTest() {
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(1,empresa,11111,"Ronaldo",41442828);
        
        assertEquals(1,cliente.getCodigo().intValue());
        assertEquals("Jambo Lanches",cliente.getEmpresa().getNomeEmpresa());
        assertEquals(11111,cliente.getCpf());
        assertEquals("Ronaldo",cliente.getNome());
        assertEquals(41442828,cliente.getTelefone());
    }
    
    @Test
    public void toStringTest() {
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(1,empresa, 11111,"Ronaldo",41442828);
        
        String expected = "Contrato: 1 - Nome Empresa:Jambo Lanches - Cliente: 11111 - Ronaldo";
        
        assertEquals(expected ,cliente.toString());
    }
}

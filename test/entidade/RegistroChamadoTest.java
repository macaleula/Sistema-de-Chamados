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
public class RegistroChamadoTest {
    
    public RegistroChamadoTest() {
    }
    
    @Test
    public void construtorTest() {
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(3,empresa,1333,"Lucas",12344321);       
        Chamado chamadoRede = new Chamado(1,"Teste chamado rede","Teste Junit rede",1,tecnico,cliente,"Windows","7.01","LAN","127.0.0.1");
        
        RegistroChamado registro = new RegistroChamado("Teste Rede",chamadoRede,tecnico);
        
        assertEquals("Teste Rede",registro.getAssunto());
        assertEquals(chamadoRede.getTitulo(),registro.getChamado().getTitulo());
        assertEquals(tecnico.getNome(),registro.getTecnico().getNome());
    }
    
}

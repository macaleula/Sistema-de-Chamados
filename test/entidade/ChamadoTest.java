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
public class ChamadoTest {
    
    public ChamadoTest() {
        
    }
    
    @Test
    public void ChamadoRedeTest() {
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(3,empresa,1333,"Lucas",12344321);
        
        Chamado chamadoRede = new Chamado(1,"Teste chamado rede","Teste Junit rede",1,tecnico,cliente,"Windows","7.01","LAN","127.0.0.1");

        assertEquals(1,chamadoRede.getCodigo());
        assertEquals("Teste chamado rede",chamadoRede.getTitulo());
        assertEquals("Teste Junit rede",chamadoRede.getDescricao());
        assertEquals(1,chamadoRede.getPrioridade());
        assertEquals(tecnico.getNome(),chamadoRede.getTecnico().getNome());
        assertEquals(cliente.getCodigo(),chamadoRede.getCliente().getCodigo());
        assertEquals("Windows",chamadoRede.getSistemaOperacional());
        assertEquals("7.01",chamadoRede.getVersaoSO());
        assertEquals("LAN",chamadoRede.getTipoConexao());
        assertEquals("127.0.0.1",chamadoRede.getEnderecoRede());  
        assertEquals("Iniciado",chamadoRede.getStatus());
        assertEquals("Problema de Rede",chamadoRede.getTipoProblema());
    }
    
    @Test
    public void ChamadoBancoDeDadosTest() {
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(3,empresa,1333,"Lucas",12344321);
        
        Chamado chamadoRede = new Chamado("Teste chamado Banco de dados","Teste Junit banco",1,tecnico,cliente,"Windows","7.01","jdbc:derby://localhost:1527/testeDB");

        assertEquals("Teste chamado Banco de dados",chamadoRede.getTitulo());
        assertEquals("Teste Junit banco",chamadoRede.getDescricao());
        assertEquals(1,chamadoRede.getPrioridade());
        assertEquals(tecnico.getNome(),chamadoRede.getTecnico().getNome());
        assertEquals(cliente.getCodigo(),chamadoRede.getCliente().getCodigo());
        assertEquals("Windows",chamadoRede.getSistemaOperacional());
        assertEquals("7.01",chamadoRede.getVersaoSO());
        assertEquals("jdbc:derby://localhost:1527/testeDB",chamadoRede.getBancoDeDados());
        assertEquals("Iniciado",chamadoRede.getStatus());
        assertEquals("Banco de Dados",chamadoRede.getTipoProblema());        
    }
    
    @Test
    public void ChamadoDesempenhoTest() {
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(3,empresa,1333,"Lucas",12344321);
        
        Chamado chamadoRede = new Chamado("Teste chamado Desempneho","Teste Junit desempenho",1,tecnico,cliente,"Windows","7.01","Teste",20);

        assertEquals("Teste chamado Desempenho",chamadoRede.getTitulo());
        assertEquals("Teste Junit desempenho",chamadoRede.getDescricao());
        assertEquals(1,chamadoRede.getPrioridade());
        assertEquals(tecnico.getNome(),chamadoRede.getTecnico().getNome());
        assertEquals(cliente.getCodigo(),chamadoRede.getCliente().getCodigo());
        assertEquals("Windows",chamadoRede.getSistemaOperacional());
        assertEquals("7.01",chamadoRede.getVersaoSO());
        assertEquals("Teste",chamadoRede.getOperacao());
        assertEquals(20,chamadoRede.getDuracaoOperacao(),0.1);
        assertEquals("Iniciado",chamadoRede.getStatus());
        assertEquals("Banco de Dados",chamadoRede.getTipoProblema());       
    }
  
    @Test
    public void equalsTest() {
        
    }
}

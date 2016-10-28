/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import apresentacao.TelaCadastroChamado;
import apresentacao.TelaRegistAcomp;
import apresentacao.TelaRelatorioChamado;
import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.RegistroChamado;
import entidade.Tecnico;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matheus
 */
public class ControleChamadosTest {
    
    public ControleChamadosTest() {
    }
    
    @Test
    public void alterarChamadoTest() {
        ControleChamados controleChamados = new ControleChamados();
        
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(3,empresa,1333,"Lucas",12344321);
        
        Chamado chamadoRede = new Chamado(1,"Teste chamado rede","Teste Junit rede",1,tecnico,cliente,"Windows","7.01","LAN","127.0.0.1");
        
        assertEquals("Iniciado",chamadoRede.getStatus());
        assertEquals(null,chamadoRede.getCausaProblema());
        assertEquals(null,chamadoRede.getSolucaoProblema());
        
        controleChamados.alterarChamado(chamadoRede, "Sob resolução", "Exceso de usuarios", "Expandir gama de enderecos de rede");
        
        assertEquals("Sob resolução",chamadoRede.getStatus());
        assertEquals("Exceso de usuarios",chamadoRede.getCausaProblema());
        assertEquals("Expandir gama de enderecos de rede",chamadoRede.getSolucaoProblema());
    }

    @Test
    public void InserirChamadoRedeTest() {

    }

    @Test
    public void InserirChamadoBancoDeDados() {
 
    }

    @Test
    public void InserirChamadoDesempenhoTest() {

    }

    @Test
    public void inserirRegistroChamadoTest() {

    }

    @Test
    public void cadastrarChamadoTest() {
        
    }

    @Test
    public void voltaChamadoCodigoTest() {
  
    }

    @Test
    public void emitirRelatoriosTest() {
    }

    @Test
    public void buscaPeloCodigo() {
    }

    @Test
    public void retornaDetalhesChamadoTest() {

    }

    @Test
    public void alterarChamadoTest2() {

    }

    @Test
    public void abrirRelatorioTest() {

    }

    @Test
    public void fecharTelaAlteracaoTest() {

    }
    
    @Test
    public void validarQtdChamadosTest(){

    }
}

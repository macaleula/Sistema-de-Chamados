/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Persistencia.ChamadoDAO;
import apresentacao.TelaCadastroChamado;
import apresentacao.TelaRegistAcomp;
import apresentacao.TelaRelatorioChamado;
import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.RegistroChamado;
import entidade.Tecnico;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(3,empresa,1333,"Lucas",12344321);
  
        ControleChamados controle = new ControleChamados();
        controle.InserirChamadoRede("Teste chamado rede", "Teste Junit rede", 1, tecnico, cliente, "Windows", "7.01", "LAN", "127.0.0.1");
        
        ChamadoDAO chamadoDAO = new ChamadoDAO();
        Iterator<Chamado> iterator = chamadoDAO.getChamados().iterator();
        while(iterator.hasNext()) {
            Chamado aux = iterator.next();
            if(aux.getTitulo() == "Teste chamado rede") {
                assertEquals("Teste Junit rede",aux.getDescricao());
                assertEquals(1,aux.getPrioridade());
                assertEquals(tecnico.getNome(),aux.getTecnico().getNome());
                assertEquals(cliente.getCodigo(),aux.getCliente().getCodigo());
                assertEquals("Windows",aux.getSistemaOperacional());
                assertEquals("7.01",aux.getVersaoSO());
                assertEquals("LAN",aux.getTipoConexao());
                assertEquals("127.0.0.1",aux.getEnderecoRede());
            }
        }  
    }

    @Test
    public void InserirChamadoBancoDeDados() {
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(3,empresa,1333,"Lucas",12344321);
  
        ControleChamados controle = new ControleChamados();
        controle.InserirChamadoBancoDeDados("Teste chamado banco", "Teste Junit banco",
                1, tecnico, cliente, "Windows", "7.01", "jdbc:derby://localhost:1527/testeDB");
        
        ChamadoDAO chamadoDAO = new ChamadoDAO();
        Iterator<Chamado> iterator = chamadoDAO.getChamados().iterator();
        while(iterator.hasNext()) {
            Chamado aux = iterator.next();
            if(aux.getTitulo() == "Teste chamado banco") {
                assertEquals("Teste Junit banco",aux.getDescricao());
                assertEquals(1,aux.getPrioridade());
                assertEquals(tecnico.getNome(),aux.getTecnico().getNome());
                assertEquals(cliente.getCodigo(),aux.getCliente().getCodigo());
                assertEquals("Windows",aux.getSistemaOperacional());
                assertEquals("7.01",aux.getVersaoSO());
                assertEquals("jdbc:derby://localhost:1527/testeDB",aux.getTipoConexao());
            }
        }
    }

    @Test
    public void InserirChamadoDesempenhoTest() {
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(3,empresa,1333,"Lucas",12344321);
  
        ControleChamados controle = new ControleChamados();
        controle.InserirChamadoDesempenho("Teste chamado rede", "Teste Junit rede", 1, tecnico, cliente, "Windows", "7.01", "HUD", 35);

        
        ChamadoDAO chamadoDAO = new ChamadoDAO();
        Iterator<Chamado> iterator = chamadoDAO.getChamados().iterator();
        while(iterator.hasNext()) {
            Chamado aux = iterator.next();
            if(aux.getTitulo() == "Teste chamado rede") {
                assertEquals("Teste Junit rede",aux.getDescricao());
                assertEquals(1,aux.getPrioridade());
                assertEquals(tecnico.getNome(),aux.getTecnico().getNome());
                assertEquals(cliente.getCodigo(),aux.getCliente().getCodigo());
                assertEquals("Windows",aux.getSistemaOperacional());
                assertEquals("7.01",aux.getVersaoSO());
                assertEquals("HUD",aux.getOperacao());
                assertEquals(35,aux.getDuracaoOperacao(),0.1);
            }
        }
    }

    @Test
    public void inserirRegistroChamadoTest() {       
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(3,empresa,1333,"Lucas",12344321);
        
        Chamado chamadoRede = new Chamado(1,"Teste chamado rede","Teste Junit rede",1,tecnico,cliente,"Windows","7.01","LAN","127.0.0.1");
        
        ControleChamados controle = new ControleChamados();
        controle.inserirRegistroChamado("Teste", chamadoRede, tecnico);
        
        ChamadoDAO chamadoDAO = new ChamadoDAO();
        Iterator<RegistroChamado> iterator = chamadoDAO.getRegistros().iterator();
        while(iterator.hasNext()) {
            RegistroChamado aux = iterator.next();
            if(aux.getAssunto()== "Teste") {
                assertEquals(chamadoRede.getTitulo(),aux.getChamado().getTitulo());
                assertEquals(tecnico.getNome(),aux.getTecnico().getNome());
            }
        }
    }

    @Test
    public void emitirRelatoriosTest() {
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(3,empresa,1333,"Lucas",12344321);
        
        
        
        ControleChamados controle = new ControleChamados();
        controle.InserirChamadoRede("Teste chamado rede","Teste Junit rede",1,tecnico,cliente,"Windows","7.01","LAN","127.0.0.1");

        String result = controle.emitirRelatorios(0);
        String expected = "Data de abertura do chamado: 28/10/2016\n" +
                "Horário de abertura do chamado: 17:36:19\n" +
                "Título do chamado: Teste chamado rede\n" +
                "Código do chamado: 24\n" +
                "Descrição do chamado: Teste Junit rede\n" +
                "Prioridade do chamado: Normal\n" +
                "Status do chamado: Iniciado\n" +
                "Tipo de problema do chamado: Problema de Rede\n" +
                "Técnico responsável pelo chamado: Jamilson\n" +
                "Cliente requisitor do chamado: Contrato: 1 - Nome Empresa:Jambo Lanches - Cliente: 1333 - Lucas\n" +
                "\n" +
                "Relatório de registros de acompanhamento:\n" +
                "Data: 28/10/2016\n" +
                "Hora: 16:50:26\n" +
                "Assunto: Teste\n" +
                "T�cnico responsável: Jamilson\n" +
                "Causa do problema: null\n" +
                "Solução do problema: null\n" +
                "--------\n" +
                "Data de abertura do chamado: 28/10/2016\n" +
                "Horário de abertura do chamado: 17:37:20\n" +
                "Título do chamado: Teste chamado rede\n" +
                "Código do chamado: 25\n" +
                "Descrição do chamado: Teste Junit rede\n" +
                "Prioridade do chamado: Normal\n" +
                "Status do chamado: Iniciado\n" +
                "Tipo de problema do chamado: Problema de Rede\n" +
                "Técnico responsável pelo chamado: Jamilson\n" +
                "Cliente requisitor do chamado: Contrato: 1 - Nome Empresa:Jambo Lanches - Cliente: 1333 - Lucas\n" +
                "\n" +
                "Relat�rio de registros de acompanhamento:\n" +
                "Data: 28/10/2016\n" +
                "Hora: 16:50:26\n" +
                "Assunto: Teste\n" +
                "Técnico responsável: Jamilson\n" +
                "Causa do problema: null\n" +
                "Solução do problema: null\n" +
                "--------\n" +
                "Data de abertura do chamado: 28/10/2016\n" +
                "Horário de abertura do chamado: 17:37:36\n" +
                "Título do chamado: Teste chamado rede\n" +
                "Código do chamado: 26\n" +
                "Descrição do chamado: Teste Junit rede\n" +
                "Prioridade do chamado: Normal\n" +
                "Status do chamado: Iniciado\n" +
                "Tipo de problema do chamado: Problema de Rede\n" +
                "T�cnico responsável pelo chamado: Jamilson\n" +
                "Cliente requisitor do chamado: Contrato: 1 - Nome Empresa:Jambo Lanches - Cliente: 1333 - Lucas\n" +
                "\n" +
                "Relat�rio de registros de acompanhamento:\n" +
                "Data: 28/10/2016\n" +
                "Hora: 16:50:26\n" +
                "Assunto: Teste\n" +
                "Técnico responsável: Jamilson\n" +
                "Causa do problema: null\n" +
                "Solução do problema: null";
        
        assertEquals(expected,result);
    }

    @Test
    public void buscaPeloCodigo() {
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(3,empresa,1333,"Lucas",12344321);
        
        
        
        ControleChamados controle = new ControleChamados();
        controle.InserirChamadoRede("Teste chamado rede","Teste Junit rede",1,tecnico,cliente,"Windows","7.01","LAN","127.0.0.1");
        
        assertEquals("Teste chamado rede",controle.buscaPeloCodigo(0)); // Qual a funcao do metodo??? Nao sabemos o codigo do chamado...
    }

    @Test
    public void retornaDetalhesChamadoTest() {
        ControleChamados controle = new ControleChamados();
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(3,empresa,1333,"Lucas",12344321);
        
        Chamado chamadoRede = new Chamado(1,"Teste chamado rede","Teste Junit rede",1,tecnico,cliente,"Windows","7.01","LAN","127.0.0.1");
        
        String expected = "Data de abertura do chamado: 28/10/2016\n" +
                "Horário de abertura do chamado: 18:05:41\n" +
                "Título do chamado: Teste chamado rede\n" +
                "Descrição do chamado: Teste Junit rede\n" +
                "Prioridade do chamado: 1\n" +
                "Status do chamado: Iniciado\n" +
                "Tipo de problema do chamado: Problema de Rede\n" +
                "Técnico responsável pelo chamado: Jamilson\n" +
                "Cliente requisitor do chamado: Contrato: 1 - Nome Empresa:Jambo Lanches - Cliente: 1333 - Lucas";
        
        assertEquals(expected,controle.retornaDetalhesChamado(chamadoRede));
    }
  
    @Test
    public void validarQtdChamadosTest(){
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        ClienteEmpresa cliente = new ClienteEmpresa(3,empresa,1333,"Lucas",12344321);
        ControleChamados controle = new ControleChamados();
        controle.InserirChamadoRede("Teste chamado rede","Teste Junit rede",1,tecnico,cliente,"Windows","7.01","LAN","127.0.0.1");
        
        assertEquals(1,controle.validarQtdChamados(cliente));
    }
}

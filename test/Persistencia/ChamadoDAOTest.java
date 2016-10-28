/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.RegistroChamado;
import entidade.Tecnico;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matheus
 */
public class ChamadoDAOTest {
    
    private static final String nomeArquivo = "chamados.dat";
    private static final String nomeArquivoRegistro = "registroChamados.dat";
    
    public ChamadoDAOTest() {
    }
    
    @Test
    public void gerarCodigoTest() {
        ChamadoDAO chamadoDAO = new ChamadoDAO();
        int expected = chamadoDAO.getChamados().size() + 1;
        assertEquals(expected, chamadoDAO.gerarCodigo());
    }
    
    @Test
    public void gerarCodigoRegistroChamadoTest() {
        ChamadoDAO chamadoDAO = new ChamadoDAO();
        int expected = chamadoDAO.getRegistros().size() + 1;
        assertEquals(expected, chamadoDAO.gerarCodigoRegistroChamado());

    }

    @Test
    public void putTest() {
        HashMap<Integer, Chamado> cashChamado = new HashMap(); 
        HashMap<Integer, RegistroChamado> cashRegistroChamado = new HashMap(); 
        
        ChamadoDAO chamadoDAO = new ChamadoDAO();
        
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(3,empresa,1333,"Lucas",12344321);
        
        Chamado chamadoRede = new Chamado(1,"Teste chamado rede","Teste Junit rede",1,tecnico,cliente,"Windows","7.01","LAN","127.0.0.1");
        
        chamadoDAO.put(chamadoRede);
        
        try {
            FileInputStream fis = new FileInputStream(nomeArquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            cashChamado = (HashMap<Integer, Chamado>) ois.readObject();
            ois.close();
            fis.close();

        } catch (FileNotFoundException ex) {
            System.err.println("Erro ao abrir o arquivo " + nomeArquivo);
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Erro de entrada ou saida de dados " + nomeArquivo);
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro ao processar registros dos arquivos " + nomeArquivo);
            System.err.println(ex.getMessage());
        }
        
        
        Iterator<Chamado> resultIterator = chamadoDAO.getChamados()
                .iterator();
        Iterator<Chamado> expectedIterator = cashChamado.values().iterator();
        
        while(expectedIterator.hasNext()) {
            
            Chamado expected = expectedIterator.next();
            Chamado result = resultIterator.next();
          
            assertEquals(expected.getCodigo(),result.getCodigo());
            assertEquals(expected.getBancoDeDados(),result.getBancoDeDados());
            assertEquals(expected.getCausaProblema(),result.getCausaProblema());
            assertEquals(expected.getCliente().getNome(),result.getCliente().getNome());
            assertEquals(expected.getData(),result.getData());
            assertEquals(expected.getDescricao(),result.getDescricao());
            assertEquals(expected.getDuracaoOperacao(),result.getDuracaoOperacao(),0.1);
            assertEquals(expected.getEnderecoRede(),result.getEnderecoRede());
            assertEquals(expected.getHora(),result.getHora());
            assertEquals(expected.getOperacao(),result.getOperacao());
            assertEquals(expected.getPrioridade(),result.getPrioridade());
            assertEquals(expected.getSistemaOperacional(),result.getSistemaOperacional());
            assertEquals(expected.getSolucaoProblema(),result.getSolucaoProblema());
            assertEquals(expected.getStatus(),result.getStatus());
            assertEquals(expected.getTecnico().getNome(),result.getTecnico().getNome());
            assertEquals(expected.getTipoConexao(),result.getTipoConexao());
            assertEquals(expected.getTipoProblema(),result.getTipoProblema());
            assertEquals(expected.getTitulo(),result.getTitulo());
            assertEquals(expected.getVersaoSO(),result.getVersaoSO());
            
        }
    }

    @Test
    public void putRegistroTest() {
        HashMap<Integer, RegistroChamado> cashRegistroChamado = new HashMap(); 
        
        ChamadoDAO chamadoDAO = new ChamadoDAO();
        
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(3,empresa,1333,"Lucas",12344321);     
        Chamado chamadoRede = new Chamado(1,"Teste chamado rede","Teste Junit rede",1,tecnico,cliente,"Windows","7.01","LAN","127.0.0.1");
        
        RegistroChamado registro = new RegistroChamado("Teste",chamadoRede,tecnico);
        
        chamadoDAO.putRegistro(registro);
        
        try {
            //registro  chamado
            FileInputStream fisR = new FileInputStream(nomeArquivoRegistro);
            ObjectInputStream oisR = new ObjectInputStream(fisR);
            cashRegistroChamado = (HashMap<Integer, RegistroChamado>) oisR.readObject();
            oisR.close();
            fisR.close();

        } catch (FileNotFoundException ex) {
            System.err.println("Erro ao abrir o arquivo " + nomeArquivo);
            System.err.println("Erro ao abrir o arquivo " + nomeArquivoRegistro);
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Erro de entrada ou saida de dados " + nomeArquivo);
            System.err.println("Erro de entrada ou saida de dados " + nomeArquivoRegistro);
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro ao processar registros dos arquivos " + nomeArquivo);
            System.err.println("Erro ao processar registros dos arquivos " + nomeArquivoRegistro);
            System.err.println(ex.getMessage());
        }
        
        Iterator<RegistroChamado> resultIterator = chamadoDAO.getRegistros()
                .iterator();
        Iterator<RegistroChamado> expectedIterator = cashRegistroChamado.values()
                .iterator();
        
        while(expectedIterator.hasNext()) {
            
            RegistroChamado expected = expectedIterator.next();
            RegistroChamado result = resultIterator.next();
          
            assertEquals(expected.getAssunto(),result.getAssunto());
            assertEquals(expected.getChamado().getCodigo(),result.getChamado().getCodigo());
            assertEquals(expected.getTecnico().getNome(),result.getTecnico().getNome());
        }
    }

    @Test
    public void getTest() {
        ChamadoDAO chamadoDAO = new ChamadoDAO();
        
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(3,empresa,1333,"Lucas",12344321);
        
        Chamado chamadoRede = new Chamado(1,"Teste chamado rede","Teste Junit rede",1,tecnico,cliente,"Windows","7.01","LAN","127.0.0.1");
        
        chamadoDAO.put(chamadoRede);
        
        assertEquals("Teste chamado rede",chamadoDAO.get(1).getTitulo());
    }
    
    @Test
    public void persitTest() {     
        HashMap<Integer, Chamado> cashChamado = new HashMap(); 
        HashMap<Integer, RegistroChamado> cashRegistroChamado = new HashMap(); 
        
        ChamadoDAO chamadoDAO = new ChamadoDAO();
        
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(3,empresa,1333,"Lucas",12344321);     
        Chamado chamadoRede = new Chamado(1,"Teste chamado rede","Teste Junit rede",1,tecnico,cliente,"Windows","7.01","LAN","127.0.0.1");
        
        chamadoDAO.put(chamadoRede);
        
        RegistroChamado registro = new RegistroChamado("Teste",chamadoRede,tecnico);
        
        chamadoDAO.putRegistro(registro);
        
        try {
            //registro  chamado
            FileInputStream fisR = new FileInputStream(nomeArquivoRegistro);
            ObjectInputStream oisR = new ObjectInputStream(fisR);
            cashRegistroChamado = (HashMap<Integer, RegistroChamado>) oisR.readObject();
            oisR.close();
            fisR.close();

        } catch (FileNotFoundException ex) {
            System.err.println("Erro ao abrir o arquivo " + nomeArquivo);
            System.err.println("Erro ao abrir o arquivo " + nomeArquivoRegistro);
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Erro de entrada ou saida de dados " + nomeArquivo);
            System.err.println("Erro de entrada ou saida de dados " + nomeArquivoRegistro);
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro ao processar registros dos arquivos " + nomeArquivo);
            System.err.println("Erro ao processar registros dos arquivos " + nomeArquivoRegistro);
            System.err.println(ex.getMessage());
        }
        
        Iterator<Chamado> resultIterator = chamadoDAO.getChamados()
                .iterator();
        Iterator<Chamado> expectedIterator = cashChamado.values().iterator();
        
        while(expectedIterator.hasNext()) {
            
            Chamado expected = expectedIterator.next();
            Chamado result = resultIterator.next();
          
            assertEquals(expected.getCodigo(),result.getCodigo());
            assertEquals(expected.getBancoDeDados(),result.getBancoDeDados());
            assertEquals(expected.getCausaProblema(),result.getCausaProblema());
            assertEquals(expected.getCliente().getNome(),result.getCliente().getNome());
            assertEquals(expected.getData(),result.getData());
            assertEquals(expected.getDescricao(),result.getDescricao());
            assertEquals(expected.getDuracaoOperacao(),result.getDuracaoOperacao(),0.1);
            assertEquals(expected.getEnderecoRede(),result.getEnderecoRede());
            assertEquals(expected.getHora(),result.getHora());
            assertEquals(expected.getOperacao(),result.getOperacao());
            assertEquals(expected.getPrioridade(),result.getPrioridade());
            assertEquals(expected.getSistemaOperacional(),result.getSistemaOperacional());
            assertEquals(expected.getSolucaoProblema(),result.getSolucaoProblema());
            assertEquals(expected.getStatus(),result.getStatus());
            assertEquals(expected.getTecnico().getNome(),result.getTecnico().getNome());
            assertEquals(expected.getTipoConexao(),result.getTipoConexao());
            assertEquals(expected.getTipoProblema(),result.getTipoProblema());
            assertEquals(expected.getTitulo(),result.getTitulo());
            assertEquals(expected.getVersaoSO(),result.getVersaoSO());
            
        }
        
        Iterator<RegistroChamado> resultIterator2 = chamadoDAO.getRegistros()
                .iterator();
        Iterator<RegistroChamado> expectedIterator2 = cashRegistroChamado.values()
                .iterator();
        
        while(expectedIterator2.hasNext()) {
            
            RegistroChamado expected = expectedIterator2.next();
            RegistroChamado result = resultIterator2.next();
          
            assertEquals(expected.getAssunto(),result.getAssunto());
            assertEquals(expected.getChamado().getCodigo(),result.getChamado().getCodigo());
            assertEquals(expected.getTecnico().getNome(),result.getTecnico().getNome());
        }
        
    }
}

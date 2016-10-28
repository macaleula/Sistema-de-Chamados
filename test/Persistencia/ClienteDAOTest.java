/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import entidade.ClienteEmpresa;
import entidade.Empresa;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matheus
 */
public class ClienteDAOTest {
    
    private static final String nomeArquivo = "clientes.dat";
    
    public ClienteDAOTest() { 
    }
    
    @Test
    public void validarCPFTest() { 
        ClienteDAO clienteDAO = new ClienteDAO();
        assertEquals(true,clienteDAO.validarCPF(11111));
        assertTrue(clienteDAO.validarCPF(0));
    }

    @Test
    public void gerarCodigoTest() { 
        ClienteDAO clienteDAO = new ClienteDAO();
        int expected = clienteDAO.voltaCashCliente().size() + 1;
        assertEquals(expected,clienteDAO.gerarCodigo());
    }

    @Test
    public void voltaCashClienteTest() { 
        ClienteDAO clienteDAO = new ClienteDAO();
        HashMap<Long, ClienteEmpresa> cashClientes = new HashMap();
        try {
            FileInputStream fis = new FileInputStream(nomeArquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);

            cashClientes = (HashMap<Long, ClienteEmpresa>) ois.readObject();

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
        Iterator<ClienteEmpresa> resultIterator = clienteDAO.voltaCashCliente()
                .values().iterator();
        Iterator<ClienteEmpresa> expectedIterator = cashClientes.values().iterator();
        
        while(expectedIterator.hasNext()) {
            
            ClienteEmpresa expected = expectedIterator.next();
            ClienteEmpresa result = resultIterator.next();
          
            assertEquals(expected.getCodigo(),result.getCodigo());
            assertEquals(expected.getCpf(),result.getCpf());
            assertEquals(expected.getEmpresa().getNomeEmpresa(),result.getEmpresa().getNomeEmpresa());
            assertEquals(expected.getNome(),result.getNome());
            assertEquals(expected.getTelefone(),result.getTelefone());

        }
        
    }

    @Test
    public void putTest() {
        ClienteDAO clienteDAO = new ClienteDAO();
        
        ClienteEmpresa clienteEmp = new ClienteEmpresa(2,new Empresa(111,"Telefone"),1234,"Sergio",12344321);
        clienteDAO.put(clienteEmp);

        
        HashMap<Long, ClienteEmpresa> cashClientes = new HashMap();
        try {
            FileInputStream fis = new FileInputStream(nomeArquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);

            cashClientes = (HashMap<Long, ClienteEmpresa>) ois.readObject();

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

        Iterator<ClienteEmpresa> resultIterator = clienteDAO.voltaCashCliente()
                .values().iterator();
        Iterator<ClienteEmpresa> expectedIterator = cashClientes.values().iterator();
        
        while(expectedIterator.hasNext()) {
            
            ClienteEmpresa expected = expectedIterator.next();
            ClienteEmpresa result = resultIterator.next();
          
            assertEquals(expected.getCodigo(),result.getCodigo());
            assertEquals(expected.getCpf(),result.getCpf());
            assertEquals(expected.getEmpresa().getNomeEmpresa(),result.getEmpresa().getNomeEmpresa());
            assertEquals(expected.getNome(),result.getNome());
            assertEquals(expected.getTelefone(),result.getTelefone());

        }
        
    }

    @Test
    public void getTest() { 
        ClienteDAO clienteDAO = new ClienteDAO();
        
        ClienteEmpresa clienteEmp = new ClienteEmpresa(3,new Empresa(111,"Jail"),1333,"Lucas",12344321);
        clienteDAO.put(clienteEmp);
        
        assertEquals("Lucas",clienteDAO.get((long)3).getNome());
    }

    @Test
    public void persitTest() { 
        ClienteDAO clienteDAO = new ClienteDAO();
        HashMap<Long, ClienteEmpresa> cashClientes = new HashMap();
        try {
            FileInputStream fis = new FileInputStream(nomeArquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);

            cashClientes = (HashMap<Long, ClienteEmpresa>) ois.readObject();

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
        ClienteEmpresa clienteEmp = new ClienteEmpresa(2,new Empresa(111,"Telefone"),1234,"Sergio",12344321);
        clienteDAO.put(clienteEmp);
        
        Iterator<ClienteEmpresa> resultIterator = clienteDAO.voltaCashCliente()
                .values().iterator();
        Iterator<ClienteEmpresa> expectedIterator = cashClientes.values().iterator();
        
        while(expectedIterator.hasNext()) {
            
            ClienteEmpresa expected = expectedIterator.next();
            ClienteEmpresa result = resultIterator.next();
          
            assertEquals(expected.getCodigo(),result.getCodigo());
            assertEquals(expected.getCpf(),result.getCpf());
            assertEquals(expected.getEmpresa().getNomeEmpresa(),result.getEmpresa().getNomeEmpresa());
            assertEquals(expected.getNome(),result.getNome());
            assertEquals(expected.getTelefone(),result.getTelefone());

        }
        
    }
}

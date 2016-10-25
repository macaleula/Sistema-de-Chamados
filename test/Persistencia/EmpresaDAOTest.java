/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import entidade.Empresa;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matheus
 */
public class EmpresaDAOTest {
    
    private static final String nomearq = "empresas.dat";
    
    public EmpresaDAOTest() { 
    }
    
    @Test
    public void putTest() {
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        EmpresaDAO empresaDAO = new EmpresaDAO();
        empresaDAO.put(empresa);
        HashMap<Long, Empresa> hashEmpresas = new HashMap();
        
        try {
            FileInputStream fis = new FileInputStream(nomearq);
            ObjectInputStream ois = new ObjectInputStream(fis);

            hashEmpresas = (HashMap<Long, Empresa>) ois.readObject();

            ois.close();
            fis.close();

        } catch (FileNotFoundException ex) {
            System.err.println("Erro ao abrir o arquivo ");
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Erro de entrada ou saida de dados ");
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro ao processar registros dos arquivos ");
            System.err.println(ex.getMessage());
        }
        
        assertEquals(1,((int)hashEmpresas.values().iterator().next().getNumeroContrato()));
        assertEquals("Jambo Lanches",hashEmpresas.values().iterator().next().getNomeEmpresa());
        
        assertEquals(1,empresaDAO.getEmpresas().iterator().next().getNumeroContrato());
        assertEquals("Jambo Lanches",empresaDAO.getEmpresas().iterator().next().getNomeEmpresa());
        
    }

    @Test
    public void loadTest() { 

    }

    @Test
    public void persitTest() { 
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        EmpresaDAO empresaDAO = new EmpresaDAO();
        empresaDAO.put(empresa);
        HashMap<Long, Empresa> hashEmpresas = new HashMap();
        
        try {
            FileInputStream fis = new FileInputStream(nomearq);
            ObjectInputStream ois = new ObjectInputStream(fis);

            hashEmpresas = (HashMap<Long, Empresa>) ois.readObject();

            ois.close();
            fis.close();

        } catch (FileNotFoundException ex) {
            System.err.println("Erro ao abrir o arquivo ");
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Erro de entrada ou saida de dados ");
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro ao processar registros dos arquivos ");
            System.err.println(ex.getMessage());
        }
        
        assertEquals(1,((int)hashEmpresas.values().iterator().next().getNumeroContrato()));
        assertEquals("Jambo Lanches",hashEmpresas.values().iterator().next().getNomeEmpresa());

    }  
}

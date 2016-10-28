/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import entidade.Tecnico;
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
public class TecnicoDAOTest {
    private static final String nomearq = "tecnicos.dat";
    
    public TecnicoDAOTest() {
    }
    
    @Test
    public void gerarCodigoTest() {
        TecnicoDAO tecnicoDAO = new TecnicoDAO();
        int expected = tecnicoDAO.voltaCashTecnico().size() + 1;
        assertEquals(expected,tecnicoDAO.gerarCodigo());
    }

    @Test
    public void voltaCashTecnicoTest() {
        TecnicoDAO tecnicoDAO = new TecnicoDAO();
        HashMap<Integer, Tecnico> cashTecnicos = new HashMap();
        try {
            FileInputStream fis = new FileInputStream(nomearq);
            ObjectInputStream ois = new ObjectInputStream(fis);

            cashTecnicos = (HashMap<Integer, Tecnico>) ois.readObject();

            ois.close();
            fis.close();

        } catch (FileNotFoundException ex) {
            System.err.println("Erro ao abrir o arquivo " + nomearq);
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Erro de entrada ou saida de dados " + nomearq);
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro ao processar registros dos arquivos " + nomearq);
            System.err.println(ex.getMessage());
        }
        Iterator<Tecnico> resultIterator = tecnicoDAO.voltaCashTecnico()
                .values().iterator();
        Iterator<Tecnico> expectedIterator = cashTecnicos.values().iterator();
        
        while(expectedIterator.hasNext()) {
            
            Tecnico expected = expectedIterator.next();
            Tecnico result = resultIterator.next();
          
            assertEquals(expected.getNome(),result.getNome());
            assertEquals(expected.getTelefone(),result.getTelefone());
        }
    }

    @Test
    public void putTest() {
        TecnicoDAO tecnicoDAO = new TecnicoDAO();
        
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        tecnicoDAO.put(tecnico);
        
        HashMap<Integer, Tecnico> cashTecnicos = new HashMap();
        try {
            FileInputStream fis = new FileInputStream(nomearq);
            ObjectInputStream ois = new ObjectInputStream(fis);

            cashTecnicos = (HashMap<Integer, Tecnico>) ois.readObject();

            ois.close();
            fis.close();

        } catch (FileNotFoundException ex) {
            System.err.println("Erro ao abrir o arquivo " + nomearq);
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Erro de entrada ou saida de dados " + nomearq);
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro ao processar registros dos arquivos " + nomearq);
            System.err.println(ex.getMessage());
        }
        
        
        Iterator<Tecnico> resultIterator = tecnicoDAO.voltaCashTecnico()
                .values().iterator();
        Iterator<Tecnico> expectedIterator = cashTecnicos.values().iterator();
        
        while(expectedIterator.hasNext()) {
            
            Tecnico expected = expectedIterator.next();
            Tecnico result = resultIterator.next();
          
            assertEquals(expected.getNome(),result.getNome());
            assertEquals(expected.getTelefone(),result.getTelefone());
        }
    }

    @Test
    public void getTest() {
        TecnicoDAO tecnicoDAO = new TecnicoDAO();
        
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        tecnicoDAO.put(tecnico);
        
        assertEquals("Jamilson",tecnicoDAO.get(0));
    }

    @Test
    public void persitTest() {
        TecnicoDAO tecnicoDAO = new TecnicoDAO();
        
        Tecnico tecnico = new Tecnico("Jamilson",11223344);
        tecnicoDAO.put(tecnico);
        
        HashMap<Integer, Tecnico> cashTecnicos = new HashMap();
        try {
            FileInputStream fis = new FileInputStream(nomearq);
            ObjectInputStream ois = new ObjectInputStream(fis);

            cashTecnicos = (HashMap<Integer, Tecnico>) ois.readObject();

            ois.close();
            fis.close();

        } catch (FileNotFoundException ex) {
            System.err.println("Erro ao abrir o arquivo " + nomearq);
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Erro de entrada ou saida de dados " + nomearq);
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro ao processar registros dos arquivos " + nomearq);
            System.err.println(ex.getMessage());
        }
        
        
        Iterator<Tecnico> resultIterator = tecnicoDAO.voltaCashTecnico()
                .values().iterator();
        Iterator<Tecnico> expectedIterator = cashTecnicos.values().iterator();
        
        while(expectedIterator.hasNext()) {
            
            Tecnico expected = expectedIterator.next();
            Tecnico result = resultIterator.next();
          
            assertEquals(expected.getNome(),result.getNome());
            assertEquals(expected.getTelefone(),result.getTelefone());
        }
    }
}

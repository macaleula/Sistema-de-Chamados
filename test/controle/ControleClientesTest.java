/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Persistencia.ClienteDAO;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matheus
 */
public class ControleClientesTest {
    
    public ControleClientesTest() {
    }
    
    @Test
    public void InserirChamadoRedeTest() {
        Empresa empresa = new Empresa(1,"Jambo Lanches");
        ClienteEmpresa cliente = new ClienteEmpresa(3,empresa,1333,"Lucas",12344321);
  
        ControleClientes controle = new ControleClientes();
        controle.incluiNovoCliente(empresa, 11111, "Anderson", 41332121);
        
        ClienteDAO clienteDAO = new ClienteDAO();
        Iterator<ClienteEmpresa> iterator = clienteDAO.voltaCashCliente().values().iterator();
        while(iterator.hasNext()) {
            ClienteEmpresa aux = iterator.next();
            if(aux.getNome() == "Anderson") {
                assertEquals(empresa.getNomeEmpresa(),aux.getEmpresa().getNomeEmpresa());
                assertEquals(11111,aux.getCpf());
                assertEquals(41332121,aux.getTelefone());
            }
        }  
    }
}

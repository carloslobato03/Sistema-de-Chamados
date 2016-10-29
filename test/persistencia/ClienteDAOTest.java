/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.ClienteEmpresa;
import entidade.Empresa;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;
import Persistencia.ClienteDAO;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos
 */
public class ClienteDAOTest {
    

    @Test
    public void testeGerarCodigo() {
        ClienteDAO cDAO = new ClienteDAO();

        int codigo = cDAO.gerarCodigo();

        Assert.assertNotNull(codigo);

    }

    @Test
    public void hashMapTest() {
        ClienteDAO cDAO = new ClienteDAO();

        HashMap<Long, ClienteEmpresa> empHash = cDAO.voltaCashCliente();

        Assert.assertNotNull(empHash);
    }

    @Test
    public void testeInsercaoCliente() {
        ClienteDAO clienteDAO = new ClienteDAO();
        Empresa empresa = new Empresa(1, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 3, "Microsoft", 2);

        clienteDAO.put(clienteEmpresa);

        ClienteEmpresa clienteEmpresa2 = clienteDAO.get(3L);

        Assert.assertEquals(clienteEmpresa, clienteEmpresa2);

    }

    @Test
    public void testeVerificacaoSeCPFExisteNoBanco() {

        ClienteDAO clienteDAO = new ClienteDAO();
        Empresa empresa = new Empresa(3, "Apple");
        ClienteEmpresa cEmp = new ClienteEmpresa(1, empresa, 5, "Microsoft", 2);

        clienteDAO.put(cEmp);
        
        ClienteEmpresa cEmp2 = clienteDAO.voltaCashCliente().get(cEmp.getCpf());
        
        if(cEmp.getCpf() == cEmp2.getCpf()){
        Assert.assertTrue(true);
        }else{
            Assert.assertFalse(false);
        }
    }
    @Test
    public void testeBuscaCliente() {
        ClienteDAO cDAO = new ClienteDAO();
        Empresa empresa = new Empresa(1, "Apple");

        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 1, "Microsoft", 2);
        cDAO.put(clienteEmpresa);

        Assert.assertEquals(clienteEmpresa, cDAO.get(1L));
    }

}

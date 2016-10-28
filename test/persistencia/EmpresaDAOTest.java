/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Empresa;
import java.util.Collection;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;
import Persistencia.EmpresaDAO;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos
 */
public class EmpresaDAOTest {

    @Test
    public void testeInserçaoVerificandoAmbiguidadeEmpresaDAO() {
        EmpresaDAO empDAO = new EmpresaDAO();
        Empresa emp = new Empresa(1, "Apple");
        boolean achou = false;
        if (!empDAO.voltaEmpresa().isEmpty()) {
            for (long key : empDAO.voltaEmpresa().keySet()) {
                if (empDAO.voltaEmpresa().get(key) != null) {
                    if (empDAO.voltaEmpresa().get(key).getNumeroContrato() == 123 || empDAO.voltaEmpresa().get(key).getNomeEmpresa() == "Google") {
                        achou = true;
                        break;
                    }
                }
            }
        }
        int tamanhoAntes = empDAO.voltaEmpresa().size();
        empDAO.put(emp);
        if (achou) {
            assertEquals(tamanhoAntes, empDAO.voltaEmpresa().size());
        } else {
            assertTrue(empDAO.getEmpresas().contains(emp));
        }

    }

    @Test(expected = Exception.class)
    public void testeInsercaoEmpresaDAONula() throws Exception {
        Empresa emp = new Empresa(1,null);
        
        EmpresaDAO empDAO = new EmpresaDAO();
        Empresa empInserida = null;
        empDAO.put(emp);
         Collection<Empresa> empresas = empDAO.getEmpresas();
         for (Empresa empresa : empresas) {
            if((empresa.getNumeroContrato() == emp.getNumeroContrato()) && (emp.getNomeEmpresa().equals(empresa.getNomeEmpresa()))){
                empInserida =empresa;
            }
            
        }
         Assert.assertEquals(empInserida, emp);
    }


    
    @Test
    public void testeInsercaoEmpresaDAO() {
        Empresa emp = new Empresa(1,"Apple");
        
        EmpresaDAO empDAO = new EmpresaDAO();
        Empresa empInserida = null;
        empDAO.put(emp);
         Collection<Empresa> empresas = empDAO.getEmpresas();
         for (Empresa empresa : empresas) {
            if((empresa.getNumeroContrato() == emp.getNumeroContrato()) && (emp.getNomeEmpresa().equals(empresa.getNomeEmpresa()))){
                empInserida =empresa;
            }
            
        }
         Assert.assertEquals(empInserida, emp);
    }

    @Test
    public void testeBuscaEmpresas() {
        
        EmpresaDAO empDAO = new EmpresaDAO();
         Collection<Empresa> empresas = empDAO.getEmpresas();
     
         Assert.assertTrue(empresas.size() > 0);
        
    }

    @Test
    public void testeVoltaEmpresa() {
        EmpresaDAO empDAO = new EmpresaDAO();
        
        HashMap<Long,Empresa> hashRetornado = empDAO.voltaEmpresa();
        
        Assert.assertNotNull(hashRetornado);
    }
}

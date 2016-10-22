/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import entidade.ClienteEmpresa;
import entidade.Empresa;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos
 */
public class ClienteEmpresaTest {

    @Test
    public void cadastrarClienteEmpresaTest() {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Assert.assertEquals((Integer) 1, clienteEmpresa.getCodigo());
        Assert.assertEquals(empresa, clienteEmpresa.getEmpresa());
        Assert.assertEquals(2197534L, clienteEmpresa.getCpf());
        Assert.assertEquals("Pedro", clienteEmpresa.getNome());
        Assert.assertEquals(123, clienteEmpresa.getTelefone());
    }

    @Test(expected = Exception.class)
    public void cadastrarClienteEmpresaCodigoInvalidoTest() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(-1, empresa, 2197534L, "Pedro", 123);
    }

    @Test(expected = Exception.class)
    public void cadastrarClienteEmpresaCodigoNuloTest() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(null, empresa, 2197534L, "Pedro", 123);
    }

    @Test(expected = Exception.class)
    public void cadastrarClienteEmpresaEmpInvalidaTest() throws Exception {
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, null, 2197534L, "Pedro", 123);
    }

    @Test(expected = Exception.class)
    public void cadastrarClienteEmpresaCpfInvalidoTest() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, -2197534L, "Pedro", 123);
    }

    @Test(expected = Exception.class)
    public void cadastrarClienteEmpresaNomeInvalidoTest() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, null, 123);
    }

    @Test(expected = Exception.class)
    public void cadastrarClienteEmpresaTelefoneInvalidoTest() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", -123);
    }

    @Test
    public void alterarCodigoClienteEmpresaTest() {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        clienteEmpresa.setCodigo(2);
        Assert.assertEquals((Integer) 2, clienteEmpresa.getCodigo());
    }

    @Test(expected = Exception.class)
    public void alterarCodigoInvalidoClienteEmpresaTest() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        clienteEmpresa.setCodigo(-002);
    }

    @Test(expected = Exception.class)
    public void alterarCodigoNuloClienteEmpresaTest() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        clienteEmpresa.setCodigo(null);
    }

    @Test
    public void alterarCpfClienteEmpresaTest() {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        clienteEmpresa.setCpf(2018L);
        Assert.assertEquals(2018L, clienteEmpresa.getCpf());
    }

    @Test(expected = Exception.class)
    public void alterarCpfInvalidoClienteEmpresaTest() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        clienteEmpresa.setCpf(-2197534L);
    }

    @Test
    public void alterarNomeClienteEmpresaTest() {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        clienteEmpresa.setNome("Carlos");
        Assert.assertEquals("Carlos", clienteEmpresa.getNome());
    }

    @Test(expected = Exception.class)
    public void alterarNomeInvalidoClienteEmpresaTest() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        clienteEmpresa.setNome(null);
    }

    @Test
    public void alterarTelefoneClienteEmpresaTest() {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        clienteEmpresa.setTelefone(4321);
        assertEquals(987654321, clienteEmpresa.getTelefone());
    }

    @Test(expected = Exception.class)
    public void alterarTelefoneInvalidoClienteEmpresaTest() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        clienteEmpresa.setTelefone(-55321223);
    }
}

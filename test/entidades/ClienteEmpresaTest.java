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
    public void testeCadastroClienteEmpresa() {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Assert.assertEquals((Integer) 1, clienteEmpresa.getCodigo());
        Assert.assertEquals(empresa, clienteEmpresa.getEmpresa());
        Assert.assertEquals(2197534L, clienteEmpresa.getCpf());
        Assert.assertEquals("Pedro", clienteEmpresa.getNome());
        Assert.assertEquals(123, clienteEmpresa.getTelefone());
    }


    @Test(expected = Exception.class)
    public void testeCadastrarClienteEmpresaCodigoNulo() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(null, empresa, 2197534L, "Pedro", 123);
    }
    @Test(expected = Exception.class)
    public void testeCadastrarClienteEmpresaCodigoInvalido() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(-1, empresa, 2197534L, "Pedro", 123);
    }

    @Test(expected = Exception.class)
    public void testeCadastrarClienteEmpresaCpfInvalido() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, -2197534L, "Pedro", 123);
    }

    @Test(expected = Exception.class)
    public void testeCadastrarClienteEmpresaEmpInvalida() throws Exception {
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, null, 2197534L, "Pedro", 123);
    }

    @Test(expected = Exception.class)
    public void testeCadastrarClienteEmpresaNomeInvalido() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, null, 123);
    }

    @Test(expected = Exception.class)
    public void testeCadastrarClienteEmpresaTelefoneInvalido() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", -123);
    }

    @Test
    public void testeAlterarCodigoClienteEmpresa() {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        clienteEmpresa.setCodigo(2);
        Assert.assertEquals((Integer) 2, clienteEmpresa.getCodigo());
    }

    @Test(expected = Exception.class)
    public void testeAlterarCodigoInvalidoClienteEmpres() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        clienteEmpresa.setCodigo(-002);
    }

    @Test(expected = Exception.class)
    public void testeAlterarCodigoNuloClienteEmpresa() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        clienteEmpresa.setCodigo(null);
    }


    @Test(expected = Exception.class)
    public void testeAlterarCpfInvalidoClienteEmpresa() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        clienteEmpresa.setCpf(-2197534L);
    }
    @Test
    public void testeAlterarCpfClienteEmpresa() {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        clienteEmpresa.setCpf(2018L);
        Assert.assertEquals(2018L, clienteEmpresa.getCpf());
    }


    @Test(expected = Exception.class)
    public void testeAlterarNomeInvalidoClienteEmpresa() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        clienteEmpresa.setNome(null);
    }
    @Test
    public void testeAlterarNomeClienteEmpresa() {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        clienteEmpresa.setNome("Carlos");
        Assert.assertEquals("Carlos", clienteEmpresa.getNome());
    }

    @Test(expected = Exception.class)
    public void testeAlterarTelefoneInvalidoClienteEmpresa() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        clienteEmpresa.setTelefone(-55321223);
    }
    @Test
    public void testeAlterarTelefoneClienteEmpresa() {
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        clienteEmpresa.setTelefone(4321);
        assertEquals(987654321, clienteEmpresa.getTelefone());
    }

}

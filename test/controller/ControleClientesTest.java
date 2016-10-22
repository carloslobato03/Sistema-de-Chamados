/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Persistencia.ClienteDAO;
import controle.ControleClientes;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos
 */
public class ControleClientesTest {

    @Test
    public void testeIncluirNovoCliente() {
        ControleClientes controller = new ControleClientes();
        Empresa empresa = new Empresa(123, "Empresa");
        ClienteEmpresa clienteEmpresa = controller.incluiNovoCliente(empresa, 123456, "Carlos", 12345678);
        ClienteDAO clientedao = controller.getClienteDAO();
        ClienteEmpresa cliente = clientedao.get(Long.parseLong("123456"));
        assertEquals(cliente.getCpf(), clienteEmpresa.getCpf());
        assertEquals(cliente.getNome(), clienteEmpresa.getNome());
        assertEquals(cliente.getEmpresa(), clienteEmpresa.getEmpresa());
        assertEquals(cliente.getTelefone(), clienteEmpresa.getTelefone());
        assertEquals(cliente.getCodigo(), clienteEmpresa.getCodigo());
    }

    @Test
    public void testeAtualizarCliente() {
        ControleClientes controller = new ControleClientes();
        Empresa empresa = new Empresa(123, "Empresa");
        Empresa empresa2 = new Empresa(123, "Empresa2");
        ClienteEmpresa clienteEmpresa = controller.incluiNovoCliente(empresa, 123456, "Carlos", 12345678);
        ClienteEmpresa clienteEmpresa2 = controller.incluiNovoCliente(empresa2, 123456, "Carlos", 12345678);
        ClienteEmpresa cliente = controller.getClienteDAO().voltaCashCliente().get(clienteEmpresa2.getCpf());
        assertEquals(clienteEmpresa2.toString(), cliente.toString());
    }

    @Test
    public void testeRemoverCliente() {
        ControleClientes controller = new ControleClientes();
        Empresa empresa = new Empresa(123, "Empresa");
        ClienteEmpresa clienteEmpresa = controller.incluiNovoCliente(empresa, 123456, "Carlos", 12345678);
        controller.getClienteDAO().voltaCashCliente().remove(clienteEmpresa.getCpf());
        Assert.assertNull(controller.getClienteDAO().voltaCashCliente().get(clienteEmpresa.getCpf()));
    }

    @Test
    public void testeBuscarCliente() {
        ControleClientes controller = new ControleClientes();
        Empresa empresa = new Empresa(123, "Empresa");
        ClienteEmpresa clienteEmpresa = controller.incluiNovoCliente(empresa, 123456, "Carlos", 12345678);
        ClienteEmpresa clienteEmpresa2 = controller.incluiNovoCliente(empresa, 123456, "Carlos", 12345678);
        ClienteDAO clientedao = controller.getClienteDAO();

        HashMap<Long, ClienteEmpresa> clientes = clientedao.voltaCashCliente();
        ClienteEmpresa cliente = clientes.get(clienteEmpresa.getCpf());
        ClienteEmpresa cliente2 = clientes.get(clienteEmpresa2.getCpf());
        assertEquals(clienteEmpresa.toString(), cliente.toString());
        assertEquals(clienteEmpresa2.toString(), cliente2.toString());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.Tecnico;
import Persistencia.ChamadoDAO;
import entidade.TipoConexao;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos
 */
public class ChamadoDAOTest {

    @Test
    public void testeInsercaoChamadoModenADSL() {
        Tecnico tecnico = new Tecnico("Tecnico", 123);
        Empresa empresa = new Empresa(1, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(Integer.SIZE, empresa, 1324L, "Tecnico", 123);
        Chamado chamado = new Chamado(5, "Problema", "Descrição", 8, tecnico, clienteEmpresa, "Windows", "Xp", "" + TipoConexao.ADSL, "123");

        ChamadoDAO dao = new ChamadoDAO();
        dao.put(chamado);

        Chamado ci = dao.get(dao.gerarCodigo() - 1);

        Assert.assertEquals(chamado.getTitulo(), ci.getTitulo());
        Assert.assertEquals(chamado.getDescricao(), ci.getDescricao());
        Assert.assertEquals(chamado.getPrioridade(), ci.getPrioridade());
        Assert.assertEquals(chamado.getTecnico().getNome(), ci.getTecnico().getNome());
        Assert.assertEquals(chamado.getCliente().getCpf(), ci.getCliente().getCpf());
        Assert.assertEquals(chamado.getSistemaOperacional(), ci.getSistemaOperacional());
        Assert.assertEquals(chamado.getTipoConexao(), ci.getTipoConexao());
        Assert.assertEquals(chamado.getEnderecoRede(), ci.getEnderecoRede());
    }
    @Test
    public void testeInsercaoChamadoModenRadio() {
        Tecnico tecnico = new Tecnico("Tecnico", 123);
        Empresa empresa = new Empresa(1, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(Integer.SIZE, empresa, 1324L, "Tecnico", 123);
        Chamado chamado = new Chamado(5, "Problema", "Descrição", 8, tecnico, clienteEmpresa, "Windows", "Xp", "" + TipoConexao.Radio, "123");

        ChamadoDAO dao = new ChamadoDAO();
        dao.put(chamado);

        Chamado ci = dao.get(dao.gerarCodigo() - 1);

        Assert.assertEquals(chamado.getTitulo(), ci.getTitulo());
        Assert.assertEquals(chamado.getDescricao(), ci.getDescricao());
        Assert.assertEquals(chamado.getPrioridade(), ci.getPrioridade());
        Assert.assertEquals(chamado.getTecnico().getNome(), ci.getTecnico().getNome());
        Assert.assertEquals(chamado.getCliente().getCpf(), ci.getCliente().getCpf());
        Assert.assertEquals(chamado.getSistemaOperacional(), ci.getSistemaOperacional());
        Assert.assertEquals(chamado.getTipoConexao(), ci.getTipoConexao());
        Assert.assertEquals(chamado.getEnderecoRede(), ci.getEnderecoRede());
    }
    @Test
    public void testeInsercaoChamadoModenOutra() {
        Tecnico tecnico = new Tecnico("Tecnico", 123);
        Empresa empresa = new Empresa(1, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(Integer.SIZE, empresa, 1324L, "Tecnico", 123);
        Chamado chamado = new Chamado(5, "Problema", "Descrição", 8, tecnico, clienteEmpresa, "Windows", "Xp", "" + TipoConexao.Outra, "123");

        ChamadoDAO dao = new ChamadoDAO();
        dao.put(chamado);

        Chamado ci = dao.get(dao.gerarCodigo() - 1);

        Assert.assertEquals(chamado.getTitulo(), ci.getTitulo());
        Assert.assertEquals(chamado.getDescricao(), ci.getDescricao());
        Assert.assertEquals(chamado.getPrioridade(), ci.getPrioridade());
        Assert.assertEquals(chamado.getTecnico().getNome(), ci.getTecnico().getNome());
        Assert.assertEquals(chamado.getCliente().getCpf(), ci.getCliente().getCpf());
        Assert.assertEquals(chamado.getSistemaOperacional(), ci.getSistemaOperacional());
        Assert.assertEquals(chamado.getTipoConexao(), ci.getTipoConexao());
        Assert.assertEquals(chamado.getEnderecoRede(), ci.getEnderecoRede());
    }
    @Test
    public void testeInsercaoChamadoModen() {
        Tecnico tecnico = new Tecnico("Tecnico", 123);
        Empresa empresa = new Empresa(1, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(Integer.SIZE, empresa, 1324L, "Tecnico", 123);
        Chamado chamado = new Chamado(5, "Problema", "Descrição", 8, tecnico, clienteEmpresa, "Windows", "Xp", "" + TipoConexao.CaboModen, "123");

        ChamadoDAO dao = new ChamadoDAO();
        dao.put(chamado);

        Chamado ci = dao.get(dao.gerarCodigo() - 1);

        Assert.assertEquals(chamado.getTitulo(), ci.getTitulo());
        Assert.assertEquals(chamado.getDescricao(), ci.getDescricao());
        Assert.assertEquals(chamado.getPrioridade(), ci.getPrioridade());
        Assert.assertEquals(chamado.getTecnico().getNome(), ci.getTecnico().getNome());
        Assert.assertEquals(chamado.getCliente().getCpf(), ci.getCliente().getCpf());
        Assert.assertEquals(chamado.getSistemaOperacional(), ci.getSistemaOperacional());
        Assert.assertEquals(chamado.getTipoConexao(), ci.getTipoConexao());
        Assert.assertEquals(chamado.getEnderecoRede(), ci.getEnderecoRede());
    }

    @Test
    public void testeLeituraChamadoADSL() {
        Tecnico tecnico = new Tecnico("Tecnico", 123);
        Empresa empresa = new Empresa(1, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(Integer.SIZE, empresa, 1324L, "Tecnico", 123);
        Chamado chamado = new Chamado(5, "Problema", "Descrição", 8, tecnico, clienteEmpresa, "Windows", "Xp", "" + TipoConexao.ADSL, "123");

        ChamadoDAO dao = new ChamadoDAO();
        dao.put(chamado);

        Assert.assertTrue(dao.getChamados().size() >= 1);

    }
    @Test
    public void testeLeituraChamadoModen() {
        Tecnico tecnico = new Tecnico("Tecnico", 123);
        Empresa empresa = new Empresa(1, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(Integer.SIZE, empresa, 1324L, "Tecnico", 123);
        Chamado chamado = new Chamado(5, "Problema", "Descrição", 8, tecnico, clienteEmpresa, "Windows", "Xp", "" + TipoConexao.CaboModen, "123");

        ChamadoDAO dao = new ChamadoDAO();
        dao.put(chamado);

        Assert.assertTrue(dao.getChamados().size() >= 1);

    }
    @Test
    public void testeLeituraChamadoOutra() {
        Tecnico tecnico = new Tecnico("Tecnico", 123);
        Empresa empresa = new Empresa(1, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(Integer.SIZE, empresa, 1324L, "Tecnico", 123);
        Chamado chamado = new Chamado(5, "Problema", "Descrição", 8, tecnico, clienteEmpresa, "Windows", "Xp", "" + TipoConexao.Outra, "123");

        ChamadoDAO dao = new ChamadoDAO();
        dao.put(chamado);

        Assert.assertTrue(dao.getChamados().size() >= 1);

    }
    @Test
    public void testeLeituraChamadoRadio() {
        Tecnico tecnico = new Tecnico("Tecnico", 123);
        Empresa empresa = new Empresa(1, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(Integer.SIZE, empresa, 1324L, "Tecnico", 123);
        Chamado chamado = new Chamado(5, "Problema", "Descrição", 8, tecnico, clienteEmpresa, "Windows", "Xp", "" + TipoConexao.Radio, "123");

        ChamadoDAO dao = new ChamadoDAO();
        dao.put(chamado);

        Assert.assertTrue(dao.getChamados().size() >= 1);

    }
    
    @Test
    public void gerarCodigoChamadoDAOTest() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(1, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(Integer.SIZE, empresa, 1324L, "Pedro", 123);
        Chamado chamDesemp = new Chamado("Titulo do chamado", "Descrição do chamado", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada", 10.0);
        ChamadoDAO chamDAO = new ChamadoDAO();

        chamDAO.put(chamDesemp);
        boolean resultado = false;
        if (chamDesemp.getCodigo() == chamDAO.gerarCodigo() - 1) {
            resultado = true;
        }
        assertTrue(resultado);
    }
}

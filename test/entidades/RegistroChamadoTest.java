package entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.RegistroChamado;
import entidade.Tecnico;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos
 */
public class RegistroChamadoTest {

    @Test
    public void testeCadastroRegistroChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setCodigo(1);
        RegistroChamado registroChamado = new RegistroChamado("Problema de desempenho.", chamado, tecnico);
        assertNotNull(registroChamado.getData());
        assertNotNull(registroChamado.getHora());
        assertEquals("Problema de desempenho.", registroChamado.getAssunto());
        assertEquals(tecnico, registroChamado.getTecnico());
        assertEquals(chamado, registroChamado.getChamado());
    }

    @Test(expected = Exception.class)
    public void testeCadastroRegistroChamadoChamInvalido() throws Exception {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        RegistroChamado registroChamado = new RegistroChamado("Problema de desempenho.", null, tecnico);
    }

    @Test(expected = Exception.class)
    public void testeCadastroRegistroChamadoAssuntoInvalido() throws Exception {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setCodigo(1);
        RegistroChamado registroChamado = new RegistroChamado(null, chamado, tecnico);
    }

    @Test(expected = Exception.class)
    public void testeCadastroRegistroChamadoTecnicoInvalido() throws Exception {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setCodigo(1);
        RegistroChamado registroChamado = new RegistroChamado("Cliente reclama de problema de desempenho.", chamado, null);
    }

    @Test
    public void testeAlterarCodigoRegistroChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setCodigo(1);
        RegistroChamado registroChamado = new RegistroChamado("Cliente reclama de problema de desempenho.", chamado, tecnico);
        registroChamado.setCodigo(2);
        assertEquals((Integer) 2, registroChamado.getCodigo());
    }

    @Test(expected = Exception.class)
    public void testeAlterarCodigoRegistroChamadoInvalido() throws Exception {
        Tecnico tecnico = new Tecnico("Carlos", 928);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setCodigo(1);
        RegistroChamado registroChamado = new RegistroChamado("Cliente reclama de problema de desempenho.", chamado, tecnico);
        registroChamado.setCodigo(-1);
    }

    @Test(expected = Exception.class)
    public void alterarCodigoNuloRegistroChamadoTest() throws Exception {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setCodigo(1);
        RegistroChamado regCham = new RegistroChamado("Problema de desempenho.", chamado, tecnico);
        regCham.setCodigo(null);
    }

    @Test
    public void testeAlterarChamadoRegistroChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setCodigo(1);
        RegistroChamado registroChamado = new RegistroChamado("Problema de desempenho.", chamado, tecnico);
        Chamado chamadoBancoDados = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 30.0);
        chamadoBancoDados.setCodigo(2);
        registroChamado.setChamado(chamadoBancoDados);
        assertEquals(chamadoBancoDados, registroChamado.getChamado());
    }

    @Test(expected = Exception.class)
    public void testeAlterarChamadoInvalidoRegistroChamado() throws Exception {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setCodigo(1);
        RegistroChamado registroChamado = new RegistroChamado("Problema de desempenho.", chamado, tecnico);
        registroChamado.setChamado(null);
    }

    @Test
    public void testeAlterarTecnicoChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setCodigo(1);
        RegistroChamado registroChamado = new RegistroChamado("Problema de desempenho.", chamado, tecnico);
        Tecnico tecnico2 = new Tecnico("Bruno", 82394);
        registroChamado.setTecnico(tecnico2);
        assertEquals(tecnico2, registroChamado.getTecnico());
    }

    @Test(expected = Exception.class)
    public void testeAlterarTecnicoInvalidoChamado() throws Exception {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setCodigo(1);
        RegistroChamado registroChamado = new RegistroChamado("Problema de desempenho.", chamado, tecnico);
        registroChamado.setTecnico(null);
    }

    @Test
    public void testeAlterarDataRegistroChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setCodigo(1);
        RegistroChamado registroChamado = new RegistroChamado("Problema de desempenho.", chamado, tecnico);
        registroChamado.setData("21/10/2016");
        assertEquals("21/10/2016", registroChamado.getData());
    }

    @Test(expected = Exception.class)
    public void testeAlterarDataInvalidaChamado() throws Exception {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 20.0);
        chamado.setCodigo(1);
        RegistroChamado registroChamado = new RegistroChamado("Problema de desempenho.", chamado, tecnico);
        registroChamado.setData(null);
    }

    @Test(expected = Exception.class)
    public void testeAlterarRegistroChamadoInvalido() throws Exception {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Google");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setCodigo(1);
        RegistroChamado registroChamado = new RegistroChamado("Problema de desempenho.", chamado, tecnico);
        registroChamado.setAssunto(null);
    }

    @Test
    public void testeAlterarHoraRegistro() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setCodigo(1);
        RegistroChamado registroChamado = new RegistroChamado("Problema de desempenho.", chamado, tecnico);
        registroChamado.setHora("22:30:00");
        assertEquals("22:30:00", registroChamado.getHora());
    }

    @Test(expected = Exception.class)
    public void testeAlterarHoraInvalidaRegistroChamado() throws Exception {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setCodigo(1);
        RegistroChamado registroChamado = new RegistroChamado("Problema de desempenho.", chamado, tecnico);
        registroChamado.setHora(null);
    }

    @Test
    public void testeAlterarAssuntoRegistroChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setCodigo(1);
        RegistroChamado registroChamado = new RegistroChamado("Problema de desempenho.", chamado, tecnico);
        registroChamado.setAssunto("Cliente está insatisfeito");
        assertEquals("Cliente está insatisfeito", registroChamado.getAssunto());
    }

}

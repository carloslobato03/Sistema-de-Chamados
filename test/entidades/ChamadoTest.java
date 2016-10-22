/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.Tecnico;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos
 */
public class ChamadoTest {

    @Test
    public void testeCadastroChamadoProblemaNaRede() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        assertEquals(01, chamado.getCodigo());
        assertEquals("Título do chamado", chamado.getTitulo());
        assertEquals("Descrição do chamado", chamado.getDescricao());
        assertEquals(2, chamado.getPrioridade());
        assertEquals(tecnico, chamado.getTecnico());
        assertEquals(clienteEmpresa, chamado.getCliente());
        assertEquals("WINDOWS", chamado.getSistemaOperacional());
        assertEquals("Vista", chamado.getVersaoSO());
        assertEquals("CaboModen", chamado.getTipoConexao());
        assertEquals("172.16.0.0", chamado.getEnderecoRede());
        assertNotNull(chamado.getData());
        assertNotNull(chamado.getHora());
        assertEquals("Iniciado", chamado.getStatus());
        assertEquals("Problema de Rede", chamado.getTipoProblema());
    }

    @Test
    public void cadastrarChamadoProblemaBancoDeDados() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamadoBancoDados = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        assertEquals("Título ", chamadoBancoDados.getTitulo());
        assertEquals("Descrição", chamadoBancoDados.getDescricao());
        assertEquals(2, chamadoBancoDados.getPrioridade());
        assertEquals(tecnico, chamadoBancoDados.getTecnico());
        assertEquals(clienteEmpresa, chamadoBancoDados.getCliente());
        assertEquals("Windows", chamadoBancoDados.getSistemaOperacional());
        assertEquals("XP", chamadoBancoDados.getVersaoSO());
        assertEquals("Oracle", chamadoBancoDados.getBancoDeDados());
        assertNotNull(chamadoBancoDados.getData());
        assertNotNull(chamadoBancoDados.getHora());
        assertEquals("iniciado", chamadoBancoDados.getStatus());
        assertEquals("Banco de Dados", chamadoBancoDados.getTipoProblema());
    }

    @Test
    public void cadastrarChamadoProblemaDesempenho() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        assertEquals("Título do chamado", chamado.getTitulo());
        assertEquals("Descrição do chamado", chamado.getDescricao());
        assertEquals(2, chamado.getPrioridade());
        assertEquals(tecnico, chamado.getTecnico());
        assertEquals(clienteEmpresa, chamado.getCliente());
        assertEquals("WINDOWS", chamado.getSistemaOperacional());
        assertEquals("Vista", chamado.getVersaoSO());
        assertEquals("Operação realizada", chamado.getOperacao());
        assertEquals(20.0, chamado.getDuracaoOperacao(), 0);
        assertNotNull(chamado.getData());
        assertNotNull(chamado.getHora());
        assertEquals("Iniciado", chamado.getStatus());
        assertEquals("Problema de Desempenho", chamado.getTipoProblema());
    }

    @Test(expected = Exception.class)
    public void cadastrarChamadoDadosInvalido() throws Exception {
        Chamado chamDesemp = new Chamado(null, null, -1, null, null, null, null, null, -1.0);
        Chamado chamBd = new Chamado(null, null, -1, null, null, null, null, null);
        Chamado chamRede = new Chamado(-1, null, null, -1, null, null, null, null, null, null);
    }

    @Test(expected = Exception.class)
    public void alterarChamadoDadosInvalido() throws Exception {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setBancoDeDados(null);
        chamado.setCausaProblema(null);
        chamado.setCliente(null);
        chamado.setCodigo(-1);
        chamado.setData(null);
        chamado.setDescricao(null);
        chamado.setDuracaoOperacao(-1.0);
        chamado.setEnderecoRede(null);
        chamado.setHora(null);
        chamado.setOperacao(null);
        chamado.setPrioridade(-1);
        chamado.setSistemaOperacional(null);
        chamado.setSolucaoProblema(null);
        chamado.setStatus(null);
        chamado.setTecnico(null);
        chamado.setTipoConexao(null);
        chamado.setTipoProblema(null);
        chamado.setTitulo(null);
        chamado.setVersaoSO(null);
    }

    @Test
    public void alterarCodigoChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setCodigo(1);
        assertEquals(1, chamado.getCodigo());
    }

    @Test
    public void alterarTecnicoChamadot() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        Tecnico tecnico2 = new Tecnico("Lauro", 11122233);
        chamado.setTecnico(tecnico2);
        assertEquals(tecnico2, chamado.getTecnico());
    }

    @Test
    public void alterarClienteChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        ClienteEmpresa clienteEmpresa2 = new ClienteEmpresa(2, empresa, 2197535L, "João", 456);
        chamado.setCliente(clienteEmpresa2);
        assertEquals(clienteEmpresa2, chamado.getCliente());
    }

    @Test
    public void alterarStatusChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setStatus("sendo atendido");
        assertEquals("sendo atendido", chamado.getStatus());
    }

    @Test
    public void alterarTipoProblemaChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setTipoProblema("Banco de Dados defeituoso");
        assertEquals("Banco de Dados defeituoso", chamado.getTipoProblema());
    }

    @Test
    public void alterarDataChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setData("02/01/2016");
        assertEquals("02/01/2016", chamado.getData());
    }

    @Test
    public void alterarHoraChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setHora("12:37:52");
        assertEquals("12:37:52", chamado.getHora());
    }

    @Test
    public void alterarTituloChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setTitulo("Titulo do chamado 2");
        assertEquals("Titulo do chamado 2", chamado.getTitulo());
    }

    @Test
    public void alterarDescricaoChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setDescricao("Descrição do chamado 2");
        assertEquals("Descrição do chamado 2", chamado.getDescricao());
    }

    @Test
    public void alterarPrioridadeChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setPrioridade(1);
        assertEquals(1, chamado.getPrioridade());
    }

    @Test
    public void alterarSistemaOperacionalChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setSistemaOperacional("Mac OSX");
        assertEquals("Mac OSX", chamado.getSistemaOperacional());
    }

    @Test
    public void testeAlterarVersaoSOChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setVersaoSO("20");
        assertEquals("20", chamado.getVersaoSO());
    }

    @Test
    public void testeAlterarBancoDeDadosChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setBancoDeDados("Oracle");
        assertEquals("Oracle", chamado.getBancoDeDados());
    }

    @Test
    public void testeAlterarCausaProblemaChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setCausaProblema("Defeito Sistema");
        assertEquals("Defeito Sistema", chamado.getCausaProblema());
    }

    @Test
    public void testeAlterarSolucaoProblemaChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setSolucaoProblema("Reiniciar Sistema");
        assertEquals("Reiniciar Sistema", chamado.getSolucaoProblema());
    }

    @Test
    public void testeAlterarTipoConexaoChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "CaboBandaLarga", 10.0);
        chamado.setTipoConexao("Internet Banda Larga");
        assertEquals("Internet Banda Larga", chamado.getTipoConexao());
    }

    @Test
    public void testeAlterarEnderecoRedeChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado1 = new Chamado(01, "Título do chamado", "Descrição do chamado", 2, tecnico, clienteEmpresa, "WINDOWS", "Vista", "CaboModen", "192.168.0.0");
        chamado1.setEnderecoRede("192.168.0.2");
        assertEquals("192.168.0.2", chamado1.getEnderecoRede());
    }

    @Test
    public void testeAlterarOperacaoChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setOperacao("Sera realizada em breve");
        assertEquals("Sera realizada em breve", chamado.getOperacao());
    }

    @Test
    public void testeVerificarChamadosPorData() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado1 = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        Chamado chamado2 = new Chamado("Título do chamado", "Descrição do chamado", 2, tecnico, clienteEmpresa, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamado1.setCodigo(1);
        chamado2.setCodigo(1);
        assertEquals(true, chamado1.equals(chamado2));
        chamado2.setData("22/10/2016");
        assertEquals(false, chamado1.equals(chamado2));
    }

    @Test
    public void testeVerificarChamadosPorCodigo() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado1 = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        Chamado chamado2 = new Chamado("Título do chamado", "Descrição do chamado", 2, tecnico, clienteEmpresa, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamado1.setCodigo(1);
        chamado2.setCodigo(1);
        assertEquals(true, chamado1.equals(chamado2));
        chamado2.setCodigo(2);
        assertEquals(false, chamado1.equals(chamado2));
    }

    @Test
    public void testeAlterarDuracaoOperacaoChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        chamado.setDuracaoOperacao(30.0);
        assertEquals(30.0, chamado.getDuracaoOperacao(), 0);
    }

    @Test
    public void testeVerificarChamadosIguaisPorTitulo() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado1 = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "Xp", "Operação realizada com sucesso", 10.0);
        Chamado chamado2 = new Chamado("Título do chamado", "Descrição do chamado", 2, tecnico, clienteEmpresa, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamado1.setCodigo(1);
        chamado2.setCodigo(1);
        assertEquals(true, chamado1.equals(chamado2));
        chamado2.setTitulo("Titulo do chamado 2");
        assertEquals(false, chamado1.equals(chamado2));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controle.ControleChamados;
import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.RegistroChamado;
import entidade.Status;
import entidade.Tecnico;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos
 */
public class ControleChamadosTest {

    @Test
    public void testeAlteraçãoChamadoRede() {
        Tecnico tecnico = new Tecnico("Carlos", 1234);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado1 = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "7", "Operação realizada com sucesso", 20.0);
        ControleChamados controleChamado = new ControleChamados();
        Chamado chamado2 = controleChamado.InserirChamadoDesempenho(chamado1.getTitulo(), chamado1.getDescricao(), chamado1.getPrioridade(), chamado1.getTecnico(), chamado1.getCliente(), chamado1.getSistemaOperacional(), chamado1.getVersaoSO(), chamado1.getOperacao(), chamado1.getDuracaoOperacao());
        controleChamado.alterarChamado(chamado2, "" + Status.sem_solucao, "Não suportado", "Sem solução");
        assertEquals(chamado2.getStatus(), "Sem Solução");
        assertEquals(chamado2.getCausaProblema(), "Não suportado.");
        assertEquals(chamado2.getSolucaoProblema(), "Sem solução");
    }

    @Test
    public void testeInsercaoChamadoBancoDeDados() {
        Tecnico tecnico = new Tecnico("Carlos", 1234);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(001, empresa, 40168413824L, "Rafael", 12123434);
        Chamado chamadoBancoDados = new Chamado("Título do chamado", "Descrição do chamado", 2, tecnico, clienteEmpresa, "Windows", "7", "Oracle");
        ControleChamados controleChamados = new ControleChamados();
        Chamado chamado = controleChamados.InserirChamadoBancoDeDados(chamadoBancoDados.getTitulo(), chamadoBancoDados.getDescricao(), chamadoBancoDados.getPrioridade(), chamadoBancoDados.getTecnico(), chamadoBancoDados.getCliente(), chamadoBancoDados.getSistemaOperacional(), chamadoBancoDados.getVersaoSO(), chamadoBancoDados.getBancoDeDados());
        Chamado chamado2 = controleChamados.buscaPeloCodigo(chamado.getCodigo());
        assertTrue((chamado.getTitulo().equals(chamado2.getTitulo())) && (chamado.getDescricao().equals(chamado2.getDescricao())) && (chamado.getPrioridade() == chamado2.getPrioridade()) && ((chamado.getTecnico().getNome().equals(chamado2.getTecnico().getNome())) && (chamado.getTecnico().getTelefone() == chamado2.getTecnico().getTelefone())) && (chamado.getCliente().getCpf() == chamado2.getCliente().getCpf()) && (chamado.getSistemaOperacional().equals(chamado2.getSistemaOperacional())) && (chamado.getVersaoSO().equals(chamado2.getVersaoSO())) && (chamado.getBancoDeDados().equals(chamado2.getBancoDeDados())));
    }

    @Test
    public void testeInsercaoChamadoControleChamados() {
        Tecnico tecnico = new Tecnico("Carlos", 1234);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado rede = new Chamado(01, "Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "7", "Modem", "192.168.0.1");
        ControleChamados ctCham = new ControleChamados();
        Chamado chamado = ctCham.InserirChamadoRede(rede.getTitulo(), rede.getDescricao(), rede.getPrioridade(), rede.getTecnico(), rede.getCliente(), rede.getSistemaOperacional(), rede.getVersaoSO(), rede.getTipoConexao(), rede.getEnderecoRede());
        Chamado chamado2 = ctCham.buscaPeloCodigo(chamado.getCodigo());
        assertTrue((chamado.getTitulo().equals(chamado2.getTitulo())) && (chamado.getDescricao().equals(chamado2.getDescricao())) && (chamado.getPrioridade() == chamado2.getPrioridade()) && ((chamado.getTecnico().getNome().equals(chamado2.getTecnico().getNome())) && (chamado.getTecnico().getTelefone() == chamado2.getTecnico().getTelefone())) && (chamado.getCliente().getCpf() == chamado2.getCliente().getCpf()) && (chamado.getSistemaOperacional().equals(chamado2.getSistemaOperacional())) && (chamado.getVersaoSO().equals(chamado2.getVersaoSO())) && (chamado.getTipoConexao().equals(chamado2.getTipoConexao())) && (chamado.getEnderecoRede().equals(chamado2.getEnderecoRede())));
    }

    @Test
    public void testeInsercaoChamadoDesempenho() {
        Tecnico tecnico = new Tecnico("Carlos", 1234);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamadoDesempenho = new Chamado("Título", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "7", "Operação realizada", 20.0);
        ControleChamados controleChamado = new ControleChamados();
        Chamado chamado = controleChamado.InserirChamadoDesempenho(chamadoDesempenho.getTitulo(), chamadoDesempenho.getDescricao(), chamadoDesempenho.getPrioridade(), chamadoDesempenho.getTecnico(), chamadoDesempenho.getCliente(), chamadoDesempenho.getSistemaOperacional(), chamadoDesempenho.getVersaoSO(), chamadoDesempenho.getOperacao(), chamadoDesempenho.getDuracaoOperacao());
        Chamado chamado2 = controleChamado.buscaPeloCodigo(chamado.getCodigo());
        assertTrue((chamado.getTitulo().equals(chamado2.getTitulo())) && (chamado.getDescricao().equals(chamado2.getDescricao())) && (chamado.getPrioridade() == chamado2.getPrioridade()) && ((chamado.getTecnico().getNome().equals(chamado2.getTecnico().getNome())) && (chamado.getTecnico().getTelefone() == chamado2.getTecnico().getTelefone())) && (chamado.getCliente().getCpf() == chamado2.getCliente().getCpf()) && (chamado.getSistemaOperacional().equals(chamado2.getSistemaOperacional())) && (chamado.getVersaoSO().equals(chamado2.getVersaoSO())) && (chamado.getOperacao().equals(chamado2.getOperacao())) && (chamado.getDuracaoOperacao() == chamado2.getDuracaoOperacao()));
    }

    @Test
    public void testeInsercaoRegistroChamado() {
        Tecnico tecnico = new Tecnico("Carlos", 1234);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamadoDesempenho = new Chamado("Título do chamado", "Descrição do chamado", 2, tecnico, clienteEmpresa, "WINDOWS", "7", "Operação realizada", 20.0);
        ControleChamados controleChamados = new ControleChamados();
        chamadoDesempenho.setCodigo(1);
        RegistroChamado registro = new RegistroChamado("Cliente reclama de problema de desempenho.", chamadoDesempenho, tecnico);
        RegistroChamado registro2 = controleChamados.inserirRegistroChamado(registro.getAssunto(), registro.getChamado(), registro.getTecnico());
        assertTrue((registro.getAssunto().equals(registro2.getAssunto())) && (registro.getChamado().equals(registro2.getChamado())) && (registro.getChamado().equals(registro2.getChamado())));
    }

    @Test
    public void testeContarQuantidadeChamadosClienteControleChamados() {
        Tecnico tecnico = new Tecnico("Carlos", 1234);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamadoDesempenho = new Chamado("Título ", "Descrição", 2, tecnico, clienteEmpresa, "Windows", "7", "Operação realizada", 20.0);
        Chamado chamadoBancoDados = new Chamado("Título banco de dados: ", "Descrição do segundo chamado", 2, tecnico, clienteEmpresa, "Windows", "7", "Oracle");
        ControleChamados controleChamados = new ControleChamados();
        controleChamados.InserirChamadoDesempenho(chamadoDesempenho.getTitulo(), chamadoDesempenho.getDescricao(), chamadoDesempenho.getPrioridade(), chamadoDesempenho.getTecnico(), chamadoDesempenho.getCliente(), chamadoDesempenho.getSistemaOperacional(), chamadoDesempenho.getVersaoSO(), chamadoDesempenho.getOperacao(), chamadoDesempenho.getDuracaoOperacao());
        controleChamados.InserirChamadoBancoDeDados(chamadoBancoDados.getTitulo(), chamadoBancoDados.getDescricao(), chamadoBancoDados.getPrioridade(), chamadoBancoDados.getTecnico(), chamadoBancoDados.getCliente(), chamadoBancoDados.getSistemaOperacional(), chamadoBancoDados.getVersaoSO(), chamadoBancoDados.getBancoDeDados());
        assertEquals(2, controleChamados.validarQtdChamados(clienteEmpresa));
    }

    @Test
    public void detalhesChamadoControleChamadosTest() {
        Tecnico tecnico = new Tecnico("Carlos", 1234);
        Empresa empresa = new Empresa(123, "Apple");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(1, empresa, 2197534L, "Pedro", 123);
        Chamado chamado = new Chamado("Título ", "Descrição do primeiro chamado", 1, tecnico, clienteEmpresa, "WINDOWS", "Vista", "Operação realizada", 20.0);

        String detalhes = "Abertura: " + chamado.getData() + "\n" + "Chamado aberto às: " + chamado.getHora() + "\n"
                + "Titulo " + "\n" + "Descricao: " + "Descrição do primeiro chamado" + "\n"+ "Prioridade do chamado" + "1" + "\n" + "Status: " + "Iniciado" + "\n"
                + "Tipo de problema: " + "Desempenho" + "\n" + "Tecnico responsável: "+ "Carlos" + "\n" + "Cliente: " + "Contrato: " + "123"
                + "Nome Empresa:" + "Apple" + " - Cliente: "+ "2197534L" + " Nome do Cliente: " + "Pedro" + "\n";
        ControleChamados controleChamado = new ControleChamados();
        assertEquals(detalhes, controleChamado.retornaDetalhesChamado(chamado));
        System.out.println(controleChamado.retornaDetalhesChamado(chamado));

    }
}

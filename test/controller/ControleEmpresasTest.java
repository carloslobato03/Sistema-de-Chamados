/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controle.ControleEmpresas;
import entidade.Empresa;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.Timeout;

/**
 *
 * @author Carlos
 */
public class ControleEmpresasTest {

    @Rule
    public Timeout globalTimeout = new Timeout(200);

    @Test
    public void testeInsercao() {
        ControleEmpresas controleEmpresas = new ControleEmpresas();
        Empresa empresa = new Empresa(92, "Apple");
        controleEmpresas.inserir(empresa.getNumeroContrato(), empresa.getNomeEmpresa());
        Empresa ei = controleEmpresas.retorna(92, "Apple");
        Assert.assertTrue(ei.getNomeEmpresa().equals(empresa.getNomeEmpresa()));
        Assert.assertTrue(ei.getNumeroContrato() == empresa.getNumeroContrato());
    }

    @Test
    public void TesteInsercaoDupla() {
        ControleEmpresas controleEmpresas = new ControleEmpresas();
        Empresa empresa = controleEmpresas.retorna(1, "Apple");
        Assert.assertNull(controleEmpresas.inserir(empresa.getNumeroContrato(), empresa.getNomeEmpresa()));

    }

    @Test
    public void testeBuscarEmpresas() {
        Empresa empresa = new Empresa(1234, "Apple");
        ControleEmpresas controleEmpresas = new ControleEmpresas();
        controleEmpresas.inserir(empresa.getNumeroContrato(), empresa.getNomeEmpresa());
        Empresa ei = controleEmpresas.retorna(1234, "Apple");
        Assert.assertEquals("Apple", ei.getNomeEmpresa());
        Assert.assertEquals(1234, ei.getNumeroContrato());

    }
}

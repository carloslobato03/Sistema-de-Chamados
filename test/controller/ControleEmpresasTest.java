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

/**
 *
 * @author Carlos
 */
public class ControleEmpresasTest {

    @Test
    public void testeInsercao() {
        ControleEmpresas controleEmpresaas = new ControleEmpresas();
        Empresa empresa = new Empresa(1, "Apple");
        controleEmpresaas.inserir(empresa.getNumeroContrato(), empresa.getNomeEmpresa());
        Empresa ei = controleEmpresaas.retorna(1, "Apple");
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
        Empresa empresa = new Empresa(1, "Apple");
        ControleEmpresas controleEmpresas = new ControleEmpresas();
        controleEmpresas.inserir(empresa.getNumeroContrato(), empresa.getNomeEmpresa());
        Empresa empresa2 = controleEmpresas.retorna(2, "Microsoft");
        Assert.assertEquals("Microosoft", empresa2.getNomeEmpresa());
        Assert.assertEquals(2, empresa2.getNumeroContrato());

    }
}

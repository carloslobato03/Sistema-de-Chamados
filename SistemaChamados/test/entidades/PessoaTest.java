/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import entidade.Pessoa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 31517072
 */
public class PessoaTest {
    
    @Test
    public void testeInstanciacao() {
        Pessoa p1 = new Pessoa("Carlos",123);
        Assert.assertEquals(123,p1.getTelefone());
        Assert.assertEquals("Carlos",p1.getNome());
    }
    
    @Test
    public void testeAlteracao(){
        Pessoa p1 = new Pessoa("Carlos",123);
        Assert.assertEquals(123,p1.getTelefone());
        Assert.assertEquals("Carlos",p1.getNome());
        p1.setNome("Pedro");
        p1.setTelefone(987);
        Assert.assertEquals(987,p1.getTelefone());
        Assert.assertEquals("Pedro",p1.getNome());
    }
    
    @Test
    public void testeInstanciacaoNull() {
        Pessoa p1 = new Pessoa(null,123);
        Assert.assertEquals(123,p1.getTelefone());
        Assert.assertNotEquals(null,p1.getNome());
    }
    
    @Test
    public void testeAlteracaoNomeNull(){
        Pessoa p1 = new Pessoa("Carlos",123);
        Assert.assertEquals(123,p1.getTelefone());
        Assert.assertEquals("Carlos",p1.getNome());
        p1.setNome(null);
        p1.setTelefone(987);
        Assert.assertEquals(987,p1.getTelefone());
        Assert.assertNotEquals(null,p1.getNome());
    }
    
    @Test
    public void testeInicializacaoTelNegativo() {
        Pessoa p1 = new Pessoa("Carlos",-123);
        if(-123 == p1.getTelefone()){
            Assert.fail("Número negativo.");
        }
    }
    
    @Test
    public void testeAlteracaoNumeroNegativo(){
        Pessoa p1 = new Pessoa("Carlos",123);
        Assert.assertEquals(123,p1.getTelefone());
        Assert.assertEquals("Carlos",p1.getNome());
        p1.setNome("Pedro");
        p1.setTelefone(-123);
        if(-123== p1.getTelefone()){
            Assert.fail("Numero Negativo.");
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

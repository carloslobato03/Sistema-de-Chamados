package entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entidade.Empresa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author 31517072
 */
public class EmpresaTest {

    @Test
    public void testeInstanciacaoNormal() {
        Empresa empresa = new Empresa(123, "Apple");
        assertEquals("Apple", empresa.getNomeEmpresa());
        assertEquals(123, empresa.getNumeroContrato());
    }

    @Test(expected = Exception.class)
    public void testeInstanciacaoNegativo() throws Exception {
        Empresa emp = new Empresa(-999, "Apple");
    }

    @Test(expected = Exception.class)
    public void testeCadastroNomeNulo() throws Exception {
        Empresa emp = new Empresa(123, null);
    }
       @Test
    public void inicializaçãoNulaTest(){
        Empresa empresa = new Empresa(123456789, "");
        assertEquals(123456789, empresa.getNumeroContrato());
        Assert.assertNotEquals("", empresa.getNomeEmpresa());
    }

    @Test
    public void testeAlteracao() {
        Empresa empresa = new Empresa(123, "Apple");
        assertEquals("Apple", empresa.getNomeEmpresa());
        assertEquals(123, empresa.getNumeroContrato());
        empresa.setNomeEmpresa("Microsoft");
        empresa.setNumeroContrato(987);
        assertEquals("Microsoft", empresa.getNomeEmpresa());
        assertEquals(987, empresa.getNumeroContrato());

    }

    
    @Test(expected = Exception.class)
    public void testeAlteracaoContratoNegativo() throws Exception {
        Empresa empresa = new Empresa(123, "Apple");
        assertEquals("Apple", empresa.getNomeEmpresa());
        assertEquals(123, empresa.getNumeroContrato());
        empresa.setNomeEmpresa("Microsoft");
        empresa.setNumeroContrato(-123);
        assertEquals("Microsoft", empresa.getNomeEmpresa());

    }

    @Test(expected = Exception.class)
    public void testeAlteracaoNomeNulo() throws Exception {
        Empresa empresa = new Empresa(123,"Apple");
        assertEquals("Apple", empresa.getNomeEmpresa());
        assertEquals(123,empresa.getNumeroContrato());
        empresa.setNomeEmpresa(null);
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

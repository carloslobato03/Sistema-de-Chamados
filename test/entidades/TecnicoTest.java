/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import entidade.Tecnico;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos
 */
public class TecnicoTest {

    @Test
    public void testeCadastrarTecnico() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        assertEquals("Carlos", tecnico.getNome());
        assertEquals(123, tecnico.getTelefone());
    }

    @Test(expected = Exception.class)
    public void testeCadastrarTecnicoTelefoneInvalido() throws Exception {
        Tecnico tecnico = new Tecnico("Carlos", -123);
    }

    @Test(expected = Exception.class)
    public void testeCadastrarTecnicoSemNome() throws Exception {
        Tecnico tecnico = new Tecnico(null, 123);
    }

    @Test
    public void testeAlterarTelefoneTecnico() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        tecnico.setTelefone(9823);
        assertEquals(9823, tecnico.getTelefone());
    }



    @Test(expected = Exception.class)
    public void testeAlterarTelefoneInvalidoTecnico() throws Exception {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        tecnico.setTelefone(-123);
    }
    @Test(expected = Exception.class)
    public void testeAlterarNomeInvalidoTecnico() throws Exception {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        tecnico.setNome(null);
    }
    @Test
    public void testeAlterarNomeTecnico() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        tecnico.setNome("Pedro");
        assertEquals("Pedro", tecnico.getNome());
    }
}

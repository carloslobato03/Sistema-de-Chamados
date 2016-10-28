/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import org.junit.Assert;
import org.junit.Test;
import Persistencia.TecnicoDAO;
import entidade.Tecnico;
import java.util.HashMap;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos
 */
public class TecnicoDAOTest {

    @Test
    public void testeGeracaoCodigo() {
        TecnicoDAO tDAO = new TecnicoDAO();

        int codigo = tDAO.gerarCodigo();

        Assert.assertNotNull(codigo);

    }

    @Test
    public void testeInsercaoTecnico() {
        Tecnico tecnico = new Tecnico("Carlos", 123);
        TecnicoDAO tecnicoDAO = new TecnicoDAO();
        tecnicoDAO.put(tecnico);
        Tecnico tecnico2 = tecnicoDAO.get(tecnicoDAO.gerarCodigo() - 1);

        Assert.assertEquals(tecnico, tecnico2);

    }
    @Test
    public void testeInsercaoTecnicoNull() {
        Tecnico tecnico = new Tecnico(null, 123);
        TecnicoDAO tecnicoDAO = new TecnicoDAO();
        tecnicoDAO.put(tecnico);
        Tecnico tecnico2 = tecnicoDAO.get(tecnicoDAO.gerarCodigo() - 1);

        Assert.assertEquals(tecnico, tecnico2);

    }
    @Test
    public void testeDoHashmap() {

        TecnicoDAO tDAO = new TecnicoDAO();

        HashMap<Integer, Tecnico> hashRetornado = tDAO.voltaCashTecnico();

        Assert.assertNotNull(hashRetornado);

    }


    @Test
    public void testeDeBuscaTecnico() {

        Tecnico tecnico = new Tecnico("Carlos", 123);
        TecnicoDAO tecnicoDAO = new TecnicoDAO();
        tecnicoDAO.put(tecnico);
        Tecnico tecnico2 = tecnicoDAO.get(tecnicoDAO.gerarCodigo() - 1);
        Assert.assertEquals(tecnico, tecnico2);
    }
}

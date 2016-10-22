/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Persistencia.TecnicoDAO;
import controle.ControleTecnicos;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos
 */
public class ControleTecnicosTest {

    @Test
    public void inserirTecnicoTest() {
        ControleTecnicos tecnico = new ControleTecnicos();
        tecnico.inserir(1, "Tecnico Joao");

        Assert.assertNotNull(tecnico);

    }

    @Test
    public void buscarTecnicoTest() {
        ControleTecnicos tecnico = new ControleTecnicos();
        tecnico.inserir(2, "Tecnico Pedro");

        TecnicoDAO tecnicoDAO = new TecnicoDAO();

        Assert.assertNotNull(tecnicoDAO.get(2));

    }
}

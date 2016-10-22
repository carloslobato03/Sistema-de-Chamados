/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controle.ControladorPrincipal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos
 */
public class ControllerPrincipalTeste {

@Test
    public void testeIniciarControladorPrincipal() {
        ControladorPrincipal controlador = new ControladorPrincipal();
        assertNotNull(controlador.getCtrEmpresa());
        assertNotNull(controlador.getCtrChamados());
        assertNotNull(controlador.getCtrClientes());
        assertNotNull(controlador.getCtrTecnicos());
        
    }

    
}

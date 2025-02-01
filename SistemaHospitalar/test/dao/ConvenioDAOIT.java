/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import modelo.Convenio;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GFS_Mac
 */
public class ConvenioDAOIT {

    public ConvenioDAOIT() {
    }

    ConvenioDAO convenioDAO = new ConvenioDAO();

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

    /**
     * Test of buscarcConvenios method, of class ConvenioDAO.
     */
    @Test
    public void testBuscarcConvenios() throws Exception {
        // cenário: lista com convenios cadastrados
        // resultado esperado: NotNull  
        int result = convenioDAO.buscarcConvenios().size();
        assertNotNull(result);

    }

    /**
     * Test of buscarConvenioFiltro method, of class ConvenioDAO.
     */
    @Test
    public void testBuscarConvenioFiltro() throws Exception {
        // cenário: busca por parte de nome de convenio cadastrado
        // resultado esperado: deve retornar um convênio com a String usada na busca  
        String query = "Am";
        Convenio result = convenioDAO.buscarConvenioFiltro((query));
        assertTrue(result.getNomeConvenio().contains(query));
    }

}

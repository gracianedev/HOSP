/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package servicos;

import java.util.ArrayList;
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
public class ConvenioServicosIT {
    
    public ConvenioServicosIT() {
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

    /**
     * Test of buscarConvenio method, of class ConvenioServicos.
     */
    @Test
    public void testBuscarConvenio() throws Exception {
        // cenário: lista com convênios cadastrados
        // resultado esperado: NotNull  
        ConvenioServicos instance = new ConvenioServicos();
        int result = instance.buscarConvenio().size();
        assertTrue(result>0);
        
    }
    
}

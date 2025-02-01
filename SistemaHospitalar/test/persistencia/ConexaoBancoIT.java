/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package persistencia;

import java.sql.Connection;
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
public class ConexaoBancoIT {
    
    public ConexaoBancoIT() {
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
     * Test of getConexao method, of class ConexaoBanco.
     */
    @Test
    public void testGetConexao() throws Exception {
        ConexaoBanco instance = new ConexaoBanco();
        Connection result = instance.getConexao();
        assertNotNull(result);
        // resultado esperado é NotNull
       
    }
    
}

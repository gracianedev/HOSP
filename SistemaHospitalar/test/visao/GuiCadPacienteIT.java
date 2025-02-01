/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package visao;

import java.util.ArrayList;
import modelo.Convenio;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import servicos.ConvenioServicos;
import servicos.ServicosFactory;
import javax.swing.JComboBox;

/**
 *
 * @author GFS_Mac
 */
public class GuiCadPacienteIT {
    
    public GuiCadPacienteIT() {
    }
    private JComboBox<String> jcConvenio;
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        jcConvenio = new JComboBox<>();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testPreencherCombo() throws Exception {
        // cenário: 5 convênios cadastrados
        // resultado esperado: o combo box deve apresentar 6 itens (5 convênios e a opção "Selecione")
        ConvenioServicos ps = ServicosFactory.getConvenioServicos();
         ArrayList<Convenio> p = new ArrayList<>();
          p = ps.buscarConvenio();
          jcConvenio.addItem("-Selecione-");
            for (int i = 0; i < p.size(); i++) {

                // Adicionando o nome do convênio ao JComboBox
                jcConvenio.addItem(p.get(i).getNomeConvenio());

            }
            int result = jcConvenio.getItemCount();
           assertEquals(6,result);
          
    }
    
}

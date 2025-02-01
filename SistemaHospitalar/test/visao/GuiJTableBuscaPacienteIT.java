/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package visao;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.table.DefaultTableModel;
import modelo.Paciente;
import servicos.PacienteServicos;
import servicos.ServicosFactory;

/**
 *
 * @author GFS_Mac
 */
public class GuiJTableBuscaPacienteIT {
    
    public GuiJTableBuscaPacienteIT() {
    }
    DefaultTableModel dtm = new DefaultTableModel(
            new Object[][]{},
            new Object[]{"Código", "Nome", "CPF", "Telefone"});
        

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

    @Test
    public void testPreencherTabela() throws Exception {
        // cenário: existem pacientes já cadastrados
        // resultado: lista de pacientes deve conter mesma quantidade de pacientes da tabela
         PacienteServicos ps = ServicosFactory.getPacienteServicos();
         ArrayList<Paciente> pac = new ArrayList<>();
         pac = ps.buscarPaciente();
         int resultadoEsperado = pac.size();
          for (int i = 0; i < pac.size(); i++) {
                dtm.addRow(new String[]{
                    String.valueOf(pac.get(i).getIdPaciente()),
                    String.valueOf(pac.get(i).getNome()),
                    String.valueOf(pac.get(i).getCpf()),
                    String.valueOf(pac.get(i).getTelefone()),});
            }
         int result = dtm.getRowCount();
         assertEquals(resultadoEsperado,result);
    }
    
    
    @Test
    public void testLimparTabela() throws Exception {
        // cenário: preencher tabela para depois verificar a funcionalidade limpar tabela
        // resultado: lista com zero linhas
        
        // preencher tabela
        PacienteServicos ps = ServicosFactory.getPacienteServicos();
         ArrayList<Paciente> pac = new ArrayList<>();
         pac = ps.buscarPaciente();
            for (int i = 0; i < pac.size(); i++) {
                dtm.addRow(new String[]{
                    String.valueOf(pac.get(i).getIdPaciente()),
                    String.valueOf(pac.get(i).getNome()),
                    String.valueOf(pac.get(i).getCpf()),
                    String.valueOf(pac.get(i).getTelefone()),});
            }
          // limpar tabela
          dtm.setNumRows(0);
          assertEquals(0,dtm.getRowCount());
         
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static junit.framework.TestCase.assertTrue;
import modelo.Paciente;
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
public class PacienteDAOIT {
    
    public PacienteDAOIT() {
    }
    
    PacienteDAO pacienteDAO = new PacienteDAO();
    SimpleDateFormat data = new SimpleDateFormat("dd/mm/yyyy");

    
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
     * Test of cadastrarPaciente method, of class PacienteDAO.
     */
    @Test
    public void testCadastrarPacienteNull() throws Exception {
        // cenário: tentar cadastrar paciente nulo
        // resultado esperado: não deve permitir cadastro de paciente null, deve lançar exceção NullPointerException

        Paciente pac = null;
        assertThrows(NullPointerException.class, () -> pacienteDAO.cadastrarPaciente(pac));
    }
    
    
    @Test
    public void testCadastrarPaciente() throws Exception {
    // cenário: cadastro de paciente com todos campos informados
    // resultado esperado: True, paciente deve ser cadastrado
    Paciente pac = new Paciente();
    pac.setConvenio(2);
    pac.setCpf("012.345.678-99");
    pac.setDataNascimento(data.parse("01/01/1990"));
    pac.setEmail("teste@teste.com");
    pac.setEndereco("Rua Java, nº 17");
    pac.setNome("James dos Santos");
    pac.setRg("6654321");
    pac.setTelefone("(55) 9836-4177");
    boolean resposta = pacienteDAO.cadastrarPaciente(pac);
    assertTrue(resposta);
    }
    
    @Test
    public void testCadastrarPacienteSemNome() throws Exception {
    // cenário: cadastro de paciente sem informar o campo obrigatório nome
    // resultado esperado: SQLException 'NOME' cannot be null
    Paciente pac = new Paciente();
    pac.setConvenio(2);
    pac.setCpf("212.345.678-79");
    pac.setDataNascimento(data.parse("01/01/1990"));
    pac.setEmail("teste@teste.com");
    pac.setEndereco("Rua Java, nº 17");
    pac.setRg("6654321");
    pac.setTelefone("(55) 9836-4177");
    assertThrows(SQLException.class, () -> pacienteDAO.cadastrarPaciente(pac));
    }
    
    @Test
    public void testCadastrarPacienteSemCPF() throws Exception {
    // cenário: cadastro de paciente sem informar o campo obrigatório cpf
    // resultado esperado: SQLException 'CPF' cannot be null
    Paciente pac = new Paciente();
    pac.setConvenio(2);
    pac.setNome("Ana Clara");
    pac.setDataNascimento(data.parse("01/01/1990"));
    pac.setEmail("teste@teste.com");
    pac.setEndereco("Rua Java, nº 17");
    pac.setRg("6654321");
    pac.setTelefone("(55) 9836-4177");
    assertThrows(SQLException.class, () -> pacienteDAO.cadastrarPaciente(pac));
    }
    
        @Test
    public void testCadastrarPacienteCPFrepetido() throws Exception {
    // cenário: cadastro de paciente informando CPF já cadastrado no banco de dados
    // resultado esperado: SQLException Duplicate entry for key 'paciente.CPF'
    Paciente pac = new Paciente();
    pac.setConvenio(2);
    pac.setNome("Artur");
    pac.setCpf("012.345.678-99");
    pac.setDataNascimento(data.parse("01/01/1990"));
    pac.setEmail("teste@teste.com");
    pac.setEndereco("Rua Java, nº 17");
    pac.setRg("6654321");
    pac.setTelefone("(55) 9836-4177");
    assertThrows(SQLException.class, () -> pacienteDAO.cadastrarPaciente(pac));
    }
    
        @Test
    public void testCadastrarPacienteEnderecoVazio() throws Exception {
    // cenário: cadastro de paciente sem informar o campo obrigatório endereço
    // resultado esperado: SQLException Check constraint 'chk_endereco_not_empty' is violated
    Paciente pac = new Paciente();
    pac.setConvenio(2);
    pac.setNome("Caio");
    pac.setCpf("111.345.678-79");
    pac.setDataNascimento(data.parse("01/01/1990"));
    pac.setEmail("teste@teste.com");
    pac.setEndereco("");
    pac.setRg("6654321");
    pac.setTelefone("(55) 9836-4177");
    //SQLException result = 
            assertThrows(SQLException.class, () -> pacienteDAO.cadastrarPaciente(pac));
    //System.out.println(result.getMessage());
    }
    
            @Test
    public void testCadastrarSemData() throws Exception {
    // cenário: cadastro de paciente sem informar o campo obrigatório data de nascimento
    // resultado esperado: NullPointerException date must not be null
    Paciente pac = new Paciente();
    pac.setConvenio(4);
    pac.setNome("Caio");
    pac.setCpf("111.345.578-79");
    pac.setEmail("teste@teste.com");
    pac.setEndereco("Rua Xyz, 543");
    pac.setRg("6654321");
    pac.setTelefone("(55) 9836-4177");
    assertThrows(NullPointerException.class, () -> pacienteDAO.cadastrarPaciente(pac));
    }
    
        @Test
    public void testCadastrarSemTelefone() throws Exception {
    // cenário: cadastro de paciente sem informar o campo obrigatório telefone
    // resultado esperado: SQLException Column 'TELEFONE' cannot be null
    Paciente pac = new Paciente();
    pac.setConvenio(4);
    pac.setNome("Caio");
    pac.setCpf("111.345.578-79");
    pac.setDataNascimento(data.parse("21/08/1976"));
    pac.setEmail("teste@teste.com");
    pac.setEndereco("Rua Xyz, 543");
    pac.setRg("6654321");
    pac.setTelefone("");
    //SQLException result = 
            assertThrows(SQLException.class, () -> pacienteDAO.cadastrarPaciente(pac));
    //System.out.println(result.getMessage());
    }
    
    
            @Test
    public void testCadastrarTelefoneVazio() throws Exception {
    // cenário: cadastro de paciente sem informar o campo obrigatório telefone
    // resultado esperado: SQLException Check constraint 'chk_telefone' is violated.
  
    Paciente pac = new Paciente();
    pac.setConvenio(4);
    pac.setNome("Caio");
    pac.setCpf("111.345.578-79");
    pac.setDataNascimento(data.parse("21/08/1976"));
    pac.setEmail("teste@teste.com");
    pac.setEndereco("Rua Xyz, 543");
    pac.setRg("6654321");
    pac.setTelefone("");
    assertThrows(SQLException.class, () -> pacienteDAO.cadastrarPaciente(pac));
    }
    
    
    /**
     * Test of buscarPacienteFiltro method, of class PacienteDAO.
     */
    @Test
    public void testBuscarPacienteFiltro() throws Exception {
        // cenário: buscar paciente pelo nome (informar dado persistido no banco)
        // resultado esperado: encontrar paciente (True)
        String query = "WHERE NOME like 'Maria%'";
        int result = pacienteDAO.buscarPacienteFiltro(query).size();
        assertTrue(result>0);
        
    }

    /**
     * Test of buscarPaciente method, of class PacienteDAO.
     */
    @Test
    public void testBuscarPaciente() throws Exception {
        // cenário: lista com pacientes cadastrados
        // resultado esperado: NotNull        
        ArrayList<Paciente> result = pacienteDAO.buscarPaciente();
        assertNotNull(result);
        
       
    }
    
}

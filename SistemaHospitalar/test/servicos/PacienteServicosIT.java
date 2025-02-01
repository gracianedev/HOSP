/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package servicos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class PacienteServicosIT {

    public PacienteServicosIT() {
    }

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
     * Test of cadastrarPaciente method, of class PacienteServicos.
     */
    @Test
    public void testCadastrarPaciente() throws Exception {
        // cenário: inserir corretamente os dados para um novo cadastro e pesquisar pelo CPF informado
        // resultado esperado: retornar um resultado, pois para um CPF só é possível um cadastro
        Paciente pac = new Paciente();
        pac.setConvenio(2);
        pac.setCpf("025.845.678-99");
        pac.setDataNascimento(data.parse("01/01/1990"));
        pac.setEmail("teste@teste.com");
        pac.setEndereco("Rua Java, nº 17");
        pac.setNome("James dos Santos");
        pac.setRg("6654321");
        pac.setTelefone("(55) 9836-4177");
        PacienteServicos instance = new PacienteServicos();
        instance.cadastrarPaciente(pac);
        int pac1 = instance.buscarPacienteFiltro("WHERE CPF = '025.845.678-99'").size();
        assertEquals(1, pac1);
    }

    /**
     * Test of buscarPacienteFiltro method, of class PacienteServicos.
     */
    @Test
    public void testBuscarPacienteFiltro() throws Exception {
        // cenário: buscar paciente pelo nome (informar dado persistido no banco)
        // resultado esperado: encontrar paciente (True)
        String query = "WHERE NOME = 'James dos Santos'";
        PacienteServicos instance = new PacienteServicos();
        int result = instance.buscarPacienteFiltro(query).size();
        assertTrue(result > 0);

    }

    /**
     * Test of buscarPaciente method, of class PacienteServicos.
     */
    @Test
    public void testBuscarPaciente() throws Exception {
        // cenário: lista com pacientes cadastrados
        // resultado esperado: NotNull  
        PacienteServicos instance = new PacienteServicos();
        ArrayList<Paciente> result = instance.buscarPaciente();
        assertNotNull(result);
    }

    @Test
    public void testValidarPacienteCamposCorretos() throws Exception {
        // cenário: paciente com dados válidos
        // resultado esperado: True  
        PacienteServicos pacServ = new PacienteServicos();
        Paciente pac = new Paciente();
        pac.setConvenio(2);
        pac.setCpf("02584567899");
        pac.setDataNascimento(data.parse("01/01/1990"));
        pac.setEmail("teste@teste.com");
        pac.setEndereco("Rua Java, nº 17");
        pac.setNome("James dos Santos");
        pac.setRg("6654321");
        pac.setTelefone("(55) 9836-4177");
        assertTrue(pacServ.validarPaciente(pac));
    }

    @Test
    public void testValidarPacienteNomeEmBranco() throws Exception {
        // cenário: paciente sem preenchimento do campo Nome
        // resultado esperado: False  
        PacienteServicos pacServ = new PacienteServicos();
        Paciente pac = new Paciente();
        pac.setConvenio(2);
        pac.setCpf("02584567899");
        pac.setDataNascimento(data.parse("01/01/1990"));
        pac.setEmail("teste@teste.com");
        pac.setEndereco("Rua Java, nº 17");
        pac.setNome("");
        pac.setRg("6654321");
        pac.setTelefone("(55) 9836-4177");
        assertFalse(pacServ.validarPaciente(pac));
    }

    @Test
    public void testValidarPacienteCPFincorreto() throws Exception {
        // cenário: paciente com preenchimento do campo CPF com menos de 11 caracteres
        // resultado esperado: False  
        PacienteServicos pacServ = new PacienteServicos();
        Paciente pac = new Paciente();
        pac.setConvenio(2);
        pac.setCpf("025845678");
        pac.setDataNascimento(data.parse("01/01/1990"));
        pac.setEmail("teste@teste.com");
        pac.setEndereco("Rua Java, nº 17");
        pac.setNome("Juarez");
        pac.setRg("6654321");
        pac.setTelefone("(55) 9836-4177");
        assertFalse(pacServ.validarPaciente(pac));
    }

    @Test
    public void testValidarPacienteEnderecoIncorreto() throws Exception {
        // cenário: paciente com endereco com mais de 200 caracteres 
        // resultado esperado: False  
        PacienteServicos pacServ = new PacienteServicos();
        Paciente pac = new Paciente();
        pac.setConvenio(2);
        pac.setCpf("02584567899");
        pac.setDataNascimento(data.parse("01/01/1990"));
        pac.setEmail("teste@teste.com");
        pac.setEndereco("Rua das Palmeiras Exóticas, Nº 1234, Bloco B, Apt. 567, Bairro Jardim das Rosas Amarelas, Cidade Nova Esperança, Estado dos Sonhos Encantados, CEP 98765-432, Referência: Próximo à Praça Central das Cerejeiras.");
        pac.setNome("Miguel");
        pac.setRg("6654321");
        pac.setTelefone("(55) 9836-4177");
        assertFalse(pacServ.validarPaciente(pac));
    }

    @Test
    public void testValidarDadosNomeVazio() throws Exception {
        // cenário: campo nome vazio 
        // resultado esperado: Frase informando os campos obrigatórios  

        String mensagem = PacienteServicos.validarDados("", "endereco", "cpf", "telefone", "email", "dataNasc");
        assertEquals("Verifique o preenchimento dos campos obrigatórios. Nome, CPF, Data de Nascimento, Endereço e Telefone devem ser preenchidos.", mensagem);
    }

    @Test
    public void testValidarDadosNomeExtrapolaCaracteres() throws Exception {
        // cenário: campo nome com mais de 55 caracteres
        // resultado esperado: Frase informando a limitação do campo  

        String mensagem = PacienteServicos.validarDados("Maximiliano Alessandro Monteiro da Silva Fernandes Júnior", "endereco", "cpf", "telefone", "email", "dataNasc");
        assertEquals("Nome deve conter no máximo 55 caracteres.", mensagem);
    }

    @Test
    public void testValidarDadosEnderecoExtrapolaCaracteres() throws Exception {
        // cenário: campo endereço com mais de 200 caracteres
        // resultado esperado: Frase informando a limitação do campo  

        String mensagem = PacienteServicos.validarDados("Alessandro Monteiro da Silva Fernandes Júnior", "Rua das Palmeiras Exóticas, Nº 1234, Bloco B, Apt. 567, Bairro Jardim das Rosas Amarelas, Cidade Nova Esperança, Estado dos Sonhos Encantados, CEP 98765-432, Referência: Próximo à Praça Central das Cerejeiras.", "cpf", "telefone", "email", "dataNasc");
        assertEquals("Endereço deve conter no máximo 200 caracteres.", mensagem);
    }

    @Test
    public void testValidarDadosCpfIncorreto() throws Exception {
        // cenário: campo CPF com menos de 11 caracteres
        // resultado esperado: Frase informando o correto preenchimento do campo  

        String mensagem = PacienteServicos.validarDados("Alessandro Monteiro da Silva Fernandes Júnior", "Rua das Palmeiras Exóticas, Nº 1234, Cidade Nova Esperança, Estado dos Sonhos Encantados, CEP 98765-432", "12345", "telefone", "email", "dataNasc");
        assertEquals("O campo CPF deve conter 11 dígitos.", mensagem);
    }

    @Test
    public void testValidarDadosTelefoneExtrapolaCaracteres() throws Exception {
        // cenário: campo telefone com mais de 15 caracteres
        // resultado esperado: Frase informando a limitação do campo   

        String mensagem = PacienteServicos.validarDados("Alessandro Monteiro da Silva Fernandes Júnior", "Rua das Palmeiras Exóticas, Nº 1234, Cidade Nova Esperança, Estado dos Sonhos Encantados, CEP 98765-432", "12345678900", "1234123412341234", "email", "dataNasc");
        assertEquals("Telefone deve conter 15 caracteres.", mensagem);
    }

    @Test
    public void testValidarDadosTelefoneIncorreto() throws Exception {
        // cenário: campo telefone preenchido incorretamente
        // resultado esperado: Frase informando o correto preenchimento do campo  

        String mensagem = PacienteServicos.validarDados("Alessandro Monteiro da Silva Fernandes Júnior", "Rua das Palmeiras Exóticas, Nº 1234, Cidade Nova Esperança, Estado dos Sonhos Encantados, CEP 98765-432", "12345678900", "123412341234123", "email", "dataNasc");
        assertEquals("Telefone deve ser informado no formato (xx) xxxx-xxxx.", mensagem);
    }

    @Test
    public void testValidarDadosEmailIncorreto() throws Exception {
        // cenário: campo email preenchido incorretamente
        // resultado esperado: Frase informando o correto preenchimento do campo  

        String mensagem = PacienteServicos.validarDados("Alessandro Monteiro da Silva Fernandes Júnior", "Rua das Palmeiras Exóticas, Nº 1234, Cidade Nova Esperança, Estado dos Sonhos Encantados, CEP 98765-432", "12345678900", "(51) 1234-1234", "email", "dataNasc");
        assertEquals("E-mail precisa ser no formato nome@dominio.com.", mensagem);
    }

    @Test
    public void testValidarDataVazio() throws Exception {
        // cenário: campo Data vazio 
        // resultado esperado: Frase informando os campos obrigatórios  

        String mensagem = PacienteServicos.validarDados("Alessandro Monteiro da Silva Fernandes Júnior", "Rua das Palmeiras Exóticas, Nº 1234, Cidade Nova Esperança, Estado dos Sonhos Encantados, CEP 98765-432", "12345678900", "(51) 1234-1234", "email@test.com", "");
        assertEquals("Verifique o preenchimento dos campos obrigatórios. Nome, CPF, Data de Nascimento, Endereço e Telefone devem ser preenchidos.", mensagem);
    }

    @Test
    public void testValidarDadosCorretos() throws Exception {
        // cenário: todos os campos preenchidos corretamente 
        // resultado esperado: nenhuma advertência para o usuário  

        String mensagem = PacienteServicos.validarDados("Alessandro Monteiro da Silva Fernandes Júnior", "Rua das Palmeiras Exóticas, Nº 1234, Cidade Nova Esperança, Estado dos Sonhos Encantados, CEP 98765-432", "12345678900", "(51) 1234-1234", "email@test.com", "01/10/1992");
        assertEquals("", mensagem);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import dao.DAOFactory;
import dao.PacienteDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Paciente;

/**
 *
 * @author senacead
 */
/*
A classe PacienteServicos representa a camada de serviços da aplicação, ela utiliza a classe PacienteDAO para realizar
operações de leitura e escrita no banco de dados.
 */
public class PacienteServicos {

    // Método para cadastrar um paciente
    public void cadastrarPaciente(Paciente pac) throws SQLException {

        // Busca da Fábrica um obj. PacienteDAO
        PacienteDAO pacDAO = DAOFactory.getPacienteDAO();

        // Chamando método cadastrarPaciente para enviar o obj. pac
        pacDAO.cadastrarPaciente(pac);
    }

    // Método para buscar um paciente por ID
    public ArrayList<Paciente> buscarPacienteFiltro(String query) throws SQLException {

        // Busca da Fábrica um obj. PacienteDAO
        PacienteDAO pacDAO = DAOFactory.getPacienteDAO();

        // Chamando método buscarPaciente para buscar o paciente pelo ID
        return pacDAO.buscarPacienteFiltro(query);
    }

    // Método para buscar todos os pacientes
    public ArrayList<Paciente> buscarPaciente() throws SQLException {

        // Busca da Fábrica um obj. PacienteDAO
        PacienteDAO pacDAO = DAOFactory.getPacienteDAO();

        // Chamando método buscarPaciente para buscar todos os pacientes
        return pacDAO.buscarPaciente();
    }

    public boolean validarPaciente(Paciente pac) {
        if (pac.getNome().isBlank() || pac.getCpf().isBlank() || pac.getEndereco().isBlank()
                || pac.getDataNascimento() == null || pac.getTelefone().isBlank()) {
            return false;
        }

        if (pac.getNome().length() > 55 || pac.getEndereco().length() > 200) {
            return false;
        }

        if (!pac.getCpf().replaceAll("[^0-9]", "").matches("[0-9]{11}")) {
            return false;
        }

        if (pac.getTelefone().length() > 15 || !pac.getTelefone().matches("\\([0-9]{2}\\) [0-9]{4}-[0-9]{4}")) {
            return false;
        }

        if (pac.getEmail() != null && !pac.getEmail().isEmpty()) {
            if (!pac.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                return false;
            }
        }

        return true;

    }

    public static String validarDados(String nome, String endereco, String cpf, String telefone, String email, String dataNasc) {
        // Alertas para o usuário caso os campos não estejam preenchidos corretamente
        if (nome.isBlank() || nome.isEmpty()
                || cpf.isBlank() || cpf.isEmpty()
                || dataNasc.isBlank() || dataNasc.isEmpty()
                || endereco.isBlank() || endereco.isEmpty()
                || telefone.isBlank() || telefone.isEmpty()) {
            return "Verifique o preenchimento dos campos obrigatórios. Nome, CPF, Data de Nascimento, Endereço e Telefone devem ser preenchidos.";
        } else if (nome.length() > 55) {
            return "Nome deve conter no máximo 55 caracteres.";
        } else if (endereco.length() > 200) {
            return "Endereço deve conter no máximo 200 caracteres.";
        } else if (!cpf.matches("[0-9]{11}")) {
            return "O campo CPF deve conter 11 dígitos.";
        } else if (telefone.length() > 15) {
            return "Telefone deve conter 15 caracteres.";
        } else if (!telefone.matches("\\([0-9]{2}\\) [0-9]{4}-[0-9]{4}")) {
            return "Telefone deve ser informado no formato (xx) xxxx-xxxx.";
        } else if (!email.isEmpty() && !email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            return "E-mail precisa ser no formato nome@dominio.com.";
        }
        return "";
    }

}

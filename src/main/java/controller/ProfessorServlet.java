package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Professor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/professor")
public class ProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProfessorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Apenas carregar professor.jsp sem nenhum elemento
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Entrada
		String cmd = request.getParameter("botao");
		String codigo = request.getParameter("codigo");
		String nome = request.getParameter("nome");
		String titulacao = request.getParameter("titulacao");
		
		//Saida
		String saida = "";
		String erro = "";
		Professor p = new Professor();
		List<Professor> professores = new ArrayList<>();
		
		if(!cmd.contains("Listar")) {
			p.setCodigo(Integer.parseInt(codigo));
		}
		if(cmd.contains("Cadastrar") || cmd.contains("Alterar")) {
			p.setNome(nome);
			p.setTitulacao(titulacao);
		}
		try {
			if(cmd.contains("Cadastrar")) {
				cadastarProfessor(p);
				saida = "Professor cadastrado com sucesso";
				p= null;
			}
			if(cmd.contains("Alterar")) {
				alterarProfessor(p);
				saida = "Professor alterado com sucesso";
				p= null;
			}
			if(cmd.contains("Excluir")) {
				excluirProfessor(p);
				saida = "Professor excluido com sucesso";
				p= null;
			}
			if(cmd.contains("Buscar")) {
				p = buscarProfessor(p);
			}
			if(cmd.contains("Listar")) {
				professores = listarprofessores();
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("professor", p);
			request.setAttribute("professores", professores);
			
			RequestDispatcher rd = request.getRequestDispatcher("professor.jsp");
			rd.forward(request, response);
		}
	}

	private void cadastarProfessor(Professor p) throws SQLException, ClassNotFoundException {
		System.out.println(p);
	}

	private void alterarProfessor(Professor p) throws SQLException, ClassNotFoundException {
		System.out.println(p);
	}

	private void excluirProfessor(Professor p) throws SQLException, ClassNotFoundException {
		System.out.println(p.getCodigo());
	}

	private Professor buscarProfessor(Professor p) throws SQLException, ClassNotFoundException {
		p.setNome("Fulano");
		p.setTitulacao("Mestre");
		return p;
	}

	private List<Professor> listarprofessores() throws SQLException, ClassNotFoundException {
		List<Professor> professores = new ArrayList<>();
		
		Professor p1 = new Professor();
		p1.setCodigo(10);
		p1.setNome("Kauan");
		p1.setTitulacao("Doutor");
		
		Professor p2 = new Professor();
		p2.setCodigo(22);
		p2.setNome("Guilherme");
		p2.setTitulacao("Mestre");
		
		Professor p3 = new Professor();
		p3.setCodigo(10);
		p3.setNome("Tutu");
		p3.setTitulacao("Mestre");
		
		professores.add(p1);
		professores.add(p2);
		professores.add(p3);
		
		return professores;
	}
}

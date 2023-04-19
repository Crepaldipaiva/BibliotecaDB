package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.edu.unicid.model.Leitor;
import br.edu.unicid.util.ConnectionFactory;

public class LeitorDAO {

	private Leitor leitor;
	private Connection conn; 		//conecta com o banco de dados
	private PreparedStatement ps; 	//permite executar querys
	private ResultSet rs;			//tabela
	
	public LeitorDAO() throws Exception{
		try {
			conn = ConnectionFactory.getConnection();
			
		}catch(Exception erro) {
			throw new Exception("Erro " + erro.getMessage());
		}
	}
	
	public void salvar(Leitor leitor) throws Exception{
		try {
			String sql = "INSERT INTO Leitor(codLeitor, nomeLeitor, tipoLeitor)" 
					+ "values (?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, leitor.getCodLeitor());
			ps.setString(2, leitor.getNomeLeitor());
			ps.setString(3, leitor.getTipoLeitor());
			ps.executeUpdate();
		}catch(Exception erro) {
			throw new Exception("Erro " + erro.getMessage());
		}
	}
}
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Blog;
import model.PublicacaoColaborativa;

public class SubmissaoDAO  extends ConnectionFactory{

	PublicacaoColaborativa publicacaoColaborativa = new PublicacaoColaborativa();
	Blog blog = new Blog();
	
	
	public void publicacaoColaborativa(int idBlog, PublicacaoColaborativa publicacaoColaborativa){
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.
					prepareStatement("INSERT INTO Publicacao (tituloPublicacao, categoriaPublicacao, "
							+ "conteudoPublicacao, idBlog, notaPublicacao, statusPublicacao) VALUES (?,?,?,?,0,false)");
			pstm.setString(1, publicacaoColaborativa.getTituloPublicacao());
			pstm.setString(2, publicacaoColaborativa.getCategoriaPublicacao());
			pstm.setString(3, publicacaoColaborativa.getConteudoPublicacao());
			pstm.setInt(4, idBlog);
			pstm.execute();
			pstm.close();
			conexao.close();
				
		} catch (Exception e) {
			System.out.println("Erro adicionar Publicação Colaborativa");
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}

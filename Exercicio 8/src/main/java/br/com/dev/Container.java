package br.com.dev;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class Container {
	
	public Container() {

	}
	
	public void insert(User novoUsuario) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into usuario (name, pais, email) values (?, ?, ?)");
			p.setString(1, novoUsuario.getName());
			p.setString(2, novoUsuario.getPais());
			p.setString(3, novoUsuario.getEmail());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<User> getListUser(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<User> lista = new ArrayList<User>();
		try {
			PreparedStatement p = con.prepareStatement("select * from usuario");
			ResultSet r = p.executeQuery();			
			
			while (r.next()) {
				Integer id = r.getInt("id");
				String name = r.getString("name");
				String pais = r.getString("pais");
				String email = r.getString("email");
				User u = new User(name, pais, email);
				u.setId(id);
				lista.add(u);
			}
			r.close();
			p.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void delete(Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from usuario where id = ?");
			p.setInt(1, id);
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
	

			p.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void update(User updateUser) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update usuario set name = ?, pais = ?, email = ? where id = ?");
			p.setString(1, updateUser.getName());
			p.setString(2, updateUser.getPais());
			p.setString(3, updateUser.getEmail());
			p.setInt(4, updateUser.getId());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");

			
			p.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public User buscarUser(Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		User u = null;
		try {
			PreparedStatement p = con.prepareStatement("select * from usuario where id = ?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();			
			
			
			while (r.next()) {
				
				String name = r.getString("name");
				String pais = r.getString("pais");
				String email = r.getString("email");
				u = new User(name, pais, email);
				u.setId(id);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	

}



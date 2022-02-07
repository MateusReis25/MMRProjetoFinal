package br.com.dev;


public class User {
	
	private Integer id;
	private String name;
	private String pais;
	private String email;

	public User(String name, String pais, String email) {
		this.name = name;
		this.pais = pais;
		this.email = email;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getPais() {
		return this.pais;
	}
	
	public String toString() {
		return this.id + " - " + this.name + " - " + this.email + " - " + this.pais; 
	}
}

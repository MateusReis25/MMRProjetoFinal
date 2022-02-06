package br.com.dev;
import java.util.ArrayList;

//SIMULANDO UM BD
public class Container {

	private ArrayList<User> userList;
	private Integer idSequence;
	
	public Container() {
		super();
		userList = new ArrayList<User>();
		this.idSequence = 1;
	}	
	
	public void insert(User user) {
		user.setId(idSequence);
		this.userList.add(user);
		this.idSequence++;
	}	
	
	public ArrayList<User> selectAll(){
		return this.userList;
	}
	
	public void delete(int chuchu) {
		for (User u : this.userList) {
			if (u.getId() == chuchu) {
				this.userList.remove(u);
				break;
			}
		}
	}
	
	public void update(User user) {
		for (User u : this.userList) {
			if (u.getId() == user.getId()) {
				u.setEmail(user.getEmail());
				u.setNome(user.getNome());
				u.setPais(user.getPais());
				break;
			}
		}
	}
	
	public User selectById(Integer id){
		for (User u : this.userList) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}
	
}

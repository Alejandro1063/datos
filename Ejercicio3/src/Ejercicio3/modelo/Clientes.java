package Ejercicio3.modelo;

public class Clientes {

	private int customer_id;
	private String firstName;
	private String lastName;
	private String email;
	private Boolean active;
	
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Clientes [customer_id=" + customer_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", active=" + active + "]";
	}
	
	
}

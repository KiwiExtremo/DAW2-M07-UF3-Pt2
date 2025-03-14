
package cat.institutmarianao.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

//TODO Add Jakarta Persistence and validation annotations
@Entity
@Table(name = "students")
public class Student {

	@Id
	@Column(name = "dni")
	private String dni;

	@NotBlank
	@Size(max = 200)
	@Column(name = "name")
	private String name;

	@NotBlank
	@Size(max = 200)
	@Column(name = "surname")
	private String surname;

	@NotBlank
	@Size(max = 200)
	@Column(name = "email")
	private String email;

	// @formatter:off
	@NotEmpty
	@ManyToMany
	@JoinTable(
		name = "modules_students", 
		joinColumns = @JoinColumn(name = "student_dni"), 
		inverseJoinColumns = {
			@JoinColumn(
				name = "module_code", 
				referencedColumnName = "code"
			),
			@JoinColumn(
				name = "module_cycle_code",
				referencedColumnName = "cycle_code"
			)
		}
	)
	// @formatter:on
	private List<Module> modules;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni.toUpperCase();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cycle getCycle() {
		if ((modules == null) || modules.isEmpty()) {
			return null;
		}
		return modules.get(0).getCycle();
	}

	public List<Module> getModules() {
		if (modules == null) {
			modules = new ArrayList<>();
		}
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Student other)) {
			return false;
		}
		return Objects.equals(dni, other.dni);
	}
}

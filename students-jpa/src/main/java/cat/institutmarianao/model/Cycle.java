
package cat.institutmarianao.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//TODO Add Jakarta Persistence and validation annotations
@Entity
@Table(name = "cycles")
public class Cycle {

	@Id
	@Column(name = "code")
	private String code;

	@NotBlank
	@Size(max = 255)
	@Column(name = "name")
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Cycle other)) {
			return false;
		}
		return Objects.equals(code, other.code);
	}
}

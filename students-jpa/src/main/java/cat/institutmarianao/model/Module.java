
package cat.institutmarianao.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "modules")
public class Module {

	@Id
	@NotBlank
	@Column(name = "code")
	private String code;

	@Id
	@NotBlank
	@Column(name = "cycle_code")
	private String cycleCode;

	@NotBlank
	@Size(max = 255)
	@Column(name = "name")
	private String name;

	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "cycle_code", insertable = false, nullable = false, updatable = false)
	private Cycle cycle;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCycleCode() {
		return cycleCode;
	}

	public void setCycleCode(String cycle) {
		cycleCode = cycle;
	}

	public Cycle getCycle() {
		return cycle;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

	public String getName() {
		return name;
	}

	public void setName(String module) {
		name = module;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, cycleCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Module other)) {
			return false;
		}
		return Objects.equals(code, other.code) && Objects.equals(cycleCode, other.cycleCode);
	}
}

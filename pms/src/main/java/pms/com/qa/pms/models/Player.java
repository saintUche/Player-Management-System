package pms.com.qa.pms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Players")
@NoArgsConstructor
@AllArgsConstructor
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@Column(name="kit_number", nullable=false)
	@Size(min = 1, max = 2)
	@NotNull(message="cannot be null1")
	private String kitNumber;

	@Column(name="first_name", nullable=false)
	@Size(min = 2, max = 50)
	@NotNull(message="cannot be null2")
	private String firstName;

	@Column(name="last_name", nullable=false)
	@Size(min = 2, max = 50)
	@NotNull(message="cannot be null3")
	private String lastName;

	@Column(name="position", nullable=false)
	@Size(min = 1, max = 3)
	@NotNull(message="cannot be null4")
	private String position;
	
	@Column(name="age", nullable=false)
	@Min(1)
	@Max(110)
	@NotNull(message="cannot be nul5")
	private int age;
	
}

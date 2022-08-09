package pms.com.qa.pms.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="MatchData")
@NoArgsConstructor
@AllArgsConstructor
public class MatchData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name="playerID", referencedColumnName="ID", nullable=true)
//    @NotNull(message="cannot be null")
	private Player player; 

	@Column(name="num_of_goals", nullable=false)
	@NotNull(message="cannot be null2")
	private int numOfGoals;

	@Column(name="num_of_tackles", nullable=false)
	@NotNull(message="cannot be null3")
	private int numOfTackles;

	
}

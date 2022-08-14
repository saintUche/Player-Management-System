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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="fans")
@NoArgsConstructor
@AllArgsConstructor
public class Fans {

    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

    @OneToOne(cascade = CascadeType.MERGE, optional = true)
	@JoinColumn(name="player", referencedColumnName="ID", nullable=true)
	private Player player; 

	@Column(name="haters", nullable=false)
	private int haters;

	@Column(name="supporters", nullable=false)
	private int supporters;

    
}

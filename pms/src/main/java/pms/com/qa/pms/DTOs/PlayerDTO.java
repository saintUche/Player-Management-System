package pms.com.qa.pms.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
	
	@Getter
	@Setter
	private Long id;
	
	@Getter
	@Setter
	private String firstName;
	
	@Getter
	@Setter
	private String lastName;
	
    @Getter
	@Setter
	private String kitNumber;

	@Getter
	@Setter
	private String Position;

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Position == null) ? 0 : Position.hashCode());
		result = prime * result + age;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kitNumber == null) ? 0 : kitNumber.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerDTO other = (PlayerDTO) obj;
		if (Position == null) {
			if (other.Position != null)
				return false;
		} else if (!Position.equals(other.Position))
			return false;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kitNumber == null) {
			if (other.kitNumber != null)
				return false;
		} else if (!kitNumber.equals(other.kitNumber))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlayerDTO [Position=" + Position + ", age=" + age + ", firstName=" + firstName + ", id=" + id
				+ ", kitNumber=" + kitNumber + ", lastName=" + lastName + "]";
	}

	@Getter
	@Setter
	private int age;

	
}
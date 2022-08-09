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
	private String age;

	
}
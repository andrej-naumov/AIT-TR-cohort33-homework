package lv.naumov.lombook;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate lastUpdated;
	private boolean active;

}

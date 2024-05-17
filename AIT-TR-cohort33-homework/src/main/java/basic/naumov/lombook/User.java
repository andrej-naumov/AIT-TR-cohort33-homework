package basic.naumov.lombook;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate lastUpdated;
	private boolean active;

}

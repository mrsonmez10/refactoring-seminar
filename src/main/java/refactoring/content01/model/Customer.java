package refactoring.content01.model;

import java.time.OffsetDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Customer {
	private String name;
	private String surName;
	private OffsetDateTime birthDate;
	private String gender;
	private String customerNo;
}

package refactoring.content01.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import refactoring.content01.before.model.Channel;

@Getter
@Setter
@ToString
@Builder
public class Request {
	private boolean secure;
	private String code;
	private boolean rememberMe;
	private Customer customer;
	private Channel channel;
}

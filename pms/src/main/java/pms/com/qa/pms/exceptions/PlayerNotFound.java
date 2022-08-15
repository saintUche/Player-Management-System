package pms.com.qa.pms.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "player does not exist with that kit number")
public class PlayerNotFound extends EntityNotFoundException {

	private static final long serialVersionUID = 1988648763292245254L;

}
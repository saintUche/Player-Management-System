package com.qa.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "match data does not exist")
public class MatchDataNotFound extends EntityNotFoundException {

	private static final long serialVersionUID = 1988648763292245254L;

}

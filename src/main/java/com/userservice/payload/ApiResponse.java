package com.userservice.payload;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {

	@SuppressWarnings("unused")
	private String message;
	@SuppressWarnings("unused")
	private boolean success;
	@SuppressWarnings("unused")
	private HttpStatus status;

}

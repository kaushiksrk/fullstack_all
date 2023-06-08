package com.cgi.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorTO {
	private int statusCode;
	private String errorMsg;
	private long errorReportingTime;
	private LocalDate errorDate;
}

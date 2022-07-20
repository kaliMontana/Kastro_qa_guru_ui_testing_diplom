package com.youtube.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Waiting {
	SIX_SEC(
			6
	),
	SEVEN_SEC(
			7
	),
	EIGHT_SEC(
			8
	);

	private final long value;
}

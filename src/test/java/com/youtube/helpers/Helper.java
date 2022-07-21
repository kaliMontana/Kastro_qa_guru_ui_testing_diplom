package com.youtube.helpers;

import static org.slf4j.helpers.MessageFormatter.arrayFormat;

public class Helper {
	/**
	 * Получить String комментария
	 *
	 * @param message - текст сообщения с расставленными сслыками на параметры {}
	 * @param args    - параметры для текста сообщения
	 * @return - String
	 */
	public static String format(String message, Object... args) {
		return arrayFormat(message, args).getMessage();
	}
}

package com.youtube.dataProviders;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public enum TabHeadersData {

	ALL(
			"Все"
	),
	SITCOMS(
			"Ситкомы"
	),
	NOW_ON_AIR(
			"Сейчас в эфире"
	),
	SKETCH_SHOW(
			"Скетч-шоу"
	),
	MUSIC(
			"Музыка"
	),
	VIDEO_GAMES(
			"Видеоигры"
	),
	TOURIST_DESTINATIONS(
			"Туристические направления"
	),
	FOOTBALL(
			"Футбол"
	),
	TOURISM(
			"Туризм"
	),
	CARTOONS(
			"Мультфильмы"
	),
	NATURE(
			"Природа"
	),
	ACTION_AND_ADVENTURE(
			"Экшен и приключения"
	),
	PETS(
			"Домашние животные"
	),
	MINECRAFT(
			"Minecraft"
	),
	COOKING_SHOWS(
			"Кулинарные шоу"
	),
	COOKING(
			"Кулинария"
	),
	CRAFTS(
			"Ремесла"
	),
	LAST_PUBLISHED_VIDEOS(
			"Последние опубликованные видео"
	);

	//region ArrayList
	@Getter
	private static final List<String> tabsValuesList = new ArrayList<>();

	static {
		for (TabHeadersData tabHeadersData : TabHeadersData.values()) {
			tabsValuesList.add(tabHeadersData.value);
		}
	}
	// endregion ArrayList

	private final String value;
}

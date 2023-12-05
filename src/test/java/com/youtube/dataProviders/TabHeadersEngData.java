package com.youtube.dataProviders;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public enum TabHeadersEngData {

	ALL(
			"All"
	),
	LIVE(
			"Live"
	),
	GAMING(
			"Gaming"
	),
	MUSIC(
			"Music"
	),
	BOSSA_NOVA(
			"Bossa Nova"
	),
	PLAY_LIST(
			"Playlists"
	),

	CHILL_OUT_MUSIC(
			"Chill-out music"
	),
	SITCOMS(
			"Sitcoms"
	),
	AMBIENT_MUSIC(
			"Ambient Music"
	),
	HISTORY(
			"History"
	),
	PIANO(
			"Piano"
	),
	TOURIST_DESTINATION(
			"Tourist destinations"
	),
	TEAMS(
			"Teams"
	),
	CONVERSATION(
			"Conversation"
	),
	POP_MUSIC(
			"Pop Music"
	),
	CARS(
			"Cars"
	),
	KYGO(
			"Kygo"
	),
	GAME_SHOW(
			"Game shows"
	),
	BODYBUILDING(
			"Bodybuilding"
	),
	NATURE(
			"Nature"
	),
	RAPPING(
			"Rapping"
	),
	RECENTLY_UPLOAD(
			"Recently uploaded"
	),
	DEEP_HOUSE(
			"Deep House"
	),
	SKETCH_COMEDY(
			"Sketch comedy"
	),
	ELECTRONIC_MUSIC(
			"Electronic Music"
	),
	SCIENCE(
			"Science"
	),
	ACTION_ADVENTURE_GAMES(
			"Action-adventure games"
	),
	TRUCKS(
			"Trucks"
	),
	SPORTS_CARS(
			"Sports cars"
	),
	JINGLE_BELLS(
			"Jingle Bells"
	),
	FIREPLACES(
			"Fireplaces"
	),
	COOKING_SHOWS(
			"Cooking shows"
	),
	TELEVISION_SERIES(
			"Television series"
	),
	VISUAL_ARTS(
			"Visual arts"
	),
	NEWS(
			"News"
	),
	LEGOS(
			"Legos"
	),
	CHRISTMAS_CAROL(
			"Christmas carol"
	),
	COMEDY(
			"Comedy"
	),
	EMPTY(
			""
	);

	//region ArrayList
	@Getter
	private static final List<String> tabsValuesList = new ArrayList<>();

	static {
		for (TabHeadersEngData tabHeadersData : TabHeadersEngData.values()) {
			tabsValuesList.add(tabHeadersData.value);
		}
	}
	// endregion ArrayList

	private final String value;
}

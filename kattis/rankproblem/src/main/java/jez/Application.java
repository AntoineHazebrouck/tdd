package jez;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lombok.val;

public class Application {

    public static void main(String[] args) {
		record Game(String winner, String loser) {
		}
		
		val game1 = new Game("T4", "T1");
		val game2 = new Game("T3", "T1");
		val game3 = new Game("T5", "T3");
		// val game4 = new Game("T5", "T3");

		// val games = List.of(game1, game2);
		val games = List.of(game1, game2, game3);
		Map<String, Integer> teams = new HashMap<String, Integer>(Map.of("T1", 1, "T2", 2, "T3", 3, "T4", 4, "T5", 5));

		var currentTeams = teams;
		for (Game game : games) {
			// si le winner est deja au dessus du loser, rien ne change
			val winnerRank = currentTeams.get(game.winner());
			val loserRank = currentTeams.get(game.loser());
			val winnerAboveLoser = winnerRank < loserRank;
			
			if (winnerAboveLoser == false) {
				val increasedAllAboveWinner = currentTeams.entrySet()
					.stream()
					.map(entry -> {
						if (entry.getValue() <= winnerRank) entry.setValue(entry.getValue() - 1);
						return entry;
					})
					.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
				
				val setLoserToOldWinnerRank = increasedAllAboveWinner.entrySet().stream()
					.map(entry -> {
						if (entry.getKey().equals(game.loser())) {
							entry.setValue(winnerRank);
						}
						return entry;
					})
					.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

				currentTeams = setLoserToOldWinnerRank;
				System.out.println(setLoserToOldWinnerRank.entrySet().stream().sorted((leftTeam, rightTeam) -> leftTeam.getValue().compareTo(rightTeam.getValue())).toList());
			}
		}
		// System.out.println(teams.entrySet().stream().sorted((leftTeam, rightTeam) -> leftTeam.getValue().compareTo(rightTeam.getValue())).toList());
    }
}

package jez;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Data;

@Data
public class RankList
{
	private final List<Team> teams;

	public RankList(int nbTeams)
	{
		List<Team> temp = new ArrayList<>();
		for (int count = 1; count <= nbTeams; count++)
		{
			temp.add(new Team(count, count));
		}
		this.teams = Collections.unmodifiableList(temp);
	}

	private RankList(List<Team> teams) {
		this.teams = teams;
	}

	public Team getRank(int rank)
	{
		return teams.stream()
				.filter(aTeam -> aTeam.getRank() == rank)
				.findFirst()
				.get();
	}

	public Team getTeam(int team)
	{
		return teams.stream()
				.filter(aTeam -> aTeam.getTeam() == team)
				.findFirst()
				.get();
	}

	// public RankList createRoomForLoser(int winningTeam, int losingTeam) {
	// 	int winnersRank = getTeam(winningTeam).getRank();
	// 	int losersRank = getTeam(losingTeam).getRank();
	// 	List<Team> winnerAndAboveWinnerAndBelowLoser = teams.stream()
	// 			// .filter(team -> team.getRank() <= winnersRank && team.getRank() > losersRank)
	// 			.map(team -> {
					
	// 				if (team.getRank() <= winnersRank && team.getRank() > losersRank) {
	// 					return new Team(team.getRank() + 1, team.getTeam());
	// 				} else {
	// 					return team;
	// 				}
	// 			})
	// 			.toList();
	// 	return new RankList(winnerAndAboveWinnerAndBelowLoser);
	// }

	public RankList next(int winningTeam, int losingTeam)
	{
		int winnersRank = getTeam(winningTeam).getRank();
		int losersRank = getTeam(losingTeam).getRank();

		if (winnersRank < losersRank) // si le winner est deja au dessus dans le classement
		{
			return this;
		} else
		{
			// sinon
			// le winner + tout ceux au dessus (et en dessous du loser) montent de 1
			List<Team> winnerAndAboveWinnerAndBelowLoser = teams.stream()
				// .filter(team -> team.getRank() <= winnersRank && team.getRank() > losersRank)
				.map(team -> {
					
					if (team.getRank() <= winnersRank && team.getRank() > losersRank) {
						return new Team(team.getRank() - 1, team.getTeam());
					} else {
						return team;
					}
				})
				.toList();

			List<Team> loserTakesWinnersRank = winnerAndAboveWinnerAndBelowLoser.stream()
				.map(team -> {
					if (team.getTeam() == losingTeam) {
						return new Team(winnersRank, losingTeam);
					} else {
						return team;
					}
				})
				.toList();

				return new RankList(loserTakesWinnersRank);
		}
	}

	@Override
	public String toString() {
		return this.teams.stream()
			.sorted((leftTeam, rightTeam) -> Integer.compare(leftTeam.getRank(), rightTeam.getRank()))
			.toList()
			.toString();
	}
}

package jez;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class ApplicationTest {

    @Test
	void build_a_rank_list() {
		RankList rankList = new RankList(5);

		assertThat(rankList.getTeams().size()).isEqualTo(5);
		assertThat(rankList.getTeam(1)).isEqualTo(new Team(1, 1));
		assertThat(rankList.getTeam(5)).isEqualTo(new Team(5, 5));
		assertThat(rankList.getRank(1)).isEqualTo(new Team(1, 1));
		assertThat(rankList.getRank(5)).isEqualTo(new Team(5, 5));

	}

	// @Test
	// void creating_room_to_move_loser() {
	// 	RankList rankList = new RankList(5);
		
	// 	RankList rankList2 = rankList.createRoomForLoser(4, 1);

	// 	// assertThat(rankList2.getTeam(1).getRank()).isEqualTo(4);
	// 	assertThat(rankList2.getTeam(2).getRank()).isEqualTo(1);
	// 	assertThat(rankList2.getTeam(3).getRank()).isEqualTo(2);
	// 	assertThat(rankList2.getTeam(4).getRank()).isEqualTo(3);
	// 	assertThat(rankList2.getTeam(5).getRank()).isEqualTo(5);
	// }

	@Test
	void build_a_new_rank_list_from_a_game() {
		RankList rankList = new RankList(5);
		
		RankList rankList2 = rankList.next(4, 1);
		assertThat(rankList2.getTeam(1).getRank()).isEqualTo(4);
		assertThat(rankList2.getTeam(2).getRank()).isEqualTo(1);
		assertThat(rankList2.getTeam(3).getRank()).isEqualTo(2);
		assertThat(rankList2.getTeam(4).getRank()).isEqualTo(3);
		assertThat(rankList2.getTeam(5).getRank()).isEqualTo(5);
	}

	@Test
	void should_be_equal_if_winner_is_already_above() {
		RankList rankList = new RankList(5);
		
		RankList rankList2 = rankList.next(4, 1);
		RankList rankList3 = rankList2.next(3, 1);
		assertThat(rankList3.getTeam(1).getRank()).isEqualTo(4);
		assertThat(rankList3.getTeam(2).getRank()).isEqualTo(1);
		assertThat(rankList3.getTeam(3).getRank()).isEqualTo(2);
		assertThat(rankList3.getTeam(4).getRank()).isEqualTo(3);
		assertThat(rankList3.getTeam(5).getRank()).isEqualTo(5);
	}
}

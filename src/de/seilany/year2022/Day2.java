package de.seilany.year2022;

import java.util.ArrayList;
import java.util.List;

import de.seilany.question.Question;

/**
 * @author Taimaz Seilany <br>
 *         03.12.2022
 */
public class Day2 extends Question {

	private List<String[]> values;

	public Day2() {
		super();
		values = new ArrayList<>();
	}


	@Override
	protected void collectRowData() throws Exception {
		String[] data = line.split(" ");
		values.add(data);
	}


	@Override
	protected void part1() {
		long totalNormalScore = 0;
		for (String[] stringArray : values) {
			long score = getNormalScore(stringArray[0], stringArray[1]);
			totalNormalScore += score;
		}
		System.out.println(totalNormalScore);
	}


	@Override
	protected void part2() {
		long totalExpectedScore = 0;
		for (String[] stringArray : values) {
			long expectedScore = getExpectedScore(stringArray[0], stringArray[1]);
			totalExpectedScore += expectedScore;
		}
		System.out.println(totalExpectedScore);
	}


	@Override
	protected void postCollectData() throws Exception {
	}


	private long getExpectedScore(String paramElf, String paramMe) {
		Move elf = Move.getValue(paramElf);
		Move me = elf.getExpected(paramMe);
		return getScore(elf, me);
	}


	private long getNormalScore(String paramElf, String paramMe) {
		Move elf = Move.getValue(paramElf);
		Move me = Move.getValue(paramMe);
		return getScore(elf, me);
	}


	// Lose 0 draw 3 Win 6
	private long getScore(Move elf, Move me) {
		long result = 0;
		if (elf.equals(me)) {
			result = 3;
		} else if ((Move.ROCK.equals(me) && Move.SCISSOR.equals(elf)) || (Move.PAPER.equals(me) && Move.ROCK.equals(elf)) || (Move.SCISSOR.equals(me) && Move.PAPER.equals(elf))) {
			result = 6;
		} else {
			result = 0;
		}
		return result + me.getScore();
	}

	public enum Move {

		ROCK("A", "X", 1), PAPER("B", "Y", 2), SCISSOR("C", "Z", 3);

		public final String name1;
		public final String name2;
		public final long score;

		private Move(String paramLabel1, String paramLabel2, long paramScore) {
			this.name1 = paramLabel1;
			this.name2 = paramLabel2;
			this.score = paramScore;
		}


		public long getScore() {
			return this.score;
		}


		public Move getExpected(String request) {
			switch (request.toLowerCase()) {
			// LOSE
			case "x":
				if (this.equals(ROCK)) {
					return SCISSOR;
				} else if (this.equals(PAPER)) {
					return ROCK;
				}
				return PAPER;

			// DRAW
			case "y":
				return this;

			// WIN
			case "z":
				if (this.equals(ROCK)) {
					return PAPER;
				} else if (this.equals(PAPER)) {
					return SCISSOR;
				}
				return ROCK;
			}
			return null;
		}


		public static Move getValue(String paramLabel) {
			for (Move element : Move.values()) {
				if (paramLabel.equals(element.name1) || paramLabel.equals(element.name2)) {
					return element;
				}
			}
			return null;
		}
	}

}

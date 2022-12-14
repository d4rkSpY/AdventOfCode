package de.seilany.year2022;

import java.util.ArrayList;
import java.util.List;

import de.seilany.question.Question;

/**
 * @author Taimaz Seilany <br>
 *         07.12.2022
 */
public class Day3 extends Question {

	private List<String[]> values;

	public Day3() {
		super();
		values = new ArrayList<>();
	}


	@Override
	protected void postCollectData() throws Exception {
	}


	@Override
	protected void collectRowData() throws Exception {
		String firstValue = line.substring(line.length() / 2);
		String secondValue = line.substring(firstValue.length() + 1, line.length());
		values.add(new String[] {firstValue, secondValue});
	}


	@Override
	protected void part1() {
		// TODO Auto-generated method stub
	}


	@Override
	protected void part2() {
		// TODO Auto-generated method stub

	}


	private int getCode(char paramChar) {
		int charCode = (int)paramChar;
		if (charCode >= 97) {
			return charCode - 96;
		} else {
			return charCode - 38;
		}
	}

}

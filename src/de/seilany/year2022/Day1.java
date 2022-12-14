package de.seilany.year2022;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import de.seilany.question.Question;

/**
 * @author Taimaz Seilany <br>
 *         03.12.2022
 */
public class Day1 extends Question {

	private List<Long> values;
	private Long currentValue;

	public Day1() {
		super();
		values = new ArrayList<>();
	}


	@Override
	protected void collectRowData() throws Exception {
		if (line.isBlank()) {
			values.add(currentValue);
			currentValue = 0L;
		} else {
			currentValue += Long.parseLong(line);
		}
	}


	@Override
	protected void part1() {
		System.out.println(values.get(0));
	}


	@Override
	protected void part2() {
		System.out.println(values.get(0) + values.get(1) + values.get(2));
	}


	@Override
	protected void postCollectData() throws Exception {
		values.sort(new Comparator<Long>() {

			@Override
			public int compare(Long paramO1, Long paramO2) {
				return Long.compare(paramO2, paramO1);
			}
		});
	}

}

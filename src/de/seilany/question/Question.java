package de.seilany.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Taimaz Seilany <br>
 *         07.12.2022
 */
public abstract class Question {

	protected final Path filePath;
	protected String line;
	private boolean dataCollected;

	public Question() {
		String packageName = this.getClass().getPackageName();
		int lastIndex = packageName.lastIndexOf(".");
		if (lastIndex > 0) {
			lastIndex++;
		}
		filePath = Paths.get("./inputs", packageName.substring(lastIndex, packageName.length()), this.getClass().getSimpleName());
		line = "";
	}


	private void collectData() throws Exception {
		dataCollected = true;
		line = "";
		try (BufferedReader bufferedReader = Files.newBufferedReader(filePath)) {
			while ((line = bufferedReader.readLine()) != null) {
				collectRowData();
			}
		}
		postCollectData();
	}


	protected abstract void postCollectData() throws Exception;


	protected abstract void collectRowData() throws Exception;


	public void solve() throws Exception {
		solvePart1();
		solvePart2();
	}


	private void solvePart1() throws Exception {
		if (!dataCollected) {
			collectData();
		}
		System.out.println(this.getClass().getSimpleName() + " Part 1:");
	};


	protected abstract void part1();


	private void solvePart2() throws Exception {
		if (!dataCollected) {
			collectData();
		}
		System.out.println(this.getClass().getSimpleName() + " Part 2:");
	};


	protected abstract void part2();


	public void showQuestion() throws IOException {
		if (Files.exists(filePath)) {
			System.out.println("Input " + this.getClass().getSimpleName() + " :");
			System.out.println("======================================");
			try (BufferedReader bufferedReader = Files.newBufferedReader(filePath)) {
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println(line);
				}
				System.out.println("======================================");
			}
		} else {
			System.err.println("File doesnt exist! -> " + filePath.toString());
		}
	}

}

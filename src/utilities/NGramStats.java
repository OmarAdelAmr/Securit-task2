package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public abstract class NGramStats {
	HashMap<String, Double> probMap = new HashMap<String, Double>();
	double floorValue = 0.00001;
	Long gramsCount = 0l;
	int keyLength;
	String fileName;

	public NGramStats(String fileName) {
		this.fileName = fileName;
		fillProbMap();
		updateProbMap();
	}

	private void fillProbMap() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));

			while (br.ready()) {
				String line = br.readLine();
				String[] quadGram = line.split(" ");
				probMap.put(quadGram[0], new Double(quadGram[1]));
				gramsCount += new Integer(quadGram[1]);
			}

			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			System.out.println("Input Output Exception");
		}
	}

	public abstract void updateProbMap();

	public abstract double getScore(String txt);

}

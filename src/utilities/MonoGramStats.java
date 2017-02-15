package utilities;

public class MonoGramStats extends NGramStats {

	public MonoGramStats() {
		super("english_monograms.txt");
		this.keyLength = 1;
	}

	@Override
	public void updateProbMap() {
		for (String ngram : probMap.keySet()) {
			double probability = (probMap.get(ngram) / gramsCount);
			probMap.put(ngram, probability);
		}
	}

	@Override
	public double getScore(String txt) {
		double score = 0;

		int i = 0;
		int txtLength = txt.length();

		while (i <= txtLength - 1) {
			Character monoGram = txt.charAt(i);
			Double prob = probMap.get("" + monoGram);
			if (prob != null) {
				score += (prob / txtLength);
			} else {
				score += floorValue;
			}
			i++;
		}
		return score;
	}

}

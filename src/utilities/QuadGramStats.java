package utilities;

public class QuadGramStats extends NGramStats {

	public QuadGramStats() {
		super("english_quadgrams.txt");
		this.keyLength = 4;
	}

	@Override
	public void updateProbMap() {
		for (String ngram : probMap.keySet()) {
			double probability = Math.log10((probMap.get(ngram) / gramsCount));
			probMap.put(ngram, probability);
		}
	}

	@Override
	public double getScore(String txt) {
		double score = 0;

		int i = 0;
		int txtLength = txt.length();

		while (i + keyLength <= txtLength - 1) {
			String quadGram = txt.substring(i, i + keyLength);
			Double prob = probMap.get(quadGram);
			if (prob != null) {
				score += prob;
			} else {
				score += floorValue;
			}
			i++;
		}

		return score;
	}

}

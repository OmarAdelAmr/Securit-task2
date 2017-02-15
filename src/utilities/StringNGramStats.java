package utilities;

/**
 * A class that provides the matching score of a given text based on the ngrams
 * frequency analysis of english language.
 */
public class StringNGramStats {
	private static MonoGramStats monoStats = new MonoGramStats();
	private static QuadGramStats quadStats = new QuadGramStats();

	/**
	 * Method to get the matching score between the monograms of the given
	 * string and the monograms frequency analysis of the english language.
	 * 
	 * @param txt
	 *            that represents the input string
	 * @return double that represents the matching score based on statistics of
	 *         monograms
	 */
	public static double getMonoGramStats(String txt) {
		return monoStats.getScore(txt);
	}

	/**
	 * Method to get the matching score between the quadgrams of the given
	 * string and the quadgrams frequency analysis of the english language.
	 * 
	 * @param txt
	 *            that represents the input string
	 * @return double that represents the matching score based on statistics of
	 *         quadgrams
	 */
	public static double getQuadGramStats(String txt) {
		return quadStats.getScore(txt);
	}

}

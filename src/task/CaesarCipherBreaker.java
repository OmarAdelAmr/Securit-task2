package task;

import utilities.StringNGramStats;

public class CaesarCipherBreaker implements CipherBreaker
{
	public String cipheredText;
	public String key;
	public String plain_text;

	@Override
	public void setCipherText(String text)
	{
		this.cipheredText = text;

	}

	@Override
	public String getPlainText()
	{
		// TODO Auto-generated method stub

		return plain_text;
	}

	@Override
	public String getKey()
	{
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public void decipherText()
	{
		double max_so_far = -100000.0;
		int temp_key = 0;
		String result_string = "";
		for (int i = 0; i < 26; i++)
		{
			String res = "";
			for (int j = 0; j < cipheredText.length(); j++)
			{
				char temp = cipheredText.charAt(j);
				int new_val = temp - i;
				if (new_val < 65)
				{
					// new_val = 90 - (65 - new_val);
					new_val += 26;
				}
				res += (char) new_val;
			}

			double eval_res = StringNGramStats.getMonoGramStats(res);
			if (eval_res > max_so_far)
			{
				temp_key = i;
				result_string = res;
				max_so_far = eval_res;
			}

		}
		plain_text = result_string;
		key = temp_key + "";
	}

	public static void main(String[] args)
	{
		CaesarCipherBreaker y = new CaesarCipherBreaker();
		y.setCipherText("DWZGDZQZOCVODHVBDIVODJIDNNOMJIBZMOCVIFIJRGZYBZOCVOHTOCDNHJMZKJOZIOOC"
				+ "VICDNOJMTOCVOYMZVHNVMZHJMZKJRZMAPGOCVIAVXONOCVOCJKZVGRVTNOMDPHKCNJQZMZSKZMDZI"
				+ "XZOCVOGVPBCOZMDNOCZJIGTXPMZAJMBMDZAVIYDWZGDZQZOCVOGJQZDNNOMJIBZMOCVIYZVOC");
		y.decipherText();
		System.out.println(y.plain_text);

	}

	@Override
	public int computeKeyLength()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}

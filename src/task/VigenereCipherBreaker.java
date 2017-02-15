package task;

public class VigenereCipherBreaker implements CipherBreaker
{

	private int key_length;
	private String cipherText;
	private String plainText;
	private String key;

	@Override
	public void setCipherText(String text)
	{
		this.cipherText = text;
	}

	@Override
	public int computeKeyLength()
	{
		int first_key_more_peek = -1;
		A: for (int i = 1; i <= 20; i++)
		{
			double IC = 0.0;
			String[] subString_arr = new String[i];
			for (int j = 0; j < subString_arr.length; j++)
			{
				subString_arr[j] = "";
			}
			int counter = 0;
			for (int j = 0; j < cipherText.length(); j++)
			{
				if (counter >= subString_arr.length)
				{
					counter = 0;
				}
				subString_arr[counter] = subString_arr[counter] + cipherText.charAt(j);
				counter++;
			}

			for (int j = 0; j < subString_arr.length; j++)
			{
				IC += calculate_ic(subString_arr[j]);
			}

			double avg_ic = IC / i;
			if (avg_ic > 0.055)
			{
				first_key_more_peek = i;
				break A;
			}

		}
		key_length = first_key_more_peek;
		return key_length;
	}

	public double calculate_ic(String input)
	{
		double res = 0.0;
		String remove_dup = "";
		for (int i = 0; i < input.length(); i++)
		{
			if (!remove_dup.contains(input.charAt(i) + ""))
			{
				remove_dup += input.charAt(i) + "";
			}
		}

		for (int i = 0; i < remove_dup.length(); i++)
		{
			String current_char = remove_dup.charAt(i) + "";
			int char_counter = 0;
			for (int j = 0; j < input.length(); j++)
			{
				if ((input.charAt(j) + "").equals(current_char))
				{
					char_counter++;
				}
			}
			res += char_counter * (char_counter - 1);
		}
		res /= (input.length() * (input.length() - 1));
		return res;
	}

	@Override
	public String getPlainText()
	{
		return plainText;
	}

	@Override
	public String getKey()
	{
		return key;
	}

	@Override
	public void decipherText()
	{
		CaesarCipherBreaker caesarCipher = new CaesarCipherBreaker();
		String[] subString_arr = new String[key_length];
		String temp_key = "";
		String temp_plain = "";
		for (int j = 0; j < subString_arr.length; j++)
		{
			subString_arr[j] = "";
		}
		int counter = 0;
		for (int j = 0; j < cipherText.length(); j++)
		{
			if (counter >= subString_arr.length)
			{
				counter = 0;
			}
			subString_arr[counter] = subString_arr[counter] + cipherText.charAt(j);
			counter++;
		}

		for (int i = 0; i < subString_arr.length; i++)
		{
			caesarCipher.setCipherText(subString_arr[i]);
			caesarCipher.decipherText();
			int temp_key2 = Integer.parseInt(caesarCipher.getKey());
			temp_key += (char) ('A' + temp_key2) + "";
			subString_arr[i] = caesarCipher.getPlainText();

		}

		for (int i = 0; i < subString_arr[0].length(); i++)
		{
			for (int j = 0; j < subString_arr.length; j++)
			{
				if (i < subString_arr[j].length())
				{
					temp_plain += subString_arr[j].charAt(i);
				}
			}
		}

		key = temp_key;
		plainText = temp_plain;
	}

}

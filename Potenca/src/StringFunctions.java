
public class StringFunctions 
{
	public String preZero(String value, int length) 
	{
		String sValue=""+value;
		while (sValue.length() < length)
		{
			sValue="0"+sValue;
		}
		return sValue;
	}

}

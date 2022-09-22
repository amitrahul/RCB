

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FPlayers {

	@Test
	public void FPlayers() throws IOException, ParseException, Throwable
	
	{
	
		JSONParser parser = new JSONParser();

		FileReader reader = new FileReader("./src/test/resources/RCBTeams.json");

		Object obj = parser.parse(reader);

		JSONObject rcb= (JSONObject) obj;

		JSONArray array = (JSONArray) rcb.get("player");

		int count = 0;
		int fcount = 0;

		for (int i = 0; i < array.size(); i++)
		{
			JSONObject player = (JSONObject) array.get(i);

			String country = (String) player.get("country");

			if (country.equalsIgnoreCase("India"))
			{
				count++;
			} else
			{
				fcount++;
			}
		}
		System.out.println("India Players  " + count);
		System.out.println("Foreign Players " + fcount);

		  Assert.assertEquals(4, fcount);
		int expect = 4;

		if (expect== fcount)
		{
			System.out.println("In RCB there is : " + fcount + " foreign Players");
		}	
	
	
}
}
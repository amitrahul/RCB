

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;
public class WicketKeeper {

	@Test
	public void WicketKeeper() throws IOException, ParseException, Throwable
	{

		JSONParser parser = new JSONParser();

		FileReader reader = new FileReader("./src/test/resources/RCBTeams.json");

		Object obj = parser.parse(reader);

		JSONObject rcb= (JSONObject) obj;

		JSONArray array = (JSONArray) rcb.get("player");

		int WicketKeeper = 0;

		for (int i = 0; i < array.size(); i++)
		{
			JSONObject player = (JSONObject) array.get(i);

			String role = (String) player.get("role");

			if (role.equalsIgnoreCase("Wicket-keeper"))
			{
				WicketKeeper++;

			}
		}
		System.out.println( WicketKeeper + " WicketKeeper");
		int expect = 1;
		Assert.assertEquals(expect, WicketKeeper);
	}
	
	
}

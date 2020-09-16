package Backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import Bowling.BowlingData;
import Bowling.BowlingDataBlok;
import Bowling.BowlingPointSaet;
import Bowling.ReturTekst;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Get {

	public Get() {
//		super();
	}
  	
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject laesJsonFraUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public BowlingDataBlok laesJsonFraUrl() throws IOException, JSONException {

		JSONObject json = laesJsonFraUrl("http://13.74.31.101/api/points");
		JSONArray points = json.getJSONArray("points");
		BowlingDataBlok bowlingDataBlok = new BowlingDataBlok();
		
        if (points.length() > 11) {
        	ReturTekst returTekst = new ReturTekst("Modtaget pointsæt for lang",200); 
        	bowlingDataBlok.setReturTekst(returTekst);
        	return bowlingDataBlok;
        }
        
		BowlingPointSaet[] bowlingPointSaetList = new BowlingPointSaet[points.length()]; 
        for (int y=0; y<points.length(); y++){

        	int value1 = Integer.parseInt(points.getJSONArray(y).get(0).toString());
        	int value2 = Integer.parseInt(points.getJSONArray(y).get(1).toString());
        	BowlingPointSaet bowlingPointSaet = new BowlingPointSaet(value1, value2);
        	ReturTekst returTekst = bowlingPointSaet.ValidateBowlingSaetVaerdier(bowlingPointSaet, y); 
        	if (returTekst.getFejlNr() != 0  ) {
        		bowlingDataBlok.setReturTekst(returTekst);
        		return bowlingDataBlok;
        	}
        	bowlingPointSaetList[y] = bowlingPointSaet;
        }
		BowlingData bowlingData = new BowlingData((json.get("token")).toString(), bowlingPointSaetList);
        bowlingDataBlok.setBowlingData(bowlingData);		
    	ReturTekst returTekst = new ReturTekst("OK",0); 
    	bowlingDataBlok.setReturTekst(returTekst);
		return bowlingDataBlok;
	}
}

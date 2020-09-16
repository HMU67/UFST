package Backend;

import org.apiguardian.api.API;
import org.json.HTTP;
import org.json.JSONObject;
import Bowling.BowlingDataBlok;
import Bowling.BowlingPointSaet;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
//import javax.xml.ws.spi.http.HttpHandler;
import java.io.OutputStreamWriter;

public class Post {
	
	private String token;
    private int[] bowlingPoint;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int[] getBowlingPoint() {
		return bowlingPoint;
	}

	public void setBowlingPoint(int[] bowlingPoint) {
		this.bowlingPoint = bowlingPoint;
	}

	public Post() {
		
	}
	
	public void postPointResultaer (String token, int[] bowlingPoint) {
		try {
			JSONObject msg = new JSONObject();
			msg.put("token", token);
			msg.put("points", bowlingPoint);
			URL url=new URL("http://13.74.31.101/api/points");

			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setDoInput(true);
			httpCon.setUseCaches(false);
			httpCon.setRequestMethod("POST");
			httpCon.connect();
			OutputStream os = httpCon.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			osw.write(msg.toString());
			osw.flush();
			osw.close();    
		} catch (Exception e) {
			
		}
	}
}

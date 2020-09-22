package Backend;

import org.json.JSONObject;
import org.json.JSONWriter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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

			URL url=new URL("http://13.74.31.101/api/points");
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setRequestProperty("Content-Type", "application/json; utf-8");
			httpCon.setRequestProperty("Accept", "application/json");
			httpCon.setDoOutput(true);
			JSONObject msg = new JSONObject();
			msg.put("token", token);
			msg.put("points", bowlingPoint);

			try(OutputStream os = httpCon.getOutputStream()){
			    byte[] input = msg.toString().getBytes("utf-8");
			    os.write(input, 0, input.length);			
			}

			try(BufferedReader br = new BufferedReader(
					  new InputStreamReader(httpCon.getInputStream(), "utf-8"))) {
					    StringBuilder response = new StringBuilder();
					    String responseLine = null;
					    while ((responseLine = br.readLine()) != null) {
					        response.append(responseLine.trim());
					    }
					    System.out.println(response.toString());
					}

		} catch (Exception e) {
			
		}
	}
}

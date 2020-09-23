package Backend;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Post {

	public String postPointResultater(String token, int[] bowlingPoint) {
		String svar = new String();
		try {
			URL url = new URL("http://13.74.31.101/api/points");
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setRequestProperty("Content-Type", "application/json; utf-8");
			httpCon.setRequestProperty("Accept", "application/json");
			httpCon.setDoOutput(true);
			JSONObject msg = new JSONObject();
			msg.put("token", token);
			msg.put("points", bowlingPoint);

			try (OutputStream os = httpCon.getOutputStream()) {
				byte[] input = msg.toString().getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			try (BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				svar = response.toString();
			}

		} catch (Exception e) {

		}
		return svar;
	}
}

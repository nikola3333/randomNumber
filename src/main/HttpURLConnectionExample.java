package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import controller.RandomizeNumbers;

import java.net.HttpURLConnection;
import java.net.URL;


public class HttpURLConnectionExample {
	
	private final String USER_AGENT = "Mozilla/5.0";
	public RandomizeNumbers rn = new RandomizeNumbers();
	
	// HTTP GET request
		public void sendGet(Integer num, Integer min, Integer max) throws Exception {

			//url koji gadjam
			String url = "https://www.random.org/integers/?num="+num+"&min="+min+"&max="+max+"&col=" + num + "&base=10&format=plain&rnd=new";
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");

			//request header
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//ispis responsa
			System.out.println(response.toString());
			
			//prebacujemo respons u string i tako saljem na obradjivanje  u RandomizeNumbers
			String resp = response.toString();
			rn.handleResponse(resp);

		}

}

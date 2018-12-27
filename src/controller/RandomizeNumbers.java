package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import main.HttpURLConnectionExample;


public class RandomizeNumbers{

	public LineChart_AWT bc = new LineChart_AWT("");
	
	//dobija num, min i max
	public void doRandomize(String string1,String string2,String string3) throws Exception {
		
	HttpURLConnectionExample http = new HttpURLConnectionExample();
	
	Integer num = Integer.valueOf(string1);
	Integer min = Integer.valueOf(string2);
	Integer max = Integer.valueOf(string3);
	
	if(max>min)
	http.sendGet(num, min, max);
	else
	JOptionPane.showMessageDialog(null, "Max nije veci od min!");
	
	}
	
	public void handleResponse(String response) {
		
		//ArrayList<Integer> brojevi  = new ArrayList<Integer>();
		ArrayList<String> stringBrojevi  = new ArrayList<String>();
		
		String[] numbers = response.split("	");
		
		/*for (String t : numbers) {
			brojevi.add(Integer.valueOf(t));
		}*/
		
		for (String t : numbers) {
			stringBrojevi.add(t);
		}
		
		//u mapu kao kljuc stavljam broj, a kao value broj ponavljanja tog broja
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (String temp : stringBrojevi) {
			Integer count = map.get(temp);
			map.put(temp, (count == null) ? 1 : count + 1);
		}
		printMap(map);
		bc.LineChart_AWT(map);
		
	}
	
	//samo za ispis mape
	public static void printMap(Map<String, Integer> map){

		int valueZbir = 0;
		System.out.println("\nIspis mape:");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : "
				+ entry.getValue());
		}
		
		System.out.println("\nIspis value:");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			valueZbir+=entry.getValue();
			
		}
		System.out.println("value zbir:" + valueZbir);
	  }
	
	
}

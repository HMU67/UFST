package Startup;

import java.io.IOException;
import Backend.Get;
import Backend.Post;

import org.json.JSONException;

import Bowling.ReturTekst;
import Bowling.Bowling;
import Bowling.BowlingDataBlok;

public class BowlingStartup {
	public static void main(String[] args) throws IOException, JSONException {
		for (int i=0; i<50; i++) {
			Get jsonReader = new Get();
			BowlingDataBlok bowlingDataBlok = jsonReader.hentDataFraUrl();
		
			if (bowlingDataBlok.getReturTekst().getFejlNr() != 0) {
				System.out.println(bowlingDataBlok.getReturTekst().getFejlNr());;
				System.out.println(bowlingDataBlok.getReturTekst().getFejlTekst());;
				break;
			}
		
			Bowling bowlingData = bowlingDataBlok.getBowlingData();
			ReturTekst returTekst = bowlingData.ValidateBowlingSaetListe(bowlingData.getBowlingPointListe());
			if (returTekst.getFejlNr() != 0) {
				System.out.println(returTekst.getFejlNr());;
				System.out.println(returTekst.getFejlTekst());;
				break;
			}
			int[] bowlingPoint = bowlingData.BeregnBowlingPoint(bowlingData.getBowlingPointListe());
			Post postResult = new Post();
	    	String svar = postResult.postPointResultater(bowlingData.getToken(), bowlingPoint);
	    	System.out.println(svar);
		}		
	}
}

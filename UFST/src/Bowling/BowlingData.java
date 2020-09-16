package Bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BowlingData {

	private String token;
    private BowlingPointSaet[] bowlingPointSaet;
	
	public BowlingData() {
		super();
	}
	
    public BowlingData(String token, BowlingPointSaet[] bowlingPointSaet) {
		super();
		this.token = token;
        this.bowlingPointSaet = bowlingPointSaet;
	}

	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public BowlingPointSaet[] getBowlingPointListe() {
		return bowlingPointSaet;
	}

	public void setBowlingPointListe(BowlingPointSaet[] bowlingPointListe) {
		this.bowlingPointSaet = bowlingPointListe;
	}

	public ReturTekst ValidateBowlingSaetListe (BowlingPointSaet[] bowlingPointListe) {
		
		ReturTekst returTekst = new ReturTekst();
        // hvis der er modtaget 11 points�t skal det 10. points�t best� af en sp�rre eller en strike 
        if (bowlingPointListe.length == 10 && 
        		((bowlingPointListe[9].getPoint1() + bowlingPointListe[9].getPoint2() != 10) ||
        		 (bowlingPointListe[9].getPoint1() != 10))){
            returTekst.setFejlNr(301);
            returTekst.setFejlTekst("Det 10. points�t skal best� af en sp�rre eller strike");
            return returTekst;
		}
        
        returTekst.setFejlNr(0);
        returTekst.setFejlTekst("OK");
		return returTekst;
	}
	
	public int[] BeregnBowlingPoint ( BowlingPointSaet[] bowlingPointSaet) {
		
		int strikesIRaekke = 0;
		Boolean spaerre = false;
		int pointNummer = 0;
		int[] points = new int[10];
        int forrigePointNr = 0;
        
		for (int i=0; i < bowlingPointSaet.length; i++) {

			if ( (i > 0 && i < 10) && (pointNummer > 0)) 
				forrigePointNr = 1;
			else
				forrigePointNr = 0;

// her h�ndteres strike
			if (bowlingPointSaet[i].getPoint1() == 10) { 
				strikesIRaekke +=1;
				if (strikesIRaekke == 3 && i < 10) {
					strikesIRaekke -=1;
					points[pointNummer] = points[pointNummer - forrigePointNr] + 30; 
					pointNummer++;
				}
				
				if (strikesIRaekke == 3 && i == 10) {
					if(bowlingPointSaet[i].getPoint1() == 10) {
						points[pointNummer] = points[pointNummer - 1] + 30;
						pointNummer++;
					}
					if(bowlingPointSaet[i].getPoint2() == 10) {
						points[pointNummer] = points[pointNummer - 1] + 30;
					}
				}
				if (spaerre) {
					points[pointNummer] = points[pointNummer - 1] + 20;
					spaerre = false;
					pointNummer++;
				}
			}
// her h�ndteres sp�rre 
			else if ( bowlingPointSaet[i].getPoint1() + bowlingPointSaet[i].getPoint2() == 10){
				if (strikesIRaekke > 0) {
					switch (strikesIRaekke) {
					case 1:  points[pointNummer] = points[pointNummer - forrigePointNr] + 20;
							 strikesIRaekke = 0;
							 pointNummer++;
							 break;
					case 2:  points[pointNummer] = points[pointNummer - forrigePointNr] + 20 + bowlingPointSaet[i].getPoint1();
							 pointNummer++;
							 points[pointNummer] = points[pointNummer - forrigePointNr] + 20 ;
	  						 strikesIRaekke = 0;
	  						 pointNummer++;
	  						 break;
					default: break;		
					}
				}
				if (spaerre) {
					points[pointNummer] = points[pointNummer - forrigePointNr] + 10 + bowlingPointSaet[i].getPoint1();
					pointNummer++;
				}
				spaerre = true;
			}
			else {
// her h�ndteres points�t som ikke udg�r strike eller sp�rre
				if (strikesIRaekke > 0) {
					switch (strikesIRaekke) {
					case 1:  points[pointNummer] = points[pointNummer - forrigePointNr] + 20;
							 pointNummer++;
							 strikesIRaekke = 0;
							 break;
					case 2:  points[pointNummer] = points[pointNummer - forrigePointNr] + 20 + bowlingPointSaet[i].getPoint1() + bowlingPointSaet[i].getPoint2();
							 pointNummer++;
							 points[pointNummer] = points[pointNummer - forrigePointNr] + 10 + bowlingPointSaet[i].getPoint1() + bowlingPointSaet[i].getPoint2();
							 pointNummer++;
							 strikesIRaekke = 0;
							 break;
					default: break;		
					}
				}
				if (spaerre) {
				    spaerre = false;
					points[pointNummer] = points[pointNummer - forrigePointNr] + 10 + bowlingPointSaet[i].getPoint1();
				    pointNummer++;
				    points[pointNummer] = points[pointNummer - forrigePointNr] + bowlingPointSaet[i].getPoint1() + bowlingPointSaet[i].getPoint2();
				    pointNummer++;
				}
				else {
					points[pointNummer] = points[pointNummer - forrigePointNr] + bowlingPointSaet[i].getPoint1() + bowlingPointSaet[i].getPoint2();
					pointNummer++;
				}
			}
		}
		if (bowlingPointSaet.length > 10) {
			return Arrays.copyOfRange(points, 0, bowlingPointSaet.length - 1);
		}
		else {
			return Arrays.copyOfRange(points, 0, bowlingPointSaet.length );
		}
	}
}


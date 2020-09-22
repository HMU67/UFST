package Bowling;

import java.util.Arrays;

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
		
        // hvis der er modtaget 11 pointsæt skal det 10. pointsæt bestå af en spærre eller en strike 
        if (bowlingPointListe.length == 11 && 
        		((bowlingPointListe[9].getPoint1() + bowlingPointListe[9].getPoint2() == 10) ||
        		 (bowlingPointListe[9].getPoint1() == 10))){
    		ReturTekst returTekst = new ReturTekst(0, "OK");
    		return returTekst;
		}
        else {
    		ReturTekst returTekst = new ReturTekst(301, "Det 10. pointsæt skal bestå af en spærre eller strike");
    		return returTekst;
        }
	}
	public int[] BeregnBowlingPoint ( BowlingPointSaet[] bowlingPointSaet) {
		
		int strikesIRaekke = 0;
		Boolean spaerre = false;
		int pointNummer = 0;
		int[] points = new int[10];
        int forrigePointNr = 0;

        for (int i=0; i < bowlingPointSaet.length; i++) {

        	if (i <= 10) {
        		if (i == 10) {
        			pointNummer = 9;
        		}
        		else {
        			pointNummer = i;
        		};
//        		her behandles strikes
        		if (bowlingPointSaet[i].getPoint1() == 10) { 
        			if ( i - 1 > -1 ) {
        				if (bowlingPointSaet[i-1].getPoint1() == 10 ){
                			if ( i - 2 > -1 ) {
            					if (bowlingPointSaet[i-2].getPoint1() == 10 ){
                					if (i == 10) {
                						points[pointNummer-2] += 0;
                					}
                					else {
                						points[pointNummer-2] += 10;
                    					points[pointNummer-1] += 10;	
                					}
                				}
                			}
        					points[pointNummer-1] += 10;
        				} 
        				else {
        					if (i < 10) {
        						if (bowlingPointSaet[i-1].getPoint1() + bowlingPointSaet[i-1].getPoint2() == 10) {
                					if (i == 10) {
        								;
                					}
                					else {
            							points[pointNummer-1] += 10;
                					}
        						}
        					}
        				}
        				points[pointNummer]  = points[pointNummer-1];
        			}
        			points[pointNummer] += 10;
            		if (i == 10) {
            			if (bowlingPointSaet[10].getPoint1() == 10) {
            				points[9] += 20;
            			}
            			else {
            				points[9] += bowlingPointSaet[i].getPoint2();
            			}
            				
            		}
        		}
        		else 
//        			her behandles spærre
        			if ( bowlingPointSaet[i].getPoint1() + bowlingPointSaet[i].getPoint2() == 10){
//        			points[i] += 10;
        				if ( i - 1 > -1 ) {
        					if (bowlingPointSaet[i-1].getPoint1() == 10 ){
        						if ( i -2 > -1) {
        							if (bowlingPointSaet[i-2].getPoint1() == 10) {
        								points[pointNummer-2] += bowlingPointSaet[i].getPoint1();
        								points[pointNummer-1] += bowlingPointSaet[i].getPoint1();
        							}
        						}
        						points[pointNummer-1] += 10 ;
        					}
        					else 
        						if	(bowlingPointSaet[i-1].getPoint1() + bowlingPointSaet[i-1].getPoint2() == 10) {
        							points[pointNummer-1] += bowlingPointSaet[i].getPoint1() ;
        							points[pointNummer]   += bowlingPointSaet[i].getPoint1() ;
        						}
        					points[pointNummer] = points[pointNummer-1];
       					}
						points[pointNummer] += 10;
        			}
        			else {
//        				her behandles andet end strike og spærre
        				if ( i - 1 > -1 ) {
        					if (i < 10) {
        					if (bowlingPointSaet[i-1].getPoint1() == 10 ){
        						if ( i - 2 > -1 ) {
        							if (bowlingPointSaet[i-2].getPoint1() == 10 ){
        								points[pointNummer-2] += bowlingPointSaet[i].getPoint1();	
        								points[pointNummer-1] += bowlingPointSaet[i].getPoint1();	
        							}
        						}
								points[pointNummer-1] += bowlingPointSaet[i].getPoint1() + bowlingPointSaet[i].getPoint2();
        					}
        					else { 
        						if (bowlingPointSaet[i-1].getPoint1() + bowlingPointSaet[i-1].getPoint2() == 10) { 
        							points[pointNummer-1] += bowlingPointSaet[i].getPoint1();
        						}
        					}
							points[pointNummer]    = points[pointNummer-1]; 
        					}
        				}
        				points[pointNummer] += bowlingPointSaet[i].getPoint1() + bowlingPointSaet[i].getPoint2();
        			}
        		}		
        	}
        		
		int sidsteForekomst = bowlingPointSaet.length - 1;
		// der skal maksimal returneres 10 point
		if (bowlingPointSaet.length > 10) {
			return Arrays.copyOfRange(points, 0, 10);
		}
		else {
			return Arrays.copyOfRange(points, 0, bowlingPointSaet.length );
		}
	}
}	
        	



package Bowling;

public class BowlingPointSaet {
	private int point1;
	private int point2;
	
	public BowlingPointSaet() {
		super();
	}

	public BowlingPointSaet(int point1, int point2) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		
	}

	public int getPoint1() {
		return point1;
	}

	public void setPoint1(int point1) {
		this.point1 = point1;
	}
	
	public int getPoint2() {
		return point2;
	}

	public void setPoint2(int point2) {
		this.point2 = point2;
	}

	public ReturTekst ValidateBowlingSaetVaerdier (BowlingPointSaet bowlingPointSaet, int pointSaetNr) {

		ReturTekst returTekst = new ReturTekst();
		if (bowlingPointSaet.getPoint1() > 10 || bowlingPointSaet.getPoint1() < 0) {
        	returTekst.setFejlNr(201);
        	returTekst.setFejlTekst("Pointsætværdi 1 er invalid");
			return returTekst;
        }
		if (bowlingPointSaet.getPoint2() > 10 || bowlingPointSaet.getPoint2() < 0) {
        	returTekst.setFejlNr(202);
        	returTekst.setFejlTekst("Pointsætværdi 2 er invalid");
			return returTekst;
        }
        	
		int checkSum = bowlingPointSaet.getPoint1() + bowlingPointSaet.getPoint2();
		if (checkSum > 10 && pointSaetNr < 10) {
        	returTekst.setFejlNr(203);
        	returTekst.setFejlTekst("Summen af pointsættet er for høj");
			return returTekst;
		}

    	returTekst.setFejlNr(0);
    	returTekst.setFejlTekst("OK");
		return returTekst;
	}
//
}

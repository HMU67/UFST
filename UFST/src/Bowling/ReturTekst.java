package Bowling;

public  class ReturTekst {
	
	String returTekst = "";
	int fejlNr;

	public ReturTekst() {
		
	}
	public ReturTekst(int fejlnr, String returTekst){
		super();
		this.returTekst = returTekst;
		this.fejlNr = fejlnr;
	}
	
	public String getFejlTekst() {
		return returTekst;
	}
	public void setFejlTekst(String fejlTekst) {
		this.returTekst = fejlTekst;
	}
	public int getFejlNr() {
		return fejlNr;
	}
	public void setFejlNr(int fejlNr) {
		this.fejlNr = fejlNr;
	}

}

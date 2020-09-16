package Startup;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Backend.Get;
import Backend.Post;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.json.JSONException;

import Bowling.BowlingPointSaet;
import Bowling.ReturTekst;
import Bowling.BowlingData;
import Bowling.BowlingDataBlok;

public class BowlingStartup {
//	public class BowlingStartup extends JFrame implements ActionListener{
//	private BowlingStartup bowlingStartup;
//	private JLabel startup;
//
//	public BowlingStartup (String title) {
//		super(title);
//		getCDontentPane().setLayout(new FlowLayout());
//		setSize(300,100);
	public static void main(String[] args) throws IOException, JSONException {
		Get jsonReader = new Get();
		BowlingDataBlok bowlingDataBlok = jsonReader.laesJsonFraUrl(); 
        if (bowlingDataBlok.getReturTekst().getFejlNr() != 0) {
        	;
        }
		
		BowlingData bowlingData = bowlingDataBlok.getBowlingData();
		ReturTekst returTekst = bowlingData.ValidateBowlingSaetListe(bowlingData.getBowlingPointListe());
		if (returTekst.getFejlNr() != 0) {
				;
		}
    	int[] bowlingPoint = bowlingData.BeregnBowlingPoint(bowlingData.getBowlingPointListe());
	    Post postResult = new Post();
	    postResult.postPointResultaer(bowlingData.getToken(), bowlingPoint);
	}		
//	}
}

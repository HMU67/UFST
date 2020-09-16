package Bowling;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class BowlingTest {

	@Test
	public void bowlingPointSaet1() {
		BowlingPointSaet bowlingPointSaet = new BowlingPointSaet(1,1);
		Assert.assertEquals(0, bowlingPointSaet.ValidateBowlingSaetVaerdier(bowlingPointSaet,1).getFejlNr() );
	}
	@Test
	public void bowlingPointSaet2() {
		BowlingPointSaet bowlingPointSaet = new BowlingPointSaet(11,1);
		Assert.assertEquals(201, bowlingPointSaet.ValidateBowlingSaetVaerdier(bowlingPointSaet,1).getFejlNr() );
	}
	@Test
	public void bowlingPointSaet3() {
		BowlingPointSaet bowlingPointSaet = new BowlingPointSaet(1,11);
		Assert.assertEquals(202, bowlingPointSaet.ValidateBowlingSaetVaerdier(bowlingPointSaet,1).getFejlNr() );
	}
	@Test
	public void bowlingPointSaet4() {
		BowlingPointSaet  bowlingPointSaet = new BowlingPointSaet(1,-1);
		Assert.assertEquals(202, bowlingPointSaet.ValidateBowlingSaetVaerdier(bowlingPointSaet,1).getFejlNr() );
	}
	@Test
	public void bowlingPointSaet5() {
		BowlingPointSaet  bowlingPointSaet = new BowlingPointSaet(-1,12);
		Assert.assertEquals(201, bowlingPointSaet.ValidateBowlingSaetVaerdier(bowlingPointSaet,1).getFejlNr() );
	}
	@Test
	public void bowlingPointSaet6() {
		BowlingPointSaet  bowlingPointSaet = new BowlingPointSaet(9,8);
		Assert.assertEquals(203, bowlingPointSaet.ValidateBowlingSaetVaerdier(bowlingPointSaet,1).getFejlNr() );
	}
	@Test
	public void beregnBowlingPoint1() {
		BowlingPointSaet[] bowlingPointSaet = new BowlingPointSaet[11];
		bowlingPointSaet[ 0]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 1]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 2]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 3]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 4]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 5]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 6]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 7]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 8]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 9]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[10]  = new BowlingPointSaet(10,10);
		BowlingData bowlingData = new BowlingData();
		bowlingData.setBowlingPointListe(bowlingPointSaet);
        int[] pointResultat = {30,60,90,120,150,180,210,240,270,300};
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}
	@Test
	public void beregnBowlingPoint2() {
		BowlingPointSaet[] bowlingPointSaet = new BowlingPointSaet[11];
		bowlingPointSaet[ 0]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 1]  = new BowlingPointSaet( 9, 1);
		bowlingPointSaet[ 2]  = new BowlingPointSaet( 9, 1);
		bowlingPointSaet[ 3]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 4]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 5]  = new BowlingPointSaet( 9, 1);
		bowlingPointSaet[ 6]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 7]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 8]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 9]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[10]  = new BowlingPointSaet(10,10);
		BowlingData bowlingData = new BowlingData();
		bowlingData.setBowlingPointListe(bowlingPointSaet);
		int[] pointResultat = {20,39,59,88,108,128,158,188,218,248};
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}
	@Test
	public void beregnBowlingPoint3() {
		BowlingPointSaet[] bowlingPointSaet = new BowlingPointSaet[4];
		bowlingPointSaet[ 0]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 1]  = new BowlingPointSaet( 9, 1);
		bowlingPointSaet[ 2]  = new BowlingPointSaet( 9, 1);
		bowlingPointSaet[ 3]  = new BowlingPointSaet( 1, 6);
		BowlingData bowlingData = new BowlingData();
		bowlingData.setBowlingPointListe(bowlingPointSaet);
		int[] pointResultat = {20,39,50,57};
		int[] p = bowlingData.BeregnBowlingPoint(bowlingPointSaet);
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}
	@Test
	public void beregnBowlingPoint4() {
		BowlingPointSaet[] bowlingPointSaet = new BowlingPointSaet[6];
		bowlingPointSaet[ 0]  = new BowlingPointSaet( 3, 5);
		bowlingPointSaet[ 1]  = new BowlingPointSaet( 9, 0);
		bowlingPointSaet[ 2]  = new BowlingPointSaet( 7, 3);
		bowlingPointSaet[ 3]  = new BowlingPointSaet( 9, 0);
		bowlingPointSaet[ 4]  = new BowlingPointSaet( 0, 7);
		bowlingPointSaet[ 5]  = new BowlingPointSaet(10, 0);
		BowlingData bowlingData = new BowlingData();
		bowlingData.setBowlingPointListe(bowlingPointSaet);
		int[] pointResultat = {8,17,36,45,52,0};
		int[] p = bowlingData.BeregnBowlingPoint(bowlingPointSaet);
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}
	@Test
	public void beregnBowlingPoint5() {
		BowlingPointSaet[] bowlingPointSaet = new BowlingPointSaet[8];
		bowlingPointSaet[ 0]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 1]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 2]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 3]  = new BowlingPointSaet( 0, 0);
		bowlingPointSaet[ 4]  = new BowlingPointSaet( 4, 2);
		bowlingPointSaet[ 5]  = new BowlingPointSaet( 2, 8);
		bowlingPointSaet[ 6]  = new BowlingPointSaet( 1, 7);
		bowlingPointSaet[ 7]  = new BowlingPointSaet( 6, 3);
		BowlingData bowlingData = new BowlingData();
		bowlingData.setBowlingPointListe(bowlingPointSaet);
		int[] pointResultat = {30,50,60,60,66,77,85,94};
		int[] p = bowlingData.BeregnBowlingPoint(bowlingPointSaet);
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}

}

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
	public void ValidateBowlingSaetListe1() {
		BowlingPointSaet[] bowlingPointListe = new BowlingPointSaet[11];
		bowlingPointListe[ 0]  = new BowlingPointSaet(10, 0);
		bowlingPointListe[ 1]  = new BowlingPointSaet(10, 0);
		bowlingPointListe[ 2]  = new BowlingPointSaet(10, 0);
		bowlingPointListe[ 3]  = new BowlingPointSaet(10, 0);
		bowlingPointListe[ 4]  = new BowlingPointSaet(10, 0);
		bowlingPointListe[ 5]  = new BowlingPointSaet(10, 0);
		bowlingPointListe[ 6]  = new BowlingPointSaet(10, 0);
		bowlingPointListe[ 7]  = new BowlingPointSaet(10, 0);
		bowlingPointListe[ 8]  = new BowlingPointSaet(10, 0);
		bowlingPointListe[ 9]  = new BowlingPointSaet( 1, 6);
		bowlingPointListe[10]  = new BowlingPointSaet( 1, 6);
		BowlingData bowlingData = new BowlingData();
		Assert.assertEquals("Det 10. pointsæt skal bestå af en spærre eller strike", bowlingData.ValidateBowlingSaetListe(bowlingPointListe).getFejlTekst());
	}
	@Test
	public void ValidateBowlingSaetListe2() {
		BowlingPointSaet[] bowlingPointListe = new BowlingPointSaet[11];
		bowlingPointListe[ 0]  = new BowlingPointSaet(10, 0);
		bowlingPointListe[ 1]  = new BowlingPointSaet(10, 0);
		bowlingPointListe[ 2]  = new BowlingPointSaet(10, 0);
		bowlingPointListe[ 3]  = new BowlingPointSaet(10, 0);
		bowlingPointListe[ 4]  = new BowlingPointSaet(10, 0);
		bowlingPointListe[ 5]  = new BowlingPointSaet(10, 0);
		bowlingPointListe[ 6]  = new BowlingPointSaet(10, 0);
		bowlingPointListe[ 7]  = new BowlingPointSaet(10, 0);
		bowlingPointListe[ 8]  = new BowlingPointSaet(10, 0);
		bowlingPointListe[ 9]  = new BowlingPointSaet( 1, 9);
		bowlingPointListe[10]  = new BowlingPointSaet( 1, 6);
		BowlingData bowlingData = new BowlingData();
		Assert.assertEquals(0, bowlingData.ValidateBowlingSaetListe(bowlingPointListe).getFejlNr());
		Assert.assertEquals("OK", bowlingData.ValidateBowlingSaetListe(bowlingPointListe).getFejlTekst());
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
        int[] pointResulta2 = bowlingData.BeregnBowlingPoint(bowlingPointSaet);
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
		int[] pointResultat = {20,39,50,57};
        int[] pointResulta2 = bowlingData.BeregnBowlingPoint(bowlingPointSaet);
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
		int[] pointResultat = {8,17,36,45,52,62};
		int[] pointResultat2 = bowlingData.BeregnBowlingPoint(bowlingPointSaet);
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
		int[] pointResultat = {30,50,60,60,66,77,85,94};
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}
	@Test
	public void beregnBowlingPoint6() {
		BowlingPointSaet[] bowlingPointSaet = new BowlingPointSaet[8];
		bowlingPointSaet[ 0]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 1]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 2]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 3]  = new BowlingPointSaet( 4, 6);
		bowlingPointSaet[ 4]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 5]  = new BowlingPointSaet( 2, 8);
		bowlingPointSaet[ 6]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 7]  = new BowlingPointSaet( 6, 3);
		BowlingData bowlingData = new BowlingData();
		int[] pointResultat = {30,54,74,94,114,134,153,162};
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}
	@Test
	public void beregnBowlingPoint7() {
		BowlingPointSaet[] bowlingPointSaet = new BowlingPointSaet[3];
		bowlingPointSaet[ 0]  = new BowlingPointSaet( 9, 1);
		bowlingPointSaet[ 1]  = new BowlingPointSaet( 6, 2);
		bowlingPointSaet[ 2]  = new BowlingPointSaet( 4, 5);
		BowlingData bowlingData = new BowlingData();
		int[] pointResultat = {16,24,33};
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}
	@Test
	public void beregnBowlingPoint8() {
		BowlingPointSaet[] bowlingPointSaet = new BowlingPointSaet[4];
		bowlingPointSaet[ 0]  = new BowlingPointSaet( 9, 1);
		bowlingPointSaet[ 1]  = new BowlingPointSaet( 6, 2);
		bowlingPointSaet[ 2]  = new BowlingPointSaet( 4, 5);
		bowlingPointSaet[ 3]  = new BowlingPointSaet(10, 0);
		BowlingData bowlingData = new BowlingData();
		int[] pointResultat = {16,24,33,43};
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}
	@Test
	public void beregnBowlingPoint9() {
		BowlingPointSaet[] bowlingPointSaet = new BowlingPointSaet[4];
		bowlingPointSaet[ 0]  = new BowlingPointSaet( 9, 1);
		bowlingPointSaet[ 1]  = new BowlingPointSaet( 6, 2);
		bowlingPointSaet[ 2]  = new BowlingPointSaet( 4, 5);
		bowlingPointSaet[ 3]  = new BowlingPointSaet( 0, 0);
		BowlingData bowlingData = new BowlingData();
		int[] pointResultat = {16,24,33,33};
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}
	@Test
	public void beregnBowlingPoint10() {
		BowlingPointSaet[] bowlingPointSaet = new BowlingPointSaet[6];
		bowlingPointSaet[ 0]  = new BowlingPointSaet( 7, 3);
		bowlingPointSaet[ 1]  = new BowlingPointSaet( 7, 1);
		bowlingPointSaet[ 2]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 3]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 4]  = new BowlingPointSaet( 2, 5);
		bowlingPointSaet[ 5]  = new BowlingPointSaet( 3, 6);
		BowlingData bowlingData = new BowlingData();
		int[] pointResultat = {17,25,47,64,71,80};
		int[] pointResultat2 = bowlingData.BeregnBowlingPoint(bowlingPointSaet);
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}
	@Test
	public void beregnBowlingPoint11() {
		BowlingPointSaet[] bowlingPointSaet = new BowlingPointSaet[6];
		bowlingPointSaet[ 0]  = new BowlingPointSaet( 9, 1);
		bowlingPointSaet[ 1]  = new BowlingPointSaet( 6, 2);
		bowlingPointSaet[ 2]  = new BowlingPointSaet( 4, 3);
		bowlingPointSaet[ 3]  = new BowlingPointSaet( 4, 3);
		bowlingPointSaet[ 4]  = new BowlingPointSaet( 8, 1);
		bowlingPointSaet[ 5]  = new BowlingPointSaet(10, 0);
		BowlingData bowlingData = new BowlingData();
		int[] pointResultat = {16,24,31,38,47,57};
		int[] pointResultat2 = bowlingData.BeregnBowlingPoint(bowlingPointSaet);
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}
	@Test
	public void beregnBowlingPoint12() {
		BowlingPointSaet[] bowlingPointSaet = new BowlingPointSaet[8];
		bowlingPointSaet[ 0]  = new BowlingPointSaet( 4, 1);
		bowlingPointSaet[ 1]  = new BowlingPointSaet( 5, 2);
		bowlingPointSaet[ 2]  = new BowlingPointSaet( 1, 1);
		bowlingPointSaet[ 3]  = new BowlingPointSaet( 7, 1);
		bowlingPointSaet[ 4]  = new BowlingPointSaet( 4, 5);
		bowlingPointSaet[ 5]  = new BowlingPointSaet( 9, 0);
		bowlingPointSaet[ 6]  = new BowlingPointSaet( 9, 1);
		bowlingPointSaet[ 7]  = new BowlingPointSaet(10, 0);
		BowlingData bowlingData = new BowlingData();
		int[] pointResultat = {5,12,14,22,31,40,60,70};
		int[] pointResultat2 = bowlingData.BeregnBowlingPoint(bowlingPointSaet);
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}
	@Test
	public void beregnBowlingPoint13() {
		BowlingPointSaet[] bowlingPointSaet = new BowlingPointSaet[3];
		bowlingPointSaet[ 0]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 1]  = new BowlingPointSaet( 1, 2);
		bowlingPointSaet[ 2]  = new BowlingPointSaet( 0, 8);
		BowlingData bowlingData = new BowlingData();
		int[] pointResultat = {13,16,24};
		int[] pointResultat2 = bowlingData.BeregnBowlingPoint(bowlingPointSaet);
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}
	@Test
	public void beregnBowlingPoint14() {
		BowlingPointSaet[] bowlingPointSaet = new BowlingPointSaet[2];
		bowlingPointSaet[ 0]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 1]  = new BowlingPointSaet(10, 0);
		BowlingData bowlingData = new BowlingData();
		int[] pointResultat = {20,30};
		int[] pointResultat2 = bowlingData.BeregnBowlingPoint(bowlingPointSaet);
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}
	@Test
	public void beregnBowlingPoint15() {
		BowlingPointSaet[] bowlingPointSaet = new BowlingPointSaet[2];
		bowlingPointSaet[ 0]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 1]  = new BowlingPointSaet( 2, 8);
		BowlingData bowlingData = new BowlingData();
		int[] pointResultat = {20,30};
		int[] pointResultat2 = bowlingData.BeregnBowlingPoint(bowlingPointSaet);
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}
	@Test
	public void beregnBowlingPoint16() {
		BowlingPointSaet[] bowlingPointSaet = new BowlingPointSaet[10];
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
		BowlingData bowlingData = new BowlingData();
		bowlingData.setBowlingPointListe(bowlingPointSaet);
        int[] pointResultat = {30,60,90,120,150,180,210,240,260,270};
        int[] pointResulta2 = bowlingData.BeregnBowlingPoint(bowlingPointSaet);
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}
	@Test
	public void beregnBowlingPoint17() {
		BowlingPointSaet[] bowlingPointSaet = new BowlingPointSaet[11];
		bowlingPointSaet[ 0]  = new BowlingPointSaet( 8, 0);
		bowlingPointSaet[ 1]  = new BowlingPointSaet( 5, 0);
		bowlingPointSaet[ 2]  = new BowlingPointSaet( 7, 1);
		bowlingPointSaet[ 3]  = new BowlingPointSaet( 0, 2);
		bowlingPointSaet[ 4]  = new BowlingPointSaet( 1, 4);
		bowlingPointSaet[ 5]  = new BowlingPointSaet( 6, 0);
		bowlingPointSaet[ 6]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 7]  = new BowlingPointSaet( 4, 0);
		bowlingPointSaet[ 8]  = new BowlingPointSaet( 7, 0);
		bowlingPointSaet[ 9]  = new BowlingPointSaet( 5, 5);
		bowlingPointSaet[10]  = new BowlingPointSaet( 7, 0);
		BowlingData bowlingData = new BowlingData();
		bowlingData.setBowlingPointListe(bowlingPointSaet);
        int[] pointResultat = {8,13,21,23,28,34,48,52,59,76};
        int[] pointResulta2 = bowlingData.BeregnBowlingPoint(bowlingPointSaet);
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}
	@Test
	public void beregnBowlingPoint18() {
		BowlingPointSaet[] bowlingPointSaet = new BowlingPointSaet[11];
		bowlingPointSaet[ 0]  = new BowlingPointSaet( 8, 0);
		bowlingPointSaet[ 1]  = new BowlingPointSaet( 5, 0);
		bowlingPointSaet[ 2]  = new BowlingPointSaet( 7, 1);
		bowlingPointSaet[ 3]  = new BowlingPointSaet( 0, 2);
		bowlingPointSaet[ 4]  = new BowlingPointSaet( 1, 4);
		bowlingPointSaet[ 5]  = new BowlingPointSaet( 6, 0);
		bowlingPointSaet[ 6]  = new BowlingPointSaet(10, 0);
		bowlingPointSaet[ 7]  = new BowlingPointSaet( 4, 0);
		bowlingPointSaet[ 8]  = new BowlingPointSaet( 7, 0);
		bowlingPointSaet[ 9]  = new BowlingPointSaet( 5, 5);
		bowlingPointSaet[10]  = new BowlingPointSaet(10, 0);
		BowlingData bowlingData = new BowlingData();
		bowlingData.setBowlingPointListe(bowlingPointSaet);
        int[] pointResultat = {8,13,21,23,28,34,48,52,59,79};
        int[] pointResulta2 = bowlingData.BeregnBowlingPoint(bowlingPointSaet);
		Assert.assertArrayEquals(pointResultat, bowlingData.BeregnBowlingPoint(bowlingPointSaet));
	}
	

}

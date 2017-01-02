package Utils;

public class Geometria {
	
	public static Double getDistance(Double x1, Double x2, Double y1, Double y2, Double z1, Double z2){
		Double distX;
		Double distY;
		Double distZ;
		
		Double resXY = 0.0;
		Double resXYZ = 0.0;
		
		distX = Math.sqrt(Math.pow((x1-x2), 2));
		distY = Math.sqrt(Math.pow((y1-y2), 2));
		distZ = Math.sqrt(Math.pow((z1-z2), 2));
		
		resXY = Math.sqrt( Math.pow(distX, 2) + Math.pow(distY, 2) );
		resXYZ = Math.sqrt( Math.pow(resXY, 2) + Math.pow(distZ, 2) );
		
		return resXYZ;
	}
	
}

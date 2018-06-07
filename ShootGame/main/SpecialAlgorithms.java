package com.shootGame.main;

public class SpecialAlgorithms 
{
	public static int[] arcRotation(int givenX, int givenY, int xOfRotation, int yOfRotation, int rotAngle)                                                           // rotates the point (givenX, givenY) around point of rotation (xOfRotation, yOfRotation) at an angle of fi
	{
		int[] returnValues = new int[3];
		
		int newX = (int) (xOfRotation + ((xOfRotation - givenX) * Math.cos(Math.toRadians(rotAngle)) - ((yOfRotation - givenY) * Math.sin(Math.toRadians(rotAngle)))));
		int newY = (int) (yOfRotation + ((yOfRotation - givenY) * Math.cos(Math.toRadians(rotAngle)) + ((xOfRotation - givenX) * Math.sin(Math.toRadians(rotAngle)))));
		
		returnValues[0] = newX;
		returnValues[1] = newY;
		returnValues[2] = rotAngle;
		
		return returnValues;
		
	}
	
	public static double[] headingToProjectedXY(int x, int y, double radius, double heading)
	{
		double[] returnArray = new double[2];
		double angle = heading % 90;
		
		double projectedX = ((double) ((int)((radius * Math.sin(Math.toRadians(angle))) * 1000))) / 1000;
		double projectedY = ((double) ((int)((radius * Math.cos(Math.toRadians(angle))) * 1000))) / 1000;
		
		if(heading >= 270 )
		{
			projectedX = ((double) ((int)((radius * Math.cos(Math.toRadians(angle))) * 1000))) / 1000;
			projectedY = ((double) ((int)((radius * Math.sin(Math.toRadians(angle))) * 1000))) / 1000;
			returnArray[0] = x + projectedX;
			returnArray[1] = y + projectedY;
		}
		else if(heading >= 180)
		{
			projectedX = ((double) ((int)((radius * Math.sin(Math.toRadians(angle))) * 1000))) / 1000;
			projectedY = ((double) ((int)((radius * Math.cos(Math.toRadians(angle))) * 1000))) / 1000;
			returnArray[0] = x + projectedX;
			returnArray[1] = y - projectedY;
		}
		else if(heading >= 90)
		{
			projectedX = ((double) ((int)((radius * Math.cos(Math.toRadians(angle))) * 1000))) / 1000;
			projectedY = ((double) ((int)((radius * Math.sin(Math.toRadians(angle))) * 1000))) / 1000;
			returnArray[0] = x - projectedX;
			returnArray[1] = y - projectedY;
		}
		else if(heading >= 0)
		{
			projectedX = ((double) ((int)((radius * Math.sin(Math.toRadians(angle))) * 1000))) / 1000;
			projectedY = ((double) ((int)((radius * Math.cos(Math.toRadians(angle))) * 1000))) / 1000;
			returnArray[0] = x -  projectedX;
			returnArray[1] = y + projectedY;
		}
		
		return returnArray;
	}
	
	public static double[] headingToProjectedXY(double heading)
	{
		double[] returnArray = new double[2];
		double angle = heading % 90;
		
		double projectedX = ((double) ((int)((Math.sin(Math.toRadians(angle))) * 1000))) / 1000;
		double projectedY = ((double) ((int)((Math.cos(Math.toRadians(angle))) * 1000))) / 1000;
		
		if(heading > 270)
		{
			returnArray[0] = -1 * projectedX;
			returnArray[1] = projectedY;
			return returnArray;
		}
		else if(heading > 180)
		{
			returnArray[0] = -1 * projectedX;
			returnArray[1] = -1 * projectedY;
			return returnArray;
		}
		else if(heading > 90)
		{
			returnArray[0] = projectedX;
			returnArray[1] = -1 * projectedY;
			return returnArray;
		}
		else if(heading >= 0)
		{
			returnArray[0] = projectedX;
			returnArray[1] = projectedY;
			return returnArray;
		}
		
		return returnArray;
	}
	
	public static double circlify(double val)
	{
		double temp = val;
		if(temp < 0)
	   	{
			while(temp < 0)
	    		temp = val + 360;
	    	return temp;
	        //System.out.println("Recursion (<0)");
	    }
		else if(temp < 360)
	   	{
	   		return temp;
	   		//return;
	   	}
		else if(temp == 360)
	    {
	   		return 0;
	   		//return;
	    }
		else if(temp > 360)
	   	{
	    	while(temp > 360)
	    		temp = temp - 360;
	    	return (temp);
	    	//System.out.println("Recursion (>360)");
	    	//return;
	   	}
		return temp;
	}
	
	public static double roundToThousandths(double val)
	{
		return ((((double)((int)((val * 1000))))/1000));
	}
	
	public static double medianDegrees(double valA, double valB)                                         // return the averaged circlification of valA and valB
	{
		double mean = valB;
		double delta = -1 ;
		double higher = 0.0;
		double lower = 0.0;
		
		if(valA > valB)
		{
			delta = valA - valB;
			higher = valA;
			lower = valB;
		}
		else if(valA < valB)
		{
			delta = valB - valA;
			higher = valB;
			lower = valA;
		}
		else if(valA == valB)
		{
			return SpecialAlgorithms.roundToThousandths(mean);                   // no change, method stops here
		}
		
		
		if(delta > 180)
		{
			mean = SpecialAlgorithms.circlify(((higher + lower) / 2) - 180);
		}
		else if(delta == 180)
		{
			return 404;
		}
		else if(delta < 180)
		{
			mean = SpecialAlgorithms.circlify((higher + lower) / 2);
		}
			
		
		return SpecialAlgorithms.roundToThousandths(mean);
	}
}

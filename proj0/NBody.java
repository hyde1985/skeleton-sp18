public class NBody {
	
	  /** Return a double corresponding to the radius of the universe in that file
	   *  @param   imgFileName 
	   *  @return  return a double corresponding to the radius of the universe in that file
	   */
	   public static double readRadius(String fileName) {
		   In in = new In(fileName);
		   int num = in.readInt();
		   double radius = in.readDouble();
		   return radius;
	   }

	   public static Planet[] readPlanets(String fileName) {

	   		In in = new In(fileName);
	   		int numOfPlanets = in.readInt();
	   		Planet[] planets = new Planet[numOfPlanets];
	   		in.readDouble();
	   		for(int i = 0; i < planets.length; i++) {
	   			double xxPos = in.readDouble();
	   			double yyPos = in.readDouble();
	   			double xxVel = in.readDouble();
	   			double yyVel = in.readDouble();
	   			double mass = in.readDouble();
	   			String imgFileName = in.readString();
	   			planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
	   		}
	   		return planets;
	   }
	
}
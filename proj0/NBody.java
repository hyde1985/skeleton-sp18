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

	   /** Return an array of Planets corresponding to the planets in the file
	   *  @param   imgFileName 
	   *  @return  return an array of Planets corresponding to the planets in the file
	   */
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

	   public static void main(String[] args) {
	   		double T         = Double.parseDouble(args[0]);
	   		double dt        = Double.parseDouble(args[1]);
	   		String fileName  = args[2];
	   		double t         = 0.0;
	   		Planet[] planets = readPlanets(fileName);
	   		double radius    = readRadius(fileName);
	   		StdDraw.enableDoubleBuffering();
	   		StdDraw.setScale(-radius, radius);
	   		StdDraw.clear();
	   		StdDraw.picture(0, 0 ,"./images/starfield.jpg");

	   		for(Planet planet: planets) {
	   				planet.draw();
	   		}

	   		while(t != T) {
	   			double[] xForces = new double[planets.length];
	   			double[] yForces = new double[planets.length];
	   			for(int i = 0; i < planets.length; i++) {
	   				xForces[i] = planets[i].calcNetForceExertedByX(planets);
	   				yForces[i] = planets[i].calcNetForceExertedByY(planets);
	   			}
	   			for(int i = 0; i < planets.length; i++) {
	   				planets[i].update(dt, xForces[i], yForces[i]);
	   			}
	   			StdDraw.picture(0, 0 ,"./images/starfield.jpg");
	   			for(Planet planet: planets) {
	   				planet.draw();
	   			}
	   			StdDraw.show();
	   			StdDraw.pause(10);
	   			t = t + dt;
	   		}
	   		StdOut.printf("%d\n", planets.length);
			StdOut.printf("%.2e\n", radius);
			for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
			}	
	   }
	
}
public class Planet {

    public double xxPos;          // Its current x position

    public double yyPos;          // Its current y position

    public double xxVel;          // Its current velocity in the x direction

    public double yyVel;          // Its current velocity in the y direction

    public double mass;           // Its mass

    public String imgFileName;    // The name of the file that corresponds to the image that depicts the planet

    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    /**
     *   Calculatr the distance between two planets
     *   @param planet     planet need to be calculated
     *   @return double  distance between two planets
     */
     public double calcDistance(Planet planet) {
         double dx = Math.abs(this.xxPos - planet.xxPos);
         double dy = Math.abs(this.yyPos - planet.yyPos);
         double r  = Math.sqrt(dx * dx + dy * dy);
         return r;
     }

     /**
      *   Calculatr a double describing the force exerted on this planet by the given planet
      *   @param planet     planet need to be calculated
      *   @return double    returns a double describing the force exerted on this planet by the given planet
      */
      public double calcForceExertedBy(Planet planet) {
          double r = this.calcDistance(planet);
          double G = 6.67e-11;
          double force = (this.mass * planet.mass) * G / (r * r);
          return force;
      }


}

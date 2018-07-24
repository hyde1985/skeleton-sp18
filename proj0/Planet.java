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
         double dx = this.xxPos - planet.xxPos;
         double dy = this.yyPos - planet.yyPos;
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

      /**
       *   Calculatr the force exerted in the X directions
       *   @param planet     planet need to be calculated
       *   @return double    returns the force exerted in the X directions
       */
      public double calcForceExertedByX(Planet planet) {
          double dx = planet.xxPos - this.xxPos;
          double r  = this.calcDistance(planet);
          double F  = this.calcForceExertedBy(planet);
          double fx = (F * dx) / r;
          return fx;
      }

      /**
       *   Calculatr the force exerted in the Y directions
       *   @param planet     planet need to be calculated
       *   @return double    returns the force exerted in the Y directions
       */
      public double calcForceExertedByY(Planet planet) {
          double dy = planet.yyPos - this.yyPos;
          double r  = this.calcDistance(planet);
          double F  = this.calcForceExertedBy(planet);
          double fy = (F * dy) / r;
          return fy;
      }

      /**  calculate the net X force exerted by all planets in that array upon the current Planet
       *   @param planets     planets need to be calculated
       *   @return double     return the net X force exerted by all planets in that array upon the current Planet
       */
      public double calcNetForceExertedByX (Planet[] planets) {
          double result = 0.0;
          for(int i = 0; i < planets.length; i++) {
              if(this.equals(planets[i]) != true) {
                  result += this.calcForceExertedByX(planets[i]);
              }
          }
          return result;
      }

      /**  calculate the net Y force exerted by all planets in that array upon the current Planet
       *   @param planets     planets need to be calculated
       *   @return double     return the net X force exerted by all planets in that array upon the current Planet
       */
      public double calcNetForceExertedByY (Planet[] planets) {
          double result = 0.0;
          for(int i = 0; i < planets.length; i++) {
              if(this.equals(planets[i]) != true) {
                  result += this.calcForceExertedByY(planets[i]);
              }
          }
          return result;
      }

      /** Determines how much the forces exerted on the planet will cause that planet to accelerate,
       *  and the resulting change in the planet’s velocity and position in a small period of time dt
       *
       *  @param  dt small period of time
       *  @param  fx x-force
       *  @param  fy y-form
       *
       */
      public void update(double dt, double fx, double fy) {
          double ax = fx / this.mass;
          double ay = fy / this.mass;
          this.xxVel = this.xxVel + dt * ax;
          this.yyVel = this.yyVel + dt * ay;
          this.xxPos = this.xxPos + dt * this.xxVel;
          this.yyPos = this.yyPos + dt * this.yyVel;
      }

      public void draw() {
          StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);
      }
}

class Sphere {
    
    double diameter=0.0;

    double setDiameter(double x){
          return diameter=x;//sets diameter to value specified in main
    }

    double radius(double diameter){
        return diameter/2;//calc and return radius value
    }

    double surfaceArea(double radius){
        return Math.PI*4*radius*radius;//use radius value to calc SA
    }
    
    double volume(double radius){
        double volume=(double)Math.PI*(4.0/3.0)*radius*radius*radius;
        return volume;//uses radius value to calc volume
    }
}
class SphereInfo{
	public static void main(String[] args) {
        Sphere sphere1 = new Sphere();
        sphere1.setDiameter(0.0);//specifies diam. value
        System.out.println("A sphere of radius 0.0 has surface area "+(sphere1.surfaceArea((sphere1.radius(sphere1.diameter))))+" and volume "+ (sphere1.volume((sphere1.radius(sphere1.diameter)))));


        Sphere sphere2 = new Sphere();
        sphere2.setDiameter(1.0);//specifies diam. value
        System.out.println("A sphere of radius 0.5 has surface area "+(sphere2.surfaceArea((sphere2.radius(sphere2.diameter))))+" and volume "+ (sphere2.volume((sphere2.radius(sphere2.diameter)))));
        
        Sphere sphere3 = new Sphere();
        sphere3.setDiameter(7.5);//specifies diam. value
        System.out.println("A sphere of radius 3.75 has surface area "+(sphere3.surfaceArea((sphere3.radius(sphere3.diameter))))+" and volume "+ (sphere3.volume((sphere3.radius(sphere3.diameter)))));
     	
    }

}

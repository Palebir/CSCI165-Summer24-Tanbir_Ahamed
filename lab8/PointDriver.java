package lab;

public class PointDriver {
    public static void main(String[] args) {
                // Task 4: Proof of Concept
                
                Point p1 = new Point(3, 4);
                Point3D p3d1 = new Point3D(3, 4, 5);
                MovablePoint mp1 = new MovablePoint(3, 4, 1.5f, 2.5f);
                
                // Demonstrate constructors
                System.out.println(p1);
                System.out.println(p3d1);
                System.out.println(mp1);
                
                // Demonstrate method chaining
                mp1.move().move();
                System.out.println(mp1);
                
                // Demonstrate distance calculation
                System.out.println(p1.distance(6, 8));
                System.out.println(p3d1.distance(new Point3D(6, 8, 10)));
                System.out.println(mp1.distance(p3d1));
                
                // Demonstrate equals method
                Point p2 = new Point(3, 4);
                Point3D p3d2 = new Point3D(3, 4, 5);
                MovablePoint mp2 = new MovablePoint(3, 4, 1.5f, 2.5f);
                
                System.out.println(p1.equals(p2));
                System.out.println(p3d1.equals(p3d2));
                System.out.println(mp1.equals(mp2));
                
                // Task 6: Polymorphism Foreshadowing
                Point[] points = new Point[9];
                points[0] = p1;
                points[1] = new Point(1, 2);
                points[2] = p2;
                points[3] = mp1;
                points[4] = new MovablePoint(5, 6, 0.5f, 0.5f);
                points[5] = mp2;
                points[6] = p3d1;
                points[7] = new Point3D(7, 8, 9);
                points[8] = p3d2;
                
                // Polymorphic behavior
                for (Point p : points) {
                    System.out.println(p);
                }
                
                // Finding the point furthest from origin
                Point furthestPoint = points[0];
                double maxDistance = furthestPoint.distance();
                for (Point p : points) {
                    double distance = p.distance();
                    if (distance > maxDistance) {
                        maxDistance = distance;
                        furthestPoint = p;
                    }
                }
                System.out.println("Furthest point from origin: " + furthestPoint + " at distance " + maxDistance);
            }
        }

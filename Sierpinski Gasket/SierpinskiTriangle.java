import java.awt.*;
import java.util.*;

/**
 * This class uses recursion to draw Sierpinski's Triangle.
 *
 * @author Ranjana Rajagopalan
 * @version 03/02/22
 */
public class SierpinskiTriangle
{
    public static void main(String[] args) {
        // 60 degrees because equilateral triangle
        double angle = Math.toRadians(60); 
        double len = 1;
        
        // Outer Triangle
        double x0 = 0;
        double y0 = 0;
        double x1 = len + x0;
        double y1 = y0;
        double x2 = x0 + (len/2);
        double y2 = (Math.sin(angle) * len) + y0;
        
        StdDraw.line(x0, y0, x1, y1);
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x0, y0, x2, y2);
        
        draw(5,len, 0, 0);
    }

    /**
     * This method uses recursion to draw the triangle.
     * @param n - depth of triangle
     * @param len - length of side of triangle
     * @param x0 - bottom left x-coordinate of triangle
     * @param y0 - bottom left y-coordinate of triangle
     */
    public static void draw(int n, double len, double x0, double y0)
    {
        if (n == 0) {
            return;
        }
        
        // 60 degrees because equilateral triangle
        double angle = Math.toRadians(60); 
        
        double x1 = len + x0;
        double y1 = y0;
        double x2 = x0 + (len/2);
        double y2 = (Math.sin(angle) * len) + y0;
        
        // midpoint coordinates 
        double midx01 = (x0 + x1)/2;
        double midy01 = (y0 + y1)/2;
        double midx02 = (x0 + x2)/2;
        double midy02 = (y0 + y2)/2;
        double midx12 = (x1 + x2)/2;
        double midy12 = (y1 + y2)/2;
        
        // drawing the triangle
        StdDraw.line(midx01, midy01, midx02, midy02);
        StdDraw.line(midx01, midy01, midx12, midy12);
        StdDraw.line(midx12, midy12, midx02, midy02);
        
        draw(n-1, len/2, midx01, midy01);
        draw(n-1, len/2, midx02, midy02);
        draw(n-1, len/2, x0, y0);        
    }
}

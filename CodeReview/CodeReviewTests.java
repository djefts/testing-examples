/* Author: Kaitlyn Leta
 *
 * Description: This example program will calculate the volume of multiple spheres and calculate the averages.
 *				formula: V = 4/3PIr^3
 *
 * Defect possibilities: there are various areas where a defect could be implanted.
 * 						 -One is line 30 for the 4/3, (defect because of the rounding of a whole number 4/3 = 1)
 * 						 -One could also be line 30 by forgetting to divide the diameter by 2.0
 * 						 -Another could be line 18 by mistyping PI value, etc.
 */

import java.text.DecimalFormat;

public class CodeReviewTests {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.####");
        final double PI = 3.1415;
        double[] diameter_list = {1.01, 1.45, 1.6, 1.99, 1.2, 1.78};
        int lengthoflist = diameter_list.length;
        double volume_list[] = new double[lengthoflist];

        CalculateSphereVolume(diameter_list, volume_list, PI, lengthoflist, df);
        CalculateAverageVolume(volume_list, lengthoflist, df);
    }

    public static void CalculateSphereVolume(double diameter_l[], double volume_l[], double PI, int length, DecimalFormat df) {

        for (int i = 0; i < length; i++) {
            volume_l[i] = ((4 / 3) * PI * Math.pow((diameter_l[i] / 2.0), 3)); //defect: should be (4.0/3.0)
            System.out.println("V" + i + ": " + df.format(volume_l[i]));
        }
    }

    public static void CalculateAverageVolume(double volume_l[], int length, DecimalFormat df) {
        double sum = 0.0;
        double avg = 0.0;

        for (int i = 0; i < length; i++) {
            sum = sum + volume_l[i];
        }
        avg = sum / length;
        System.out.println("Average Volume: " + df.format(avg));
    }
}

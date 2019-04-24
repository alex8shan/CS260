import java.awt.Color;
/**
 * Name:Chaolun Feng
 * LA2:Traffic Light
 * This class displays a traffic light panel.
 */
public class TrafficLight {
    /**
     * This method is responsible for drawing the traffic light
     */
    public void drawTheLight() {
        //create the window
        NscWindow window = new NscWindow(10,10,140,330);
        //create the rectangle
        NscRectangle rectangle = new NscRectangle(17,20,90,250);
        //set the rectangle's color to light gray
        rectangle.setFilled(true);
        rectangle.setForeground(Color.lightGray);
        rectangle.setBackground(Color.lightGray);
        rectangle.repaint();
        //add the rectangle to the window
        window.add(rectangle);

        //add the traffic light
        NscEllipse redTraffic = new NscEllipse(10,10,70,70);
        //set the traffic's color to red
        redTraffic.setFilled(true);
        redTraffic.setForeground(Color.red);
        redTraffic.setBackground(Color.red);

        //add the traffic light
        NscEllipse yellowTraffic = new NscEllipse(10,90,70,70);
        //set the traffic's color to yellow
        yellowTraffic.setFilled(true);
        yellowTraffic.setForeground(Color.yellow);
        yellowTraffic.setBackground(Color.yellow);

        //add the traffic light
        NscEllipse greenTraffic = new NscEllipse(10,170,70,70);
        //set the traffic's color to custom green
        greenTraffic.setFilled(true);
        greenTraffic.setForeground(new Color(0,128,0));
        greenTraffic.setBackground(new Color(0,128,0));

        //add traffic lights to rectangle
        rectangle.add(redTraffic);
        rectangle.add(yellowTraffic);
        rectangle.add(greenTraffic);
    }
}
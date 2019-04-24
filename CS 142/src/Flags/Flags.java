package Flags;

import java.awt.Color;

/**
 * Name: Chaolun Feng
 * Programming Assignment: Flags
 */
public class Flags {
    /**
     *  Draws the flag of the Norway
     *  Calculations:
     *  Overall flag:
     *      dimensions: 308*264
     *      location: (85, 50)
     *  Orange banner:
     *      locations: (85,50)
     *          height: 264/3 = 88, width: 308
     *  Green banner:
     *      locations: (85,226)
     *          416 - 234 + 35 = 217
     *          height: 264/3*3/4 = 88, width: 308
     *  circle:
     *      locations: (206,149)
     *          (308-66)/2 + 85 = 206, 50 + 88 + 88/8 = 149
     *          height: 264/3*3/4 = 66, width: 264/3*3/4 = 66
     */
    public void drawNigerFlag(){
        //create NscWindow object
        NscWindow window = new NscWindow(100,100,500,400);
        //create NscRectangle object for the flag
        NscRectangle flag = new NscRectangle(85,50,308,264);
        flag.setFilled(true);
        flag.setBackground(Color.white);
        window.add(flag);
        //create NscRectangle objects for the horizontal bars of color
        NscRectangle orangeBar = new NscRectangle(85,50,308,88);
        orangeBar.setFilled(true);
        orangeBar.setBackground(new Color(255,127,0));
        window.add(orangeBar);
        NscRectangle greenBar = new NscRectangle(85,226,308,88);
        greenBar.setFilled(true);
        greenBar.setBackground(new Color(0,204,0));
        window.add(greenBar);
        //create NscRectangle object
        NscEllipse circle = new NscEllipse(206,149,66,66);
        circle.setFilled(true);
        circle.setBackground(new Color(255,127,0));
        window.add(circle);
        //repaint the window
        window.repaint();
    }
    /**
     *  Draws the flag of the Norway
     *  Calculations:
     *  Overall flag:
     *      dimensions: 416*260
     *      location: (35, 50)
     *  Top left rectangle:
     *      locations: (35,50)
     *          height: 416*5/16 = 130, width: 260 * 4/10 = 104
     *  Top right rectangle:
     *      locations: (217,50)
     *          416 - 234 + 35 = 217
     *          height: 416*9/16 = 234, width: 260*4/10 = 104
     *  Bottom left rectangle:
     *      locations: (35,206)
     *          260 - 104 + 50 = 206
     *          height: 260*4/10 = 104, width: 416*5/16= 130
     *  Bottom right rectangle:
     *      locations: (217,206)
     *          416 - 234 + 35 = 217, 260 - 104 + 50 = 206
     *          height: 256*6/16 = 104, width: 416*9/16 = 234
     */
    public void drawSwedenFlag(){
        //create NscWindow object
        NscWindow window = new NscWindow(100,100,500,400);
        //create NscRectangle object for the flag
        NscRectangle flag = new NscRectangle(35,50,416,260);
        flag.setFilled(true);
        flag.setBackground(Color.yellow);
        window.add(flag);
        //create NscRectangle objects
        NscRectangle topLeft = new NscRectangle(35,50,130,104);
        topLeft.setFilled(true);
        topLeft.setBackground(Color.blue);
        window.add(topLeft);

        NscRectangle bottomLeft = new NscRectangle(35,206,130,104);
        bottomLeft.setFilled(true);
        bottomLeft.setBackground(Color.blue);
        window.add(bottomLeft);

        NscRectangle topRight = new NscRectangle(217,50,234,104);
        topRight.setFilled(true);
        topRight.setBackground(Color.blue);
        window.add(topRight);

        NscRectangle bottomRight = new NscRectangle(217,206,234,104);
        bottomRight.setFilled(true);
        bottomRight.setBackground(Color.blue);
        window.add(bottomRight);

        //add more rectangle *******************************************

        //repaint the window
        window.repaint();
    }

    /**
     * Draws the flag of the Norway
     * Calculations:
     *  Overall flag:
     *      dimensions: 352*256
     *      location: (74, 50)
     *  Left white rectangles:
     *      locations: (74,50), (74,194)
     *          256 - 112 + 50 = 194
     *          height: 256*7/16 = 112, width: 352*7/22 = 112
     *  Right white rectangles:
     *      locations: (218,50), (218, 194)
     *          352 - 208 + 74 = 218, 256 - 112 + 50 = 194
     *          height: 256*7/16 = 112, width: 352*13/22 = 208
     *  Left red rectangles:
     *      locations: (74,50), (74,210)
     *          256 - 96 + 50 = 210
     *          height: 256*6/16 = 96, width: 352*6/22 = 96
     *  Right red rectangles:
     *      locations: (234,210), (218, 210)
     *          352 - 192 + 74 = 234, 256 - 96 + 50 = 210
     *          height: 256*6/16 = 96, width: 352*12/22 = 192
     */
    public void drawNorwayFlag(){
        //create NscWindow object
        NscWindow window = new NscWindow(100,100,500,400);

        //create NscRectangle object for the flag
        NscRectangle flag = new NscRectangle(74,50,352,256);
        flag.setFilled(true);
        flag.setBackground(Color.blue);
        window.add(flag);

        //create NscRectangle objects
        NscRectangle topLeftWhite = new NscRectangle(74,50,112,112);
        topLeftWhite.setFilled(true);
        topLeftWhite.setBackground(Color.white);
        window.add(topLeftWhite);

        NscRectangle topLeftRed = new NscRectangle(74,50,96,96);
        topLeftRed.setFilled(true);
        topLeftRed.setBackground(Color.red);
        window.add(topLeftRed);

        NscRectangle topRightWhite = new NscRectangle(218,50,208,112);
        topRightWhite.setFilled(true);
        topRightWhite.setBackground(Color.white);
        window.add(topRightWhite);

        NscRectangle topRightRed = new NscRectangle(234,50,192,96);
        topRightRed.setFilled(true);
        topRightRed.setBackground(Color.red);
        window.add(topRightRed);

        NscRectangle bottomLeftWhite = new NscRectangle(74,194,112,112);
        bottomLeftWhite.setFilled(true);
        bottomLeftWhite.setBackground(Color.white);
        window.add(bottomLeftWhite);

        NscRectangle bottomLeftRed = new NscRectangle(74,210,96,96);
        bottomLeftRed.setFilled(true);
        bottomLeftRed.setBackground(Color.red);
        window.add(bottomLeftRed);

        NscRectangle bottomRightWhite = new NscRectangle(218,194,208,112);
        bottomRightWhite.setFilled(true);
        bottomRightWhite.setBackground(Color.white);
        window.add(bottomRightWhite);

        NscRectangle bottomRightRed = new NscRectangle(234,210,192,96);
        bottomRightRed.setFilled(true);
        bottomRightRed.setBackground(Color.red);
        window.add(bottomRightRed);

        //repaint the window
        window.repaint();
    }
    /**
     * Draws the flag of the Alabama
     * Calculations:
     *  Overall flag:
     *      dimensions: 440*264
     *      location: (22, 50)
     *  Left & Right Triangle:
     *      locations: (22,74), (282, 74)
     *          x is the same with flag and y is 50 + 264/11 = 74; x: 440 + 22 - 180 = 282 and y: 74
     *         height: 264/11*9 = 216, width: 400/11*9/2 = 180
     *  Upper & Down Triangle:
     *      locations: (62,50), (62, 206)
     *          22 + 440/11 = 62. 50 is the same with flag: 264 + 50 - 108 = 206
     *         height: 264/11*9 = 216, width: 400/11*9/2 = 180????????????????????
     */
    public void drawAlabamaFlag(){
        //create NscWindow object
        NscWindow window = new NscWindow(100,100,500,400);

        //create NscRectangle object for the flag
        NscRectangle flag = new NscRectangle(22,50,440,264);
        flag.setFilled(true);
        flag.setBackground(Color.red);
        window.add(flag);

        //create different triangles
        NscRightTriangle leftTriangle = new NscRightTriangle(22,74,180,216);
        leftTriangle.setFilled(true);
        leftTriangle.setBackground(Color.white);
        window.add(leftTriangle);

        NscLeftTriangle rightTriangle = new NscLeftTriangle(282,74,180,216);
        rightTriangle.setFilled(true);
        rightTriangle.setBackground(Color.white);
        window.add(rightTriangle);

        NscDownTriangle upTriangle = new NscDownTriangle(62,50,360,108);
        upTriangle.setFilled(true);
        upTriangle.setBackground(Color.white);
        window.add(upTriangle);

        NscUpTriangle downTriangle = new NscUpTriangle(62,206,360,108);
        downTriangle.setFilled(true);
        downTriangle.setBackground(Color.white);
        window.add(downTriangle);

        //repaint the window
        window.repaint();
    }
}

package probability_theory.lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;


public class Histogram extends JComponent{
    private final int width;
    private final int height;
    private final double[] array;
    Distribution distribution;

    public Histogram(int width, int height, Distribution distribution){
        this.distribution = distribution;
        this.array = distribution.intervals;
        this.width = width;
        this.height = height;
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;
        int currentXPos = 50;
        double maxInIntervals = array[0];

        for (int i = 0; i < array.length; i++){
            if (array[i] > maxInIntervals){
                maxInIntervals = array[i];
            }
        }

        double xDisplacement = (double)(width / distribution.intervals.length * 0.8);

        double minInVals = distribution.vals.get(0);
        for (double val:
                distribution.vals) {
            if (val < minInVals){
                minInVals = val;
            }
        }

        //graphics2D.drawString(String.format("%.3f", distribution.min), currentXPos, height - 60);


        for (int i = 0; i < distribution.intervals.length; i++){
            //rectangle
            Rectangle2D.Double r = new Rectangle2D.Double(currentXPos, height - 80 - (array[i] * height), xDisplacement, array[i] * height);
            graphics2D.setColor(Color.CYAN);
            graphics2D.fill(r);
            currentXPos += xDisplacement;

            //rectangle lines
            Line2D.Double line = new Line2D.Double(r.x, r.y, r.x, r.y + r.height);
            graphics2D.setColor(Color.BLACK);
            graphics2D.draw(line);

            line = new Line2D.Double(r.x, r.y + r.height, r.x + r.width, r.y + r.height);
            graphics2D.setColor(Color.BLACK);
            graphics2D.draw(line);

            line = new Line2D.Double(r.x + r.width, r.y + r.height, r.x + r.width, r.y);
            graphics2D.setColor(Color.BLACK);
            graphics2D.draw(line);

            line = new Line2D.Double(r.x + r.width, r.y, r.x, r.y);
            graphics2D.setColor(Color.BLACK);
            graphics2D.draw(line);

            //rectangle value
            graphics2D.drawString(String.format("%.3f", array[i]), (int)r.x + 5, (int)(height - 68 - (array[i] * height)));

            //Ox digits
            graphics2D.drawString(String.format("%.3f", distribution.min + distribution.lenInterval * i), currentXPos - (int)xDisplacement, height - 60);

        }

        graphics2D.drawString(String.format("%.3f", distribution.min + distribution.lenInterval * distribution.intervals.length), currentXPos, height - 60);

        //assics

        //0y
        Line2D.Double line = new Line2D.Double(30, height - 80, 30 , 0);
        graphics2D.setColor(Color.BLACK);
        graphics2D.draw(line);
        graphics2D.drawString("1", 10, 10);

        //0x
        line = new Line2D.Double(30, height - 80, width , height - 80);
        graphics2D.setColor(Color.BLACK);
        graphics2D.draw(line);

        graphics2D.drawString("0", 10, height - 60);
    }
}
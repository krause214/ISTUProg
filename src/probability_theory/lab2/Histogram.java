package probability_theory.lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;


public class Histogram extends JComponent{
    private final int width;
    private final int height;
    private final int[] array;
    ContinuousUniformDistribution distribution;

    public Histogram(int width, int height, ContinuousUniformDistribution distribution){
        this.distribution = distribution;
        this.array = distribution.intervals;
        this.width = width;
        this.height = height;
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;
        int currentXPos = 50;
        int maxInIntervals = distribution.intervals[0];

        for (int i = 0; i < distribution.intervals.length; i++){
            if (distribution.intervals[i] > maxInIntervals){
                maxInIntervals = distribution.intervals[i];
            }
        }

        double yMult = (double)height / maxInIntervals * 0.8;
        double xDisplacement = (double)(width / array.length * 0.8);

        graphics2D.drawString(String.format("%.3f",distribution.min), currentXPos, height - 60);


        for (int i = 0; i < array.length; i++){
            //rectangle
            Rectangle2D.Double r = new Rectangle2D.Double(currentXPos, height - 80 - (array[i] * yMult), xDisplacement, array[i] * yMult);
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
            graphics2D.drawString(String.valueOf(array[i]), (int)r.x + 5, (int)(height - 68 - (array[i] * yMult)));

            //Ox digits
            graphics2D.drawString(String.format("%.3f",distribution.min + distribution.lenInterval * i + 0.1), currentXPos, height - 60);

        }

        //assics

            //0y
        Line2D.Double line = new Line2D.Double(30, height - 80, 30 , 0);
        graphics2D.setColor(Color.BLACK);
        graphics2D.draw(line);
        graphics2D.drawString("frecuncy", 10, 10);

            //0x
        line = new Line2D.Double(30, height - 80, width , height - 80);
        graphics2D.setColor(Color.BLACK);
        graphics2D.draw(line);

        graphics2D.drawString("0", 10, height - 60);
    }

}
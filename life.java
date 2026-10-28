import java.awt.*;
import javax.swing.*;

public class life extends Rectangle
{
    ImageIcon life_icon = new ImageIcon(System.getProperty("user.dir")+"\\objects\\life.png");
    Image life_i = life_icon.getImage();
    life(int x,int y)
    {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
    }
    public void draw(Graphics g){
        g.drawImage(life_i,this.x,this.y,this.width,this.height,null);
    }
}
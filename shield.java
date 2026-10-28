import javax.swing.*;
import java.awt.*;

public class shield extends Rectangle
{
    ImageIcon shield = new ImageIcon(System.getProperty("user.dir")+"\\objects\\shield.png");
    shield(int x,int y)
    {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
    }
    public void draw(Graphics g){
        g.drawImage(shield.getImage(),this.x,this.y,this.width,this.height,null);
    }
}
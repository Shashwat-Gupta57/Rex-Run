import java.awt.*;
import javax.swing.*;

public class blocks extends Rectangle{
    ImageIcon obj_icon = new ImageIcon(System.getProperty("user.dir")+"\\objects\\obstruction.png");
    Image obj_i = obj_icon.getImage();
    ImageIcon obj_inv_icon = new ImageIcon(System.getProperty("user.dir")+"\\objects\\obstruction_inverted.png");
    Image obj_inv_i = obj_inv_icon.getImage();
    blocks(int x,int y,int w,int h)
    {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }
    public void draw(Graphics g)
    {
        if(y > 300)
        {
            g.drawImage(obj_i,this.x,this.y,this.width,this.height,null);
        }
        else
        {
            g.drawImage(obj_inv_i,this.x,this.y,this.width,this.height,null);
        }
    }
}
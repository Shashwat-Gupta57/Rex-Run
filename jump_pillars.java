import javax.swing.*;
import java.awt.*;

public class jump_pillars extends Rectangle{
    ImageIcon pill_icon = new ImageIcon(System.getProperty("user.dir")+"\\objects\\pillar.png");
    Image pill_i = pill_icon.getImage();
    jump_pillars(int x,int y,int h){
        this.x = x;
        this.y = y;
        this.width = 80;
        this.height = h;
    }
    public void draw(Graphics g){
        g.drawImage(pill_i,this.x,this.y,this.width,this.height,null);
    }
}
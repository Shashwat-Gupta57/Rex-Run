import javax.swing.*;
import java.awt.*;

public class rex extends Rectangle
{
    boolean gameOver;
    int s = 1;
    ImageIcon rex1 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex1.png");
    ImageIcon rex2 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex2.png");
    ImageIcon rex3 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex3.png");
    ImageIcon rex4 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex4.png");
    ImageIcon rex5 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex5.png");
    ImageIcon rex6 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex6.png");
    ImageIcon rex7 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex7.png");
    ImageIcon rex8 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex8.png");
    ImageIcon rex9 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex9.png");
    ImageIcon rex10 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex10.png");
    ImageIcon rex11 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex11.png");
    ImageIcon rex12 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex12.png");
    ImageIcon rex13 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex13.gif");
    ImageIcon rex14 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex14.png");
    ImageIcon rex15 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex15.gif");
    ImageIcon rex16 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex16.png");
    ImageIcon rex17 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex17.png");
    ImageIcon rex18 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex18.png");
    ImageIcon rex19 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex19.png");
    ImageIcon rex20 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex20.png");
    ImageIcon rex21 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex21.png");
    ImageIcon rex22 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex22.png");
    ImageIcon rex23 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex23.png");
    ImageIcon rex24 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex24.png");
    ImageIcon rex25 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex25.png");
    ImageIcon rex26 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex26.png");
    ImageIcon rex27 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex27.png");
    ImageIcon rex28 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex28.gif");
    ImageIcon rex_dead1 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex1.png");
    ImageIcon rex_dead2 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex2.png");
    ImageIcon rex_dead3 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex3.png");
    ImageIcon rex_dead4 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex4.png");
    ImageIcon rex_dead5 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex5.png");
    ImageIcon rex_dead6 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex6.png");
    ImageIcon rex_dead7 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex7.png");
    ImageIcon rex_dead8 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex8.png");
    ImageIcon rex_dead9 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex9.png");
    ImageIcon rex_dead10 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex10.png");
    ImageIcon rex_dead11 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex11.png");
    ImageIcon rex_dead12 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex12.png");
    ImageIcon rex_dead13 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex13.gif");
    ImageIcon rex_dead14 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex14.png");
    ImageIcon rex_dead15 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex15.gif");
    ImageIcon rex_dead16 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex16.png");
    ImageIcon rex_dead17 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex17.png");
    ImageIcon rex_dead18 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex18.png");
    ImageIcon rex_dead19 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex19.png");
    ImageIcon rex_dead20 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex20.png");
    ImageIcon rex_dead21 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex21.png");
    ImageIcon rex_dead22 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex22.png");
    ImageIcon rex_dead23 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex23.png");
    ImageIcon rex_dead24 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex24.png");
    ImageIcon rex_dead25 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex25.png");
    ImageIcon rex_dead26 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex26.png");
    ImageIcon rex_dead27 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex27.png");
    ImageIcon rex_dead28 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\dead rex28.gif");
    rex(int x,int y,int w,int h,boolean game,int sprite)
    {
        gameOver = game;
        if(sprite > 28){
            sprite = 28;
        }
        s = sprite;
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }
    public void draw(Graphics g)
    {
        if(s == 1)
        {
            if(!gameOver)
            {
                g.drawImage(rex1.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead1.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 2)
        {
            if(!gameOver)
            {
                g.drawImage(rex2.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead2.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 3)
        {
            if(!gameOver)
            {
                g.drawImage(rex3.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead3.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 4)
        {
            if(!gameOver)
            {
                g.drawImage(rex4.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead4.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 5)
        {
            if(!gameOver)
            {
                g.drawImage(rex5.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead5.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 6)
        {
            if(!gameOver)
            {
                g.drawImage(rex6.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead6.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 7)
        {
            if(!gameOver)
            {
                g.drawImage(rex7.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead7.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 8)
        {
            if(!gameOver)
            {
                g.drawImage(rex8.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead8.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 9)
        {
            if(!gameOver)
            {
                g.drawImage(rex9.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead9.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 10)
        {
            if(!gameOver)
            {
                g.drawImage(rex10.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead10.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 11)
        {
            if(!gameOver)
            {
                g.drawImage(rex11.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead11.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 12)
        {
            if(!gameOver)
            {
                g.drawImage(rex12.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead12.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 13)
        {
            if(!gameOver)
            {
                g.drawImage(rex13.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead13.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 14)
        {
            if(!gameOver)
            {
                g.drawImage(rex14.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead14.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 15)
        {
            if(!gameOver)
            {
                g.drawImage(rex15.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead15.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 16)
        {
            if(!gameOver)
            {
                g.drawImage(rex16.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead16.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 17)
        {
            if(!gameOver)
            {
                g.drawImage(rex17.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead17.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 18)
        {
            if(!gameOver)
            {
                g.drawImage(rex18.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead18.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 19)
        {
            if(!gameOver)
            {
                g.drawImage(rex19.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead19.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 20)
        {
            if(!gameOver)
            {
                g.drawImage(rex20.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead20.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 21)
        {
            if(!gameOver)
            {
                g.drawImage(rex21.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead21.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 22)
        {
            if(!gameOver)
            {
                g.drawImage(rex22.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead22.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 23)
        {
            if(!gameOver)
            {
                g.drawImage(rex23.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead23.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 24)
        {
            if(!gameOver)
            {
                g.drawImage(rex24.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead24.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 25)
        {
            if(!gameOver)
            {
                g.drawImage(rex25.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead25.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 26)
        {
            if(!gameOver)
            {
                g.drawImage(rex26.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead26.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 27)
        {
            if(!gameOver)
            {
                g.drawImage(rex27.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead27.getImage(),x,y,width,height,null);
            }
        }
        else if(s == 28)
        {
            if(!gameOver)
            {
                g.drawImage(rex28.getImage(),x,y,width,height,null);
            }
            else
            {
                g.drawImage(rex_dead28.getImage(),x,y,width,height,null);
            }
        }
    }
}
import java.awt.*;
import java.awt.event.*;
public class BouncingBall
{
	public static void main(String[] args)
	{
		BounceFrame bf=new BounceFrame();
	}
}
class BounceFrame extends Frame implements ActionListener
{
	Button bn,bx;
	Panel p,q;
	Ball c;
	BounceFrame()
	{
		super();
		p=new Panel();
		add(p,BorderLayout.CENTER);
		
		q=new Panel();
		bn=new Button("New Object");
		bn.addActionListener(this);
		q.add(bn);
		bx=new Button("Exit");
		bx.addActionListener(this);
		q.add(bx);
		add(q,BorderLayout.SOUTH);
		
		setTitle("BouncingBall");
		setSize(600,600);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		Button b=(Button)e.getSource();
		if(b==bx)
			System.exit(0);
		else
			c=new Ball(p);
	}
}
class Ball extends Thread
{
	Panel box;
	static final int xs=10;
	static final int ys=10;
	int x,y,dx,dy;
	Color cr;
	Ball(Panel p)
	{
		super();
		box=p;
		dx=2;
		dy=2;
		x=0;//
		y=(int)(Math.random()*600);
		cr=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		start();
	}
	public void run()
	{
		while(true)
		{
			move();
			try
			{
				Thread.sleep(100);
			}
			catch(Exception e)
			{}
		}
	}
	public void move()
	{
		Graphics g=box.getGraphics();
		g.setColor(Color.WHITE);
		g.fillOval(x,y,xs,ys);
		x=x+dx;
		y=y+dy;
		g.setColor(cr);
		g.fillOval(x,y,xs,ys);
		if(x<0)
		{
			x=0;
			dx=-dx;
		}
		if(x+dx>600)
		{
			x=600-xs;
			dx=-dx;
		}
		if(y<0)
		{
			y=0;
			dy=-dy;
		}
		if(y+dy>600)
		{
			y=600-ys;
			dy=-dy;
		}
	}
}

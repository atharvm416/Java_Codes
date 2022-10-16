import javax.swing.*;
abstract class MyData
{
	int [] arr;
	MyData()
	{
		arr = new int [5];
	}
	void set(int pos,int d)
	{
		arr[pos]=d;
	}
	int get(int pos)
	{
		return pos;
	}
	abstract void display();
	abstract void menu();
} 
class Stack1 extends MyData
{
	int top;
	Stack1()
	{
		super();
		top=-1;
	}
	void push(int d)
	{
		if(top==arr.length-1)
			return;
		set(++top,d);
	}
	void pop()
	{
		if(top==-1)
			return;
		top--;
	}
	void display()
	{
		String str="Stack";
		if(top==-1)
			str=str+"Empty Stack";
		else
		{
			for(int i=top;i>=0;i--)
				str=str+" "+arr[i];
		}
		JOptionPane.showMessageDialog(null,str);
	}
	void menu()
	{
		int opt=0,d=0;
		String [] choice= new String[] {"Push","Pop","Display","Back"};
		while(true)
		{
			opt=JOptionPane.showOptionDialog(null,"Choose Option :","Stack",JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE,null,choice,0);
			if(opt==3)
				break;
			switch(opt)
			{
				case 0:
					try
					{
						d=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Number :"));
					}
					catch(Exception e){}
					push(d);
					break;
				case 1:
					pop();
					break;
				case 2:
					display();
			}
		}
	}
}
class Stack
{
	public static void main(String[] args)
	{
		Stack1 a=new Stack1();
		a.menu();
	}
}
class Queue1 extends MyData
{
	int fr,rr;
	Queue1()
	{
		super();
		rr=-1;
		fr=0;
	}
	void insert(int d)
	{
		if(rr==arr.length-1)
			return;
		set(++rr,d);
	}
	void remove()
	{
		if(rr<fr)
			return;
		fr++;
	}
	void display()
	{
		String str="Queue";
		if(rr<fr)
			str=str+"Empty Queue";
		else
		{
			for(int i=fr;i<=rr;i++)
				str=str+" "+arr[i];
		}
		JOptionPane.showMessageDialog(null,str);
	}
	void menu()
	{
		int opt=0,d=0;
		String [] choice= new String[] {"Insert","Remove","Display","Back"};
		while(true)
		{
			opt=JOptionPane.showOptionDialog(null,"Choose Option :","Queue",JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE,null,choice,0);
			if(opt==3)
				break;
			switch(opt)
			{
				case 0:
					try
					{
						d=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Number :"));
					}
					catch(Exception e){}
					insert(d);
					break;
				case 1:
					remove();
					break;
				case 2:
					display();
			}
		}
	}
}
class Queue 
{
	public static void main(String[] args)
	{
		Queue1 a=new Queue1();
		a.menu();
	}
}
class Abstr_St_Que
{
	public static void main(String[] args) {
		String[] msg=new String[] {"Stack","Queue","Exit"};
		while(true)
		{
			int y=JOptionPane.showOptionDialog(null,"Choose Option :","Pick Stack or Queue", JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE,null,msg,0);
			if(y==2)
				break;
			switch(y)
			{
				case 0:
				try {
					Stack1 a=new Stack1();
					a.menu();
				} catch (Exception e) {
					//TODO: handle exception
				}
				break;
				case 1:
				try {
					Queue1 a=new Queue1();
					a.menu();
				} catch (Exception e) {
					//TODO: handle exception
				}
			}
		}

	}
}
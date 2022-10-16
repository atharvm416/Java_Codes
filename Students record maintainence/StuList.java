import java.io.*;
import java.util.*;
import mypkg.Util;
interface DataIO
{
	void setData(int no);
	void display();
	int getNo();
	boolean getState();
	void setState();
}
interface ObjAMD
{
	void add();
	void mod();
	void del();
	void display();
	void menu();
}
interface ObjAMDRW extends ObjAMD
{
	void write();
	void read();
}
class EStudent implements DataIO,Serializable
{
	int no;
	String nm;
	double mrk;
	boolean state;
	EStudent()
	{
		no=0;
		nm="";
		mrk=0.0;
		state=true;
	}
	public int getNo()
	{
		return no;
	}
	public boolean getState()
	{
		return state;
	}
	public void setState()
	{
		state=false;
	}
	public String toString()
	{
		String s="Data\nNo: "+no+"\nName: "+nm+"\nMarks: "+mrk+"\nState: "+state;
		return s;
	}
	public void display()
	{
		Util.display(toString());
	}
	public void setData(int n)
	{
		no=n;
		nm=Util.sInput("Name: ");
		mrk=Util.dInput("Marks: ");
		state=true;
	}
}
class StuList implements ObjAMDRW
{
	LinkedList <EStudent> ls;
	EStudent obj;
	StuList()
	{
		obj=null;
		ls=new LinkedList <EStudent>();
	}
	boolean search(int no)
	{
		int i=0,n=ls.size();
		obj=null;
		while(i<n)
		{
			obj=ls.get(i);
			if(obj.getNo()==no)
				break;
			i++;
		}
		if(i==n)
			obj=null;
		return (i!=n);//If found returns true and visa.
	}
	public void add()
	{
		int no=Util.iInput("Roll No: ");
		if(search(no)==true)
		{
			Util.display("Record Exists");
			return;
		}
		obj=new EStudent();
		obj.setData(no);
		ls.add(obj);
	}
	public void mod()
	{
		int no=Util.iInput("Roll No: ");
		if(search(no)==false)
		{
			Util.display("Invalid Roll No");
			return;
		}
		if(obj.getState()==false)
		{
			Util.display("Deleted Record");
			return;
		}
		obj.setData(no);
	}
	public void del()
	{
		int no=Util.iInput("Roll No: ");
		if(search(no)==false)
		{
			Util.display("Invalid Roll No");
			return;
		}
		if(obj.getState()==false)
		{
			Util.display("Deleted Record");
			return;
		}
		obj.setState();
	}
	public void display()
	{
		int i=0,n=ls.size();
		while(i<n)
		{
			obj=ls.get(i);
			obj.display();
			i++;
		}
	}
	public void write()
	{
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try
		{
			fos=new FileOutputStream("Stu2122.dat");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(ls);
			oos.close();
			fos.close();
		}
		catch(Exception e)
		{}
	}
	public void read()
	{
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try
		{
			fis=new FileInputStream("Stu2122.dat");
			ois=new ObjectInputStream(fis);
			ls=(LinkedList<EStudent>)ois.readObject();
			ois.close();
			fis.close();
		}
		catch(Exception e)
		{}
	}
	public void menu()
	{
		String[] choice=new String[] {"Add","Mod","Del","Display All","Exit"};
		int opt=0;
		read();//loads object from file
		while(true)
		{
			opt=Util.oInput(choice,"Choose one","Student List");
			if(opt==4)
				break;
			switch(opt)
			{
				case 0:
					add();
					break;
				case 1:
					mod();
					break;
				case 2:
					del();
					break;
				case 3:
					display();
					break;
				
			}
		}
		write();//write object to file
	}
	public static void main(String[] args)
	{
		StuList a=new StuList();
		a.menu();
	}
}
//Remote method envocation
//RMIServer1.java
import java.rmi.*;
import java.rmi.server.*;
interface Inter1 extends Remote
{
	public int getNumber() throws Exception;
}
class Inter1Impl extends UnicastRemoteObject implements Inter1
{
	Inter1Impl() throws RemoteException
	{
		super();
	}
	public int getNumber() throws Exception
	{
		return (int)(Math.random()*100);
	}
}
class RMIServer1 
{
	public static void main(String [] args) throws Exception
	{
		Inter1Impl i1=new Inter1Impl();
		Naming.rebind("Obj",i1);
		System.out.println("Server Started....");
	}
}


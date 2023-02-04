import java.rmi.*;
import java.rmi.server.*;
class RMIClient1
{
	public static void main(String [] args) throws Exception
	{
		String url="rmi://localhost/Obj";
		Inter1 ref=(Inter1)Naming.lookup(url);
		System.out.println("Number:"+ref.getNumber());
	}
}	
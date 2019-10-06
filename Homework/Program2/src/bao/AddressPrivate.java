package bao;
import java.io.*;
public class AddressPrivate extends AddressPublic {
	
	protected String phone;
	
	//构造函数们
	public AddressPrivate() {
		surname=name=email="";
		phone="";
	}
	public AddressPrivate(String sur,String na,String em,String ph) {
		super(sur,na,em);
		phone=ph;
	}
	public String toString() {
		String s=surname+"  "+name+" : "+email+" / "+phone;
		return s;
	}
	   public void save(DataOutputStream out) throws IOException{
		      out.writeUTF(surname);
		      out.writeUTF(name);
		      out.writeUTF(email);
		      out.writeUTF(phone);
		   }

		   public void load(DataInputStream in) throws IOException {
		      super.load(in);
		      phone=in.readUTF();
		   }
}

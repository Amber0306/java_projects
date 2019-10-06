package bao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class AddressPublic {

	protected String surname;
	protected String name;
	protected String email;
	
	//构造函数们
	public AddressPublic() {
		surname="";
		name="";
		email="";
	}//重载
	public AddressPublic(String sur,String na,String em) {
		surname=sur;
		name=na;
		email=em;
	}
	public String toString() {
		String s=surname+"  "+name+" : "+email;
		return s;
	}
	public void save(DataOutputStream out) throws IOException{
	      out.writeUTF(surname);
	      out.writeUTF(name);
	      out.writeUTF(email);
	   }
	   public void load(DataInputStream in) throws IOException {
	      surname = in.readUTF();
	      name=in.readUTF();
	      email = in.readUTF();
	   }
}

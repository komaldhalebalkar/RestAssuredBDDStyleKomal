package RestTEST;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test implements Serializable 
{
	int i=10,j=20;
}
public class Rest_serialisationandDeserialisation {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Test ts=new Test();
		
		//serialisation
		FileOutputStream fos=new FileOutputStream("test.txt");
		ObjectOutputStream os= new ObjectOutputStream(fos);
		os.writeObject(ts);
		
		//Desrialisation
		FileInputStream fis=new FileInputStream("test.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Test t2=(Test) ois.readObject();
		System.out.println(ts.i+"  "+t2.j);

	}

}

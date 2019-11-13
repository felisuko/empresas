package pruebasSueltas;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.codec.binary.Base64;

public class ImagenToArrayBytes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			String s = Base64.encodeBase64String(extractBytes ("C://Users//fgonzalezc//Documents//pruebaOjo.jpg"));
			System.out.println(s);
			
		}catch(Exception e){
			System.out.println("ERROR " + e);
		}
	}
	
	public static byte[] extractBytes (String ImageName) throws IOException {
		 // open image
		 File imgPath = new File(ImageName);
		 byte[] fileContent = Files.readAllBytes(imgPath.toPath());

		 return (fileContent);
	}
	
}

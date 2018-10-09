package sist.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamUtil {

	public static void inToOut(InputStream is,OutputStream os) throws IOException{
		byte[] buffer = new byte[1024];
		int length = 0;
		
		while((length = is.read(buffer))!=-1){
			os.write(buffer, 0, length);
		}
	}
}

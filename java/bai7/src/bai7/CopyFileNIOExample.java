package bai7;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class CopyFileNIOExample {
public static void main(String[] args) throws Exception {
	File sourceFile = new File("E:\\java\\iotest\\acb.txt");
	File desFile= new File("E:\\java\\iotest\\cde.txt");
	
	FileChannel srcChannel = null;
	FileChannel desChannel = null;
	srcChannel = new FileInputStream(sourceFile).getChannel();
	desChannel = new FileOutputStream(desFile).getChannel();
	srcChannel.transferTo(0, srcChannel.size(), desChannel);
	Desktop.getDesktop().open(sourceFile.getParentFile());
}
}

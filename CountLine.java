
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class CountLine {
	private static int total_line = 0;
	public static void main(String[] args) {
		listFile(new File("js"));
		System.out.println("小游戏总代码行数："+total_line);
	}
	public static void listFile(File file) {
		File []fs = file.listFiles();
		if(fs == null)return;
		for(File f :fs) {
			if(f.isFile()) {
				countLine(f);
				writeToOneFile(f);
			}else {
				listFile( f);
			}
		}
	}
	
	private static void writeToOneFile(File f) {
		if(!f.getName().endsWith(".js"))return;
		try (BufferedReader  bfr = new BufferedReader(
				new InputStreamReader(new FileInputStream(f), "UTF-8"));
			BufferedWriter buw = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("总.js",true)))){
			while(true) {
				String line = bfr.readLine();
				if(line == null)break;
				buw.write(line);
				buw.newLine();
			}
		} catch (Exception e) { }
	}
	private static void countLine(File f) {
		if(!f.getName().endsWith(".js"))return;
		try (BufferedReader  bfr = new BufferedReader(
				new InputStreamReader(new FileInputStream(f), "UTF-8"));){
			while(true) {
				String line = bfr.readLine();
				if(line == null)break;
				total_line++;
			}
		} catch (Exception e) { }
	}
	
}

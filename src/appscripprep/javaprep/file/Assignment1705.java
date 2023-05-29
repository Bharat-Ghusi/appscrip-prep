package appscripprep.javaprep.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assignment1705 {
	
	public static void solve1(List<File> list,String path) {
		File file = new File(path);
		
		File[] listFiles = file.listFiles();
		if(listFiles != null) {
			for(File files:listFiles) {
				if(files.isDirectory()) {
					solve1(list, files.getAbsolutePath());
				}else if(files.isFile()){
					list.add(files);
				}
			}
		}
		
		
	}
	//Print in a order
	public static void solve2(File[] files) {
		for (int i = 0; i < files.length; i++) {
			if(files[i].isFile()) {
				System.out.println("\t file name: "+files[i].getName());
			}
			else if(files[i].isDirectory()) {
				System.out.println("Dir name: "+files[i].getName());
				solve2(files[i].listFiles());
			}
		}
	}

	public static void main(String[] args) {
		String path = "C:\\Users\\3Embed\\eclipse-workspace\\appscripprep";
		ArrayList<File> list = new ArrayList<>();
//		solve1(list,path);
//		for(File f:list) {
//			System.out.println(f.getName());
//		}
		File file = new File(path);
		File[] listFiles = file.listFiles();
		solve2(listFiles);
		
	}

}

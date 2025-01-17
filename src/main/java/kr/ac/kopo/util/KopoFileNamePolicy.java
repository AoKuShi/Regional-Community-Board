package kr.ac.kopo.util;

import java.io.File;
import java.util.UUID;

public class KopoFileNamePolicy {

	public File rename(File f) {
		String name = f.getName();
		String ext = "";
		int dot = name.lastIndexOf(".");
		if (dot != -1) {
			ext = name.substring(dot); 
		} else {
			ext = "";
		}
		String str = "kopo" + UUID.randomUUID();
		File renameFile = new File(f.getParent(), str + ext);
		return renameFile;
	}
}

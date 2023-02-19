package com.Property.org;

import java.io.IOException;

public class File_Reader_Manager {

	private File_Reader_Manager() {

	}

	public static File_Reader_Manager getInstanceFRM() {
		File_Reader_Manager frm = new File_Reader_Manager();
		return frm;
	}

	public Configuration_Reader getInstanceCR() throws IOException {
		Configuration_Reader cr = new Configuration_Reader();
		return cr;

	}
}

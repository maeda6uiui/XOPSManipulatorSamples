//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.xml;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.daxie.xops.character.CharacterData;
import com.daxie.xops.xcs.XCSManipulator;
import com.daxie.xops.xml.CharacterDataXMLOutputter;

public class OutputCharacterDataXML {
	public static void main(String[] args) {
		final String xcs_filename = "./temp.xcs";
		final String xml_filename = "./character_data.xml";

		XCSManipulator xcs_manipulator = null;
		try {
			xcs_manipulator = new XCSManipulator(xcs_filename);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		}

		CharacterData[] character_data_array = xcs_manipulator.GetCharacterDataArray();

		List<CharacterData> character_data_list = new ArrayList<>();
		for (int i = 0; i < character_data_array.length; i++) {
			character_data_list.add(character_data_array[i]);
		}

		CharacterDataXMLOutputter cdxo = new CharacterDataXMLOutputter(character_data_list);
		// cdxo.SetOpenXOPSCompatibleFlag(false);
		cdxo.WriteXML(xml_filename);
	}
}

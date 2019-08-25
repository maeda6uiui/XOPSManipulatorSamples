//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.mif;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import com.daxie.xops.mif.MIFManipulator;
import com.daxie.xops.mif.MissionInfo;

public class WriteMIF {
	public static void main(String[] args) {
		final String mif_orig_filename = "./temp.mif";
		final String mif_dest_filename = "./temp2.mif";
		final String encoding = "Shift-JIS";

		MIFManipulator mif_manipulator = null;
		try {
			mif_manipulator = new MIFManipulator(mif_orig_filename, encoding);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported encoding.");
			return;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return;
		}

		MissionInfo mif = mif_manipulator.GetMissionInfo();

		// Change the mission name to upper case.
		String mission_name = mif.GetMissionName();
		mission_name = mission_name.toUpperCase();
		mif.SetMissionName(mission_name);

		mif_manipulator.SetMissionInfo(mif);

		try {
			mif_manipulator.Write(mif_dest_filename, encoding);
		} catch (FileNotFoundException e) {
			System.out.println("Failed to create a MIF file.");
			return;
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported encoding.");
			return;
		}
	}
}
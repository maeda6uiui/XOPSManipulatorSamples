//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.xms;

import java.io.FileNotFoundException;

import com.daxie.xops.ids.IDSManipulator;
import com.daxie.xops.weapon.WeaponData;

public class LoadIDS {
	public static void main(String[] args) {
		final String ids_filename = "./temp.ids";

		IDSManipulator ids_manipulator = null;
		try {
			ids_manipulator = new IDSManipulator(ids_filename);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		}

		WeaponData weapon_data = ids_manipulator.GetWeaponData();
		System.out.println(weapon_data);
	}
}
package com.gale.knewton.StepDefs;

import java.util.HashMap;
import java.util.Map;

import com.gale.knewton.util.YamlReader;

public class TestYaml {
	
	static Map<String,Object> testyaml;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testyaml= YamlReader.getYamlValues("ASR_CancleCheckout");
		System.out.println(testyaml);
		Object value=  testyaml.get("passVNet");
		//System.out.println(value);
			
		
		String value1=String.valueOf(value);
		System.out.println(value1);
		
		

	}

}

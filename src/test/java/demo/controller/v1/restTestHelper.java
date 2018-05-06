package demo.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class restTestHelper {

	public static String asJsonString(final Object object) {
		try{
			return new ObjectMapper().writeValueAsString(object);
		}
		catch(Exception e){
			throw new RuntimeException();
		}
	}
}

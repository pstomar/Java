package com.tomar.constants;

public abstract class Queries {
	public static abstract class City {
		private static final String ENTITY = "City";
		public static String get(){
			return "from "+ENTITY;
		}
		public static String get(Integer id){
			return "from "+ENTITY+" where id="+id;
		}
	}
	
	public static abstract class State {
		private static final String ENTITY = "State";
		
	}
	
	public static abstract class Country {
		private static final String ENTITY = "Country";
		
	}
	
	public static abstract class User {
		private static final String ENTITY = "User";
		
	}
}

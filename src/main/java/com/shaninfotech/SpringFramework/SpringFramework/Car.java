package com.shaninfotech.SpringFramework.SpringFramework;

public class Car {
      private Engine engine;
      public Car() {
    	  //engine = new Engine();
    	  
    	  
      }
      
      public Car(Engine engine) {
		super();
		this.engine = engine;
	}

	  public void drive() {
    	  engine.start();
    	  System.out.println("started driving");
      }
}

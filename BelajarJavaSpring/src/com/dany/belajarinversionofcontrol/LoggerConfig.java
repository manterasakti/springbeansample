package com.dany.belajarinversionofcontrol;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LoggerConfig {
	
	private String tingkatanAkarMasalah;
	private String tampilkanTingkatMasalah;
	
	public void setTingkatanAkarMasalah (String tingkatanAkarMasalah) {
		this.tingkatanAkarMasalah = tingkatanAkarMasalah;
	}
	
	public void setTampilkanTingkatMasalah (String tampilkanTingkatMasalah) {
		this.tampilkanTingkatMasalah = tampilkanTingkatMasalah;
	}
	
	public void initLogger() {
		
		//level
		Level akarMasalah = Level.parse(tingkatanAkarMasalah);
		Level tampilkanLevel = Level.parse(tampilkanTingkatMasalah);
		
		//context logger
		Logger applicationContextLogger = Logger.getLogger(
				AnnotationConfigApplicationContext.class.getName());
		
		//induk logger
		Logger indukLogger = applicationContextLogger.getParent();
		
		//level logger
		indukLogger.setLevel(akarMasalah);
		
		//atur handler
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(tampilkanLevel);
		consoleHandler.setFormatter(new SimpleFormatter());
		
		//handler logger
		indukLogger.addHandler(consoleHandler);
	}
	

}

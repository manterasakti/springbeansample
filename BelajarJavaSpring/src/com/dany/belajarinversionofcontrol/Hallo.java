package com.dany.belajarinversionofcontrol;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hallo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// memuat konfigurasi
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext ("applicationContext.xml");
		
		// ambil data (bean) dari spring container
		Pelatih pelatih = context.getBean("pelatihSaya", Pelatih.class);
		
		// panggil method bean
		System.out.println(pelatih.getJadwalHarian());
		
		// tutup dengan context
		context.close();

	}

}

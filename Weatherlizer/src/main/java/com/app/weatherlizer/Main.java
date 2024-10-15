package com.app.weatherlizer;

import com.app.weatherlizer.api.service.file.FileService;
import com.app.weatherlizer.api.service.ApiServiceWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
	@Autowired
	private ApiServiceWeather apiServiceWeather;

	@Autowired
	private FileService fileService;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

	}
}



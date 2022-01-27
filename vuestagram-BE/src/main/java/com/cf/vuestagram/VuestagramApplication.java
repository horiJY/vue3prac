package com.cf.vuestagram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class VuestagramApplication {

	public static void main(String[] args) {
		SpringApplication.run(VuestagramApplication.class, args);

		// os linux 환경에 따라 분리할 경우
		// String os = System.getProperty("os.name").toLowerCase();

		// if (os.contains("win")) {
		// new SpringApplicationBuilder()
		// .sources(
		// VuestagramApplication.class)
		// .properties("spring.config.location=" +
		// "C:\\Users\\JY\\Desktop\\code\\vueprac\\vuestagram-BE\\src\\main\\resources\\application-dev.yml").run(args);
		// } else {
		// new SpringApplicationBuilder().sources(
		// VuestagramApplication.class)
		// .properties("spring.config.location=" +
		// "\\home\\ec2-user\\app\\application-dev.yml").run(args);
		// }
	}

}
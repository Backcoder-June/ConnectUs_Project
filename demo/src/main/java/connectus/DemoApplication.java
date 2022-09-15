package connectus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@ComponentScan(basePackages = "connectus.board")
@ComponentScan(basePackages = "connectus.reservation")
@MapperScan(basePackages = "connectus.board")
@MapperScan(basePackages = "connectus.reservation")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

package connectus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@ComponentScan(basePackages = "connectus.member")
@ComponentScan(basePackages = "connectus.board")
@ComponentScan(basePackages = "connectus.product")
@ComponentScan(basePackages = "connectus.reservation")
@MapperScan(basePackages = "connectus.member")
@MapperScan(basePackages = "connectus.board")
@MapperScan(basePackages = "connectus.product")
@MapperScan(basePackages = "connectus.reservation")
@SpringBootApplication
public class ConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectApplication.class, args);
	}

}

package connectus;


import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

//main 메소드 있으면 SPRING BOOT APP으로 실행 가능
//또는 main 메소드 있는 부트클래스가 실행시 같이 실행 가능
@Configuration
@EnableEncryptableProperties 
public class JasyptConfig {

	@Autowired
	Environment environment;
	
    @Bean("jasyptEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        //config.setPassword("1234"); // 암호화 키
        config.setPassword(environment.getProperty("jasypt.encryptor.password")); //runas config VM-option 용 
        //config.setPassword(System.getenv("DB_PW"));  // jenkins 에 global properties 값으로 가져오기 
        config.setAlgorithm("PBEWithMD5AndDES"); // 알고리즘
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
		System.out.println("===JasyptConfig실행===");
		//application.properties db항목 복호화 확인
		System.out.println(encryptor.decrypt("nEIG7HArcrBgGvuKz49jQn2rzCSDteJ5zgRnBjAAtQUhdWXOYryblw=="));
		System.out.println(encryptor.decrypt("/x+OEz9gaWMEc0DDhjBWhb2c+ul3QE0rg65GlF0cDHsvezbg6LR9ziI+v8sGrw4nE7EIbH45ofY="));
		System.out.println(encryptor.decrypt("4uWSrKDQ+SJvJolzXkB/y9qE9yj3oFqg"));
		System.out.println(encryptor.decrypt("T6KrzQQ9/lnDhiuVX0mDkEeYglxdPFI9"));
        return encryptor;
    }
 
}
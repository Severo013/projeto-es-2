package br.unesp.rc.msaccesscontrol;

import br.unesp.rc.msaccesscontrol.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class MsaccesscontrolApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaccesscontrolApplication.class, args);
	}

}

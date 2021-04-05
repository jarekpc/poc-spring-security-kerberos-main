package com.arqdomsandig.kerberos.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Paths;

@SpringBootApplication
public class KerberizedServerApp {
	///home/jarek/Dokumenty/springboot/przyklady_ksiazki/poc-spring-security-kerberos/krb-test-workdir/minikdc-krb5.con
	//java.security.minikdc-krb5.conf
	static {
		System.setProperty("java.security.krb5.conf",
				Paths
					.get("/home/jarek/Dokumenty/springboot/przyklady_ksiazki/poc-spring-security-kerberos-main/krb-test-workdir/krb5.conf")
					.normalize().toAbsolutePath().toString());
		System.setProperty("sun.security.krb5.debug", "true");
		// Disable usage of local kerberos ticket cache
		System.setProperty("http.use.global.creds", "false");

	}

	public static void main(String[] args) {

		// Set App Port
		System.getProperties().put( "server.port", 8090 );
		SpringApplication.run(KerberizedServerApp.class, args);
	}
}

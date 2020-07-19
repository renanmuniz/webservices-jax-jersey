package br.com.alura.loja;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Servidor {

	static HttpServer server = null;
	
    public static void main(String[] args) throws IOException {
    	inicializaServidor();
    	System.out.println("Tecle enter para parar o servidor...");
    	System.in.read();
    	finalizaServidor();
    }		
        
    
    public static HttpServer inicializaServidor() {
    	ResourceConfig config = new ResourceConfig().packages("br.com.alura.loja");
        URI uri = URI.create("http://localhost:8080/");
        server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
        System.out.println("SERVIDOR: Servidor inicializado.");
        return server;
    }
    
    public static void finalizaServidor() {	
        server.stop();
        System.out.println("SERVIDOR: Servidor encerrado.");
    }
}

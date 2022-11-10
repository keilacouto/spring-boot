package io.github.keilacouto;

import io.github.keilacouto.domain.entity.Cliente;
import io.github.keilacouto.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return args -> {

            System.out.println("Salvando cliente");
            clientes.save(new Cliente("Keila"));
            clientes.save(new Cliente("Adriano"));

            List<Cliente> result = clientes.encontrarPorNome("Keila");
            result.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}

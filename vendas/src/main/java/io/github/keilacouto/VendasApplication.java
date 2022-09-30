package io.github.keilacouto;

import io.github.keilacouto.domain.entity.Cliente;
import io.github.keilacouto.domain.repositorio.Clientes;
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

            System.out.println("Listando cliente");
            List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando cliente");
            todosClientes.forEach(c ->  {
                c.setNome(c.getNome() + " atualizado.");
                clientes.save(c);
            });

            todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando cliente por nome");
            clientes.findByNomeLike("Adri").forEach(System.out::println);

            System.out.println("Deletando cliente por nome");
            clientes.findAll().forEach(c -> {
                clientes.delete(c);
            });

            System.out.println("Listando cliente");
            todosClientes = clientes.findAll();
            if (todosClientes.isEmpty()) {
                System.out.println("Nenhum cliente encontrado.");
            } else {
                todosClientes.forEach(System.out::println);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}

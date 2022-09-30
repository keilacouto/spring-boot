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
            clientes.salvar(new Cliente("Keila"));
            clientes.salvar(new Cliente("Adriano"));

            System.out.println("Listando cliente");
            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando cliente");
            todosClientes.forEach(c ->  {
                c.setNome(c.getNome() + " atualizado.");
                clientes.atualizar(c);
            });

            todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando cliente por nome");
            clientes.buscarPorNome("Adri").forEach(System.out::println);

            System.out.println("Deletando cliente por nome");
            clientes.obterTodos().forEach(c -> {
                clientes.deletar(c);
            });

            System.out.println("Listando cliente");
            todosClientes = clientes.obterTodos();
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

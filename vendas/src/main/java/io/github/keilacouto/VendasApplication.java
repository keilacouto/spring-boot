package io.github.keilacouto;

import io.github.keilacouto.domain.entity.Cliente;
import io.github.keilacouto.domain.entity.Pedido;
import io.github.keilacouto.domain.repository.Clientes;
import io.github.keilacouto.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(
            @Autowired Clientes clientes,
            @Autowired Pedidos pedidos) {
        return args -> {

            System.out.println("Salvando cliente");
            Cliente keila = new Cliente("Keila");
            clientes.save(keila);

            Pedido p = new Pedido();
            p.setCliente(keila);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidos.save(p);

            Cliente cliente = clientes.findClienteFetchPedidos(keila.getId());
            System.out.println(cliente.getPedidos());
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}

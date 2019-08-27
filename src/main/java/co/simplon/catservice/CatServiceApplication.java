package co.simplon.catservice;

import co.simplon.catservice.dao.ProductRepository;
import co.simplon.catservice.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CatServiceApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(CatServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Product.class);
        productRepository.save(new Product(null,"string",100,5));
        productRepository.save(new Product(null,"PC dell",100,5));
        productRepository.save(new Product(null,"PC acer",100,5));
        productRepository.save(new Product(null,"PC asus",100,5));
        productRepository.save(new Product(null,"PC apple",100,5));
        productRepository.save(new Product(null,"PC toshiba",100,5));

        productRepository.findAll().forEach(p-> {
            System.out.println(p.toString());
        });
        System.out.println( productRepository.findByNameContains("PC"));
    }
}

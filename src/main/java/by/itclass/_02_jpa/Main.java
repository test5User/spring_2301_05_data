package by.itclass._02_jpa;

import by.itclass._02_jpa.configs.AppConfig;
import by.itclass._02_jpa.entities.Airplane;
import by.itclass._02_jpa.repositories.AirplaneRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        var repository = ctx.getBean(AirplaneRepository.class);
//        var boeing736 = ctx.getBean("boeing736", Airplane.class);
//        var airbus300 = ctx.getBean("airbus300", Airplane.class);
//        System.out.println("We just created " + boeing736);
//
//        boeing736 = repository.save(boeing736);
//        repository.save(airbus300);
//        System.out.println("Airplane after save " + boeing736);
//
//        boeing736.setPlace(200);
//        boeing736 = repository.save(boeing736);
//        System.out.println("Airplane after changes " + boeing736);
        var boeing = repository.findByModelLike("Boe%");
        System.out.println(boeing);
        System.out.println("___________________");
        var airbus = repository.findByPlaceBetween(250, 500);
        airbus.forEach(System.out::println);
    }
}

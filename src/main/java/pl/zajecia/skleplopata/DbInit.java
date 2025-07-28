package pl.zajecia.skleplopata;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pl.zajecia.skleplopata.model.Item;
import pl.zajecia.skleplopata.repository.ItemRepository;

import java.math.BigDecimal;

@Configuration
public class DbInit implements CommandLineRunner {

    private final ItemRepository itemRepository;

    public DbInit(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(itemRepository.count() == 0) {itemRepository.save(new Item("Kotek z lopatka", "Koteczek 1", new BigDecimal("4.99"), "https://m.media-amazon.com/images/I/51a5aR7yzwL._AC_UF1000,1000_QL80_.jpg"));
            itemRepository.save(new Item("Kotek z waderem", "Kotek 2", new BigDecimal("19.00"), "https://thumbs.dreamstime.com/z/kociak-w-niebieskim-wiadrze-na-pla%C5%BCy-trzymaj%C4%85cy-izolowan%C4%85-%C5%BC%C3%B3%C5%82t%C4%85-%C5%82opat%C4%99-portret-uroczego-czarnego-i-opalonego-kotka-218442143.jpg"));
            itemRepository.save(new Item("Kotek ze szpadelm ", "Kotunio 3", new BigDecimal("1.99"), "https://thumbs.dreamstime.com/z/kot-z-%C5%82opat%C4%85-przy-ta%C5%9Bmie-ko%C5%82owej-t%C5%82uczniem-be%C5%BCowy-budowniczy-kot%C3%B3w-i-wid%C5%82em-ko%C5%82owym-jest-w-pobli%C5%BCu-taczki-pe%C5%82nej-267501063.jpg"));}

    }

}

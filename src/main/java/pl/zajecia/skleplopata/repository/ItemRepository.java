package pl.zajecia.skleplopata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zajecia.skleplopata.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}

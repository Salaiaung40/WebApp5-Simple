package salai.springframework.webapp5simple.repositories;

//Created by Salai 6 May 2021

import org.springframework.data.repository.CrudRepository;
import salai.springframework.webapp5simple.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}

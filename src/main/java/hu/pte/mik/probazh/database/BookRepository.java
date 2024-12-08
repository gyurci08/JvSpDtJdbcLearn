package hu.pte.mik.probazh.database;

import hu.pte.mik.probazh.entity.Author;
import hu.pte.mik.probazh.entity.Book;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends ListCrudRepository<Book, Long> {

    //1.	Összes Book listázása; Default
    //2.	Egy Book betöltése ID alapján; Default

    //3.	Book mentése (létrehozás és frissítés lehet egyben és külön is, a választott technológia függvényében)
    //4.	Book törlése

}
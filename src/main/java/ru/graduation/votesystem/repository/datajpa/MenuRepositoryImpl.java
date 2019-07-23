package ru.graduation.votesystem.repository.datajpa;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.graduation.votesystem.model.Menu;
import ru.graduation.votesystem.repository.MenuRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

import static ru.graduation.votesystem.util.ValidationUtil.checkNotFoundWithDate;
import static ru.graduation.votesystem.util.ValidationUtil.checkNotFoundWithId;

@Repository
public class MenuRepositoryImpl implements MenuRepository {

    @Autowired
    private CrudMenuRepository crudRepository;

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public Menu save(Menu menu) {
        Assert.notNull(menu, "dish must not be null");
        return crudRepository.save(menu);
    }

    @Override
    public void delete(int id) {
        checkNotFoundWithId(crudRepository.delete(id) != 0, id);
    }

    @Transactional
    @Override
    public List<Menu> getAllByDate(LocalDate date) {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Menu> cr = cb.createQuery(Menu.class);
        Root<Menu> root = cr.from(Menu.class);
        cr.select(root);

        cr.where(
                cb.equal(root.get("date"), date)
        );

        TypedQuery<Menu> query = em.createQuery(cr);
        List<Menu> results = query.getResultList();

        /*
        Next, getting items having itemPrice less than 1000:
        cr.select(root).where(cb.lt(root.get("itemPrice"), 1000));
        Items having itemNames contain Chair:
        cr.select(root).where(cb.like(root.get("itemName"), "%chair%"));
        Records having itemPrice in between 100 and 200:
        cr.select(root).where(cb.between(root.get("itemPrice"), 100, 200));
        To check if the given property is null:
        cr.select(root).where(cb.isNull(root.get("itemDescription")));
        To check if the given property is not null:
        cr.select(root).where(cb.isNotNull(root.get("itemDescription")));
         */
        return results;

        //return checkNotFoundWithDate(crudRepository.getAllByDate(date), date);
    }
}

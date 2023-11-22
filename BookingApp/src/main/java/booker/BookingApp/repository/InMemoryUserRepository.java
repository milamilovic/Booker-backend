package booker.BookingApp.repository;

import booker.BookingApp.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private static AtomicLong counter = new AtomicLong();

    private ConcurrentMap<Long, User> users = new ConcurrentHashMap<Long, User>();

    @Override
    public Collection<User> findAll() {
        return this.users.values();
    }

    @Override
    public User create(User user) {
        Long id = user.getId();

        if (id == null) {
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.users.put(id, user);
        return user;
    }

    @Override
    public User findOne(Long id) {
        return this.users.get(id);
    }

    @Override
    public User update(User user) {
        Long id = user.getId();
        if (id != null) {
            this.users.put(id, user);
        }
        return user;
    }

    @Override
    public void delete(Long id) {
        this.users.remove(id);
    }
}

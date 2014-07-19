package fz.jfs2014;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {

	List<fz.jfs2014.User> findByName(String string);
}

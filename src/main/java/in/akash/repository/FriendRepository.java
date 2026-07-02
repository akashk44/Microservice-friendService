package in.akash.repository;

import in.akash.entity.FriendEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<FriendEntity, Integer> {

    @Query(value = "select count(*) from friend where phone_number = ? and friend_number = ?", nativeQuery = true)
    Integer checkfriendcontact(Long  phoneNumber, Long friendNumber);

    @Query(value = "select friend_number, friend_name from friend where phone_number = ?", nativeQuery = true)
    List<Object[]> findfriendcontactnumber(Long phone_number);


}

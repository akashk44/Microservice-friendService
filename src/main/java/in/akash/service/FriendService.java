package in.akash.service;

import in.akash.entity.FriendEntity;
import in.akash.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    @Autowired
    FriendRepository friendRepository;

    public FriendEntity addfriendcontact(FriendEntity friend) {
        java.lang.Integer count =friendRepository.checkfriendcontact(friend.getPhoneNumber(), friend.getFriendNumber());

        if(count==0)
        {
            friend = friendRepository.save(friend);
            return friend;
        }
        return null;
    }

    public List<Object[]> readfriendcontact(Long phone_number) {

       return friendRepository.findfriendcontactnumber(phone_number);

    }





    }




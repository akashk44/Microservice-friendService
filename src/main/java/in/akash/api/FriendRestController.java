package in.akash.api;

import in.akash.entity.FriendEntity;
import in.akash.service.FriendService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FriendRestController {


    @Autowired
    FriendService friendService;

    @PostMapping(value = "/friend/add")
    public ResponseEntity<FriendEntity> addfriendcontact(@RequestBody FriendEntity friend) {
        FriendEntity savedFriend = friendService.addfriendcontact(friend);
        if (savedFriend != null) {
            return new ResponseEntity<>(savedFriend, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/friend/{phone_number}")
    public ResponseEntity<List<Object[]>> readfriendcontact(@PathVariable Long phone_number) {
        java.util.List<Object[]> friendContacts = friendService.readfriendcontact(phone_number);
        if (friendContacts != null && !friendContacts.isEmpty()) {
            return new ResponseEntity<>(friendContacts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

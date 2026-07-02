package in.akash.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "friend")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FriendEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long phoneNumber;
    private Long friendNumber;
    private String friendName;
}

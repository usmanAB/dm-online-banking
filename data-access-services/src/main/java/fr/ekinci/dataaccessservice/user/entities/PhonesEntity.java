package fr.ekinci.dataaccessservice.user.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Usman ABID BUTT on 04/11/2017.
 */
@Data
@Entity(name = "phones")
public class PhonesEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id", insertable =false, updatable = false)
    private int phone_id;

    @Column(name = "phones")
    private String phone;

    @ManyToOne
    private UserEntity userEntity;

}

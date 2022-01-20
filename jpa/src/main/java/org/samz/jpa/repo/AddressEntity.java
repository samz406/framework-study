package org.samz.jpa.repo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author: lilin
 * @Date: 2022/1/20 14:12
 * @Description:
 */
@Data
@Entity
@Table(name = "t_area")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String province;

    private String city;

    private String area;

}

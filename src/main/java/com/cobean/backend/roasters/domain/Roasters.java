package com.cobean.backend.roasters.domain;

import com.cobean.backend.bean.domain.Bean;
import com.cobean.backend.common.exception.CustomException;
import com.cobean.backend.common.exception.ExceptionType;
import com.cobean.backend.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
public class Roasters {
    @Id
    @Column(name = "roasters_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "roasters")
    private User user;

    @OneToMany(mappedBy = "roasters", fetch = FetchType.EAGER)
    private List<Bean> beanList = new ArrayList<>();

    private Boolean isDeleted = false;

    public Roasters(String name) {
        this.name = name;
    }

    protected Roasters() {
    }

    public void addBean(Bean bean) {
        for (int i = 0; i < beanList.size(); i++) {
            if (beanList.get(i).equals(bean.getId())) {
                throw new CustomException(ExceptionType.ALREADY_EXIST_BEAN);
            }
        }
        this.beanList.add(bean);
    }

    public void removeBean(Bean bean) {
        for (int i = 0; i < beanList.size(); i++) {
            if (beanList.get(i).getId().equals(bean.getId())){
                beanList.remove(i);
                return;
            }
        }

        throw new CustomException(ExceptionType.BEAN_NOT_FOUND);
    }

    public void deleteRoasters(){
        this.isDeleted = true;
    }



}
